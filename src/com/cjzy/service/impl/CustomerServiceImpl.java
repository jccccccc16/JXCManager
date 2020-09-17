package com.cjzy.service.impl;

import java.util.List;

import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.dao.CustomerDao;
import com.cjzy.model.Customer;
import com.cjzy.service.CustomerService;
/**
 * �ͻ�ҵ��ʵ����
 * @author 61702
 *
 */
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao = null;
	/**
	 * ��ӿͻ�
	 * @throws CustomerExistException 
	 */
	@Override
	public boolean addCustomer(Customer customer) throws CustomerExistException {
		customerDao = new CustomerDao();
		return customerDao.addCustomer(customer);
	}
	@Override
	public String getCustomerId() {
		// TODO Auto-generated method stub
		customerDao = new CustomerDao();
		return customerDao.getCustomerId();
	}
	@Override
	public List<Customer> findCustomers(Customer customer) {
		// TODO Auto-generated method stub
		customerDao = new CustomerDao();
		return customerDao.findCustomers(customer);
	}
	
	/***
	 * �޸Ŀͻ���Ϣ
	 */
	@Override
	public boolean updateCustomer(Customer customer) {
		customerDao = new CustomerDao();
		
		return customerDao.updateCustomer(customer);
	}
	
	/***
	 * ɾ��
	 */
	@Override
	public boolean updateCustomer(String id, Integer available) {
		// TODO Auto-generated method stub
		customerDao = new CustomerDao();
		
		return customerDao.updateCustomer(id, available);
	}
	
	
	

}
