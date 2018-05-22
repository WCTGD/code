package com.xyb2c.dao;

import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Supplier;
import com.xyb2c.pojo.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
    int countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

    /**
     *  基础数据 供应商
     * @param page 分页
     * @return
     */
    List<Supplier> supplierSelect(PageBean page);
    
    /**
     *  供应商总数
     * @return
     */
    int countSupplier();
    
    /**
     *  基础数据 供应商 查看
     * @param no
     * @return
     */
    Supplier supplierSelectByNo(String no);
    
    /**
     * 基础数据 供应商 删除(update)
     * @param no
     */
    void supplierDeleteByNo(String no);
    
    /**
     * 基础数据 供应商  拼接 编号 先查询 数据库是否存在 并查询出其max
     * @return
     */
    Supplier supplierAdd();
    
    /**
     * 基础数据 供应商  保存
     * @param supplier
     */
    void supplierInsert(Supplier supplier);
    
    /**
     * 基础数据 供应商  修改
     * @param supplier
     */
    void updateSupplierByNo(Supplier supplier);
    
    /**
     * 回收站
     * @return
     */
    Supplier selectSupplierByShow(Integer id);
    
}