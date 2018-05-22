package com.xyb2c.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.SundryWorkerClass;
import com.xyb2c.pojo.SundryWorkerClassExample;

public interface SundryWorkerClassMapper {
	int countByExample(SundryWorkerClassExample example);

	int deleteByExample(SundryWorkerClassExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SundryWorkerClass record);

	int insertSelective(SundryWorkerClass record);

	List<SundryWorkerClass> selectByExample(SundryWorkerClassExample example);

	SundryWorkerClass selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") SundryWorkerClass record,
			@Param("example") SundryWorkerClassExample example);

	int updateByExample(@Param("record") SundryWorkerClass record, @Param("example") SundryWorkerClassExample example);

	int updateByPrimaryKeySelective(SundryWorkerClass record);

	int updateByPrimaryKey(SundryWorkerClass record);

	/**
	 * 基础数据 综合 员工类型
	 * 
	 * @return
	 */
	List<SundryWorkerClass> selectSundryWokerClass();

	/**
	 * 基础数据 综合 员工类型 add
	 * 
	 * @param SundryWokerClass
	 */
	void sundryWokerClassInsert(SundryWorkerClass sundryWokerClass);

	/**
	 * 基础数据 综合 员工类型 Delete
	 * 
	 * @param SundryWokerClass
	 */
	void sundryWokerClassDelete(String information);

	/**
	 * 获取角色
	 * 
	 * @param page
	 * @return
	 */
	List<SundryWorkerClass> getAllRole(PageBean page);

	/**
	 * 添加用户角色
	 * 
	 * @param workerId
	 * @param roleId
	 */
	void insertWorkerRole(@Param("workerId") String workerId, @Param("roleId") String roleId);

	/**
	 * 判断用户角色表用户是否存在
	 * 
	 * @param workerId
	 * @return
	 */
	SundryWorkerClass WorkerIsexist(String workerId);

	/**
	 * 根据用户ID获取所拥有的角色
	 * 
	 * @param workerId
	 * @return
	 */
	List<SundryWorkerClass> getSundryWorkerClass(String workerId);

	/**
	 * 删除用户角色
	 * 
	 * @param workerId
	 * @param roleId
	 */
	void deleteWorkerRole(@Param("workerId") String workerId, @Param("roleId") String roleId);
}