package com.xyb2c.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.BaseAssetClass;
import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.SundryAssetsState;
import com.xyb2c.pojo.SundryAssetsWay;
import com.xyb2c.pojo.Supplier;

/**
 * 
 * @author zzf
 *
 */
public interface AssetsService {
	/**
	 * 条件查询资产
	 * 
	 * @param start
	 * @param size
	 * @param asset
	 * @param repair1
	 * @param repair2
	 * @param stuse1
	 * @param stuse2
	 * @return
	 */
	List<Assets> select(int start, int size, Assets asset, Date repair1, Date repair2, Date stuse1, Date stuse2);

	/**
	 * 数数
	 * 
	 * @param asset
	 * @param repair1
	 * @param repair2
	 * @param stuse1
	 * @param stuse2
	 * @return
	 */
	int count(Assets asset, Date repair1, Date repair2, Date stuse1, Date stuse2);

	/**
	 * 获取所有资产状态
	 * 
	 * @return
	 */
	List<SundryAssetsState> selectAllSundryAssetsState();

	/**
	 * 获取所有资产类型
	 * 
	 * @return
	 */
	List<BaseAssetClass> selectAllBaseAssetClass();

	/**
	 * 获取所有保修外包类型
	 * 
	 * @return
	 */
	List<SundryAssetsWay> selectAllSundryAssetsWay();

	/**
	 * 获取所有部门
	 * 
	 * @return
	 */
	Map<String,List<BaseDepartment>> selectAllBaseDepartment();

	/**
	 * 通过主键查找资产
	 * 
	 * @param id
	 * @return
	 */
	Assets selectByPK(int id);

	/**
	 * 假删除
	 * 
	 * @param id
	 */
	void updateShow(int id,String name);

	/**
	 * 获取所有承包商
	 * 
	 * @return
	 */
	List<BaseContractor> selectAllBaseContractor();

	/**
	 * 获取所有供应商
	 * 
	 * @return
	 */
	List<Supplier> selectAllSupplier();

	/**
	 * 检查编号通过true
	 * 
	 * @param no
	 * @return
	 */
	boolean checkNo(String no);

	/**
	 * 部门换时返回该部门的编号no员工worker和位置position
	 */
	Map<String, Object> changeDepartment(Integer id);
	/**
	 * 只改部门
	 * @param id
	 * @return
	 */
	BaseDepartment onlyChangeDepartment(Integer id);
	/**
	 * 根据id返回相应位置编号
	 * @param id
	 * @return
	 */
	Position changePosition(Integer id);
	/**
	 * 更新资产
	 * @param assets
	 */
	void update(Assets assets);
	/**
	 * 添加资产
	 * @param assets
	 */
	void add(Assets assets);
	/**
	 * 获取所有公共资产
	 * @return
	 */
	List<Assets> selectPublicAssets();
	/**
	 * 
	 * @param start
	 * 开始下标
	 * @param size
	 * 长度下标
	 * @param d1
	 * 日期1
	 * @param d2
	 * 日期2
	 * @param did
	 * 部门id
	 * @return
	 */
	List<Assets> formSelect(int start,int size,Date d1,Date d2,Integer did);
	/**
	 * 
	 * @param d1
	 * 日期1
	 * @param d2
	 * 日期2
	 * @param did
	 * 部门id
	 * @return
	 */
	Integer formCount(Date d1,Date d2,Integer did);
	
}