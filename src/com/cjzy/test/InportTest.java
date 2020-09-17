package com.cjzy.test;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cjzy.common.CommonFactory;
import com.cjzy.model.InportInfor;
import com.cjzy.model.Inpout;
import com.cjzy.service.GoodService;
import com.cjzy.service.InpoutService;

public class InportTest {
	
	InpoutService inpoutService;
	@Before
	public void init() {
		inpoutService = CommonFactory.getInpoutService();
	}
	
	@Test
	public void getId() {
		String id = inpoutService.getId();
		System.out.println(id);
	}
	@Test
	public void queryAll() {
	
		List<Inpout> query = inpoutService.query(null);
		for (Inpout inpout : query) {
			System.out.println(inpout);
		}
	}
	
	@Test
	public void queryById() {
		Inpout inpout =new Inpout();
		inpout.setId("IP1003");
		List<Inpout> query = inpoutService.query(inpout);
		for (Inpout inpout2 : query) {
			System.out.println(inpout2);
		}
	}
	
	@Test
	public void queryInportInforById() {
		InportInfor inportInfor = new InportInfor();
		inportInfor.setId("IP1003");
		List<InportInfor> queryInportInfors = inpoutService.queryInportInfors(inportInfor);
		InportInfor inportInfor2 = queryInportInfors.get(0);
		System.out.println(inportInfor2);
		
	}
	
	@Test
	public void queryInportInfor() {

		List<InportInfor> queryInportInfors = inpoutService.queryInportInfors(null);
		for (InportInfor inportInfor : queryInportInfors) {
			System.out.println(inportInfor);
		}
		
	}
	
	@Test
	public void queryInportInforByProduct() {
		InportInfor inportInfor = new InportInfor();
		inportInfor.setProviderName("王德发");
		List<InportInfor> queryInportInfors = inpoutService.queryInportInfors(inportInfor);
		for (InportInfor inportInfor1 : queryInportInfors) {
			System.out.println(inportInfor1);
		}
		
	}
	
	
	@Test
	public void queryInportInforByGoodsName() {
		InportInfor inportInfor = new InportInfor();
		inportInfor.setGoodsName("十寸大彩电");
		List<InportInfor> queryInportInfors = inpoutService.queryInportInfors(inportInfor);
		for (InportInfor inportInfor1 : queryInportInfors) {
			System.out.println(inportInfor1);
		}
		
	}
	
	
	@Test
	public void queryInportInforBySponsor() {
		InportInfor inportInfor = new InportInfor();
		inportInfor.setSponsor("马风");
		List<InportInfor> queryInportInfors = inpoutService.queryInportInfors(inportInfor);
		for (InportInfor inportInfor1 : queryInportInfors) {
			System.out.println(inportInfor1);
		}
		
	}
	
	
	@Test
	public void queryInportInforByTime() {
		InportInfor inportInfor = new InportInfor();
		inportInfor.setStartTime("2020-4-20");
		inportInfor.setEndTime("2020-6-1");
		List<InportInfor> queryInportInfors = inpoutService.queryInportInfors(inportInfor);
		for (InportInfor inportInfor1 : queryInportInfors) {
			System.out.println(inportInfor1);
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
