package com.xyb2c.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb2c.dao.AssetsMapper;
import com.xyb2c.dao.PositionMapper;
import com.xyb2c.dao.RecycleMapper;
import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.LocationConditions;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.service.PositionService;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
	@Autowired
	PositionMapper positionMapper;
	
	@Autowired
	AssetsMapper assetsMapper;
	
	@Autowired
	RecycleMapper recycleMapper;

	@Override
	public List<LocationConditions> positionList(LocationConditions locationConditions,PageBean page) {
		List<LocationConditions> list = positionMapper.positionList(locationConditions,page);
		return list;
	}
	
	@Override
	public int positionCount(LocationConditions locationConditions) {
		return positionMapper.positionCount(locationConditions);
	}

	@Override
	public List<LocationConditions> positionListPage(PageBean page) {
		return positionMapper.positionListPage(page);
	}

	@Override
	public List<BaseDepartment> selectDepartment() {
		return positionMapper.selectDepartment();
	}

	@Override
	public LocationConditions selectLocationNumberByDepartmentId(Integer id) {
		return positionMapper.selectLocationNumberByDepartmentId(id);
	}

	@Override
	public void insert(LocationConditions lc) {
		positionMapper.insertPosition(lc);
	}

	@Override
	public void deleteById(String ids,String name) {
		positionMapper.deleteById(Integer.parseInt(ids));
		Recycle r=new Recycle();
		r.setOperation(name);
		r.setTbName("position");
		r.setFkId(Integer.parseInt(ids));
		r.setType("位置");
		recycleMapper.insert(r);
	}

	@Override
	public LocationConditions selectPlaceById(String ids) {
		return positionMapper.selectPlaceById(Integer.parseInt(ids));
	}
	
	@Override
	public LocationConditions updateLocationNumberByDepartmentId(String aids) {
		Integer aid= Integer.parseInt(aids);
		return positionMapper.updateLocationNumberByDepartmentId(aid);
	}

	@Override
	public void updateById(LocationConditions locationConditions) {
		positionMapper.updateById(locationConditions);
	}

	@Override
	public BaseDepartment selectLocationNumberByDepartment(String id) {
		return positionMapper.selectLocationNumberByDepartment(Integer.parseInt(id));
	}

	@Override
	public BaseDepartment selectDepartmentById(String id) {
		return positionMapper.selectDepartmentById(Integer.parseInt(id));
	}

	@Override
	public LocationConditions selectPositionByNo(String no, String id) {
		BaseDepartment bd= positionMapper.selectDepartmentById(Integer.parseInt(id));// 获取部门编号
		String aNo;
		if(Integer.parseInt(no)<10){ //获取位置no
			 aNo = bd.getNo()+"-00"+Integer.parseInt(no);
		}else if(Integer.parseInt(no)<100 && Integer.parseInt(no) >=10) {
			 aNo = bd.getNo()+"-0"+Integer.parseInt(no);
		}else{
			 aNo = bd.getNo()+"-"+Integer.parseInt(no);
		}
		LocationConditions lConditions = new LocationConditions();
		lConditions.setaNo(aNo);
		String s = aNo.substring(aNo.length()-3, aNo.length()); // 截取该部门编号最大的最后3位
		lConditions.setPosition(bd.getDepartment()+s+"号");
		System.out.println("拼接好的:"+bd.getDepartment()+s+"号");
		return lConditions; // 拼接好的位置编号
	}

	@Override
	public LocationConditions judgeExist(LocationConditions loc) {
		 List<LocationConditions> lConditions = positionMapper.selectlc();
		 LocationConditions lc = new LocationConditions();
		 Map<String , Object> map = new HashMap<>();
		 for(LocationConditions locationConditions : lConditions){
			 map.put(locationConditions.getaNo(), locationConditions.getaNo());
		 }
		 if(!map.containsKey(loc.getaNo())){
			lc.setaNo(loc.getaNo());
			if(loc.getPosition() != null &&! loc.getPosition().equals("")){
				System.out.println("position:"+loc.getPosition());
			lc.setPosition(loc.getPosition());
			}
		 }else {
			 lc.setJudge("1");
		 }
		return lc;
	}

	@Override
	public int delectJudge(Integer id) {
		List<Assets> list = assetsMapper.selectAssets();
		 Map<String , Object> map = new HashMap<>();
		 list.forEach(assets->map.put(assets.getPositionNo(), assets.getPositionId()));
		 if(map.containsValue(id)){
			 return 1;
		 }
		return 2;
	}

}
