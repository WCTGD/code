package com.xyb2c.pojo;

import java.util.Date;

// {
//   * "id":"82", // user id
//   * "emp_no":"chenm", // 登录名
//   * "name":"\u9648\u94ed", // 员工的名字
//     "letter":"CM", // 字母
//     "email":"chenming@xyb2c.com", // email
//     "duty":"Java\u5f00\u53d1\u5de5\u7a0b\u5e08", // 职称
//     "mobile_tel":"18268268735", // 手机
//     "birthday":"1995-06-14", // 生日
//     "sex":"male", // sex
//     "password":"e10adc3949ba59abbe56e057f20f883e", // password
//     "is_del":"0", // 删除标记
//     "dept_name":"\u6280\u672f\u90e8 //部门名称
// }
public class User {
	private String id;
	private String emp_no;
	private String name;
	private String letter;
	private String email;
	private String duty;
	private String mobile_tel;
	private String birthday;
	private String sex;
	private String password;
	private String is_del;
	private String dept_name;
	private Integer positionId;
	private Date createTime;
	private Date modifyTime;
	private String token;

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getMobile_tel() {
		return mobile_tel;
	}

	public void setMobile_tel(String mobile_tel) {
		this.mobile_tel = mobile_tel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIs_del() {
		return is_del;
	}

	public void setIs_del(String is_del) {
		this.is_del = is_del;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emp_no=" + emp_no + ", name=" + name + ", letter=" + letter + ", email=" + email
				+ ", duty=" + duty + ", mobile_tel=" + mobile_tel + ", birthday=" + birthday + ", sex=" + sex
				+ ", password=" + password + ", is_del=" + is_del + ", dept_name=" + dept_name + ", positionId="
				+ positionId + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", token=" + token + "]";
	}

}
