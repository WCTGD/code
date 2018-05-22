package com.xyb2c.pojo;
/**
 * 分页bean
 * @author Administrator
 *
 */
public class PageBean {
	private int pageCode=1;// 当前页码
	private int totalPage;// 总页数
	private int totalRecord;// 总记录数
	private int pageSize;// 每页记录数
	private int end; 
	private boolean previous;
	private boolean next;
	public int getEnd() {
		return pageCode*pageSize;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart(){
			return(pageCode-1)*pageSize;
	}
	
	public boolean isPrevious() {
		return this.pageCode > 1;
	}


	public void setPrevious(boolean previous) {
		this.previous = previous;
	}


	public boolean isNext() {
		return this.pageCode < this.totalPage;
	}


	public void setNext(boolean next) {
		this.next = next;
	}
	
	public int getPageCode() {
		return pageCode;
	}
	
	
	
	public void setPageCode(int pageCode) {
		if(pageCode<=0){
		this.pageCode = 1;
		}else if(pageCode >totalPage){
		this.pageCode =	totalPage;
		}
		this.pageCode = pageCode;
		
	}
	public int getTotalPage() {
		int total = totalRecord / pageSize;
		return totalRecord % pageSize == 0 ? total : total + 1;
		
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageBean [pageCode=" + pageCode + ", totalPage=" + totalPage + ", totalRecord=" + totalRecord
				+ ", pageSize=" + pageSize + ", end=" + end + ", previous=" + previous + ", next=" + next + "]";
	}
	
}
