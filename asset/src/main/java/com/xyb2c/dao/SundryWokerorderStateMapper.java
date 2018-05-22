package com.xyb2c.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xyb2c.pojo.SundryWokerorderState;
import com.xyb2c.pojo.SundryWokerorderStateExample;

public interface SundryWokerorderStateMapper {
    int countByExample(SundryWokerorderStateExample example);

    int deleteByExample(SundryWokerorderStateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SundryWokerorderState record);

    int insertSelective(SundryWokerorderState record);

    List<SundryWokerorderState> selectByExample(SundryWokerorderStateExample example);

    SundryWokerorderState selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SundryWokerorderState record, @Param("example") SundryWokerorderStateExample example);

    int updateByExample(@Param("record") SundryWokerorderState record, @Param("example") SundryWokerorderStateExample example);

    int updateByPrimaryKeySelective(SundryWokerorderState record);

    int updateByPrimaryKey(SundryWokerorderState record);
    
    /**
     * 基础数据   综合 工单状态
     * @return
     */
    List<SundryWokerorderState> sundryWokerorderStatesSelect();
    
    /**
     * 基础数据   综合 工单状态 add
     * @param sundryWokerorderState
     */
    void sundryWokerorderStatesInsert(SundryWokerorderState sundryWokerorderState);
    
    /**
     * 基础数据   综合 工单状态  Delete
     * @param sundryWokerorderState
     */
    void sundryWokerorderStatesDelete(String information);
    
}