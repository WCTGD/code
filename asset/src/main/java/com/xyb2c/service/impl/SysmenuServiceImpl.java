package com.xyb2c.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyb2c.dao.SysMenuMapper;
import com.xyb2c.pojo.SysMenu;
import com.xyb2c.service.SysmenuService;

@Service("sysmenuService")
public class SysmenuServiceImpl implements SysmenuService {
	@Autowired
	private SysMenuMapper dao;

	@Override
	public List<SysMenu> getMenu() {
		return dao.selectByExample(null);
	}

}
