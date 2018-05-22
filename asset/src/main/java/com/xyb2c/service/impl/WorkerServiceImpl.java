package com.xyb2c.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb2c.dao.BaseDepartmentMapper;
import com.xyb2c.dao.PositionMapper;
import com.xyb2c.dao.SundryWorkerClassMapper;
import com.xyb2c.dao.WorkerMapper;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.BaseDepartmentExample;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.PositionExample;
import com.xyb2c.pojo.SundryWorkerClass;
import com.xyb2c.pojo.SundryWorkerClassExample;
import com.xyb2c.pojo.Worker;
import com.xyb2c.pojo.WorkerExample;
import com.xyb2c.pojo.WorkerExample.Criteria;
import com.xyb2c.service.WorkerService;
import com.xyb2c.util.RecursionUtil;

@Service("workerService")
public class WorkerServiceImpl implements WorkerService {
	@Autowired
	private WorkerMapper workerMapper;
	@Autowired
	BaseDepartmentMapper baseDepartmentMapper;
	@Autowired
	SundryWorkerClassMapper sundryWorkerClassMapper;
	@Autowired
	PositionMapper positionMapper;

	/**
	 * 分页 查询
	 */
	public Map<String, Object> search(Worker worker, PageBean page) {
		Map<String, Object> map = new HashMap<>();
		WorkerExample example = new WorkerExample();
		Criteria criteria = example.createCriteria();
		if (worker.getId() != null && !(worker.getId().equals(""))) {
			criteria.andDIdEqualTo(worker.getId());
		}
		if (worker.getName() != null && !(worker.getName().equals(""))) {
			criteria.andNameLike(worker.getName());
		}
		if (worker.getJob() != null && !(worker.getJob().equals(""))) {
			criteria.andJobLike(worker.getJob());
		}
		if (worker.getDepartment() != null && !(worker.getDepartment().equals(""))) {
			String d_name = worker.getDepartment();
			BaseDepartmentExample baseDepartmentExample = new BaseDepartmentExample();
			List<BaseDepartment> baseDepartments = baseDepartmentMapper.selectByExample(baseDepartmentExample);
			baseDepartmentExample.createCriteria().andDepartmentEqualTo(d_name);
			List<BaseDepartment> list = baseDepartmentMapper.selectByExample(baseDepartmentExample);
			List<Integer> id = new ArrayList<>();
			for (BaseDepartment baseDepartment : list) {
				List<Integer> l = RecursionUtil.getListPid(baseDepartments, baseDepartment.getId());
				id.addAll(l);
			}
			criteria.andDIdIn(id);
		}
		int total = workerMapper.countByExample(example);
		page.setTotalRecord(total);
		example.setStart(page.getStart());
		example.setSize(page.getPageSize());
		List<Worker> list = workerMapper.selectByExample(example);
		List<Worker> result = new ArrayList<>();
		for (Worker worker2 : list) {
			BaseDepartmentExample baseDepartmentExample = new BaseDepartmentExample();
			BaseDepartment baseDepartment = baseDepartmentMapper.selectByPrimaryKey(worker2.getdId());
			List<BaseDepartment> badlist = baseDepartmentMapper.selectByExample(baseDepartmentExample);
			if (baseDepartment != null) {
				BaseDepartment ba = RecursionUtil.StringToDepartName(badlist, baseDepartment);
				worker2.setDepartment(ba.getDepartment());
				result.add(worker2);
			} else {
				worker2.setDepartment(null);
				result.add(worker2);
			}
		}
		map.put("result", result);
		map.put("page", page);
		return map;
	}

	@Override
	public Map<String, Object> selectById(int id) {
		Map<String, Object> resultMap = new HashMap<>();
		Worker worker = workerMapper.selectByPrimaryKey(id);
		BaseDepartmentExample baseDepartmentExample = new BaseDepartmentExample();
		List<BaseDepartment> badlist = baseDepartmentMapper.selectByExample(baseDepartmentExample);
		BaseDepartment department = baseDepartmentMapper.selectByPrimaryKey(worker.getdId());
		BaseDepartment ba = RecursionUtil.StringToDepartName(badlist, department);
		if (ba != null) {
			worker.setDepartment(ba.getDepartment());
		} else {
			worker.setDepartment(null);
		}
		if (worker.getcId() != null) {
			SundryWorkerClass sundryWorkerClass = sundryWorkerClassMapper.selectByPrimaryKey(worker.getcId());
			worker.setInformation(sundryWorkerClass.getInformation());
		} else {
			worker.setInformation("无");
		}
		if (worker.getpId() != null) {
			Position position = positionMapper.selectByPrimaryKey(worker.getpId());
			worker.setPosition(position.getPosition());
		} else {
			worker.setPosition("无");
		}
		resultMap.put("result", worker);
		return resultMap;
	}

	public Map<String, Object> selectDepartment() {
		Map<String, Object> resultMap = new HashMap<>();
		BaseDepartmentExample example = new BaseDepartmentExample();
		example.createCriteria().andPIdEqualTo(1);
		List<BaseDepartment> list = baseDepartmentMapper.selectByExample(example);
		resultMap.put("result", list);
		return resultMap;
	}

	@SuppressWarnings("unused")
	@Override
	public Map<String, Object> selectChildrenDepartment(String department) {

		Map<String, Object> map = new HashMap<>();
		List<Position> list = new ArrayList<>();
		BaseDepartmentExample example = new BaseDepartmentExample();
		List<BaseDepartment> baseDepartments = baseDepartmentMapper.selectByExample(example);
		example.createCriteria().andDepartmentEqualTo(department);
		List<BaseDepartment> departments = baseDepartmentMapper.selectByExample(example);
		for (BaseDepartment baseDepartment : departments) {
			PositionExample example2 = new PositionExample();
			example2.createCriteria().andDIdEqualTo(baseDepartment.getId());
			List<Position> list2 = positionMapper.selectByExample(example2);
			list.addAll(list2);
		}
		map.put("result", list);
		return map;
	}

	@Override
	public Map<String, Object> selectInformation() {
		Map<String, Object> map = new HashMap<>();
		SundryWorkerClassExample example = new SundryWorkerClassExample();
		List<SundryWorkerClass> list = sundryWorkerClassMapper.selectByExample(example);
		map.put("result", list);
		return map;
	}

	@Override
	public Map<String, Object> save(Worker worker) {
		Map<String, Object> map = new HashMap<>();
		System.out.println(worker.toString());
		if (worker.getInformation() != null && !worker.getInformation().equals("无")
				&& !worker.getInformation().equals("")) {
			SundryWorkerClassExample example = new SundryWorkerClassExample();
			example.createCriteria().andInformationEqualTo(worker.getInformation());
			List<SundryWorkerClass> sdwc = sundryWorkerClassMapper.selectByExample(example);
			for (SundryWorkerClass sundryWorkerClass : sdwc) {
				worker.setcId(sundryWorkerClass.getId());
			}
		}
		if (worker.getPosition() != null && !worker.getDepartment().equals("无") && !worker.getDepartment().equals("")) {
			PositionExample example = new PositionExample();
			example.createCriteria().andPositionEqualTo(worker.getPosition());
			List<Position> list = positionMapper.selectByExample(example);
			for (Position position : list) {
				worker.setpId(position.getId());
			}
		}
		workerMapper.updateByPrimaryKeySelective(worker);
		map.put("result", "修改成功");
		return map;
	}

	public Integer count() {
		return workerMapper.countByExample(null);
	}

	public List<Worker> selectPage(int start, int size) {
		WorkerExample we = new WorkerExample();
		we.setStart(start);
		we.setSize(size);
		List<Worker> worker = workerMapper.selectByExample(we);
		List<BaseDepartment> baseDepartments = baseDepartmentMapper.selectByExample(null);
		for (int i = 0; i < worker.size(); i++) {
			if (worker.get(i).getdId() != null) {
				BaseDepartment bd = baseDepartmentMapper.selectByPrimaryKey(worker.get(i).getdId());
				if (bd != null) {
					BaseDepartment bde = RecursionUtil.StringToDepartName(baseDepartments, bd);
					worker.get(i).setDepartment(bde.getDepartment());
					worker.get(i).setDepartmentNo(bde.getNo());
				}
			}
			if (worker.get(i).getpId() != null) {
				worker.get(i).setPosition(positionMapper.selectByPrimaryKey(worker.get(i).getpId()).getPosition());
			}
			if (worker.get(i).getcId() != null) {
				worker.get(i).setInformation(
						sundryWorkerClassMapper.selectByPrimaryKey(worker.get(i).getcId()).getInformation());
			}
		}

		return worker;
	}
}
