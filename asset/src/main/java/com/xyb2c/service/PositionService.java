package com.xyb2c.service;

import java.util.List;

import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.LocationConditions;
import com.xyb2c.pojo.PageBean;

/**
 * 位置 
 * @author Administrator
 *
 */
public interface PositionService {
	/**
	 *  位置条件查询
	 * @param locationConditions 
	 * @return
	 */
	List<LocationConditions> positionList(LocationConditions locationConditions,PageBean page);
	
	/**
	 * 位置总条数
	 * @param locationConditions 根据分页
	 * @return
	 */
	int positionCount(LocationConditions locationConditions);
	
	 /**
     * 位置查询页面
     * @param page
     * @return
     */
    List<LocationConditions> positionListPage(PageBean page);
    
    /**
     * 部门查询
     * @return
     */
    List<BaseDepartment> selectDepartment();
    
    /**
     * 通过部门Id查询  最大的位置编号
     */
    LocationConditions selectLocationNumberByDepartmentId(Integer id);
    
    /**
     * 添加前 根据id 查询出该部门的信息
     * @param id
     * @return
     */
    BaseDepartment selectDepartmentById(String id);
    
    /**
     * 查询位置
     * @param no
     * @param id
     * @return
     */
    LocationConditions selectPositionByNo(String no,String id);
    
    /**
     *  判断
     * @param aNo
     * @return
     */
    LocationConditions judgeExist(LocationConditions loc);
    
    /**
     * 添加位置
     * @param record
     * @return
     */
    void insert(LocationConditions lc);
    
    /**
     * 删除（修改flag状态）
     * @param id
     */
    void deleteById(String ids,String name);
    
    /**
     * 修改前的查询根据id
     * @return 
     */
    LocationConditions selectPlaceById(String id);
    
    
    
    /**
     * 通过部门Id查询  最大的位置编号 修改查询
     */
    LocationConditions updateLocationNumberByDepartmentId(String aids);

    /**
     * 修改位置
     * @param lC
     */
    void updateById(LocationConditions locationConditions);
    
    /**
     * 通过部门查询  部门编号
     */
    BaseDepartment selectLocationNumberByDepartment(String id);
    
    /**
     * 删除 判断
     * @param id
     * @return
     */
    int delectJudge(Integer id);
    
}
