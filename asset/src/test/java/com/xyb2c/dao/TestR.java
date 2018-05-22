package com.xyb2c.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyb2c.pojo.PageBean;
import com.xyb2c.pojo.Recycle;
import com.xyb2c.pojo.Zzf;
import com.xyb2c.util.ExcelUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestR {
	@Autowired
	RecycleMapper recycleMapper;
	@Autowired
	ZzfMapper zzfMapper;
	@Test
	public void test() throws ParseException {
		PageBean page = new PageBean();
		Recycle recycle = new Recycle();
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		Date start = sdf.parse( " 2016-11-17 14:10:13 " );
		Date end = sdf.parse( " 2016-11-17 14:10:15 " );
		page.setTotalRecord(5);
		recycleMapper.selectRecycle(recycle, page, start, end);
	}
	
	@Test
	public void textOne(){
		String tbName = "assets";
		Integer fkId =9;
		recycleMapper.updateRecycleByFkidByTbname(fkId, tbName);
	}
	@Test
	public void textOne333() throws Exception{
		long t1=System.currentTimeMillis();
		FileInputStream is=new FileInputStream("a.xlsx");
		List<String> list=new ArrayList<>();
		list.add("data1");
		list.add("data2");
		list.add("data3");
		list.add("data4");
		list.add("data5");
		list.add("data6");
		list.add("data7");
		List<Zzf> data=ExcelUtil.parse(is, Zzf.class, list);
		zzfMapper.insertMany(data);
		long t2=System.currentTimeMillis();
		System.out.println("运行消耗"+(t2-t1)+"毫秒");
	}
}
