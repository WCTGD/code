package com.xyb2c.pojo;

/**
 * 基础数据   综合 紧急程度
 * @param sundryUrgencyLevel
 */
public class SundryUrgencyLevel {
    private Integer id;

    private String information;

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