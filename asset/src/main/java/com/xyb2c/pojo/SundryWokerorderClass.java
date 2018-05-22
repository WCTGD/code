package com.xyb2c.pojo;

/**
 * 工单类型列表
 * @author Administrator
 *
 */
public class SundryWokerorderClass {
    private Integer id;

    private String information; //信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information == null ? null : information.trim();
    }
}