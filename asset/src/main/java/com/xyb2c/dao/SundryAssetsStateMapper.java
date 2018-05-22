package com.xyb2c.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xyb2c.pojo.SundryAssetsState;
import com.xyb2c.pojo.SundryAssetsStateExample;

public interface SundryAssetsStateMapper {
    int countByExample(SundryAssetsStateExample example);

    int deleteByExample(SundryAssetsStateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SundryAssetsState record);

    int insertSelective(SundryAssetsState record);

    List<SundryAssetsState> selectByExample(SundryAssetsStateExample example);

    SundryAssetsState selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SundryAssetsState record, @Param("example") SundryAssetsStateExample example);

    int updateByExample(@Param("record") SundryAssetsState record, @Param("example") SundryAssetsStateExample example);

    int updateByPrimaryKeySelective(SundryAssetsState record);

    int updateByPrimaryKey(SundryAssetsState record);
    
    /**
     *  基础数据 综合 资产状态列表
     * @return
     */
    List<SundryAssetsState> selectSundryAssetsState();
    
    /**
     * 基础数据   综合 资产状态列表 add
     * @param sundryAssetsState
     */
    void sundryAssetsStateInsert(SundryAssetsState sundryAssetsState);
    
    /**
     * 基础数据  综合 资产状态列表  Delete
     * @param sundryAssetsState
     */
    void sundryAssetsStateDelete(String information);
}