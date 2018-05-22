package com.xyb2c.pojo;
/**
 * 资产保修方式
 * @author Administrator
 *
 */
public class SundryAssetsWay {
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