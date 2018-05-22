package com.xyb2c.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xyb2c.pojo.SundryJobPriority;
import com.xyb2c.pojo.SundryJobPriorityExample;

public interface SundryJobPriorityMapper {
    int countByExample(SundryJobPriorityExample example);

    int deleteByExample(SundryJobPriorityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SundryJobPriority record);

    int insertSelective(SundryJobPriority record);

    List<SundryJobPriority> selectByExample(SundryJobPriorityExample example);

    SundryJobPriority selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SundryJobPriority record, @Param("example") SundryJobPriorityExample example);

    int updateByExample(@Param("record") SundryJobPriority record, @Param("example") SundryJobPriorityExample example);

    int updateByPrimaryKeySelective(SundryJobPriority record);

    int updateByPrimaryKey(SundryJobPriority record);
    
    /**
     *  基础数据 综合 工作优先级
     * @return
     */
    List<SundryJobPriority> selectSundryJobPriority();
    
    /**
     * 基础数据   综合 工作优先级 add
     * @param sundryJobPriority
     */
    void sundryJobPriorityInsert(SundryJobPriority sundryJobPriority);
    
    /**
     * 基础数据   综合 工作优先级  Delete
     * @param sundryJobPriority
     */
    void sundryJobPriorityDelete(String information);
}