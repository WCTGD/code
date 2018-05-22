package com.xyb2c.dao;

import com.xyb2c.pojo.SundryJobClass;
import com.xyb2c.pojo.SundryJobClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SundryJobClassMapper {
    int countByExample(SundryJobClassExample example);

    int deleteByExample(SundryJobClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SundryJobClass record);

    int insertSelective(SundryJobClass record);

    List<SundryJobClass> selectByExample(SundryJobClassExample example);

    SundryJobClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SundryJobClass record, @Param("example") SundryJobClassExample example);

    int updateByExample(@Param("record") SundryJobClass record, @Param("example") SundryJobClassExample example);

    int updateByPrimaryKeySelective(SundryJobClass record);

    int updateByPrimaryKey(SundryJobClass record);
    
    /**
     *  基础数据 综合 工作类别
     * @return
     */
    List<SundryJobClass> selectSundryJobClass();
    
    /**
     * 基础数据   综合 工作类别 add
     * @param sundryJobClass
     */
    void sundryJobClassInsert(SundryJobClass sundryJobClass);
    
    /**
     * 基础数据   综合 工作类别  Delete
     * @param sundryJobClass
     */
    void sundryJobClassDelete(String information);
    
}