package com.xyb2c.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyb2c.dao.BaseDepartmentMapper;
import com.xyb2c.dao.PositionMapper;
import com.xyb2c.dao.SundryWorkerClassMapper;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Worker;
import com.xyb2c.service.WorkerService;

@Controller
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	WorkerService workService;
	@Autowired
	BaseDepartmentMapper baseDepartmentMapper;
	@Autowired
	SundryWorkerClassMapper sundryWorkerClassMapper;
	@Autowired
	PositionMapper positionMapper;

	@RequestMapping(value = "search")
	public @ResponseBody Map<String, Object> Search(@RequestBody Map<String, String> map) {
		Worker worker = new Worker();
		if (map.get("id") != "" && map.get("id") != null) {
			worker.setId(Integer.parseInt(map.get("id")));
		}
		worker.setName(map.get("name"));
		worker.setJob(map.get("job"));
		worker.setDepartment(map.get("department"));
		PageBean page = new PageBean();
		page.setPageCode(Integer.parseInt(map.get("pageCode")));
		page.setPageSize(Integer.parseInt(map.get("pageSize")));
		Map<String, Object> resultmap = workService.search(worker, page);
		return resultmap;
	}

	@RequestMapping(value = "selectById")
	public @ResponseBody Map<String, Object> selectById(@RequestBody Map<String, Integer> map) {
		int id = map.get("id");
		Map<String, Object> resultMap = new HashMap<>();
		if (id > 0) {
			resultMap = workService.selectById(id);
			return resultMap;
		}
		return null;
	}

	@RequestMapping(value = "selectDepartment")
	public @ResponseBody Map<String, Object> selectDepartment() {
		return workService.selectDepartment();
	}

	@RequestMapping(value = "selectChildrenDepartment")
	public @ResponseBody Map<String, Object> selectChildrenDepartment(@RequestBody Worker worker) {
		String department = worker.getDepartment();
		if (!department.equals("") && department != null) {
			Map<String, Object> map = workService.selectChildrenDepartment(department);
			return map;
		}
		return null;
	}

	@RequestMapping(value = "selectInformation")
	public @ResponseBody Map<String, Object> selectInformation() {
		return workService.selectInformation();
	}

	@RequestMapping(value = "save")
	public @ResponseBody Map<String, Object> save(@RequestBody Worker worker) {
		System.out.println(worker.toString());
		return workService.save(worker);
	}

}
