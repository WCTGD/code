package com.xyb2c.dao;

import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.BaseContractorExample;
import com.xyb2c.pojo.PageBean;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseContractorMapper {
    int countByExample(BaseContractorExample example);

    int deleteByExample(BaseContractorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseContractor record);

    int insertSelective(BaseContractor record);

    List<BaseContractor> selectByExample(BaseContractorExample example);

    BaseContractor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseContractor record, @Param("example") BaseContractorExample example);

    int updateByExample(@Param("record") BaseContractor record, @Param("example") BaseContractorExample example);

    int updateByPrimaryKeySelective(BaseContractor record);

    int updateByPrimaryKey(BaseContractor record);
    
    /**
     *  基础数据 承包商
     * @param page 分页
     * @return
     */
    List<BaseContractor> baseContractorSelect(PageBean page);
    
    /**
     * 承包商总数
     * @return
     */
    int countBaseContractor();
    
    /**
     * 承包商 查看
     * @param baseContractor
     * @return
     */
    BaseContractor baseContractorSelectByNo(BaseContractor baseContractor);
    
    /**
     * 通过no删除(update)
     * @param no
     */
     void deleteBaseContractorByNo(String no);
     
     /**
      * 承包商 查询出其no max
      * @return
      */
     BaseContractor baseContractorAdd();
     
     /**
      * 添加(承包商)
      */
     void baseContractorInsert(BaseContractor baseContractor);
     
     /**
      * 修改(承包商)
      * @param baseContractor
      */
     void updateBaseContractorByNo(BaseContractor baseContractor);
     
     /**
      * 回收站(承包商)
      * @return
      */
     BaseContractor selectBaseContractorByflag(Integer id);
    
}