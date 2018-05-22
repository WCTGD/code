package com.xyb2c.pojo;

import java.util.Date;
/**
 * 维修
 * @author Administrator
 *
 */
public class RepairList {
	private Assets assets;

	private SundryUrgencyLevel level;

	private SundryWokerorderClass wokerorderClass;

	private SundryWokerorderState wokerorderState;

	private Worker worker;

	private Worker launchworker;

	public Assets getAssets() {
		return assets;
	}

	public void setAssets(Assets assets) {
		this.assets = assets;
	}

	public SundryUrgencyLevel getLevel() {
		return level;
	}

	public void setLevel(SundryUrgencyLevel level) {
		this.level = level;
	}

	public SundryWokerorderClass getWokerorderClass() {
		return wokerorderClass;
	}

	public void setWokerorderClass(SundryWokerorderClass wokerorderClass) {
		this.wokerorderClass = wokerorderClass;
	}

	public SundryWokerorderState getWokerorderState() {
		return wokerorderState;
	}

	public void setWokerorderState(SundryWokerorderState wokerorderState) {
		this.wokerorderState = wokerorderState;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Worker getLaunchworker() {
		return launchworker;
	}

	public void setLaunchworker(Worker launchworker) {
		this.launchworker = launchworker;
	}

	private Integer id;

	private String no;

	private Integer workerorderStateId;

	private Integer workerId;

	private Integer launchworkerId;

	private Integer workerorderClassId;

	private Integer assetId;

	private Integer levelId;

	private Date finishTime;
	
    private Date realFinishTime;
    
    private Date startTime;

	private Date launchTime;

	private Integer flag;

	private Date createTime;

	private Date modifyTime;

	private String note;

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

	public Integer getWorkerorderStateId() {
		return workerorderStateId;
	}

	public void setWorkerorderStateId(Integer workerorderStateId) {
		this.workerorderStateId = workerorderStateId;
	}

	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}

	public Integer getLaunchworkerId() {
		return launchworkerId;
	}

	public void setLaunchworkerId(Integer launchworkerId) {
		this.launchworkerId = launchworkerId;
	}

	public Integer getWorkerorderClassId() {
		return workerorderClassId;
	}

	public void setWorkerorderClassId(Integer workerorderClassId) {
		this.workerorderClassId = workerorderClassId;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getLaunchTime() {
		return launchTime;
	}

	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public Date getRealFinishTime() {
		return realFinishTime;
	}

	public void setRealFinishTime(Date realFinishTime) {
		this.realFinishTime = realFinishTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
}