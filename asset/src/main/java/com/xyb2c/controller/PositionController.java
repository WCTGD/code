package com.xyb2c.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.LocationConditions;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.User;
import com.xyb2c.service.PositionService;
import com.xyb2c.util.position.PositionJudge;

@Controller
@RequestMapping(value = "/position")
public class PositionController {
	@Autowired
	PositionService positionService;

	/**
	 * 位置页面条件查询
	 * @param maps
	 * @return
	 */
	@RequestMapping(value = "/positionList")
	@ResponseBody
	public Map<String, Object> positionList(
			 @RequestBody Map<String,String> maps) {
		LocationConditions locationConditions = new LocationConditions();
			               locationConditions.setbNo(maps.get("bNo"));
			               locationConditions.setaNo(maps.get("aNo"));
			               locationConditions.setPosition(maps.get("position"));
			               locationConditions.setDepartment(maps.get("department"));
		PageBean page= new PageBean();
				 page.setPageCode(Integer.parseInt(maps.get("pageCode")));
				 page.setPageSize(Integer.parseInt(maps.get("pageSize")));
		List<LocationConditions> list = positionService.positionList(locationConditions, page);
		List<BaseDepartment> departments = positionService.selectDepartment();
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("departments", departments);
		page.setTotalRecord(positionService.positionCount(locationConditions));
		map.put("page", page);
		return map;
	}

	
	/**
	 * 部门查询
	 * @return
	 */
	@RequestMapping(value = "selectDepartment",method = RequestMethod.GET)
	@ResponseBody
	public void selectDepartment(HttpServletResponse response){
		try{
		List<BaseDepartment> departments = positionService.selectDepartment();
		Map<String, Object> map = new HashMap<>();
		map.put("departments", departments);
		response.getWriter().print(new Gson().toJson(map));	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 查询部门
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/alterDepartment",method = RequestMethod.GET)
	@ResponseBody 
	public void alterDepartment(HttpServletRequest request,HttpServletResponse response){
		try{
			response.setContentType("application/json;charset=utf-8");
			String id = request.getParameter("dId");
			LocationConditions lists = positionService.selectLocationNumberByDepartmentId(Integer.parseInt(id));
			Map<String, Object> map = new HashMap<>();
			map.put("noId", lists);
			response.getWriter().print(new Gson().toJson(map));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 位置编号查询
	 * @param idString
	 * @return
	 */
	@RequestMapping(value = "/departmentId",method = RequestMethod.GET)
	@ResponseBody 
	public void selectLocationNumberByDepartmentId(HttpServletRequest request,HttpServletResponse response){
		try{
			response.setContentType("application/json;charset=utf-8");
			String id = request.getParameter("dId");
			String no = request.getParameter("aNo");
			Map<String, Object> map = new HashMap<>();
			if(PositionJudge.insterSelectJudge(id, no) != 1){
			LocationConditions loc = positionService.selectPositionByNo(no, id);
			LocationConditions lc = positionService.judgeExist(loc);
			map.put("lc", lc);
			response.getWriter().print(new Gson().toJson(map));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	/**
	 * 位置添加
	 * @param position
	 * @return
	 */
	@RequestMapping(value="insert",method = RequestMethod.POST)
	public String insert(LocationConditions lc){
		if(PositionJudge.judge(lc) != 1){
			positionService.insert(lc);
		}
		return "redirect:/html/positionList.html";
	}
	
	
	/**
	 * 位置删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="delete",method = RequestMethod.GET)
	@ResponseBody 
	public int delete(HttpServletRequest request,HttpSession session){
		String id = request.getParameter("id");
		if(PositionJudge.delectById(id) != 1){
			if(positionService.delectJudge(Integer.parseInt(id)) == 2){
				User u=(User) session.getAttribute("user");
				positionService.deleteById(id,u.getName());
			}
		}
		return positionService.delectJudge(Integer.parseInt(id));
	}
	
	/**
	 * 位置修改前的查询
	 * @return
	 */
	@RequestMapping(value="selectPlaceById",method = RequestMethod.GET)
	@ResponseBody
	public void selectPlaceById(HttpServletRequest req,HttpServletResponse response){
		try{
		response.setContentType("application/json;charset=utf-8");
		String id = req.getParameter("id");
		LocationConditions locationConditions = positionService.selectPlaceById(id);
		//截取该部门编号最后3位 (保留到百位)
		String best = locationConditions.getaNo().substring(locationConditions.getaNo().length()-3, locationConditions.getaNo().length());
		Map<String, Object> map = new HashMap<>();
		map.put("locationId", locationConditions);
		map.put("best", Integer.parseInt(best));
		List<BaseDepartment> departments = positionService.selectDepartment();
		map.put("departments", departments);
		response.getWriter().print(new Gson().toJson(map));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 修改的位置编号查询
	 * @param idString
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/lNumber",method = RequestMethod.GET)
	@ResponseBody
	public void selectLocationNumber(HttpServletRequest request,HttpServletResponse response){
		try{
			response.setContentType("application/json;charset=utf-8");
			String bids =request.getParameter("aNo"); // 传上来一个新的选中的部门id   b_id
			Integer bid = Integer.parseInt(bids);
			String aid=request.getParameter("aId");// 传上来的位置ID
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 修改位置
	 * @param lc
	 */
	@RequestMapping(value="updatePosition",method = RequestMethod.POST)
	public String updatePosition(LocationConditions locationConditions){
		System.out.println(locationConditions.toString());
		if(PositionJudge.LocationConditionsJudge(locationConditions) !=1){
		positionService.updateById(locationConditions);
		return "redirect:/html/positionList.html";
		}
		return "redirect:/html/positionList.html";
	}
	
	
	/**
	 * 部门发生改变时显示部门编号
	 * @param req
	 * @param response
	 */
	@RequestMapping(value="selectDepartmentByName",method = RequestMethod.GET)
	@ResponseBody
	public void selectDepartmentByName(HttpServletRequest req,HttpServletResponse response){
		try{
		response.setContentType("application/json;charset=utf-8");
		String  id= req.getParameter("department");
		Map<String, Object> map = new HashMap<>();
		if(id != null &&! id.equals("")){
			BaseDepartment baseDepartment = positionService.selectLocationNumberByDepartment(id);
			map.put("location", baseDepartment);
			response.getWriter().print(new Gson().toJson(map));	
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
