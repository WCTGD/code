package com.xyb2c.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xyb2c.pojo.SundryUrgencyLevel;
import com.xyb2c.pojo.SundryUrgencyLevelExample;

public interface SundryUrgencyLevelMapper {
    int countByExample(SundryUrgencyLevelExample example);

    int deleteByExample(SundryUrgencyLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SundryUrgencyLevel record);

    int insertSelective(SundryUrgencyLevel record);

    List<SundryUrgencyLevel> selectByExample(SundryUrgencyLevelExample example);

    SundryUrgencyLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SundryUrgencyLevel record, @Param("example") SundryUrgencyLevelExample example);

    int updateByExample(@Param("record") SundryUrgencyLevel record, @Param("example") SundryUrgencyLevelExample example);

    int updateByPrimaryKeySelective(SundryUrgencyLevel record);

    int updateByPrimaryKey(SundryUrgencyLevel record);
    
    /**
     *  基础数据 综合 紧急程度
     * @return
     */
    List<SundryUrgencyLevel> selectSundryUrgencyLevel();
    
    /**
     * 基础数据   综合 紧急程度 add
     * @param sundryUrgencyLevel
     */
    void sundryUrgencyLevelInsert(SundryUrgencyLevel sundryUrgencyLevel);
    
    /**
     * 基础数据   综合 紧急程度  Delete
     * @param sundryUrgencyLevel
     */
    void sundryUrgencyLevelDelete(String information);
}