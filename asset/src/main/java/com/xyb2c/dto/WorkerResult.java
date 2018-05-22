package com.xyb2c.dto;

import org.apache.ibatis.session.RowBounds;

public class WorkerResult<T> {

//	private int id;
//	private String no;
//	private String name;
//	private String job;
//	//部门
//	private String depart;
//	//类型
//	private String type;
	
	private T data;
	private RowBounds page;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public RowBounds getPage() {
		return page;
	}
	public void setPage(RowBounds page) {
		this.page = page;
	}
	
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getNo() {
//		return no;
//	}
//	public void setNo(String no) {
//		this.no = no;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getJob() {
//		return job;
//	}
//	public void setJob(String job) {
//		this.job = job;
//	}
//	public String getDepart() {
//		return depart;
//	}
//	public void setDepart(String depart) {
//		this.depart = depart;
//	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	
//	
//	
//	
//	public WorkerResult(int id, String no, String name, String job,
//			String depart, String type) {
//		super();
//		this.id = id;
//		this.no = no;
//		this.name = name;
//		this.job = job;
//		this.depart = depart;
//		this.type = type;
//	}
//	@Override
//	public String toString() {
//		return "WorkerResult [id=" + id + ", no=" + no + ", name=" + name
//				+ ", job=" + job + ", depart=" + depart + ", type=" + type
//				+ "]";
//	}
//	
	
	
}
