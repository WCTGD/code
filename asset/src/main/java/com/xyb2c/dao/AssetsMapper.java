package com.xyb2c.dao;

import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.AssetsExample;
import com.xyb2c.pojo.PageBean;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetsMapper {
    int countByExample(AssetsExample example);

    int deleteByExample(AssetsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Assets record);

    int insertSelective(Assets record);

    List<Assets> selectByExample(AssetsExample example);

    Assets selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Assets record, @Param("example") AssetsExample example);

    int updateByExample(@Param("record") Assets record, @Param("example") AssetsExample example);

    int updateByPrimaryKeySelective(Assets record);

    int updateByPrimaryKey(Assets record);
    /**
     * 分页查询
     * @param example
     * @return
     */
    List<Assets> selectByExamplePage(AssetsExample example) ;
    
    /**
     * 资产总条数
     */
    int countAssets();
    
    /**
     * 基础数据 资产
     * @param page
     * @return
     */
    List<Assets> assetsSelect(PageBean page);
    
    
    /**
     * 删除 资产(update)
     * @param no
     */
    void deleteAssetsByNo(String no);
    
    
    /**
     * 查询 资产
     * @return
     */
    List<Assets> selectAssets();
    
    
    Assets selectByNo(String no);
    
    /**
     * 回收站
     * @return
     */
    List<Assets> selectAssetsByShow();
    
    
}