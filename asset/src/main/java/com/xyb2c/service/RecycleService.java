package com.xyb2c.service;

import java.util.List;

import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.LocationConditions;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.pojo.Supplier;

/**
 * 回收站
 * @author Administrator
 *
 */
public interface RecycleService {
	 /**
     * 回收站 资产
     * @return
     */
//    List<Assets> selectAssetsByShow();
    
    /**
     * 回收站  供应商
     * @return
     */
//    List<Supplier> selectSupplierByShow();
    
    /**
     * 回收站 位置
     * @return
     */
//    List<Position> selectPositionByShow();
    
    /**
     * 回收站 
     * @return
     */
//    List<RepairList> selectRepairListByFlag();
    
    /**
     * 回收站(承包商)
     * @return
     */
//    List<BaseContractor> selectBaseContractorByflag();
    
    /**
     * 回收站
     * @return
     */
//    List<Maintain> selectMaintainByShow();
	
	/**
     * 回收站 界面
     * @return
     */
    List<Recycle> selectRecycle(PageBean page,Recycle recycle,String start,String end);
    
    /**
     * 回收站 类别
     * @return
     */
    List<Recycle> selectRecycleType();
    
    /**
     * 根据fkid 改变状态
     * @param fkId
     * @param tbName
     */
    void updateRecycleByFkidByTbname(String id);
    
    /**
     * 查看 位置
     * @return
     */
    LocationConditions positionSelect(String id);
    
    /**
     * 查看 供应商 
     * @return
     */
    Supplier selectSupplierByShow(String id);
    
    /**
     * 查看 承包商
     * @param id
     * @return
     */
    BaseContractor selectBaseContractorByflag(String id);
    
    /**
     * 用过id 查询出数据
     * @param id
     * @return
     */
    Recycle recycleSelectId(String id);
    
}
