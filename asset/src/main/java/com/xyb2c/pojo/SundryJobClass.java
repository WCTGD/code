package com.xyb2c.pojo;
/**
 * 工作类型
 * @author Administrator
 *
 */
public class SundryJobClass {
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