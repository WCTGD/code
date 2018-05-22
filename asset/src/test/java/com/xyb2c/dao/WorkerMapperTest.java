package com.xyb2c.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyb2c.pojo.Worker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class WorkerMapperTest {
	@Autowired
	WorkerMapper workerMapper;
	
	@Test
	public void  insert(){
		Worker record=new Worker();
		record.setId(1);
		record.setName("张三");
		workerMapper.insert(record);
		System.out.println("保存成功");
	}
	@Test
	public void deleteByExample(){
		workerMapper.deleteByExample(null);
		System.out.println("删除成功");
	}
}
