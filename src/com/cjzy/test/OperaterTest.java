package com.cjzy.test;

import java.util.List;

import org.junit.Test;

import com.cjzy.common.CommonFactory;
import com.cjzy.model.Operator;
import com.cjzy.service.OperatorService;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class OperaterTest {
	@Test
	public void tsetLoginCheck() {
		OperatorService operatorService = CommonFactory.getOperatorService();
		boolean result = operatorService.loginCheck(new Operator("cjc123","cjc123"));
		if(result==true) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
	/**
	 * GetOperator
	 */
	@Test
	public void testGetOperator() {
		OperatorService operatorService = CommonFactory.getOperatorService();
		Operator operator = operatorService.queryByUserName("cjc123");
		System.out.println(operator);
	}
	@Test
	public void delete() {
		OperatorService operatorService = CommonFactory.getOperatorService();
		operatorService.delete("czy123");
	}
	
	
	@Test
	public void update() {
		OperatorService operatorService = CommonFactory.getOperatorService();
		Operator operator = new Operator();
		operator.setUsername("cjc123");
		operator.setPassword("cjc123");
		operator.setName("陈基础");
		operator.setPower("超级管理员");
		operatorService.update(operator);
	}
	@Test
	public void query(){
		OperatorService operatorService = CommonFactory.getOperatorService();
		List<Operator> query = operatorService.query(null);
		for (Operator operator : query) {
			System.out.println(operator);
		}
	}
}
