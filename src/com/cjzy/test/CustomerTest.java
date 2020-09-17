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
 * �ͻ�ҵ�����
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
			result = customerService.addCustomer(new Customer("CT1005","����ǿ���޹�˾","alibaba","����","88888"
					,"12346789","0000-000-000","�ǿ","123456798","�й�����","4211111111","dongqiang@520.com",1));
		} catch (CustomerExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==true) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("ʧ��");
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
		c.setCustomerName("����ǿ���޹�˾");
		List<Customer> list = customerService.findCustomers(c);
		for (Customer customer2 : list) {
			System.out.println(customer2);
		}
	}
	
	
	
	@Test
	public void findCustomersByContacts() {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.setContacts("�ǿ");
		List<Customer> list = customerService.findCustomers(c);
		for (Customer customer2 : list) {
			System.out.println(customer2);
		}
	}

	
	/***
	 * �޸���Ϣ
	 */
	@Test
	public void updateCustomer() {
		Customer customer = new Customer("CT1005","����ǿ���޹�˾","����ǿ","����","88888"
				,"12346789","0000-000-000","�ǿ","123456798","�й�����","4211111111","dongqiang@520.com",1);
		boolean result = customerService.updateCustomer(customer);
		if(result==true) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	
	@Test
	public void deleteCustomer() {
		boolean result = customerService.updateCustomer("CT1002",Constants.DATA_DEL);
		if(result==true) {
			System.out.println("ɾ��/�һسɹ�");
		}else {
			System.out.println("ɾ��/�һ�ʧ��");
		}
	}
	

}
