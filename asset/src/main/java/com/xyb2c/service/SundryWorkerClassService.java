package com.xyb2c.service;

import java.util.List;

import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.SundryWorkerClass;

public interface SundryWorkerClassService {

	/**
	 * 获取角色
	 * 
	 * @param page
	 * @return
	 */
	List<SundryWorkerClass> getAllRole(PageBean page);

	int count();

	/**
	 * 添加用户角色
	 * 
	 * @param workerId
	 * @param roleId
	 */
	void insertWorkerRole(String workerId, String roleId);

	/**
	 * 判断用户角色表用户是否存在
	 * 
	 * @param workerId
	 * @return
	 */
	boolean WorkerIsexist(String workerId);

	/**
	 * 根据用户ID获取所拥有的角色
	 * 
	 * @param workerId
	 * @return
	 */
	List<SundryWorkerClass> getSundryWorkerClass(String workerId);

	/**
	 * 删除用户角色
	 * @param workerId
	 * @param roleId
	 */
	void deleteWorkerRole(String workerId, String roleId);
}
