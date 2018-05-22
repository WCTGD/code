package com.xyb2c.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyb2c.pojo.SysMenu;
import com.xyb2c.service.SysmenuService;

@Controller("sysmenuController")
@RequestMapping(value = "sysMenu")
public class SysmenuController {
	@Autowired
	private SysmenuService sysmenuService;

	@RequestMapping(value = "/getSysMenu", method = RequestMethod.GET)
	public void getSysmenu(HttpServletResponse response) {
		List<SysMenu> list = sysmenuService.getMenu();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(list);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
