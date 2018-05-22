package com.xyb2c.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.RepairList;
import com.xyb2c.pojo.SundryUrgencyLevel;
import com.xyb2c.pojo.SundryWokerorderClass;
import com.xyb2c.pojo.SundryWokerorderState;
import com.xyb2c.pojo.User;
import com.xyb2c.pojo.Worker;
import com.xyb2c.service.AssetsService;
import com.xyb2c.service.RepairlistService;

@Controller
@RequestMapping(value = "repairlist")
public class RepairListController {
	@Autowired
	RepairlistService repairlistService;
	@Autowired
	AssetsService assetsService;

	/**
	 * 获取所有工单类型
	 * 
	 * @return
	 */
	@RequestMapping(value = "selectallsundrywokerorderclass")
	public @ResponseBody List<SundryWokerorderClass> selectAllSundryWokerorderClass() {
		return repairlistService.selectAllSundryWokerorderClass();
	}

	/**
	 * 获取所有工单状态
	 * 
	 * @return
	 */
	@RequestMapping(value = "selectallsundrywokerorderstate")
	public @ResponseBody List<SundryWokerorderState> selectAllSundryWokerorderState() {
		return repairlistService.selectAllSundryWokerorderState();
	}

	/**
	 * 获取所有工单紧急等级
	 * 
	 * @return
	 */
	@RequestMapping(value = "selectallsundryurgencyLevel")
	public @ResponseBody List<SundryUrgencyLevel> selectAllSundryUrgencyLevel() {
		return repairlistService.selectAllSundryUrgencyLevel();
	}

	/**
	 * 获取所有员工
	 * 
	 * @return
	 */
	@RequestMapping(value = "selectallworker")
	public @ResponseBody List<Worker> selectAllWorker() {
		return repairlistService.selectAllWorker();
	}

	/**
	 * 获取所有位置
	 * 
	 * @return
	 */
	@RequestMapping(value = "selectallposition")
	public @ResponseBody List<Position> selectAllPosition() {
		return repairlistService.selectAllPosition();
	}

	/**
	 * 假删除
	 * 
	 * @param repairList
	 */
	@RequestMapping(value = "delete")
	public @ResponseBody void delete(Integer id,HttpSession session) {
		User u=(User) session.getAttribute("user");
		repairlistService.update(id,u.getName());
	}

	/**
	 * 更新
	 * 
	 * @param repairList
	 */
	@RequestMapping(value = "update")
	public @ResponseBody Integer update(RepairList repairList) {
		repairList.setFlag(1);
		return repairlistService.realUpdate(repairList);
	}

	/**
	 * 根据主键获取维修
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "selectone")
	public @ResponseBody RepairList selectOne(Integer id) {
		RepairList rl = repairlistService.selectOne(id);
		rl.setAssets(assetsService.selectByPK(rl.getAssetId()));
		return rl;
	}

	/**
	 * 查询
	 * 
	 * @param repairList
	 *            bean
	 * @param assetsClassId
	 *            资产类型id
	 * @param date1
	 *            发起时间1
	 * @param date2
	 *            发起时间2
	 * @param page
	 *            页数
	 * @param size
	 *            每页长度
	 * @return
	 */
	@RequestMapping(value = "select")
	public @ResponseBody Map<String, Object> select(RepairList repairList, Integer assetsClassId,
			@DateTimeFormat(pattern = "yyyy-MM-dd")Date date1, @DateTimeFormat(pattern = "yyyy-MM-dd")Date date2,
			Integer page, Integer size) {
		Map<String, Object> map = new TreeMap<>();
		int start = (page - 1) * size;
		int count = repairlistService.count(repairList, assetsClassId, date1, date2,null,1);
		int pagesize = count / size;
		if (count % size > 0) {
			pagesize++;
		}
		map.put("repairList", repairlistService.select(repairList, assetsClassId, date1, date2, start, size,null,1));
		map.put("count", count);
		map.put("pagesize", pagesize);
		map.put("start", start + 1);
		map.put("end", start + size);
		return map;
	}

	/**
	 * 返回最大的no还要大1
	 * 
	 * @return
	 */
	@RequestMapping(value = "selectmax")
	public @ResponseBody String selectMax() {
		return repairlistService.selectMaxNo();
	}

	/**
	 * 
	 * @param name
	 *            员工名字
	 * @return worker：员工bean，position：位置信息
	 */
	@RequestMapping(value = "changeworker")
	public @ResponseBody Map<String, Object> changeWorker(String name) {
		Map<String, Object> map = repairlistService.changeWorker(name);
		return map == null ? new HashMap<String, Object>() : map;
	}

	/**
	 * 改变位置了
	 * 
	 * @param position
	 *            位置描述
	 * @return assets：该位置的所有资产 position：改位置的信息
	 */
	@RequestMapping(value = "changeposition")
	public @ResponseBody Map<String, Object> changePosition(String position) {
		return repairlistService.changePosition(position);
	}
	/**
	 * 添加
	 * @param repairList
	 * 要添加的类
	 * @return
	 */
	@RequestMapping(value = "add")
	public @ResponseBody Integer add(RepairList repairList) {
		repairList.setFlag(1);
		try {
			return repairlistService.add(repairList);
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 获取所有公共资产
	 * @return
	 */
	@RequestMapping(value = "selectpublicassets")
	public @ResponseBody List<Assets> selectPublicAssets(){
		return assetsService.selectPublicAssets();
	}

	
}
