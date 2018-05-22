package com.xyb2c.service;

import java.util.List;

import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.BaseAssetClass;
import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.SundryAssetsState;
import com.xyb2c.pojo.SundryAssetsWay;
import com.xyb2c.pojo.SundryJobClass;
import com.xyb2c.pojo.SundryJobPriority;
import com.xyb2c.pojo.SundryUrgencyLevel;
import com.xyb2c.pojo.SundryWokerorderClass;
import com.xyb2c.pojo.SundryWokerorderState;
import com.xyb2c.pojo.SundryWorkerClass;
import com.xyb2c.pojo.Supplier;
import com.xyb2c.pojo.UploadFile;

/** 基础数据
 * Created by Administrator on 2016/11/1 0001.
 */
public interface BasicDataService {
	/**
     * 基础数据 部门
     * @return
     */
    List<BaseDepartment> baseDepartmentSelect(PageBean page);
    
    
    /**
     * 部门判断
     * @return
     */
    String departmentJudge(String departmen,String no);
    
    
    /**
     * 删除部门  1不包含（可以删） 并且把状态该成已删除状态
     * @param no 编号
     */
//    int deleteDepartment(String no);
    
    
    /**
     * 添加部门
     */
//    void insertBaseDepartment(BaseDepartment bDepartment);
    
    /**
     * 修改前的查询
     * @return
     */
//    BaseDepartment selectBaseDepartmentById(Integer id);
    
    /**
     * 修改部门，名称，编号
     * @param bDepartment
     */
//    void updateBaseDepartment(BaseDepartment bDepartment);
   
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
   
//   /**
//    * 删除 员工(update)
//    * @param no
//    */
//   void deleteWorkerByNo(String no);
   
   /**
    * 删除 位置 (update)
    * @param no
    */
   int deletePositionByNo(String no);
   
   
   /**
    * 基础数据 资产类别
    * @param page
    * @return
    */
   List<BaseAssetClass> assetClasseSelect(PageBean page);
   
   /**
    * 基础数据  综合  资产类别 添加
    * @param baseAssetClass
    * @return
    */
   void saveAssetClasses(BaseAssetClass baseAssetClass);
   
   /**
    * 基础数据  综合  资产类别 数据库判断
    * @param baseAssetClass
    * @return
    */
   int judgeBaseAssetClass(BaseAssetClass baseAssetClass);
   
   /**
    * 基础数据  综合  资产类别 删除
    * @param no
    */
   int deleteAssetClasses(String deleteAssetClasses);
   
   /**
    *  基础数据 供应商
    * @param page 分页
    * @return
    */
   List<Supplier> supplierSelect(PageBean page);
   
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
   int supplierDeleteByNo(String no,String name);
   
   /**
    * 基础数据 供应商  拼接 编号 先查询 数据库是否存在 并查询出其max
    * @return
    */
   Supplier stitchingNumber();
   
   /**
    * 基础数据 承包商  拼接 编号 先查询 数据库是否存在 并查询出其max
    * @return
    */
   BaseContractor contractorNumber();
   
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
    *  基础数据 承包商
    * @param page 分页
    * @return
    */
   List<BaseContractor> baseContractorSelect(PageBean page);
   
   /**
    * 承包商 查看
    * @param baseContractor
    * @return
    */
   BaseContractor baseContractorSelectByNo(BaseContractor baseContractor);
   
   /**
    * 通过no删除(update承包商)
    * @param no
    */
    int deleteBaseContractorByNo(String no,String name);
    
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
    *  基础数据 综合 工单状态
    * @return
    */
   List<SundryWokerorderState> sundryWokerorderStatesSelect();
   
   /**
    * 基础数据   综合 工单状态  Delete
    * @param sundryWokerorderState
    */
   String sundryWokerorderStatesDelete(String information);
   
   /**
    * 基础数据   综合 工单状态 add
    * @param sundryWokerorderState
    */
   void sundryWokerorderStatesInsert(SundryWokerorderState sundryWokerorderState);
   
   /**
    * 基础数据 综合 工单类型列表
    * @return
    */
   List<SundryWokerorderClass> selectSundryWokerorderClass();
   
   /**
    * 工单类型 判断 工单类型列表
    * @param sundryWokerorderClass
    * @return
    */
   int judgeSundryWokerorderClass(SundryWokerorderClass sundryWokerorderClass);
   
   /**
    * 基础数据   综合 工单类型 add
    * @param sundryWokerorderClass
    */
   void sundryWokerorderClassInsert(SundryWokerorderClass sundryWokerorderClass);
   
   /**
    * 基础数据   综合 工单类型  Delete
    * @param sundryWokerorderClass
    */
   String sundryWokerorderClassDelete(String information);
   
   /**
    * 基础数据  综合  资产类别
    * @return
    */
   List<BaseAssetClass> selectBaseAssetClass();
   
   /**
    *  基础数据 综合 资产状态列表
    * @return
    */
   List<SundryAssetsState> selectSundryAssetsState();
   
   /**
    * 判断数据库是否已存在(资产类别)
    * @param baseAssetClass
    * @return
    */
   int judgeSundryAssetsState (SundryAssetsState sundryAssetsState);
   
   /**
    * 基础数据   综合 资产状态列表 add
    * @param sundryAssetsState
    */
   void sundryAssetsStateInsert(SundryAssetsState sundryAssetsState);
   
   /**
    * 基础数据  综合 资产状态列表  Delete
    * @param sundryAssetsState
    */
   String sundryAssetsStateDelete(String information);
   
   /**
    * 基础数据 综合 保修/外包
    * @return
    */
   List<SundryAssetsWay> selectSundryAssetsWay();
   
   /**
    * 判断数据库是否已存在(保修/外包)
    * @param sundryAssetsWay
    * @return
    */
   int judgeSundryAssetsWay (SundryAssetsWay sundryAssetsWay);
   
   /**
    * 基础数据   综合 保修/外包 add
    * @param sundryAssetsWay
    */
   void sundryAssetsWayInsert(SundryAssetsWay sundryAssetsWay);
   
   /**
    * 基础数据   综合 保修/外包  Delete
    * @param sundryAssetsWay
    */
   String sundryAssetsWayDelete(String information);
   
   /**
    *  基础数据 综合  员工类型
    * @return
    */
   List<SundryWorkerClass> selectSundryWokerClass();
   
   /**
    * 判断数据库是否已存在(员工类型)
    * @param sundryAssetsWay
    * @return
    */
   int judgeSundryWorkerClass (SundryWorkerClass sundryWorkerClass);
   
   /**
    * 基础数据   综合  员工类型 add
    * @param SundryWokerClass
    */
   void sundryWokerClassInsert(SundryWorkerClass sundryWokerClass);
   
   /**
    * 基础数据   综合  员工类型  Delete
    * @param SundryWokerClass
    */
   String sundryWokerClassDelete(String information);
   
   /**
    *  基础数据 综合 紧急程度
    * @return
    */
   List<SundryUrgencyLevel> selectSundryUrgencyLevel();
   
   /**
    * 基础数据   综合 紧急程度 add
    * @param sundryUrgencyLevel
    */
   void sundryUrgencyLevelInsert(SundryJobClass sundryJobClass);
   
   /**
    * 判断数据库是否已存在(紧急程度)
    * @param sundryUrgencyLevel
    */
   int judgeSundryUrgencyLevel(SundryJobClass sundryUrgencyLevel);
   
   /**
    * 基础数据   综合 紧急程度  Delete
    * @param sundryUrgencyLevel
    */
   int sundryUrgencyLevelDelete(String information);
   
   /**
    *  基础数据 综合 工作优先级
    * @return
    */
   List<SundryJobPriority> selectSundryJobPriority();
   
   /**
    * 判断数据库是否已存在(工作优先级)
    * @param sundryJobPriority
    */
   int judgeSundryJobPriority(SundryJobPriority sundryJobPriority);
   
   /**
    * 基础数据   综合 工作优先级 add
    * @param sundryJobPriority
    */
   void sundryJobPriorityInsert(SundryJobPriority sundryJobPriority);
   
   /**
    * 基础数据   综合 工作优先级  Delete
    * @param sundryJobPriority
    */
   String sundryJobPriorityDelete(String information);
   
   /**
    * 判断数据库是否已存在(工单状态)
    * @param list
    * @param object
    * @return
    */
   int judgeSundryWokerorderState (SundryWokerorderState sundryWokerorderState);
   
   /**
    *  基础数据 综合 工作类别
    * @return
    */
   List<SundryJobClass> selectSundryJobClass();
   
   /**
    * 安全指导
    * @param uploadFile
    */
   int SecurityGuidance(String name,String url);
   
   /**
    *  基础数据 供应商
    * @param page 分页
    * @return
    */
   List<UploadFile> listUploadFile(PageBean page);
   
   /**
    * 删除 安全指导
    * @param no
    */
   void deleteSecurityGuidance(String no);
   
   /**
    *  通过no查询所有 安全指导
    * @param no
    * @return
    */
   UploadFile downloadUploadFile(String no);
   
}
