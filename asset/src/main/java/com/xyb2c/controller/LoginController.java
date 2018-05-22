package com.xyb2c.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyb2c.authority.IOAuthority;
import com.xyb2c.pojo.Authority;
import com.xyb2c.pojo.User;
import com.xyb2c.service.AuthorityService;
import com.xyb2c.service.LoginService;
import com.xyb2c.util.CryptographyUtil;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public void getUser(@RequestBody Map<String, String> map, HttpServletResponse response,
			HttpServletRequest request) {
		IOAuthority authority = new IOAuthority();
		String json = "";
		String username = map.get("username");
		String password = map.get("password");
		User user = new User();
		user.setEmp_no(username);
		user.setPassword(password);
		User user1 = loginService.getUser(username, password);
		if (user1 != null && user1.getEmp_no() != "" && user1.getEmp_no() != null
				&& user1.getEmp_no().equals(username)) {
			if (user1.getPassword() != "" && user1.getPassword() != null
					&& user1.getPassword().equals(CryptographyUtil.md5(password))) {
				json += "{\"url\":\"/asset/home.html\"}";
			}
			request.getSession().setAttribute("user", user1);
			List<Authority> list = authorityService.getAuthorityByWorkerId(user1.getId());
			list.addAll(authorityService.getAuthority(user1.getId()));
			authority.out(list, user1.getId());
		} else {
			json += "{\"message\":\"用户名密码错误\"}";
		}

		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getduty", method = RequestMethod.POST)
	public void getduty(HttpServletResponse response, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			return;
		}
		String str = "{\"name\":\"" + user.getName() + "\",\"duty\":\"" + user.getDuty() + "\"}";
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(str);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/quit", method = RequestMethod.GET)
	public String quit(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "redirect:/login.html";
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public @ResponseBody User getUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
}
