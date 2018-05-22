package com.xyb2c.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xyb2c.pojo.SundryWorkerClass;
import com.xyb2c.pojo.Worker;
import com.xyb2c.service.SundryWorkerClassService;
import com.xyb2c.util.JsonUtil;
import com.xyb2c.util.getWorkerDataUtil;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private SundryWorkerClassService roleService;

	/**
	 * 根据用户ID获取用户信息
	 * 
	 * @param map
	 * @param response
	 */
	@RequestMapping(value = "/getWorkerById", method = RequestMethod.POST)
	public void getWorkerById(@RequestBody Map<String, String> map, HttpServletResponse response) {
		String id = map.get("id");
		if (id != null && !id.equals("undefined")) {
			Worker worker = getWorkerDataUtil.getWorkerData(Integer.parseInt(id));
			String json = JsonUtil.parseObjectToString(worker);
			try {
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(json);
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "/role.html", method = RequestMethod.GET)
	public String setWorkerId(String id, HttpServletRequest request) {
		request.setAttribute("workerId", 167);
		return "redirect:/role.html";
	}

	@RequestMapping(value = "/getWorkerId", method = RequestMethod.POST)
	public void getWorkerId(HttpServletRequest request, HttpServletResponse response) {
		// String id = (String) request.getAttribute("workerId");
		String id = "167";
		if (id != null && !id.equals("undefined")) {
			String json = JsonUtil.parseObjectToString(id);
			try {
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(json);
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 给用户添加角色
	 * 
	 * @param map
	 */
	@RequestMapping(value = "/addWorkerRole", method = RequestMethod.POST)
	public void addWorkerRole(@RequestBody Map<String, String> map) {
		String workerId = map.get("workerId");
		String roleId = map.get("roleId");
		if (workerId != null && !workerId.equals("undefined") && roleId != null && !roleId.equals("undefined")) {
			if (!roleService.WorkerIsexist(workerId)) {
				roleService.insertWorkerRole(workerId, roleId);
			}
		}
	}

	/**
	 * 获取用户拥有的角色
	 * 
	 * @param map
	 * @param response
	 */
	@RequestMapping(value = "/getSundryWorkerClass", method = RequestMethod.POST)
	public void getSundryWorkerClass(@RequestBody Map<String, String> map, HttpServletResponse response) {
		String workerId = map.get("workerId");
		if (workerId != null && !workerId.equals("undefined")) {
			List<SundryWorkerClass> role = roleService.getSundryWorkerClass(workerId);
			String json = "";
			if (role != null) {
				json = JsonUtil.parseObjectToString(role);
			} else {
				json += "{\"message\":\"nodata\"}";
			}
			try {
				response.setContentType("application/json;charset=utf-8");
				response.getWriter().write(json);
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除用户角色
	 * 
	 * @param map
	 * @param response
	 */
	@RequestMapping(value = "/deleteWorkerRole", method = RequestMethod.POST)
	public void deleteWorkerRole(@RequestBody Map<String, String> map, HttpServletResponse response) {
		String workerId = map.get("workerId");
		String roleId = map.get("roleId");
		if (workerId != null && !workerId.equals("undefined") && roleId != null && !roleId.equals("undefined")) {
			if (roleService.WorkerIsexist(workerId)) {
				roleService.deleteWorkerRole(workerId, roleId);
			}
		}
	}
}
