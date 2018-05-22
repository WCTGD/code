package com.xyb2c.plugin;

import org.apache.ibatis.session.RowBounds;

/**
 * <p>
 * 简单分页模型
 * </p>
 * 用户可以通过继承 org.apache.ibatis.session.RowBounds实现自己的分页模型<br>
 * 注意：插件仅支持RowBounds及其子类作为分页参数
 * 
 */
public class Pagination extends RowBounds {

	/* 总数 */
	private int total;

	/* 每页显示条数 */
	private int size;

	/* 总页数 */
	private int pages;

	/* 当前页 */
	private int current = 1;

	@SuppressWarnings("unused")
	private boolean previous;
	@SuppressWarnings("unused")
	private boolean next;
	@SuppressWarnings("unused")
	private int start;
	@SuppressWarnings("unused")
	private int end;

	public Pagination() {
		super();
	}


	/**
	 * <p>
	 * 分页构造函数
	 * </p>
	 * 
	 * @param current
	 *            当前页
	 * @param size
	 *            每页显示条数
	 */
	public Pagination( int current, int size ) {
		super(offsetCurrent(current, size), size);
		if ( current >1 ) {
			this.current = current;
		}
		this.size = size;
	}


	protected static int offsetCurrent( int current, int size ) {
		if ( current > 0 ) {
			return (current - 1) * size;
		}
		return 0;
	}


	public int getOffsetCurrent() {
		return offsetCurrent(this.current, this.size);
	}

	

	public boolean hasPrevious() {
		return this.current > 1;
	}


	public boolean hasNext() {
		return this.current < this.pages;
	}


	public int getStart() {
		return (current-1)*size+1;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getEnd() {
		if(total<size){
			return total;
		}else if(total<current*size){
			return total;
		}
		return current*size;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	public boolean isPrevious() {
		return this.current > 1;
	}


	public void setPrevious(boolean previous) {
		this.previous = previous;
	}


	public boolean isNext() {
		return this.current < this.pages;
	}


	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}


	public void setTotal( int total ) {
		this.total = total;
		this.pages = this.total / this.size;
		if ( this.total % this.size != 0 ) {
			this.pages++;
		}
		if ( this.current > this.pages ) {
			/**
			 * 当前页大于总页数，当前页设置为第一页
			 */
			this.current = 1;
		}
	}


	public int getSize() {
		return size;
	}


	public int getPages() {
		return pages;
	}


	public int getCurrent() {
		return current;
	}


	@Override
	public String toString() {
		return "Pagination { total=" + total + " ,size=" + size + " ,pages=" + pages + " ,current=" + current + " }";
	}
}
