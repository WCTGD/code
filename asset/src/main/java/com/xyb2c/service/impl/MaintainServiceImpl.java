package com.xyb2c.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb2c.dao.AssetsMapper;
import com.xyb2c.dao.MaintainMapper;
import com.xyb2c.dao.PositionMapper;
import com.xyb2c.dao.RecycleMapper;
import com.xyb2c.dao.SundryJobClassMapper;
import com.xyb2c.dao.SundryWokerorderStateMapper;
import com.xyb2c.pojo.Assets;
import com.xyb2c.pojo.AssetsExample;
import com.xyb2c.pojo.Maintain;
import com.xyb2c.pojo.MaintainExample;
import com.xyb2c.pojo.MaintainExample.Criteria;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.PositionExample;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.pojo.SundryJobClass;
import com.xyb2c.pojo.SundryJobClassExample;
import com.xyb2c.pojo.SundryWokerorderState;
import com.xyb2c.pojo.SundryWokerorderStateExample;
import com.xyb2c.service.MaintainService;
import com.xyb2c.util.StringUtil;

@Service("maintainService")
public class MaintainServiceImpl implements MaintainService {
	@Autowired
	MaintainMapper maintainMapper;
	@Autowired
	AssetsMapper assetsMapper;
	@Autowired
	PositionMapper positionMapper;
	@Autowired
	SundryJobClassMapper jobClassMapper;
	@Autowired
	SundryWokerorderStateMapper wokerorderStateMapper;
	@Autowired
	RecycleMapper recycleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyb2c.service.impl.MaintainService#select(int, int,
	 * java.lang.String, java.lang.String, java.lang.String, java.sql.Date,
	 * java.sql.Date)
	 */
	@SuppressWarnings("deprecation")
	public List<Maintain> select(int start, int length, String no, String name, String assetsno, Date start1,
			Date start2, Integer plan) {
		MaintainExample me = new MaintainExample();
		me.setStart(start);
		me.setLength(length);
		Criteria c = me.createCriteria();
		c.andFlagEqualTo(1);
		if (plan != null) {
			c.andPlanEqualTo(plan);
		}
		if (no != null && !"".equals(no)) {
			c.andNoLike("%" + no + "%");
		}
		if (name != null && !"".equals(name)) {
			c.andNameLike("%" + name + "%");
		}
		if (start1 != null) {
			c.andStartdateGreaterThanOrEqualTo(start1);
		}
		if (start2 != null) {
			c.andStartdateLessThanOrEqualTo(start2);
		}
		if (assetsno != null && !"".equals(assetsno)) {
			AssetsExample ae = new AssetsExample();
			AssetsExample.Criteria ac = ae.createCriteria();
			ac.andNoLike("%" + assetsno + "%");
			List<Assets> assets = assetsMapper.selectByExample(ae);
			if (assets != null && !assets.isEmpty()) {
				List<Integer> list = new ArrayList<>();
				for (Assets asset : assets) {
					list.add(asset.getId());
				}
				c.andAIdIn(list);
			}
		}
		List<Maintain> maintain = maintainMapper.selectByExamplePage(me);
		if (maintain != null && !maintain.isEmpty()) {
			for (int i = 0; i < maintain.size(); i++) {
				if (maintain.get(i).getDaynum() != null) {
					Date d = maintain.get(i).getEnddate();
					d.setDate(d.getDate() + maintain.get(i).getDaynum());
					maintain.get(i).setNext(d);
				}
				if (maintain.get(i).getaId() != null) {
					maintain.get(i).setAssets(assetsMapper.selectByPrimaryKey(maintain.get(i).getaId()));
				}
				if (maintain.get(i).getpId() != null) {
					maintain.get(i).setPosition(positionMapper.selectByPrimaryKey(maintain.get(i).getpId()));
				}
				maintain.get(i).setSundryJobClass(jobClassMapper.selectByPrimaryKey(maintain.get(i).getJobId()));
				maintain.get(i).setWokerorderState(
						wokerorderStateMapper.selectByPrimaryKey(maintain.get(i).getWorkerorderStateId()));
			}
		}
		return maintain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyb2c.service.impl.MaintainService#count(java.lang.String,
	 * java.lang.String, java.lang.String, java.sql.Date, java.sql.Date)
	 */
	public int count(String no, String name, String assetsno, Date start1, Date start2, Integer plan) {
		MaintainExample me = new MaintainExample();
		Criteria c = me.createCriteria();
		c.andFlagEqualTo(1);
		if (plan != null) {
			c.andPlanEqualTo(plan);
		}
		if (no != null && !"".equals(no)) {
			c.andNoLike("%" + no + "%");
		}
		if (name != null && !"".equals(name)) {
			c.andNameLike("%" + name + "%");
		}
		if (start1 != null) {
			c.andStartdateGreaterThanOrEqualTo(start1);
		}
		if (start2 != null) {
			c.andStartdateLessThanOrEqualTo(start2);
		}
		if (assetsno != null && !"".equals(assetsno)) {
			AssetsExample ae = new AssetsExample();
			AssetsExample.Criteria ac = ae.createCriteria();
			ac.andNoLike("%" + assetsno + "%");
			List<Assets> assets = assetsMapper.selectByExample(ae);
			if (assets != null && !assets.isEmpty()) {
				List<Integer> list = new ArrayList<>();
				for (Assets asset : assets) {
					list.add(asset.getId());
				}
				c.andAIdIn(list);
			}
		}
		return maintainMapper.countByExample(me);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyb2c.service.impl.MaintainService#selectOne(int)
	 */
	public Maintain selectOne(int id) {
		Maintain maintain = maintainMapper.selectByPrimaryKey(id);
		maintain.setPosition(positionMapper.selectByPrimaryKey(maintain.getpId()));
		maintain.setSundryJobClass(jobClassMapper.selectByPrimaryKey(maintain.getJobId()));
		return maintain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xyb2c.service.impl.MaintainService#selectMaxNo()
	 */
	public String selectMaxNo() {
		int no = 000001;
		MaintainExample me = new MaintainExample();
		me.setStart(0);
		me.setLength(1);
		me.setOrderByClause("no desc");
		List<Maintain> maintain = maintainMapper.selectByExamplePage(me);
		if (maintain != null && !maintain.isEmpty()) {
			no = new Integer(maintain.get(0).getNo());
			no++;
		}

		return StringUtil.fillZero(no, 6);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyb2c.service.impl.MaintainService#insert(com.xyb2c.pojo.Maintain)
	 */
	public int insert(Maintain maintain) {
		if (maintain.getaId() != null) {
			MaintainExample me = new MaintainExample();
			me.setLength(1);
			me.setOrderByClause("startdate desc");
			Criteria c = me.createCriteria();
			c.andAIdEqualTo(maintain.getaId());
			c.andPlanEqualTo(maintain.getPlan());
			List<Maintain> list = maintainMapper.selectByExamplePage(me);
			if (list.size() > 0) {
				maintain.setLastDate(list.get(0).getStartdate());
			}
		} else {
			MaintainExample me = new MaintainExample();
			me.setLength(1);
			me.setOrderByClause("startdate desc");
			Criteria c = me.createCriteria();
			c.andPIdEqualTo(maintain.getpId());
			c.andPlanEqualTo(maintain.getPlan());
			List<Maintain> list = maintainMapper.selectByExamplePage(me);
			if (list.size() > 0) {
				maintain.setLastDate(list.get(0).getStartdate());
			}
		}
		return maintainMapper.insert(maintain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xyb2c.service.impl.MaintainService#update(com.xyb2c.pojo.Maintain)
	 */
	public int update(Maintain maintain) {
		return maintainMapper.updateByPrimaryKey(maintain);
	}

	public List<SundryJobClass> selectAllJobClass() {
		return jobClassMapper.selectByExample(null);
	}

	public void updateFlag(Maintain maintain,String name) {
		maintainMapper.updateByPrimaryKeySelective(maintain);
		Recycle r=new Recycle();
		r.setOperation(name);
		r.setTbName("maintain");
		r.setFkId(maintain.getId());
		r.setType("维护");
		recycleMapper.insert(r);
	}

	public int upInsert(List<Maintain> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo() == null || "".equals(list.get(i).getNo()) || list.get(i).getName() == null
					|| "".equals(list.get(i).getName()) || list.get(i).getJclass() == null
					|| "".equals(list.get(i).getJclass()) || list.get(i).getWostate() == null
					|| "".equals(list.get(i).getWostate()) || list.get(i).getStartdate() == null
					|| list.get(i).getEnddate() == null) {
				return 0;
			}
			if ((list.get(i).getAssetsno() == null || "".equals(list.get(i).getAssetsno()))
					&& (list.get(i).getPositionname() == null || "".equals(list.get(i).getPositionname()))) {
				return 0;
			}
			if(!list.get(i).getStartdate().before(list.get(i).getEnddate())){
				return 0;
			}
			if(list.get(i).getNext()!=null){
				if(list.get(i).getNext().before(list.get(i).getEnddate())){
					return 0;
				}
				list.get(i).setDaynum((int) ((list.get(i).getNext().getTime()-list.get(i).getEnddate().getTime())/(1000*3600*24)));
			}
			list.get(i).setWorkday((int) ((list.get(i).getEnddate().getTime()-list.get(i).getStartdate().getTime())/(1000*3600*24)));
			SundryJobClassExample jce = new SundryJobClassExample();
			SundryJobClassExample.Criteria jcec = jce.createCriteria();
			jcec.andInformationEqualTo(list.get(i).getJclass());
			List<SundryJobClass> jobclass = jobClassMapper.selectByExample(jce);
			if (null == jobclass || jobclass.size() == 0) {
				return 0;
			}
			list.get(i).setJobId(jobclass.get(0).getId());
			SundryWokerorderStateExample wose = new SundryWokerorderStateExample();
			SundryWokerorderStateExample.Criteria wosec = wose.createCriteria();
			wosec.andInformationEqualTo(list.get(i).getWostate());
			List<SundryWokerorderState> state = wokerorderStateMapper.selectByExample(wose);
			if (null == state || state.size() == 0) {
				return 0;
			}
			list.get(i).setWorkerorderStateId(state.get(0).getId());
			if(list.get(i).getAssetsno()!=null&&!"".equals(list.get(i).getAssetsno())){
				AssetsExample ae=new AssetsExample();
				AssetsExample.Criteria ac=ae.createCriteria();
				ac.andNoEqualTo(list.get(i).getAssetsno());
				List<Assets> assets=assetsMapper.selectByExample(ae);
				if (null == assets || assets.size() == 0) {
					return 0;
				}
				list.get(i).setaId(assets.get(0).getId());
				if(list.get(i).getLastDate()!=null){
					MaintainExample me=new MaintainExample();
					Criteria mc=me.createCriteria();
					mc.andAIdEqualTo(assets.get(0).getId());
					List<Maintain> maintain=maintainMapper.selectByExample(me);
					boolean b=false;
					for (Maintain m : maintain) {
						if(m.getStartdate().compareTo(list.get(i).getLastDate())==0){
							b=true;
							break;
						}
					}
					if(!b){
						return 0;
					}
				}
			}else{
				PositionExample pe=new PositionExample();
				PositionExample.Criteria pec= pe.createCriteria();
				pec.andPositionEqualTo(list.get(i).getPositionname());
				List<Position> position=	positionMapper.selectByExample(pe);
				if (null == position || position.size() == 0) {
					return 0;
				}
				list.get(i).setpId(position.get(0).getId());
				if(list.get(i).getLastDate()!=null){
					MaintainExample me=new MaintainExample();
					Criteria mc=me.createCriteria();
					mc.andPIdEqualTo(position.get(0).getId());
					List<Maintain> maintain=maintainMapper.selectByExample(me);
					boolean b=false;
					for (Maintain m : maintain) {
						if(m.getStartdate().compareTo(list.get(i).getLastDate())==0){
							b=true;
							break;
						}
					}
					if(!b){
						return 0;
					}
				}
			}
			list.get(i).setFlag(1);
			list.get(i).setPlan(1);
			try {
				maintainMapper.insert(list.get(i));
			} catch (Exception e) {
				return 0;
			}
			
		}

		return 1;
	}
}
