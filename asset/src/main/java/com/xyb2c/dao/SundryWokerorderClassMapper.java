package com.xyb2c.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xyb2c.pojo.SundryWokerorderClass;
import com.xyb2c.pojo.SundryWokerorderClassExample;

public interface SundryWokerorderClassMapper {
    int countByExample(SundryWokerorderClassExample example);

    int deleteByExample(SundryWokerorderClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SundryWokerorderClass record);

    int insertSelective(SundryWokerorderClass record);

    List<SundryWokerorderClass> selectByExample(SundryWokerorderClassExample example);

    SundryWokerorderClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SundryWokerorderClass record, @Param("example") SundryWokerorderClassExample example);

    int updateByExample(@Param("record") SundryWokerorderClass record, @Param("example") SundryWokerorderClassExample example);

    int updateByPrimaryKeySelective(SundryWokerorderClass record);

    int updateByPrimaryKey(SundryWokerorderClass record);
    
    /**
     * 工单类型列表
     * @return
     */
    List<SundryWokerorderClass> selectSundryWokerorderClass();
    
    /**
     * 基础数据   综合 工单类型 add
     * @param sundryWokerorderClass
     */
    void sundryWokerorderClassInsert(SundryWokerorderClass sundryWokerorderClass);
    
    /**
     * 基础数据   综合 工单类型  Delete
     * @param sundryWokerorderClass
     */
    void sundryWokerorderClassDelete(String information);
}