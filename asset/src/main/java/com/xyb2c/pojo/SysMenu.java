package com.xyb2c.pojo;

import java.util.Date;

public class SysMenu {
    private Long id;

    private Date cTimestamp;

    private Date uTimestamp;

    private String menuName;

    private String menuUrl;

    private String menuImg1;

    private String menuImg2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getcTimestamp() {
        return cTimestamp;
    }

    public void setcTimestamp(Date cTimestamp) {
        this.cTimestamp = cTimestamp;
    }

    public Date getuTimestamp() {
        return uTimestamp;
    }

    public void setuTimestamp(Date uTimestamp) {
        this.uTimestamp = uTimestamp;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuImg1() {
        return menuImg1;
    }

    public void setMenuImg1(String menuImg1) {
        this.menuImg1 = menuImg1 == null ? null : menuImg1.trim();
    }

    public String getMenuImg2() {
        return menuImg2;
    }

    public void setMenuImg2(String menuImg2) {
        this.menuImg2 = menuImg2 == null ? null : menuImg2.trim();
    }
}