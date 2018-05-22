package com.xyb2c.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.RepairList;
import com.xyb2c.pojo.SundryUrgencyLevel;
import com.xyb2c.pojo.SundryWokerorderClass;
import com.xyb2c.pojo.SundryWokerorderState;
import com.xyb2c.pojo.Worker;

/**
 * 
 * @author zzf
 *
 */
public interface RepairlistService {
	/**
	 * 获取所有工单类型
	 * 
	 * @return
	 */
	List<SundryWokerorderClass> selectAllSundryWokerorderClass();

	/**
	 * 获取所有工单状态
	 * 
	 * @return
	 */
	List<SundryWokerorderState> selectAllSundryWokerorderState();

	/**
	 * 获取所有紧急等级
	 * 
	 * @return
	 */
	List<SundryUrgencyLevel> selectAllSundryUrgencyLevel();

	/**
	 * 更新假删除
	 * 
	 * @param repairList
	 */
	void update(Integer id,String name);

	/**
	 * 更新
	 * 
	 * @param repairList
	 */
	Integer realUpdate(RepairList repairList);

	/**
	 * 查一个
	 * 
	 * @param id
	 * @return
	 */
	RepairList selectOne(Integer id);

	/**
	 * 分页查询
	 * 
	 * @param repairList
	 *            条件bean
	 * @param assetsClassId
	 *            资产类型ID
	 * @param date1
	 *            发起时间1
	 * @param date2
	 *            发起时间2
	 * @return
	 */
	List<RepairList> select(RepairList repairList, Integer assetsClassId, Date date1, Date date2, int start,
			int length,Integer pid,Integer flag);

	/**
	 * 数数
	 * 
	 * @param repairList
	 *            条件bean
	 * @param assetsClassId
	 *            资产类型ID
	 * @param date1
	 *            发起时间1
	 * @param date2
	 *            发起时间2
	 * @return
	 */
	Integer count(RepairList repairList, Integer assetsClassId, Date date1, Date date2,Integer pid,Integer flag);

	/**
	 * 查询所有的员工
	 * 
	 * @return
	 */
	List<Worker> selectAllWorker();
	/**
	 * 查询所有的位置
	 * @return
	 */
	List<Position> selectAllPosition();
	/**
	 * 返回比数据库里面最大的NO还大1的NO
	 * @return
	 */
	String selectMaxNo();
	/**
	 * 
	 * @param name
	 * 员工名字
	 * @return
	 * worker：员工bean，position：位置信息
	 */
	Map<String,Object> changeWorker(String name);
	/**
	 * 改变位置了
	 * @param position
	 * 位置描述
	 * @return
	 * assets：该位置的所有资产
	 * position：改位置的信息
	 */
	Map<String,Object> changePosition(String position);
	/**
	 * 添加
	 * @param repairList
	 * 要添加的类
	 * @return
	 */
	Integer add(RepairList repairList);

	
}