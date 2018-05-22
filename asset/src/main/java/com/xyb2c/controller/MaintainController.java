package com.xyb2c.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.Maintain;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.SundryJobClass;
import com.xyb2c.pojo.User;
import com.xyb2c.service.AssetsService;
import com.xyb2c.service.MaintainService;
import com.xyb2c.service.RepairlistService;
import com.xyb2c.util.ExcelUtil;

@Controller
@RequestMapping(value = "maintain")
public class MaintainController {
	@Autowired
	MaintainService maintainService;
	@Autowired
	AssetsService assetsService;
	@Autowired
	RepairlistService repairlistService;
	/**
	 * 维护查询
	 * @param page
	 * 当前页码
	 * @param size
	 * 每页长度
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
	 * @param plan
	 * 计划和工单标识
	 * @return
	 */
	@RequestMapping(value = "select")
	public @ResponseBody Map<String, Object> select(Integer page, Integer size, String no, String name, String assetsno,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date start1,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "start2") Date start2,Integer plan) {
		int start = (page - 1) * size;
		List<Maintain> maintain = maintainService.select(start, size, no, name, assetsno, start1, start2,plan);
		Integer count = maintainService.count(no, name, assetsno, start1, start2,plan);
		Integer pagesize = count / size + 1;
		if (count % size == 0) {
			pagesize--;
		}
		Integer begin = start + 1;
		Integer end = start + size;
		Map<String, Object> map = new HashMap<>();
		map.put("data", maintain);
		map.put("count", count);
		map.put("pagesize", pagesize);
		map.put("begin", begin);
		map.put("end", end);
		return map;
	}
	/**
	 * 查单个
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "selectone")
	public @ResponseBody Maintain selectOne(int id) {
		Maintain maintain = maintainService.selectOne(id);
		if(maintain.getaId()!=null){
			maintain.setAssets(assetsService.selectByPK(maintain.getaId()));
		}
		return maintain;
	}
	/**
	 * 查比最大的编号大一的编号
	 * @return
	 */
	@RequestMapping(value = "selectmaxno")
	public @ResponseBody String selectMaxNo() {
		return maintainService.selectMaxNo();
	}
	/**
	 * 插入
	 * @param maintain
	 * bean
	 * @return
	 */
	@RequestMapping(value = "insert")
	public @ResponseBody Integer insert(Maintain maintain) {
		maintain.setFlag(1);
		try {
			return maintainService.insert(maintain);
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 更新
	 * @param maintain
	 * bean
	 * @return
	 */
	@RequestMapping(value = "update")
	public @ResponseBody int update(Maintain maintain) {
		maintain.setFlag(1);
		 try {
			 maintainService.update(maintain);
			 return 1;
		} catch (Exception e) {
			return -1;
		}
	}
	/**
	 * 查询公共资产
	 * @return
	 */
	@RequestMapping(value = "selectpublicassets")
	public @ResponseBody List<Assets> selectPublicAssets() {
		return assetsService.selectPublicAssets();
	}
	/**
	 * 获取所有部门
	 * @return
	 */
	@RequestMapping(value = "selectallbasedepartment")
	public @ResponseBody Map<String, List<BaseDepartment>> selectAllBaseDepartment() {
		return assetsService.selectAllBaseDepartment();
	}
	/**
	 * 查询所有位置
	 * @return
	 */
	@RequestMapping(value = "selectallposition")
	public @ResponseBody List<Position> selectAllPosition() {
		return repairlistService.selectAllPosition();
	}
	/**
	 * 更换位置
	 * @param position
	 * 位置名称
	 * @return
	 * assets：该位置的所有资产 position：改位置的信息
	 */
	@RequestMapping(value = "changeposition")
	public @ResponseBody Map<String, Object> changePosition(String position) {
		return repairlistService.changePosition(position);
	}
	/**
	 * 查询所有工作类型
	 * @return
	 */
	@RequestMapping(value = "selectalljobclass")
	public @ResponseBody List<SundryJobClass> selectAllJobClass() {
		return maintainService.selectAllJobClass();
	}
	/**
	 * 假删
	 * @param maintain
	 * bean
	 * @param session
	 */
	@RequestMapping(value = "delete")
	public @ResponseBody void delete(Maintain maintain,HttpSession session) {
		User u=(User) session.getAttribute("user");
		maintain.setFlag(0);
		maintainService.updateFlag(maintain,u.getName());
	}
	/**
	 * 维护上传
	 * @param multipartFile
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public @ResponseBody Integer upload(@ModelAttribute MultipartFile multipartFile, HttpServletRequest req)
			{
		List<String> list = new ArrayList<>();
		list.add("no");
		list.add("name");
		list.add("jclass");
		list.add("wostate");
		list.add("assetsno");
		list.add("positionname");
		list.add("startdate");
		list.add("enddate");
		list.add("lastDate");
		list.add("next");
		List<Maintain> maintain=new ArrayList<>();
		try {
			maintain=ExcelUtil.parse(multipartFile.getInputStream(), Maintain.class, list);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return maintainService.upInsert(maintain);
	}
}
