package com.xyb2c.service;

import com.xyb2c.pojo.User;

public interface LoginService {
	public User getUser(String username , String password);
}
