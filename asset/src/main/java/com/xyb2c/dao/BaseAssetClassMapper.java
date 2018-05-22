package com.xyb2c.dao;

import com.xyb2c.pojo.BaseAssetClass;
import com.xyb2c.pojo.BaseAssetClassExample;
import com.xyb2c.pojo.PageBean;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseAssetClassMapper {
    int countByExample(BaseAssetClassExample example);

    int deleteByExample(BaseAssetClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseAssetClass record);

    int insertSelective(BaseAssetClass record);

    List<BaseAssetClass> selectByExample(BaseAssetClassExample example);

    BaseAssetClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseAssetClass record, @Param("example") BaseAssetClassExample example);

    int updateByExample(@Param("record") BaseAssetClass record, @Param("example") BaseAssetClassExample example);

    int updateByPrimaryKeySelective(BaseAssetClass record);

    int updateByPrimaryKey(BaseAssetClass record);
    
    /**
     * 基础数据 资产类别
     * @param page
     * @return
     */
    List<BaseAssetClass> baseAssetClasseSelect(PageBean page);
    
    /**
     * 资产类别总数
     * @return
     */
    int counttBaseAssetClass();
    
    /**
     * 基础数据  综合  资产类别
     * @return
     */
    List<BaseAssetClass> selectBaseAssetClass();
    
    /**
     * 基础数据  综合  资产类别 添加
     * @param baseAssetClass
     * @return
     */
    void saveAssetClasses(BaseAssetClass baseAssetClass);
    
    /**
     * 基础数据  综合  资产类别 删除
     * @param no
     */
    void deleteAssetClasses(String assetCategory);
    
}