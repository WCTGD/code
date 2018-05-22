package com.xyb2c.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyb2c.pojo.LocationConditions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestR {
	@Autowired
	private RecycleService re;
	
	@Test
	public void test(){
		String id = "4";
		LocationConditions lc =re.positionSelect(id);
		System.out.println(lc.toString());
	}
	
	@Test
	public void testOnt(){
		String id = "4";
		LocationConditions lc =re.positionSelect(id);
		System.out.println(lc.toString());
	}

}
