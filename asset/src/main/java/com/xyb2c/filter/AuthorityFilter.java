package com.xyb2c.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyb2c.authority.IOAuthority;
import com.xyb2c.pojo.Authority;
import com.xyb2c.pojo.User;

public class AuthorityFilter implements Filter {

	private static final String[] suffix = new String[] { ".jpg", ".css", ".js", ".png", "/userLogin", "/quit",
			"/getduty", ".html" ,".ico"};

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		IOAuthority authority = new IOAuthority();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String url = httpRequest.getRequestURL().toString();
		if (!reuqestSupport(url)) {
			User user = getSessionUser(httpRequest);
			if (user == null) {
				//user session为空时返回登录页
//				httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
				httpResponse.sendError(401);
				return;
			} else {
				Map<String, Authority> map = authority.read(user.getId());
//				for (String key : map.keySet()) {
//					   System.out.println("key= "+ key + " and value= " + map.get(key));
//					}
				String suffix = getSuffix(httpRequest);
				if (plainRequest(httpRequest)) {
					//普通请求 ,权限文件中不包含该url请求后缀的权限,跳转至无权限页面
					if (!map.containsKey(suffix)) {
//						httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
						httpResponse.sendError(403);
						return;
					}
				} else {
					//ajax请求,权限文件中不包含该url请求后缀的权限,重定向至无权限页面
					if (!map.containsKey(suffix)) {
//						String json = "{\"error\":\"没有权限\",\"url\":\"" + httpRequest.getContextPath() + "/login.html"
//								+ "\"}";
//						response.setContentType("application/json;charset=utf-8");
//						try {
//							response.getWriter().write(json);
//							response.getWriter().flush();
//						httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
						httpResponse.sendError(403);
						return;
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	
	// 判断request请求 true为普通请求 flase为ajax请求
	private boolean plainRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		return requestType == null ? true : false;
	}

	
	//获取user session
	private User getSessionUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return user;
	}

	
	//获得url请求后缀
	private String getSuffix(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		String suffix = url.substring(url.indexOf(request.getContextPath()));
		suffix = suffix.replaceFirst(request.getContextPath(), "");
		return suffix;
	}

	
	//判断url后缀是否需要过滤
	private boolean reuqestSupport(String url) {
		for (String s : suffix) {
			if (url.endsWith(s)) {
				return true;
			}
		}
		return false;
	}

}
