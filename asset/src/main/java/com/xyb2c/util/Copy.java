package com.xyb2c.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyb2c.dao.BaseDepartmentMapper;
import com.xyb2c.dao.WorkerMapper;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.User;
import com.xyb2c.pojo.Worker;
import com.xyb2c.pojo.users;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

public class Copy {
	static final BeanFactory factory=new ClassPathXmlApplicationContext("applicationContext.xml");
	static BaseDepartmentMapper departmentMapper=factory.getBean(BaseDepartmentMapper.class);
	 static WorkerMapper workerMapper = factory.getBean(WorkerMapper.class);
	
	/**
	 * 同步部门数据
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static void copyDepatment(){
		String s = SafeRedict.get("http://oa.xyb2c.com/index.php",
				"?m=login&a=check_login&emp_no=zhuzf&password=a7275708&mobile_login_type=app");
		JSONTokener jt = new JSONTokener(s);
		JSONObject jb = (JSONObject) jt.nextValue();
		String st = SafeRedict.get("http://oa.xyb2c.com/index.php",
				"?m=dept&a=index&id=" + jb.get("id") + "&token=" + jb.get("token") + "&tree=true");
		jt = new JSONTokener(st);
		jb = (JSONObject) jt.nextValue();
		String data= jb.get("dept_tree")+"";
		departmentMapper.deleteByExample(null);
		try {
			read(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void read(String s) throws Exception{
		ObjectMapper ob=new ObjectMapper();
		JsonNode node =  ob.readTree(s);
		@SuppressWarnings("unused")
		List<BaseDepartment> list=new ArrayList<>();
		
		BaseDepartment bd=new BaseDepartment();
		for (int i = 0; i < node.size(); i++) {
			JsonNode node_1=node.get(i);
			
			bd.setId(new Integer(node_1.get("id").asInt()));
			bd.setpId(new Integer(node_1.get("pid").asInt()));
			bd.setDepartment(node_1.get("name").asText());
			bd.setNo(node_1.get("dept_no").asText());
			departmentMapper.insertSelective(bd);
			if(node_1.get("_child")!=null){
				read(node_1.get("_child")+"");
			}
		}
	}
	//获取worker信息，并保存到数据库
	public static void getWorkerInfo(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		String id = user.getId();
		String token = user.getToken();
		// 是否分页
		String pagination = "true";
		Map<String, String> map = new HashMap<>();
		map.put("m", "user");
		map.put("a", "index");
		map.put("id", id);
		map.put("token", token);
		map.put("pagination", pagination);
		String url = "http://oa.xyb2c.com/php-oa/index.php";
		String s = null;
		Worker worker =new Worker();
		try {
			s = HttpUtil.doGet(url.toString(), map);
			JSONTokener jsonToken = new JSONTokener(s);
			Object vo = ((JSONObject) jsonToken.nextValue()).get("list");
			ObjectMapper mapper = new ObjectMapper();
			users[] us = mapper.readValue(vo.toString(), users[].class);
			for (users u : us) {
				worker.setId(Integer.parseInt(u.getId()));
				worker.setName(u.getName());
				worker.setJob(u.getDuty());
				worker.setMobilePhone(u.getMobile_tel());
				worker.setEmail(u.getEmail());
				worker.setdId(Integer.parseInt(u.getDept_id()));
				workerMapper.updateByPrimaryKeySelective(worker);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
