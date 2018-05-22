package com.xyb2c.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.BaseDepartmentExample;
import com.xyb2c.pojo.PageBean;

public interface BaseDepartmentMapper {
    int countByExample(BaseDepartmentExample example);

    int deleteByExample(BaseDepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseDepartment record);

    int insertSelective(BaseDepartment record);

    List<BaseDepartment> selectByExample(BaseDepartmentExample example);

    BaseDepartment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseDepartment record, @Param("example") BaseDepartmentExample example);

    int updateByExample(@Param("record") BaseDepartment record, @Param("example") BaseDepartmentExample example);

    int updateByPrimaryKeySelective(BaseDepartment record);

    int updateByPrimaryKey(BaseDepartment record);
    
    /**
     * 基础数据 部门
     * @return
     */
    List<BaseDepartment> baseDepartmentSelect(PageBean page);
    
    /**
     * 部门总数
     * @return
     */
    int countBaseDepartment();
    
    /**
     * 添加部门，名称，编号
     */
//    void insertBaseDepartment(BaseDepartment bDepartment);
    
    /**
     * 修改前的查询
     * @return
     */
//    BaseDepartment selectBaseDepartmentById(Integer id);
    
    /**
     * 修改部门，名称，编号
     * @param bDepartment
     */
//    void updateBaseDepartment(BaseDepartment bDepartment);
    
    /**
     * 部门查询
     * @return
     */
    List<BaseDepartment> selectDepartment();
    
    /**
     * 删除部门
     * @param no 编号
     */
//    void deleteDepartment(String no);
    
    /**
     * 部门查询 通过no 获取id
     * @return
     */
    BaseDepartment selectDepartmentByNo(String no);
    
    List<BaseDepartment> selectDepartmentByPid();
    
}