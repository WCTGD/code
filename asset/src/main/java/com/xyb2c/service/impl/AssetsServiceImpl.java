package com.xyb2c.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb2c.dao.AssetsMapper;
import com.xyb2c.dao.BaseAssetClassMapper;
import com.xyb2c.dao.BaseContractorMapper;
import com.xyb2c.dao.BaseDepartmentMapper;
import com.xyb2c.dao.PositionMapper;
import com.xyb2c.dao.RecycleMapper;
import com.xyb2c.dao.SundryAssetsStateMapper;
import com.xyb2c.dao.SundryAssetsWayMapper;
import com.xyb2c.dao.SupplierMapper;
import com.xyb2c.dao.WorkerMapper;
import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.AssetsExample;
import com.xyb2c.pojo.AssetsExample.Criteria;
import com.xyb2c.pojo.BaseAssetClass;
import com.xyb2c.pojo.BaseAssetClassExample;
import com.xyb2c.pojo.BaseContractor;
import com.xyb2c.pojo.BaseContractorExample;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.BaseDepartmentExample;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.PositionExample;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.pojo.SundryAssetsState;
import com.xyb2c.pojo.SundryAssetsStateExample;
import com.xyb2c.pojo.SundryAssetsWay;
import com.xyb2c.pojo.Supplier;
import com.xyb2c.pojo.SupplierExample;
import com.xyb2c.pojo.Worker;
import com.xyb2c.pojo.WorkerExample;
import com.xyb2c.service.AssetsService;
import com.xyb2c.util.RecursionUtil;

@Service("assetsService")
public class AssetsServiceImpl implements AssetsService {
	@Autowired
	AssetsMapper assetsMapper;


	@Autowired
	PositionMapper positionMapper;


	@Autowired
	BaseContractorMapper baseContractorMapper;


	@Autowired
	BaseDepartmentMapper baseDepartmentMapper;


	@Autowired
	WorkerMapper workerMapper;


	@Autowired
	SupplierMapper supplierMapper;


	@Autowired
	BaseAssetClassMapper baseAssetClassMapper;


	@Autowired
	SundryAssetsStateMapper sundryAssetsStateMapper;


	@Autowired
	SundryAssetsWayMapper sundryAssetsWayMapper;
	@Autowired
	RecycleMapper recycleMapper;

	@Override
	public List<Assets> select(int start, int size, Assets asset, Date repair1, Date repair2, Date stuse1,
			Date stuse2) {
		AssetsExample assetsExample=new AssetsExample();
		assetsExample.setStart(start);
		assetsExample.setSize(size);
		Criteria c = assetsExample.createCriteria();
		c.andShowEqualTo(1);
		if (repair1 != null) {
			c.andWarrantyDeadlineGreaterThanOrEqualTo(repair1);
		}
		if (repair2 != null) {
			c.andWarrantyDeadlineLessThanOrEqualTo(repair2);
		}
		if (stuse1 != null) {
			c.andStartDateGreaterThanOrEqualTo(stuse1);
		}
		if (stuse2 != null) {
			c.andStartDateLessThanOrEqualTo(stuse2);
		}
		if (asset != null) {
			if (!("".equals(asset.getNo()) || asset.getNo() == null)) {
				c.andNoLike("%" + asset.getNo() + "%");
			}
			if (!("".equals(asset.getPositionNo()) || asset.getPositionNo() == null)) {
				PositionExample positionExample=new PositionExample();
				PositionExample.Criteria pc = positionExample.createCriteria();
				pc.andNoLike("%" + asset.getPositionNo() + "%");
				List<Position> positions = positionMapper.selectByExample(positionExample);
				if (!(positions == null || positions.isEmpty())) {
					List<Integer> pids = new ArrayList<Integer>();
					for (Position position : positions) {
						pids.add(position.getId());
					}
					c.andPositionIdIn(pids);
				} else {
					List<Assets> l = new ArrayList<>();
					return l;
				}
			}
			if (!("".equals(asset.getDepartmentNo()) || asset.getDepartmentNo() == null)) {
				BaseDepartmentExample baseDepartmentExample=new BaseDepartmentExample();
				BaseDepartmentExample.Criteria cbp = baseDepartmentExample.createCriteria();
				cbp.andNoLike("%" + asset.getDepartmentNo() + "%");
				List<BaseDepartment> baseDepartments = baseDepartmentMapper.selectByExample(baseDepartmentExample);
				if (!(baseDepartments == null || baseDepartments.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (BaseDepartment baseDepartment : baseDepartments) {
						ids.add(baseDepartment.getId());
					}
					c.andDepartmentIdIn(ids);
				} else {
					List<Assets> l = new ArrayList<>();
					return l;
				}
			}
			if (!("".equals(asset.getSupplierName()) || asset.getSupplierName() == null)) {
				SupplierExample supplierExample=new SupplierExample();
				SupplierExample.Criteria sc = supplierExample.createCriteria();
				sc.andSupplierNameLike("%" + asset.getSupplierName() + "%");
				List<Supplier> suppliers = supplierMapper.selectByExample(supplierExample);
				if (!(suppliers == null || suppliers.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (Supplier supplier : suppliers) {
						ids.add(supplier.getId());
					}
					c.andSupplierIdIn(ids);
				} else {
					List<Assets> l = new ArrayList<>();
					return l;
				}
			}
			if (!("".equals(asset.getAssetClass()) || asset.getAssetClass() == null)) {
				BaseAssetClassExample baseAssetClassExample=new BaseAssetClassExample();
				BaseAssetClassExample.Criteria bc = baseAssetClassExample.createCriteria();
				bc.andAssetCategoryEqualTo(asset.getAssetClass());
				List<BaseAssetClass> baseAssetClasses = baseAssetClassMapper.selectByExample(baseAssetClassExample);
				if (!(baseAssetClasses == null || baseAssetClasses.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (BaseAssetClass baseAssetClass : baseAssetClasses) {
						ids.add(baseAssetClass.getId());
					}
					c.andClassIdIn(ids);
				} else {
					List<Assets> l = new ArrayList<>();
					return l;
				}
			}
			if (!("".equals(asset.getWokerName()) || asset.getWokerName() == null)) {
				WorkerExample workerExample=new WorkerExample();
				WorkerExample.Criteria wc = workerExample.createCriteria();
				wc.andNameEqualTo(asset.getWokerName());
				List<Worker> wokers = workerMapper.selectByExample(workerExample);
				if (!(wokers == null || wokers.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (Worker woker : wokers) {
						ids.add(woker.getId());
					}
					c.andWokerIdIn(ids);
				} else {
					List<Assets> l = new ArrayList<>();
					return l;
				}
			}
			if (!("".equals(asset.getAssetState()) || asset.getAssetState() == null)) {
				SundryAssetsStateExample sundryAssetsStateExample=new SundryAssetsStateExample();
				SundryAssetsStateExample.Criteria sc = sundryAssetsStateExample.createCriteria();
				sc.andInformationEqualTo(asset.getAssetState());
				List<SundryAssetsState> sundryAssetsStates = sundryAssetsStateMapper
						.selectByExample(sundryAssetsStateExample);
				if (!(sundryAssetsStates == null || sundryAssetsStates.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (SundryAssetsState sundryAssetsState : sundryAssetsStates) {
						ids.add(sundryAssetsState.getId());
					}
					c.andStateIdIn(ids);
				} else {
					List<Assets> l = new ArrayList<>();
					return l;
				}
			}
			if (!("".equals(asset.getType()) || asset.getType() == null)) {
				c.andTypeEqualTo(asset.getType());
			}
		}
		List<Assets> assets = assetsMapper.selectByExamplePage(assetsExample);
		for (int i = 0; i < assets.size(); i++) {
			Assets ass = assets.get(i);
			ass.setBaseAssetClass(baseAssetClassMapper.selectByPrimaryKey(ass.getClassId()));
			ass.setBaseContractor(baseContractorMapper.selectByPrimaryKey(ass.getContractorId()));
			ass.setBaseDepartment(baseDepartmentMapper.selectByPrimaryKey(ass.getDepartmentId()));
			ass.setPosition(positionMapper.selectByPrimaryKey(ass.getPositionId()));
			ass.setSundryAssetsState(sundryAssetsStateMapper.selectByPrimaryKey(ass.getStateId()));
			ass.setSundryAssetsWay(sundryAssetsWayMapper.selectByPrimaryKey(ass.getWayId()));
			ass.setSupplier(supplierMapper.selectByPrimaryKey(ass.getSupplierId()));
			ass.setWorker(workerMapper.selectByPrimaryKey(ass.getWokerId()));
		}
		return assets;
	}

	public int count(Assets asset, Date repair1, Date repair2, Date stuse1, Date stuse2) {
		AssetsExample assetsExample=new AssetsExample();
		Criteria c = assetsExample.createCriteria();
		c.andShowEqualTo(1);
		if (repair1 != null) {
			c.andWarrantyDeadlineGreaterThanOrEqualTo(repair1);
		}
		if (repair2 != null) {
			c.andWarrantyDeadlineLessThanOrEqualTo(repair2);
		}
		if (stuse1 != null) {
			c.andStartDateGreaterThanOrEqualTo(stuse1);
		}
		if (stuse2 != null) {
			c.andStartDateLessThanOrEqualTo(stuse2);
		}
		if (asset != null) {
			if (!("".equals(asset.getNo()) || asset.getNo() == null)) {
				c.andNoLike("%" + asset.getNo() + "%");
			}
			if (!("".equals(asset.getPositionNo()) || asset.getPositionNo() == null)) {
				PositionExample positionExample=new PositionExample();
				PositionExample.Criteria pc = positionExample.createCriteria();
				pc.andNoLike("%" + asset.getPositionNo() + "%");
				List<Position> positions = positionMapper.selectByExample(positionExample);
				if (!(positions == null || positions.isEmpty())) {
					List<Integer> pids = new ArrayList<Integer>();
					for (Position position : positions) {
						pids.add(position.getId());
					}
					c.andPositionIdIn(pids);
				} else {
					return 0;
				}
			}
			if (!("".equals(asset.getDepartmentNo()) || asset.getDepartmentNo() == null)) {
				BaseDepartmentExample baseDepartmentExample=new BaseDepartmentExample();
				BaseDepartmentExample.Criteria cbp = baseDepartmentExample.createCriteria();
				cbp.andNoLike("%" + asset.getDepartmentNo() + "%");
				List<BaseDepartment> baseDepartments = baseDepartmentMapper.selectByExample(baseDepartmentExample);
				if (!(baseDepartments == null || baseDepartments.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (BaseDepartment baseDepartment : baseDepartments) {
						ids.add(baseDepartment.getId());
					}
					c.andDepartmentIdIn(ids);
				} else {
					return 0;
				}
			}
			if (!("".equals(asset.getSupplierName()) || asset.getSupplierName() == null)) {
				SupplierExample supplierExample=new SupplierExample();
				SupplierExample.Criteria sc = supplierExample.createCriteria();
				sc.andSupplierNameLike("%" + asset.getSupplierName() + "%");
				List<Supplier> suppliers = supplierMapper.selectByExample(supplierExample);
				if (!(suppliers == null || suppliers.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (Supplier supplier : suppliers) {
						ids.add(supplier.getId());
					}
					c.andSupplierIdIn(ids);
				} else {
					return 0;
				}
			}
			if (!("".equals(asset.getAssetClass()) || asset.getAssetClass() == null)) {
				BaseAssetClassExample baseAssetClassExample=new BaseAssetClassExample();
				BaseAssetClassExample.Criteria bc = baseAssetClassExample.createCriteria();
				bc.andAssetCategoryEqualTo(asset.getAssetClass());
				List<BaseAssetClass> baseAssetClasses = baseAssetClassMapper.selectByExample(baseAssetClassExample);
				if (!(baseAssetClasses == null || baseAssetClasses.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (BaseAssetClass baseAssetClass : baseAssetClasses) {
						ids.add(baseAssetClass.getId());
					}
					c.andClassIdIn(ids);
				} else {
					return 0;
				}
			}
			if (!("".equals(asset.getWokerName()) || asset.getWokerName() == null)) {
				WorkerExample workerExample=new WorkerExample();
				WorkerExample.Criteria wc = workerExample.createCriteria();
				wc.andNameEqualTo(asset.getWokerName());
				List<Worker> wokers = workerMapper.selectByExample(workerExample);
				if (!(wokers == null || wokers.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (Worker woker : wokers) {
						ids.add(woker.getId());
					}
					c.andWokerIdIn(ids);
				} else {
					return 0;
				}
			}
			if (!("".equals(asset.getAssetState()) || asset.getAssetState() == null)) {
				SundryAssetsStateExample sundryAssetsStateExample=new SundryAssetsStateExample();
				SundryAssetsStateExample.Criteria sc = sundryAssetsStateExample.createCriteria();
				sc.andInformationEqualTo(asset.getAssetState());
				List<SundryAssetsState> sundryAssetsStates = sundryAssetsStateMapper
						.selectByExample(sundryAssetsStateExample);
				if (!(sundryAssetsStates == null || sundryAssetsStates.isEmpty())) {
					List<Integer> ids = new ArrayList<Integer>();
					for (SundryAssetsState sundryAssetsState : sundryAssetsStates) {
						ids.add(sundryAssetsState.getId());
					}
					c.andStateIdIn(ids);
				} else {
					return 0;
				}
			}
			if (!("".equals(asset.getType()) || asset.getType() == null)) {
				c.andTypeEqualTo(asset.getType());
			}
		}
		return assetsMapper.countByExample(assetsExample);
	}

	public List<BaseAssetClass> selectAllBaseAssetClass() {
		BaseAssetClassExample baseAssetClassExample=new BaseAssetClassExample();
		BaseAssetClassExample.Criteria c = baseAssetClassExample.createCriteria();
		c.andIdIsNotNull();
		return baseAssetClassMapper.selectByExample(baseAssetClassExample);
	}

	public List<SundryAssetsState> selectAllSundryAssetsState() {
		return sundryAssetsStateMapper.selectByExample(null);
	}

	public List<SundryAssetsWay> selectAllSundryAssetsWay() {
		return sundryAssetsWayMapper.selectByExample(null);
	}

	public Map<String,List<BaseDepartment>> selectAllBaseDepartment() {
		Map<String, List<BaseDepartment>> map=new TreeMap<>();
		BaseDepartmentExample be=new BaseDepartmentExample();
		BaseDepartmentExample.Criteria bc=be.createCriteria();
		bc.andPIdEqualTo(0);
		List<BaseDepartment> bigs=baseDepartmentMapper.selectByExample(be);
		map.put("big",bigs );
		List<Integer> ids=new ArrayList<>();
		for (BaseDepartment baseDepartment : bigs) {
			ids.add(baseDepartment.getId());
		}
		be=new BaseDepartmentExample();
		bc=be.createCriteria();
		bc.andPIdIn(ids);
		map.put("small", baseDepartmentMapper.selectByExample(be));
		return map;
	}

	public List<BaseContractor> selectAllBaseContractor() {
		BaseContractorExample be=new BaseContractorExample();
		BaseContractorExample.Criteria bc=be.createCriteria();
		bc.andFlagEqualTo(1);
		return baseContractorMapper.selectByExample(be);
	}

	public List<Supplier> selectAllSupplier() {
		SupplierExample se=new SupplierExample();
		SupplierExample.Criteria sc=se.createCriteria();
		sc.andFlagEqualTo(1);
		return supplierMapper.selectByExample(se);
	}

	public Assets selectByPK(int id) {
		Assets ass = assetsMapper.selectByPrimaryKey(id);
		ass.setBaseAssetClass(baseAssetClassMapper.selectByPrimaryKey(ass.getClassId()));
		ass.setBaseContractor(baseContractorMapper.selectByPrimaryKey(ass.getContractorId()));
		ass.setBaseDepartment(baseDepartmentMapper.selectByPrimaryKey(ass.getDepartmentId()));
		ass.setPosition(positionMapper.selectByPrimaryKey(ass.getPositionId()));
		ass.setSundryAssetsState(sundryAssetsStateMapper.selectByPrimaryKey(ass.getStateId()));
		ass.setSundryAssetsWay(sundryAssetsWayMapper.selectByPrimaryKey(ass.getWayId()));
		ass.setSupplier(supplierMapper.selectByPrimaryKey(ass.getSupplierId()));
		ass.setWorker(workerMapper.selectByPrimaryKey(ass.getWokerId()));
		return ass;
	}

	public void updateShow(int id,String name) {
		Assets ass = new Assets();
		ass.setId(id);
		ass.setDeleteTime(new Date());
		ass.setShow(0);
		assetsMapper.updateByPrimaryKeySelective(ass);
		Recycle r=new Recycle();
		r.setOperation(name);
		r.setTbName("assets");
		r.setFkId(ass.getId());
		r.setType("资产");
		recycleMapper.insert(r);
	}

	public boolean checkNo(String no) {
		if (no == null) {
			return false;
		}
		AssetsExample assetsExample=new AssetsExample();
		Criteria c = assetsExample.createCriteria();
		c.andNoEqualTo(no);
		if ("".equals(no) || !assetsMapper.selectByExample(assetsExample).isEmpty()) {
			return false;
		}
		return true;
	}
	public Map<String,Object> changeDepartment(Integer id) {
		if(id==null){
			return null;
		}
		Map<String,Object> map=new TreeMap<>();
		PositionExample positionExample=new PositionExample();
		PositionExample.Criteria pc=positionExample.createCriteria();
		pc.andDIdEqualTo(id);
		WorkerExample workerExample=new WorkerExample();
		WorkerExample.Criteria wc=workerExample.createCriteria();
		wc.andDIdIn(RecursionUtil.getListPid(baseDepartmentMapper.selectByExample(null), id));
		map.put("position", positionMapper.selectByExample(positionExample));
		map.put("worker", workerMapper.selectByExample(workerExample));
		map.put("no", baseDepartmentMapper.selectByPrimaryKey(id).getNo());
		return map;
	}
	public BaseDepartment onlyChangeDepartment(Integer id) {
		return baseDepartmentMapper.selectByPrimaryKey(id);
	}
	public Position changePosition(Integer id){
		return positionMapper.selectByPrimaryKey(id);
	}
	public void update(Assets assets){
		assetsMapper.updateByPrimaryKey(assets);
	}
	public void add(Assets assets){
		assets.setRegainTime(new Date());
		assetsMapper.insert(assets);
	}
	public List<Assets> selectPublicAssets(){
		AssetsExample ae=new AssetsExample();
		AssetsExample.Criteria c=ae.createCriteria();
		c.andShowEqualTo(1);
		c.andPublicPropertyEqualTo(1);
		return assetsMapper.selectByExample(ae);
	}
	public List<Assets> formSelect(int start,int size,Date d1,Date d2,Integer did){
		AssetsExample ae=new AssetsExample();
		ae.setStart(start);
		ae.setSize(size);
		AssetsExample.Criteria c=ae.createCriteria();
		c.andShowEqualTo(1);
		if (null!=d1) {
			c.andCreateTimeGreaterThanOrEqualTo(d1);
		}
		if (null!=d2) {
			c.andCreateTimeLessThanOrEqualTo(d2);
		}
		if(null!=did){
			c.andDepartmentIdEqualTo(did);
		}
		List<Assets> assets = assetsMapper.selectByExamplePage(ae);
		for (int i = 0; i < assets.size(); i++) {
			Assets ass = assets.get(i);
			ass.setBaseAssetClass(baseAssetClassMapper.selectByPrimaryKey(ass.getClassId()));
			ass.setBaseContractor(baseContractorMapper.selectByPrimaryKey(ass.getContractorId()));
			ass.setBaseDepartment(baseDepartmentMapper.selectByPrimaryKey(ass.getDepartmentId()));
			ass.setPosition(positionMapper.selectByPrimaryKey(ass.getPositionId()));
			ass.setSundryAssetsState(sundryAssetsStateMapper.selectByPrimaryKey(ass.getStateId()));
			ass.setSundryAssetsWay(sundryAssetsWayMapper.selectByPrimaryKey(ass.getWayId()));
			ass.setSupplier(supplierMapper.selectByPrimaryKey(ass.getSupplierId()));
			ass.setWorker(workerMapper.selectByPrimaryKey(ass.getWokerId()));
		}
		return assets;
	}
	public Integer formCount(Date d1,Date d2,Integer did){
		AssetsExample ae=new AssetsExample();
		AssetsExample.Criteria c=ae.createCriteria();
		c.andShowEqualTo(1);
		if (null!=d1) {
			c.andCreateTimeGreaterThanOrEqualTo(d1);
		}
		if (null!=d2) {
			c.andCreateTimeGreaterThanOrEqualTo(d2);
		}
		if(null!=did){
			c.andDepartmentIdEqualTo(did);
		}
		
		return assetsMapper.countByExample(ae);
	}
}
