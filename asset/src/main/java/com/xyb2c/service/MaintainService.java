package com.xyb2c.service;

import java.util.Date;
import java.util.List;

import com.xyb2c.pojo.Maintain;
import com.xyb2c.pojo.SundryJobClass;

public interface MaintainService {
	/**
	 * 分页查询
	 * @param start
	 * 开始下标
	 * @param length
	 * 长度
	 * @param no
	 * 编号
	 * @param name
	 * 名称
	 * @param assetsno
	 * 资产编号
	 * @param start1
	 * 开始时间1
	 * @param start2
	 * 开始时间2
	 * @return
	 */
	List<Maintain> select(int start, int length, String no, String name, String assetsno, Date start1, Date start2,Integer plan);
	/**
	 * 数数
	 * @param no
	 * 编号
	 * @param name
	 * 名称
	 * @param assetsno
	 * 资产编号
	 * @param start1
	 * 开始时间1
	 * @param start2
	 * 开始时间2
	 * @return
	 */
	int count(String no, String name, String assetsno, Date start1, Date start2,Integer plan);
	/**
	 * 查一个
	 * @param id
	 * @return
	 */
	Maintain selectOne(int id);
	/**
	 * 差比最大的编号大一的编号
	 * @return
	 */
	String selectMaxNo();
	/**
	 * 插入
	 * @param maintain
	 */
	int insert(Maintain maintain);
	/**
	 * 更新
	 * @param maintain
	 */
	int update(Maintain maintain);
	/**
	 * 查找所有所有的工作类型
	 * @return
	 */
	List<SundryJobClass> selectAllJobClass();
	/**
	 * 假删除
	 * @param maintain
	 */
	void updateFlag(Maintain maintain,String name);
	/**
	 * insert一个list 上传格式
	 * @param list
	 * @return
	 */
	int upInsert(List<Maintain> list);

}