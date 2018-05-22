package com.xyb2c.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xyb2c.pojo.SundryAssetsWay;
import com.xyb2c.pojo.SundryAssetsWayExample;

public interface SundryAssetsWayMapper {
    int countByExample(SundryAssetsWayExample example);

    int deleteByExample(SundryAssetsWayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SundryAssetsWay record);

    int insertSelective(SundryAssetsWay record);

    List<SundryAssetsWay> selectByExample(SundryAssetsWayExample example);

    SundryAssetsWay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SundryAssetsWay record, @Param("example") SundryAssetsWayExample example);

    int updateByExample(@Param("record") SundryAssetsWay record, @Param("example") SundryAssetsWayExample example);

    int updateByPrimaryKeySelective(SundryAssetsWay record);

    int updateByPrimaryKey(SundryAssetsWay record);
    
    /**
     * 基础数据 综合 保修/外包
     * @return
     */
    List<SundryAssetsWay> selectSundryAssetsWay();
    
    /**
     * 基础数据   综合 保修/外包 add
     * @param sundryAssetsWay
     */
    void sundryAssetsWayInsert(SundryAssetsWay sundryAssetsWay);
    
    /**
     * 基础数据   综合 保修/外包  Delete
     * @param sundryAssetsWay
     */
    void sundryAssetsWayDelete(String information);
}