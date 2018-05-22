package com.xyb2c.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.BaseAssetClass;
import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.SundryAssetsState;
import com.xyb2c.pojo.SundryAssetsWay;
import com.xyb2c.pojo.Supplier;
import com.xyb2c.pojo.User;
import com.xyb2c.service.AssetsService;

@Controller
@RequestMapping(value = "assets")
public class AssetsController {
	@Autowired
	AssetsService assetsService;
	/**
	 * 
	 * @param page
	 * 页码
	 * @param size
	 * 每页长度
	 * @param asset
	 * 资产查询bean
	 * @param repair1
	 * 维修时间一
	 * @param repair2
	 * 维修时间二
	 * @param stuse1
	 * 开始时间一
	 * @param stuse2
	 * 开始时间二
	 * @return
	 * map 开始下标 start
	 * 结束下标 end
	 * 
	 */
	@RequestMapping(value = "selectassets")
	public @ResponseBody Map<String, Object> selectAssets(Integer page, Integer size, @ModelAttribute Assets asset,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date repair1, @DateTimeFormat(pattern = "yyyy-MM-dd") Date repair2,
			@DateTimeFormat(pattern = "yyyy-MM-dd") Date stuse1, @DateTimeFormat(pattern = "yyyy-MM-dd") Date stuse2) {
		if (page == null) {
			page = 1;
		}
		int start = (page - 1) * size;
		if ("全部".equals(asset.getAssetClass())) {
			asset.setAssetClass(null);
		}
		if ("全部".equals(asset.getAssetState())) {
			asset.setAssetState(null);
		}
		int count = assetsService.count(asset, repair1, repair2, stuse1, stuse2);
		List<Assets> assets = assetsService.select(start, size, asset, repair1, repair2, stuse1, stuse2);
		int pagesize = count / size;
		if (count % size != 0) {
			pagesize += 1;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("start", start + 1);
		map.put("end", start + size);
		map.put("assets", assets);
		map.put("page", page);
		map.put("count", count);
		map.put("pagesize", pagesize);
		return map;
	}
	/**
	 * 查询所有资产类型
	 * @return
	 */
	@RequestMapping(value = "selectallbaseassetclass")
	public @ResponseBody List<BaseAssetClass> selectAllBaseAssetClass() {
		return assetsService.selectAllBaseAssetClass();
	}
	/**
	 * 查询所有资产状态
	 * @return
	 */
	@RequestMapping(value = "selectallsundryassetsstate")
	public @ResponseBody List<SundryAssetsState> selectAllSundryAssetsState() {
		return assetsService.selectAllSundryAssetsState();
	}
	/**
	 * 查询所有资产保修方式
	 * @return
	 */
	@RequestMapping(value = "selectallsundryassetsway")
	public @ResponseBody List<SundryAssetsWay> selectAllSundryAssetsWay() {
		return assetsService.selectAllSundryAssetsWay();
	}
	/**
	 * big：一级部门
	 * small：二级部门
	 * @return
	 */
	@RequestMapping(value = "selectallbasedepartment")
	public @ResponseBody Map<String, List<BaseDepartment>> selectAllBaseDepartment() {
		return assetsService.selectAllBaseDepartment();
	}
	/**
	 * 获取所有承包商
	 * @return
	 */
	@RequestMapping(value = "selectallbasecontractor")
	public @ResponseBody List<BaseContractor> selectAllBaseContractor() {
		return assetsService.selectAllBaseContractor();
	}
	/**
	 * 获取所有供应商
	 * @return
	 */
	@RequestMapping(value = "selectallsupplier")
	public @ResponseBody List<Supplier> selectAllSupplier() {
		return assetsService.selectAllSupplier();
	}
	/**
	 * 根据ID查单个
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "selectbypk")
	public @ResponseBody Assets selectByPK(Integer id) {
		return assetsService.selectByPK(id);
	}
	/**
	 * 根据ID假删单个
	 * 需要获取session里面的user赋值操作用户信息
	 * @param id
	 * @param session
	 */
	@RequestMapping(value = "deletebypk")
	public @ResponseBody void updateShowByPK(Integer id,HttpSession session) {
		User u=(User) session.getAttribute("user");
		assetsService.updateShow(id,u.getName());
		
	}
	/**
	 * 监测编号是否已存在
	 * @param no
	 * @return
	 */
	@RequestMapping(value = "checkno")
	public @ResponseBody boolean checkNo(String no) {
		return assetsService.checkNo(no);
	}
	/**
	 * 根据部门ID查询相应的一对多的信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "changedepartment")
	public @ResponseBody Map<String, Object> changeDepartment(Integer id) {
		return assetsService.changeDepartment(id);
	}
	/**
	 * 根据 部门ID查询他的编号（no）
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "onlychangedepartment")
	public @ResponseBody BaseDepartment onlyChangeDepartment(Integer id) {
		return assetsService.onlyChangeDepartment(id);
	}
	/**
	 * 获取位置信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "changeposition")
	public @ResponseBody Position changePosition(Integer id) {
		return assetsService.changePosition(id);
	}
	/**
	 * 更新资产
	 * @param assets
	 */
	@RequestMapping(value = "update")
	public @ResponseBody void update(@RequestBody Assets assets){
		assets.setShow(1);
		assetsService.update(assets);
	}
	/**
	 * 添加资产
	 * @param assets
	 */
	@RequestMapping(value = "add")
	public @ResponseBody void add(@RequestBody Assets assets){
		assets.setShow(1);
		assetsService.add(assets);
	}
}
