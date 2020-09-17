package com.cjzy.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.Constants;
import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.dao.CustomerDao;
import com.cjzy.model.Customer;
import com.cjzy.service.CustomerService;
import com.sun.scenario.animation.shared.InfiniteClipEnvelope;

/**
 * 客户业务测试
 * @author 61702
 *
 */
public class CustomerTest {
	
	
	CustomerService customerService = null;
	@Before
	public void init() {
		customerService = CommonFactory.getCustomerService();
	}
	
	
	@Test
	public void  addCustomer() {
		
		boolean result=false;
		try {
			result = customerService.addCustomer(new Customer("CT1005","冬瓜强有限公司","alibaba","杭州","88888"
					,"12346789","0000-000-000","李东强","123456798","中国银行","4211111111","dongqiang@520.com",1));
		} catch (CustomerExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==true) {
			System.out.println("添加成功");
		}else {
			System.out.println("失败");
		}
	}
	
	@Test
	public void getCustomerId() {
		// TODO Auto-generated method stub
		String idString = customerService.getCustomerId();
		System.out.println(idString);
	}
	
	@Test
	public void findCustomers() {
		// TODO Auto-generated method stub

		List<Customer> list = customerService.findCustomers(null);
		for (Customer customer2 : list) {
			System.out.println(customer2);
		}
	}
	
	
	@Test
	public void findCustomersByshorts() {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.setShorts("alibaba");
		List<Customer> list = customerService.findCustomers(c);
		for (Customer customer2 : list) {
			System.out.println(customer2);
		}
	}
	
	
	
	@Test
	public void findCustomersByCustomerName() {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.setCustomerName("冬瓜强有限公司");
		List<Customer> list = customerService.findCustomers(c);
		for (Customer customer2 : list) {
			System.out.println(customer2);
		}
	}
	
	
	
	@Test
	public void findCustomersByContacts() {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.setContacts("李东强");
		List<Customer> list = customerService.findCustomers(c);
		for (Customer customer2 : list) {
			System.out.println(customer2);
		}
	}

	
	/***
	 * 修改信息
	 */
	@Test
	public void updateCustomer() {
		Customer customer = new Customer("CT1005","冬瓜强有限公司","冬瓜强","杭州","88888"
				,"12346789","0000-000-000","李东强","123456798","中国银行","4211111111","dongqiang@520.com",1);
		boolean result = customerService.updateCustomer(customer);
		if(result==true) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	
	@Test
	public void deleteCustomer() {
		boolean result = customerService.updateCustomer("CT1002",Constants.DATA_DEL);
		if(result==true) {
			System.out.println("删除/找回成功");
		}else {
			System.out.println("删除/找回失败");
		}
	}
	

}
