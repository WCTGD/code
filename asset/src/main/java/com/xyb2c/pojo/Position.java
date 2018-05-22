package com.xyb2c.pojo;

import java.util.Date;

/**
 *  位置 实体类
 * @author Administrator
 *
 */
public class Position {
    private Integer id; // id

    private String no; // 位置编号

    private Integer dId; // 部门Id（外键）

	private String position; // 位置描述

    private String note; // 位置注释

    private Date createTime;

    private Date modifyTime;

    private String flag; // 状态 0 不存在  1 存在

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

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
    
    @Override
   	public String toString() {
   		return "Position [id=" + id + ", no=" + no + ", dId=" + dId + ", position=" + position + ", note=" + note
   				+ ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", flag=" + flag + "]";
   	}
}