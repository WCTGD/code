package com.xyb2c.pojo;

import java.util.Date;

/**
 * 部门实体类
 * @author Administrator
 *
 */
public class BaseDepartment {
    private Integer id; // id

    private String no; // 编号

    private String department; // 部门名称

    private Integer pId; // 上级部门id

    private Date createTime;

    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
	public String toString() {
		return "BaseDepartment [id=" + id + ", no=" + no + ", department=" + department + ", pId=" + pId
				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}

	public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
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
}