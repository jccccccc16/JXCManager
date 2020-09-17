package com.cjzy.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.cjzy.common.CommonFactory;
import com.cjzy.model.Inpout;
import com.cjzy.service.InpoutService;
import com.cjzy.service.OutPortService;

public class OutPortTest {
	
	OutPortService outPortService;
	@Before
	public void init() {
		outPortService = CommonFactory.getOutPortService();
	}
	
	@Test
	public void query() {
		 Date date = new Date();
		 long time = date.getTime();
		Inpout inpout = new Inpout("IP1001",5, 50, "良好", "PD1001",new Date(),"管理员", "马风", "银联", "GD1001");
		outPortService.addOutPort(inpout);
	}
}
