package com.xyb2c.pojo;

import java.util.Date;

/**
 * 资产实体类
 * @author Administrator
 *
 */
public class Assets {
	private String assetClass; 

	private String wokerName;

	private String assetState;

	private String supplierName;

	private String departmentNo;

	private String positionNo;

	private BaseAssetClass baseAssetClass;

	private BaseDepartment baseDepartment;

	private BaseContractor baseContractor;

	private Position position;

	private SundryAssetsState sundryAssetsState;

	private SundryAssetsWay sundryAssetsWay;

	private Supplier supplier;

	private Worker woker;

	private Integer id;

	private String no;

	private Integer contractorId;

	private String assetDesc;

	private Integer wayId;

	private Date warrantyDeadline;

	private String wayNote;

	private String assetNote;

	private Integer positionId;

	private Integer departmentId;

	private Integer classId;

	private Integer stateId;

	private Integer wokerId;

	private String type;

	private String serialNo;

	private String manufacturer;

	private Integer supplierId;

	private Date startDate;

	private Double assetValue;

	private Double purchaserPrice;

	private String lifeSpan;

	private Date clearDate;

	private Integer publicProperty;

	private String note;

	private Date regainTime;

	private Date deleteTime;
	
	private Date createTime;

	private Date modifyTime;

	private Integer show;

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

	public Integer getContractorId() {
		return contractorId;
	}

	public void setContractorId(Integer contractorId) {
		this.contractorId = contractorId;
	}

	public String getAssetDesc() {
		return assetDesc;
	}

	public void setAssetDesc(String assetDesc) {
		this.assetDesc = assetDesc == null ? null : assetDesc.trim();
	}

	public Integer getWayId() {
		return wayId;
	}

	public void setWayId(Integer wayId) {
		this.wayId = wayId;
	}

	public Date getWarrantyDeadline() {
		return warrantyDeadline;
	}

	public void setWarrantyDeadline(Date warrantyDeadline) {
		this.warrantyDeadline = warrantyDeadline;
	}

	public String getWayNote() {
		return wayNote;
	}

	public void setWayNote(String wayNote) {
		this.wayNote = wayNote == null ? null : wayNote.trim();
	}

	public String getAssetNote() {
		return assetNote;
	}

	public void setAssetNote(String assetNote) {
		this.assetNote = assetNote == null ? null : assetNote.trim();
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getWokerId() {
		return wokerId;
	}

	public void setWokerId(Integer wokerId) {
		this.wokerId = wokerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo == null ? null : serialNo.trim();
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer == null ? null : manufacturer.trim();
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Double getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(Double assetValue) {
		this.assetValue = assetValue;
	}

	public Double getPurchaserPrice() {
		return purchaserPrice;
	}

	public void setPurchaserPrice(Double purchaserPrice) {
		this.purchaserPrice = purchaserPrice;
	}

	public String getLifeSpan() {
		return lifeSpan;
	}

	public void setLifeSpan(String lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public Date getClearDate() {
		return clearDate;
	}

	public void setClearDate(Date clearDate) {
		this.clearDate = clearDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
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

	public Integer getShow() {
		return show;
	}

	public void setShow(Integer show) {
		this.show = show;
	}

	public String getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getPositionNo() {
		return positionNo;
	}

	public void setPositionNo(String positionNo) {
		this.positionNo = positionNo;
	}

	public BaseAssetClass getBaseAssetClass() {
		return baseAssetClass;
	}

	public void setBaseAssetClass(BaseAssetClass baseAssetClass) {
		this.baseAssetClass = baseAssetClass;
	}

	public BaseDepartment getBaseDepartment() {
		return baseDepartment;
	}

	public void setBaseDepartment(BaseDepartment baseDepartment) {
		this.baseDepartment = baseDepartment;
	}

	public BaseContractor getBaseContractor() {
		return baseContractor;
	}

	public void setBaseContractor(BaseContractor baseContractor) {
		this.baseContractor = baseContractor;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public SundryAssetsState getSundryAssetsState() {
		return sundryAssetsState;
	}

	public void setSundryAssetsState(SundryAssetsState sundryAssetsState) {
		this.sundryAssetsState = sundryAssetsState;
	}

	public SundryAssetsWay getSundryAssetsWay() {
		return sundryAssetsWay;
	}

	public void setSundryAssetsWay(SundryAssetsWay sundryAssetsWay) {
		this.sundryAssetsWay = sundryAssetsWay;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Worker getWorker() {
		return woker;
	}

	public void setWorker(Worker woker) {
		this.woker = woker;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getAssetClass() {
		return assetClass;
	}

	public void setAssetClass(String assetClass) {
		this.assetClass = assetClass;
	}

	public String getWokerName() {
		return wokerName;
	}

	public void setWokerName(String wokerName) {
		this.wokerName = wokerName;
	}

	public String getAssetState() {
		return assetState;
	}

	public void setAssetState(String assetState) {
		this.assetState = assetState;
	}

	@Override
	public String toString() {
		return "Assets [assetClass=" + assetClass + ", wokerName=" + wokerName + ", assetState=" + assetState
				+ ", supplierName=" + supplierName + ", departmentNo=" + departmentNo + ", positionNo=" + positionNo
				+ ", baseAssetClass=" + baseAssetClass + ", baseDepartment=" + baseDepartment + ", baseContractor="
				+ baseContractor + ", position=" + position + ", sundryAssetsState=" + sundryAssetsState
				+ ", sundryAssetsWay=" + sundryAssetsWay + ", supplier=" + supplier + ", woker=" + woker + ", id=" + id
				+ ", no=" + no + ", contractorId=" + contractorId + ", assetDesc=" + assetDesc + ", wayId=" + wayId
				+ ", warrantyDeadline=" + warrantyDeadline + ", wayNote=" + wayNote + ", assetNote=" + assetNote
				+ ", positionId=" + positionId + ", departmentId=" + departmentId + ", classId=" + classId
				+ ", stateId=" + stateId + ", wokerId=" + wokerId + ", type=" + type + ", serialNo=" + serialNo
				+ ", manufacturer=" + manufacturer + ", supplierId=" + supplierId + ", startDate=" + startDate
				+ ", assetValue=" + assetValue + ", purchaserPrice=" + purchaserPrice + ", lifeSpan=" + lifeSpan
				+ ", clearDate=" + clearDate + ", note=" + note + ", createTime=" + createTime + ", modifyTime="
				+ modifyTime + ", show=" + show + "]";
	}

	public Integer getPublicProperty() {
		return publicProperty;
	}

	public void setPublicProperty(Integer publicProperty) {
		this.publicProperty = publicProperty;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Date getRegainTime() {
		return regainTime;
	}

	public void setRegainTime(Date regainTime) {
		this.regainTime = regainTime;
	}

}