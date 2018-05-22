package com.xyb2c.pojo;

import java.util.Date;

/**
 * 供应商
 * @author Administrator
 *
 */
public class Supplier {
    private Integer id;

    private String no; //编号

    private String supplierName; //供应商名称

    private String country; //国家

    private String province; //省

    private String city; //市

    private String zipCode; //邮编

    private String telphone; //电话

    private String fax; //传真号码

    private String email; //邮箱

    private String contactName; //联系人

    private String contactJob; //联系人职位

    private String contactAddress; //联系人地址

    private String service; //服务
    
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactJob() {
        return contactJob;
    }

    public void setContactJob(String contactJob) {
        this.contactJob = contactJob == null ? null : contactJob.trim();
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
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

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", no=" + no + ", supplierName=" + supplierName + ", country=" + country
				+ ", province=" + province + ", city=" + city + ", zipCode=" + zipCode + ", telphone=" + telphone
				+ ", fax=" + fax + ", email=" + email + ", contactName=" + contactName + ", contactJob=" + contactJob
				+ ", contactAddress=" + contactAddress + ", service=" + service + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + "]";
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
    
}