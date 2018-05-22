package com.xyb2c.pojo;

import java.util.Date;
/**
 * 维护
 * @author Administrator
 *
 */
public class Maintain {
	private Date next;

	private Position position;

	private String jclass;

	private String wostate;
	private String assetsno;

	private String positionname;

	private Assets assets;

	private SundryJobClass sundryJobClass;

	private SundryWokerorderState wokerorderState;
	
	

	public String getJclass() {
		return jclass;
	}

	public void setJclass(String jclass) {
		this.jclass = jclass;
	}

	public String getWostate() {
		return wostate;
	}

	public void setWostate(String wostate) {
		this.wostate = wostate;
	}

	public String getAssetsno() {
		return assetsno;
	}

	public void setAssetsno(String assetsno) {
		this.assetsno = assetsno;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	private Integer id;

	private String no;

	private String name;

	private String unit;

	private Integer frequency;

	private Integer daynum;

	private Date startdate;

	private Date enddate;

	private Date lastDate;

	private Integer workday;

	private Integer pId;

	private Integer jobId;

	private Integer aId;

	private Integer workerorderStateId;

	private Integer plan;

	private Integer flag;

	private Date createTime;

	private Date modifyTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no == null ? null : no.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getDaynum() {
		return daynum;
	}

	public void setDaynum(Integer daynum) {
		this.daynum = daynum;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Integer getWorkday() {
		return workday;
	}

	public void setWorkday(Integer workday) {
		this.workday = workday;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public SundryJobClass getSundryJobClass() {
		return sundryJobClass;
	}

	public void setSundryJobClass(SundryJobClass sundryJobClass) {
		this.sundryJobClass = sundryJobClass;
	}

	public Integer getPlan() {
		return plan;
	}

	public void setPlan(Integer plan) {
		this.plan = plan;
	}

	public Integer getWorkerorderStateId() {
		return workerorderStateId;
	}

	public void setWorkerorderStateId(Integer workerorderStateId) {
		this.workerorderStateId = workerorderStateId;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Date getNext() {
		return next;
	}

	public void setNext(Date next) {
		this.next = next;
	}

	public SundryWokerorderState getWokerorderState() {
		return wokerorderState;
	}

	public void setWokerorderState(SundryWokerorderState wokerorderState) {
		this.wokerorderState = wokerorderState;
	}
}