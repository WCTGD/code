package com.xyb2c.service;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xyb2c.pojo.Assets;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AssetsServiceImplTest {
	@Autowired
	AssetsService assetsService;
	
	@Test
	public void testSelect() {
		Assets a = new Assets();
		a.setSupplierName("哇哈哈");

		System.out.println("假货多看会" + assetsService.select(0, 1, a, null, null, null, null));
	}

	@Test
	public void testCount() {
		System.out.println(assetsService.checkNo("s"));
	}

	@Test
	public void testSelectAllBaseAssetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAllSundryAssetsState() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateShow() {
//		assetsService.updateShow(1);
	}

	@Test
	public void testJSONParse() {
		
	}

	public static void main(String[] args) throws JsonProcessingException, IOException {
//		Copy.copyDepatment();
	}

}
