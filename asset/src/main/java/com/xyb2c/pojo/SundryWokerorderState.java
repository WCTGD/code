package com.xyb2c.pojo;

/**
 * 信息
 * @author Administrator
 *
 */
public class SundryWokerorderState {
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

	@Override
	public String toString() {
		return "SundryWokerorderState [id=" + id + ", information=" + information + "]";
	}
    
    
}