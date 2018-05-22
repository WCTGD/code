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
import com.xyb2c.dao.BaseDepartmentMapper;
import com.xyb2c.dao.PositionMapper;
import com.xyb2c.dao.RecycleMapper;
import com.xyb2c.dao.RepairListMapper;
import com.xyb2c.dao.SundryAssetsStateMapper;
import com.xyb2c.dao.SundryAssetsWayMapper;
import com.xyb2c.dao.SundryUrgencyLevelMapper;
import com.xyb2c.dao.SundryWokerorderClassMapper;
import com.xyb2c.dao.SundryWokerorderStateMapper;
import com.xyb2c.dao.WorkerMapper;
import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.AssetsExample;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.BaseDepartmentExample;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.PositionExample;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.pojo.RepairList;
import com.xyb2c.pojo.RepairListExample;
import com.xyb2c.pojo.RepairListExample.Criteria;
import com.xyb2c.pojo.SundryUrgencyLevel;
import com.xyb2c.pojo.SundryWokerorderClass;
import com.xyb2c.pojo.SundryWokerorderState;
import com.xyb2c.pojo.Worker;
import com.xyb2c.pojo.WorkerExample;
import com.xyb2c.service.RepairlistService;
import com.xyb2c.util.RecursionUtil;

@Service
public class RepairListServiceImpl implements RepairlistService {
	@Autowired
	RepairListMapper repairListMapper;
	@Autowired
	SundryUrgencyLevelMapper urgencyLevelMapper;
	@Autowired
	SundryWokerorderClassMapper wokerorderClassMapper;
	@Autowired
	SundryWokerorderStateMapper wokerorderStateMapper;
	@Autowired
	AssetsMapper assetsMapper;
	@Autowired
	WorkerMapper workerMapper;
	@Autowired
	PositionMapper positionMapper;
	@Autowired
	SundryAssetsStateMapper assetsStateMapper;
	@Autowired
	SundryAssetsWayMapper assetsWayMapper;
	@Autowired
	BaseDepartmentMapper baseDepartmentMapper;
	@Autowired
	BaseAssetClassMapper baseAssetClassMapper;
	@Autowired
	RecycleMapper recycleMapper;
	@Override
	public List<SundryWokerorderClass> selectAllSundryWokerorderClass() {
		return wokerorderClassMapper.selectByExample(null);
	}

	@Override
	public List<SundryWokerorderState> selectAllSundryWokerorderState() {
		return wokerorderStateMapper.selectByExample(null);
	}

	@Override
	public List<SundryUrgencyLevel> selectAllSundryUrgencyLevel() {
		return urgencyLevelMapper.selectByExample(null);
	}

	@Override
	public void update(Integer id,String name) {
		RepairList repairList = new RepairList();
		repairList.setId(id);
		repairList.setFlag(0);
		repairListMapper.updateByPrimaryKeySelective(repairList);
		Recycle r=new Recycle();
		r.setOperation(name);
		r.setTbName("repair_list");
		r.setFkId(id);
		r.setType("维修");
		recycleMapper.insert(r);
	}

	@Override
	public Integer realUpdate(RepairList repairList) {
		SundryWokerorderState sw=wokerorderStateMapper.selectByPrimaryKey(repairList.getWorkerorderStateId());
		if ("完成".equals(sw.getInformation())||"关闭".equals(sw.getInformation())) {
			RepairList rl = repairListMapper.selectByPrimaryKey(repairList.getId());
			if (rl.getRealFinishTime() == null) {
				repairList.setRealFinishTime(new Date());
				repairList.setStartTime(rl.getStartTime());
			}
		}
		return repairListMapper.updateByPrimaryKey(repairList);
	}

	@Override
	public RepairList selectOne(Integer id) {
		RepairList rl = repairListMapper.selectByPrimaryKey(id);
		if(rl.getStartTime()==null){
			rl.setStartTime(new Date());
			repairListMapper.updateByPrimaryKey(rl);
		}
		rl.setWokerorderClass(wokerorderClassMapper.selectByPrimaryKey(rl.getWorkerorderClassId()));
		rl.setWokerorderState(wokerorderStateMapper.selectByPrimaryKey(rl.getWorkerorderStateId()));
		rl.setAssets(assetsMapper.selectByPrimaryKey(rl.getAssetId()));
		rl.setWorker(workerMapper.selectByPrimaryKey(rl.getWorkerId()));
		rl.setLaunchworker(workerMapper.selectByPrimaryKey(rl.getLaunchworkerId()));
		rl.setLevel(urgencyLevelMapper.selectByPrimaryKey(rl.getLevelId()));
		return rl;
	}

	@Override
	public List<RepairList> select(RepairList repairList, Integer assetsClassId, Date date1, Date date2, int start,
			int length,Integer pid,Integer flag) {
		RepairListExample re = new RepairListExample();
		re.setStart(start);
		re.setLength(length);
		Criteria c = re.createCriteria();
		c.andFlagEqualTo(flag);
		
		List<Integer> ids = null;
		if(pid!=null){
			AssetsExample ae = new AssetsExample();
			AssetsExample.Criteria ac = ae.createCriteria();
			ac.andPositionIdEqualTo(pid);
			List<Assets> assets = assetsMapper.selectByExample(ae);
			ids = new ArrayList<>();
			for (Assets asset : assets) {
				ids.add(asset.getId());
			}
			if (ids == null || ids.size() == 0) {
				return new ArrayList<>();
			}
		}
		if (assetsClassId != null) {
			AssetsExample ae = new AssetsExample();
			AssetsExample.Criteria ac = ae.createCriteria();
			ac.andClassIdEqualTo(assetsClassId);
			List<Assets> assets = assetsMapper.selectByExample(ae);
			ids = new ArrayList<>();
			for (Assets asset : assets) {
				ids.add(asset.getId());
			}
			if (ids == null || ids.size() == 0) {
				return new ArrayList<>();
			}
		}
		if (repairList != null) {
			if (repairList.getNo() != null && !repairList.getNo().equals("")) {
				c.andNoLike("%" + repairList.getNo() + "%");
			}
			if (repairList.getLevelId() != null) {
				c.andLevelIdEqualTo(repairList.getLevelId());
			}
			if (repairList.getWorkerorderClassId() != null) {
				c.andWorkerIdEqualTo(repairList.getWorkerorderClassId());
			}
			if (repairList.getWorkerorderStateId() != null) {
				c.andWorkerorderStateIdEqualTo(repairList.getWorkerorderStateId());
			}
			if (ids != null && ids.size() > 0) {
				c.andAssetIdIn(ids);
			}
		}
		if (date1 != null) {
			c.andLaunchTimeGreaterThanOrEqualTo(date1);
		}
		if (date2 != null) {
			c.andLaunchTimeLessThanOrEqualTo(date2);
		}
		re.setOrderByClause("no desc");
		List<RepairList> list = repairListMapper.selectByExamplePage(re);
		for (int i = 0; i < list.size(); i++) {
			RepairList rl = list.get(i);
			rl.setWokerorderClass(wokerorderClassMapper.selectByPrimaryKey(rl.getWorkerorderClassId()));
			rl.setWokerorderState(wokerorderStateMapper.selectByPrimaryKey(rl.getWorkerorderStateId()));
			rl.setAssets(assetsMapper.selectByPrimaryKey(rl.getAssetId()));
			rl.getAssets().setPosition(positionMapper.selectByPrimaryKey(rl.getAssets().getPositionId()));
			rl.getAssets().setBaseDepartment(baseDepartmentMapper.selectByPrimaryKey(rl.getAssets().getDepartmentId()));
			rl.getAssets().setBaseAssetClass(baseAssetClassMapper.selectByPrimaryKey(rl.getAssets().getClassId()));
			rl.setWorker(workerMapper.selectByPrimaryKey(rl.getWorkerId()));
			rl.setLevel(urgencyLevelMapper.selectByPrimaryKey(rl.getLevelId()));
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyb2c.service.impl.RepairlistService#count(com.xyb2c.pojo.RepairList,
	 * java.lang.Integer, java.util.Date, java.util.Date)
	 */
	@Override
	public Integer count(RepairList repairList, Integer assetsClassId, Date date1, Date date2,Integer pid,Integer flag) {
		RepairListExample re = new RepairListExample();
		Criteria c = re.createCriteria();
		c.andFlagEqualTo(flag);
		List<Integer> ids = null;
		
		if(pid!=null){
			AssetsExample ae = new AssetsExample();
			AssetsExample.Criteria ac = ae.createCriteria();
			ac.andPositionIdEqualTo(pid);
			List<Assets> assets = assetsMapper.selectByExample(ae);
			ids = new ArrayList<>();
			for (Assets asset : assets) {
				ids.add(asset.getId());
			}
			if (ids == null || ids.size() == 0) {
				return 0;
			}
		}
		
		if (assetsClassId != null) {
			AssetsExample ae = new AssetsExample();
			AssetsExample.Criteria ac = ae.createCriteria();
			ac.andClassIdEqualTo(assetsClassId);
			List<Assets> assets = assetsMapper.selectByExample(ae);
			ids = new ArrayList<>();
			for (Assets asset : assets) {
				ids.add(asset.getId());
			}
			if (ids == null || ids.size() == 0) {
				return 0;
			}
		}
		if (repairList != null) {
			if (repairList.getNo() != null && !repairList.getNo().equals("")) {
				c.andNoLike("%" + repairList.getNo() + "%");
			}
			if (repairList.getLevelId() != null) {
				c.andLevelIdEqualTo(repairList.getLevelId());
			}
			if (repairList.getWorkerorderClassId() != null) {
				c.andWorkerIdEqualTo(repairList.getWorkerorderClassId());
			}
			if (repairList.getWorkerorderStateId() != null) {
				c.andWorkerorderStateIdEqualTo(repairList.getWorkerorderStateId());
			}
		}
		if (date1 != null) {
			c.andLaunchTimeGreaterThanOrEqualTo(date1);
		}
		if (date2 != null) {
			c.andLaunchTimeLessThanOrEqualTo(date2);
		}
		if (ids != null && ids.size() > 0) {
			c.andAssetIdIn(ids);
		}
		return repairListMapper.countByExample(re);
	}

	public List<Worker> selectAllWorker() {
		BaseDepartmentExample be = new BaseDepartmentExample();
		BaseDepartmentExample.Criteria bc = be.createCriteria();
		bc.andPIdEqualTo(0);
		List<BaseDepartment> bigs = baseDepartmentMapper.selectByExample(be);
		List<Integer> ids = new ArrayList<>();
		for (BaseDepartment baseDepartment : bigs) {
			ids.add(baseDepartment.getId());
		}
		be = new BaseDepartmentExample();
		bc = be.createCriteria();
		bc.andPIdIn(ids);
		List<BaseDepartment> small = baseDepartmentMapper.selectByExample(be);
		List<BaseDepartment> all = baseDepartmentMapper.selectByExample(null);
		List<Worker> worker = new ArrayList<>();
		for (BaseDepartment baseDepartment : small) {
			WorkerExample we = new WorkerExample();
			WorkerExample.Criteria c = we.createCriteria();
			c.andDIdIn(RecursionUtil.getListPid(all, baseDepartment.getId()));
			List<Worker> w = workerMapper.selectByExample(we);
			for (int i = 0; i < w.size(); i++) {
				w.get(i).setdId(baseDepartment.getId());
				worker.add(w.get(i));
			}
		}
		return worker;
	}

	public List<Position> selectAllPosition() {
		PositionExample pe = new PositionExample();
		PositionExample.Criteria c = pe.createCriteria();
		c.andFlagEqualTo("1");
		return positionMapper.selectByExample(pe);
	}

	public String selectMaxNo() {
		RepairListExample re = new RepairListExample();
		re.setOrderByClause("no desc");
		re.setStart(0);
		re.setLength(1);
		List<RepairList> list = repairListMapper.selectByExample(re);
		if (list.size() > 0) {
			return ((new Integer(list.get(0).getNo())) + 1) + "";
		} else {
			return "1000001";
		}
	}

	public Map<String, Object> changeWorker(String name) {
		Map<String, Object> map = new TreeMap<String, Object>();
		WorkerExample we = new WorkerExample();
		WorkerExample.Criteria c = we.createCriteria();
		c.andNameEqualTo(name);
		List<Worker> list = workerMapper.selectByExample(we);
		if (list.size() == 0) {
			return null;
		}
		List<BaseDepartment> baseDepartments = baseDepartmentMapper.selectByExample(null);
		BaseDepartment bd = baseDepartmentMapper.selectByPrimaryKey(list.get(0).getdId());
		if (bd != null) {
			BaseDepartment bde = RecursionUtil.StringToDepartName(baseDepartments, bd);
			list.get(0).setDepartment(bde.getDepartment());
		}
		map.put("worker", list.get(0));
		map.put("position", positionMapper.selectByPrimaryKey(list.get(0).getpId()));
		return map;
	}

	public Map<String, Object> changePosition(String position) {
		Map<String, Object> map = new TreeMap<String, Object>();
		PositionExample pe = new PositionExample();
		PositionExample.Criteria pc = pe.createCriteria();
		pc.andPositionEqualTo(position);
		List<Position> list = positionMapper.selectByExample(pe);
		if (list.size() == 0) {
			return map;
		}
		Position p = list.get(0);
		AssetsExample ae = new AssetsExample();
		AssetsExample.Criteria ac = ae.createCriteria();
		ac.andPositionIdEqualTo(p.getId());
		List<Assets> alist = assetsMapper.selectByExample(ae);
		map.put("assets", alist);
		map.put("position", p);
		return map;
	}

	public Integer add(RepairList repairList) {
		Assets assets = new Assets();
		assets.setStateId(7);
		assets.setId(repairList.getAssetId());
		assetsMapper.updateByPrimaryKeySelective(assets);
		return repairListMapper.insert(repairList);
	}
}
