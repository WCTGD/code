package com.xyb2c.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyb2c.pojo.User;
import com.xyb2c.util.HttpUtil;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LoginServiceImplTest {

	@SuppressWarnings("unused")
	@Autowired
	private LoginService loginService;

	@SuppressWarnings("unused")
	@Test
	public void test() throws IOException {
		String url = "http://oa.xyb2c.com/index.php";
		Map<String, String> parms = new HashMap<>();
		parms.put("m", "login");
		parms.put("a", "check_login");
		parms.put("emp_no", "chenhao");
		parms.put("password", "asd654440416");
		parms.put("mobile_login_type", "app");
		User temp = null;
		try {
			String str = HttpUtil.doGet(url, Collections.singletonMap("User-Agent", "java"), parms);

			JSONTokener jsonToken = new JSONTokener(str);
			Object status = ((JSONObject) jsonToken.nextValue()).get("status");

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
			System.out.println(message);
		} catch (Exception e) {

		}

	}
	/*
	 * {"jumpUrl":"\/index.php?m=index&a=index","id":"82","token":
	 * "b20c574bce8a6feceda9c1e06c20a1a3"}
	 */

	@SuppressWarnings("unused")
	@Test
	public void test2() throws IOException {
		String url = "http://oa.xyb2c.com/index.php";
		Map<String, String> parms = new HashMap<>();
		parms.put("m", "dept");
		parms.put("a", "index");
		parms.put("id", "167");
		parms.put("token", "c0cf59756fe17fe4f67f41a50d1d0ef8");
		parms.put("tree", "true");
		String str = HttpUtil.doGet(url, Collections.singletonMap("User-Agent", "java"), parms);
	}
}
