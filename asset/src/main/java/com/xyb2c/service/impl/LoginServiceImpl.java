package com.xyb2c.service.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.xyb2c.pojo.User;
import com.xyb2c.service.LoginService;
import com.xyb2c.util.HttpUtil;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

@Service("loginSerive")
public class LoginServiceImpl implements LoginService {
	@Override
	public User getUser(String username , String password) {
		// 通过用户名密码获取id和token
		String url = "http://oa.xyb2c.com/index.php";
		Map<String, String> parms = new HashMap<>();
		parms.put("m", "login");
		parms.put("a", "check_login");
		parms.put("emp_no", username);
		parms.put("password", password);
		parms.put("mobile_login_type", "app");
		User temp = null;
		try {
			String str = HttpUtil.doGet(url, Collections.singletonMap("User-Agent", "java"), parms);

			JSONTokener jsonToken = new JSONTokener(str);
			Object status = ((JSONObject) jsonToken.nextValue()).get("status");
			if (status != null && status.equals(0)) {
				return temp;
			}

			jsonToken.reset();
			Object id = ((JSONObject) jsonToken.nextValue()).get("id");
			jsonToken.reset();
			Object token = ((JSONObject) jsonToken.nextValue()).get("token");

			// 通过token获取JSON
			Map<String, String> parms1 = new HashMap<>();
			parms1.put("m", "profile");
			parms1.put("a", "index");
			parms1.put("id", id.toString());
			parms1.put("token", token.toString());
			String message = HttpUtil.doGet(url, parms1);
			
			// 读取返回的一大串JSON中关于User<vo>子串
			jsonToken = new JSONTokener(message);
			Object vo = ((JSONObject) jsonToken.nextValue()).get("vo");
			temp = new Gson().fromJson(vo.toString(), User.class);
			temp.setToken(token.toString()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
		
	}
}
