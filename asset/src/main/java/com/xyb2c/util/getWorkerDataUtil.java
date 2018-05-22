package com.xyb2c.util;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xyb2c.dao.BaseDepartmentMapper;
import com.xyb2c.dao.PositionMapper;
import com.xyb2c.dao.SundryWorkerClassMapper;
import com.xyb2c.dao.WorkerMapper;
import com.xyb2c.pojo.BaseDepartment;
import com.xyb2c.pojo.BaseDepartmentExample;
import com.xyb2c.pojo.Position;
import com.xyb2c.pojo.SundryWorkerClass;
import com.xyb2c.pojo.Worker;

public class getWorkerDataUtil {
	static final BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	static BaseDepartmentMapper baseDepartmentMapper = factory.getBean(BaseDepartmentMapper.class);
	static WorkerMapper workerMapper = factory.getBean(WorkerMapper.class);
	static SundryWorkerClassMapper sundryWorkerClassMapper = factory.getBean(SundryWorkerClassMapper.class);
	static PositionMapper positionMapper = factory.getBean(PositionMapper.class);
	
	
	public static  Worker getWorkerData(int id){
		Worker worker  =  workerMapper.selectByPrimaryKey(id);
		if (worker.getdId() != null ) {
			BaseDepartmentExample example=new BaseDepartmentExample();
			List<BaseDepartment> baseDepartments = 	baseDepartmentMapper.selectByExample(example);
			BaseDepartment baseDepartment = baseDepartmentMapper.selectByPrimaryKey(worker.getdId()); 
			BaseDepartment department =  RecursionUtil.StringToDepartName(baseDepartments, baseDepartment);
			worker.setDepartment(department.getDepartment());
		}
		if (worker.getcId() != null) {
			SundryWorkerClass sundryWorkerClass = sundryWorkerClassMapper.selectByPrimaryKey(worker.getcId());
			worker.setInformation(sundryWorkerClass.getInformation());
		}
		if (worker.getpId() != null) {
			Position position  =	positionMapper.selectByPrimaryKey(worker.getpId());
			worker.setPosition(position.getPosition());
		}
		return worker;
	} 
}
