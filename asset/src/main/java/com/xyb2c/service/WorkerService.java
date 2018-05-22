package com.xyb2c.service;

import java.util.List;
import java.util.Map;

import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Worker;

public interface WorkerService {
	Map<String, Object> search(Worker worker, PageBean page);
	Map<String, Object> selectById(int id);
	Map<String, Object> selectDepartment();
	Map<String, Object> selectChildrenDepartment(String department);
	Map<String , Object> selectInformation();
	Map<String , Object> save(Worker  worker);
	
	
	
	/**
	 * 无条件分页查询
	 * @param start
	 * @param size
	 * @return
	 * @author zzf
	 */
	List<Worker> selectPage(int start, int size);
	/**
	 * 无条件数数
	 * @return
	 * @author zzf
	 */
	Integer count();
}