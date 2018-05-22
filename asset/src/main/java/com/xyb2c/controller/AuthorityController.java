package com.xyb2c.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyb2c.authority.IOAuthority;
import com.xyb2c.pojo.Authority;
import com.xyb2c.pojo.AuthorityExample;
import com.xyb2c.pojo.AuthorityExample.Criteria;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.SundryWorkerClass;
import com.xyb2c.service.AuthorityService;
import com.xyb2c.service.SundryWorkerClassService;

@Controller("authority")
@RequestMapping(value = "authority")
public class AuthorityController {
	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private SundryWorkerClassService sundryWorkerClassService;

	/**
	 * 根据菜单id获取菜单下所拥有的权限
	 * 
	 * @param map
	 * @param response
	 */
	@RequestMapping(value = "/getAuthorityByMenu", method = RequestMethod.POST)
	public void getAuthorityByMenu(@RequestBody Map<String, Object> map, HttpServletResponse response) {
		String id = map.get("id").toString();
		try {
			String json = getAuthorityMap(id);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将权限变为map对象生成json字符串 map格式: <br>
	 * {authority表e_name:{authority表sign:对应javaBean}} 例如:<br>
	 * {"authority.html":{"detail":"javaBean"}}
	 * sign有detail,select,insert,del,update分别标识这条数据为读取,查询,插入,删除,更新等操作权限
	 * 
	 * @param id
	 * @return
	 */
	private String getAuthorityMap(String id) {
		AuthorityExample example = new AuthorityExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(Long.parseLong(id));
		criteria.andEnabledEqualTo(1);
		List<Authority> list = authorityService.getAuthorityByMenu(example);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Map<String, Authority>> bigMap = new HashMap<>();
		for (Authority a : list) {
			if (bigMap.containsKey(a.geteName())) {
				Authority authority = a;
				authority.setName(a.getName());
				bigMap.get(a.geteName()).put(a.getSign(), authority);
			} else {
				Map<String, Authority> smallMap = new HashMap<>();
				Authority authority = a;
				authority.setName(a.getName());
				smallMap.put(a.getSign(), authority);
				bigMap.put(a.geteName(), smallMap);
			}
		}
		try {
			String json = mapper.writeValueAsString(bigMap);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取所有角色列表(带分页)
	 * 
	 * @param map
	 * @param response
	 */
	@RequestMapping(value = "/getAllRole", method = RequestMethod.POST)
	public void getAllRole(@RequestBody Map<String, Object> map, HttpServletResponse response) {
		PageBean page = new PageBean();
		page.setPageCode(Integer.parseInt(map.get("page").toString()));
		page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		List<SundryWorkerClass> list = sundryWorkerClassService.getAllRole(page);
		try {
			String json = parseJson(list, sundryWorkerClassService.count());
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String parseJson(List<SundryWorkerClass> list, int total) {
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("total", total);
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	@SuppressWarnings("rawtypes")
	private String parseJson(List list) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 根据菜单ID,角色ID获取权限列表
	 * 
	 * @param map
	 * @param response
	 */
	@RequestMapping(value = "/getRoleAuthority", method = RequestMethod.POST)
	public void getRoleAuthority(@RequestBody Map<String, String> map, HttpServletResponse response) {
		String id = map.get("id");
		String menuId = map.get("menuId");
		if (id != null && id != "" && menuId != null && menuId != "") {
			List<Authority> list = authorityService.getRoleAuthority(id, menuId);
			try {
				String json = parseJson(list);
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(json);
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 保存角色权限
	 * 
	 * @param map
	 * @param response
	 * @param request
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveAuthority", method = RequestMethod.POST)
	public void saveAuthority(@RequestBody Map<String, Object> map, HttpServletResponse response,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		String rid = map.get("rid").toString();
		String aid = map.get("aid").toString();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Boolean> aidMap = new HashMap<>();
		aidMap = mapper.readValue(aid, new TypeReference<Map<String, Boolean>>() {
		});
		for (String s : aidMap.keySet()) {
			boolean flag = authorityService.getAuthority(rid, s);
			if (!flag) {
				if (aidMap.get(s)) {
					authorityService.saveAuthority(rid, s);
				}
			} else {
				if (!aidMap.get(s)) {
					authorityService.deleteAuthority(rid, s);
				}
			}
		}
		try {
			String json = "{\"message\":\"保存成功\"}";
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据菜单ID,获取用户所拥有的权限
	 * 
	 * @param map
	 * @param response
	 */
	@RequestMapping(value = "/getUserAuthority", method = RequestMethod.POST)
	public void getUserAuthority(@RequestBody Map<String, String> map, HttpServletResponse response) {
		String id = map.get("id");
		String menuId = map.get("menuId");
		if (id != null && id != "" && menuId != null && menuId != "") {
			List<Authority> list = authorityService.getUserAuthority(id, menuId);
			try {
				String json = parseJson(list);
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(json);
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 保存用户自定义权限
	 * 
	 * @param map
	 * @param response
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveUserAuthority", method = RequestMethod.POST)
	public void saveUserAuthority(@RequestBody Map<String, Object> map, HttpServletResponse response)
			throws JsonParseException, JsonMappingException, IOException {
		String uid = map.get("uid").toString();
		String aid = map.get("aid").toString();
		ObjectMapper mapper = new ObjectMapper();
		IOAuthority authority = new IOAuthority();
		Map<String, Boolean> aidMap = new HashMap<>();
		aidMap = mapper.readValue(aid, new TypeReference<Map<String, Boolean>>() {
		});
		for (String s : aidMap.keySet()) {
			boolean flag = authorityService.userAuthorityExist(uid, s);
			if (!flag) {
				if (aidMap.get(s)) {
					authorityService.saveUserAuthority(uid, s);
				}
			} else {
				if (!aidMap.get(s)) {
					authorityService.deleteUserAuthority(uid, s);
				}
			}
		}
		try {
			String json = "{\"message\":\"保存成功\"}";
			List<Authority> list = authorityService.getAuthorityByWorkerId(uid);
			list.addAll(authorityService.getAuthority(uid));
			authority.out(list, uid);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据用户ID获取权限
	 * 
	 * @param response
	 * @param map
	 */
	@RequestMapping(value = "/getAuthority", method = RequestMethod.POST)
	public void getAuthority(HttpServletResponse response, @RequestBody Map<String, Object> map) {
		String uid = map.get("id").toString();
		List<Authority> list = authorityService.getAuthority(uid);
		try {
			String json = parseJson(list);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
