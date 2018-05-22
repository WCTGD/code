package com.xyb2c.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.LocationConditions;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.pojo.Supplier;
import com.xyb2c.service.AssetsService;
import com.xyb2c.service.MaintainService;
import com.xyb2c.service.RecycleService;
import com.xyb2c.service.RepairlistService;

@Controller
@RequestMapping(value = "/recycle")
public class RecycleController {
	@Autowired
	RecycleService recycleService;
	
	@Autowired
	AssetsService assetsService;
	
	@Autowired
	MaintainService maintainService;
	
	@Autowired
	RepairlistService repairList;
	
	
	/**
	 * 回收站 列表
	 * @param maps
	 * @return
	 */
	@RequestMapping(value="/select")
	@ResponseBody
	public Map<String, Object> select( @RequestBody Map<String,String> maps){
		Recycle recycle =new Recycle();
		recycle.setType(maps.get("type"));
		String start = maps.get("startType");
		String end = maps.get("endType");
		PageBean page= new PageBean();
		page.setPageCode(Integer.parseInt(maps.get("pageCode")));
		page.setPageSize(Integer.parseInt(maps.get("pageSize")));
		List<Recycle> list = recycleService.selectRecycle(page, recycle, start, end);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(Recycle l : list){
			String startTime = sdf.format(l.getCreateTime());
			l.setTime(startTime);
		}
		List<Recycle> recyclesType = recycleService.selectRecycleType();
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("page", page);
		map.put("recyclesType", recyclesType);
		return map;
	}
	

	/**
	 * 回收站 恢复
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public int update(HttpServletRequest request){
		if(request.getParameter("id") !=null &&! request.getParameter("id").equals("")){
			recycleService.updateRecycleByFkidByTbname(request.getParameter("id"));
		return 1;
		}
		return 2;
	}
	
	
	/**
	 * 回收站 查看
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/selectById")
	@ResponseBody
	public Recycle selectById(HttpServletRequest request){
		String fkId =request.getParameter("id");
		return recycleService.recycleSelectId(fkId);
	}
	
	
	/**
	 * 位置 查看
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/positionSelect")
	@ResponseBody
	public LocationConditions positionSelect(HttpServletRequest request){
		return recycleService.positionSelect(request.getParameter("id"));
	}
	
	
	/**
	 *  供应商 查看
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/supplierSelect")
	@ResponseBody
	public Supplier supplierSelect(HttpServletRequest request){
		return recycleService.selectSupplierByShow(request.getParameter("id"));
	}
	
	
	/**
	 *  承包商 查看
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/baseContractorSelect")
	@ResponseBody
	public BaseContractor baseContractorSelect(HttpServletRequest request){
		return recycleService.selectBaseContractorByflag(request.getParameter("id"));
	}

}
