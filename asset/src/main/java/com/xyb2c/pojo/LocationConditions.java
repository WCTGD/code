package com.xyb2c.pojo;

/**
 *  位置 查询 的条件 类
 * @author Administrator
 *
 */
public class LocationConditions {
	private Integer id;//位置Id
	private Integer bid;//部门id 外键
	private String bNo; //部门编号
	private String aNo; //位置编号
	private String department;// 部门描述
	private String position; // 位置描述
	private String note; //注释
	private String judge; // 判断 s
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
	}
	public String getaNo() {
		return aNo;
	}
	public void setaNo(String aNo) {
		this.aNo = aNo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "LocationConditions [id=" + id + ", bid=" + bid + ", bNo=" + bNo + ", aNo=" + aNo + ", department="
				+ department + ", position=" + position + ", note=" + note + "]";
	}
	
}
