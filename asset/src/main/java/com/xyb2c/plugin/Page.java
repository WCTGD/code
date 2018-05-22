package com.xyb2c.plugin;

import java.util.Collections;
import java.util.List;


/**
 * 实现分页辅助类
 */
public class Page<T> extends Pagination {

	/**
	 * 查询数据列表
	 */
	private List<T> records = Collections.emptyList();


	protected Page() {
		/* 保护 */
	}


	public Page( int current, int size ) {
		super(current, size);
	}


	public List<T> getRecords() {
		return records;
	}


	public void setRecords( List<T> records ) {
		this.records = records;
	}


	@Override
	public String toString() {
		StringBuffer pg = new StringBuffer();
		pg.append(" Page:{ [").append(super.toString()).append("], ");
		if ( records != null ) {
			pg.append("records-size:").append(records.size());
		} else {
			pg.append("records is null");
		}
		return pg.append(" }").toString();
	}
}
