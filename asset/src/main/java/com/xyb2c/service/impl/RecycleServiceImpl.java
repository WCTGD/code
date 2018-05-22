package com.xyb2c.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb2c.dao.BaseContractorMapper;
import com.xyb2c.dao.PositionMapper;
import com.xyb2c.dao.RecycleMapper;
import com.xyb2c.dao.SupplierMapper;
import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.LocationConditions;
import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.pojo.Supplier;
import com.xyb2c.service.RecycleService;

@Service("recycleService")
public class RecycleServiceImpl implements RecycleService {
//	@Autowired
//	AssetsMapper assetsMapper;
//	
	@Autowired
	SupplierMapper supplierMapper;
	
	@Autowired
	PositionMapper positionMapper;
	
//	@Autowired
//	RepairListMapper repairListMapper;
	
	@Autowired
	BaseContractorMapper baseContractorMapper;
	@Autowired
	RecycleMapper recycleMapper;

	@SuppressWarnings("null")
	@Override
	public List<Recycle> selectRecycle(PageBean page,Recycle recycle,String starts,String ends) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start=null;
		Date end=null;
		if(!starts.equals("") &&! end.equals("")){
		try {
			start = sdf.parse(starts);
			end= sdf.parse(ends);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		page.setTotalRecord(recycleMapper.recycleCount(recycle,start,end));
		return recycleMapper.selectRecycle(recycle, page, end, end);
	}

	@Override
	public List<Recycle> selectRecycleType() {
		return recycleMapper.selectRecycleType();
	}

	@Override
	public void updateRecycleByFkidByTbname(String id) {
		if(id != null &&! id.equals("")){
			Recycle recycle =recycleMapper.selectRecycleById(Integer.parseInt(id));
			if(recycle.getFkId() != null &&! recycle.getFkId().equals("") && recycle.getTbName() != null &&! recycle.getTbName().equals("")){
				recycleMapper.updateRecycleByFkidByTbname(recycle.getFkId(), recycle.getTbName());
				recycleMapper.deleteRecycleById(Integer.parseInt(id));
			}
		}
		
	}

	@Override
	public LocationConditions positionSelect(String id) {
		LocationConditions lConditions =positionMapper.selectPositionByShow(Integer.parseInt(id));
		return lConditions;
	}
	
	
	/**
	 * 根据id查询出fkId
	 * @param id
	 * @return
	 */
	public Recycle recycle2(String id){
		Recycle recycle =recycleMapper.selectRecycleById(Integer.parseInt(id));
		return recycle;
	}

	@Override
	public Supplier selectSupplierByShow(String id) {
		Supplier supplier = supplierMapper.selectSupplierByShow(Integer.parseInt(id));
		return supplier;
	}

	@Override
	public BaseContractor selectBaseContractorByflag(String id) {
		return baseContractorMapper.selectBaseContractorByflag(Integer.parseInt(id));
	}

	@Override
	public Recycle recycleSelectId(String id) {
		Recycle recycle =recycleMapper.selectRecycleById(Integer.parseInt(id));
		return recycle;
	}
}
