package com.xyb2c.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb2c.dao.SundryWorkerClassMapper;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.SundryWorkerClass;
import com.xyb2c.service.SundryWorkerClassService;

@Service("sundryWorkerClassService")
public class SundryWorkerClassServiceImpl implements SundryWorkerClassService {

	@Autowired
	private SundryWorkerClassMapper dao;

	@Override
	public List<SundryWorkerClass> getAllRole(PageBean page) {
		return dao.getAllRole(page);
	}

	@Override
	public int count() {
		return dao.countByExample(null);
	}

	@Override
	public void insertWorkerRole(String workerId, String roleId) {
		dao.insertWorkerRole(workerId, roleId);
	}

	@Override
	public boolean WorkerIsexist(String workerId) {
		SundryWorkerClass worker = dao.WorkerIsexist(workerId);
		return worker != null;
	}

	@Override
	public List<SundryWorkerClass> getSundryWorkerClass(String workerId) {
		return dao.getSundryWorkerClass(workerId);
	}

	@Override
	public void deleteWorkerRole(String workerId, String roleId) {
		dao.deleteWorkerRole(workerId, roleId);
	}
}
