package com.xyb2c.pojo;

import java.util.Date;
/**
 * 员工类型
 * @author Administrator
 *
 */
public class SundryWorkerClass {
    private Integer id;

    private String information;

    private Date cTimestamp;

    private Date eTimestamp;

    private Integer enable;

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

    public Date getcTimestamp() {
        return cTimestamp;
    }

    public void setcTimestamp(Date cTimestamp) {
        this.cTimestamp = cTimestamp;
    }

    public Date geteTimestamp() {
        return eTimestamp;
    }

    public void seteTimestamp(Date eTimestamp) {
        this.eTimestamp = eTimestamp;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}