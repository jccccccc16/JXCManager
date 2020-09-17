package com.cjzy.service.impl;

import java.util.List;

import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.dao.CustomerDao;
import com.cjzy.model.Customer;
import com.cjzy.service.CustomerService;
/**
 * 客户业务实现类
 * @author 61702
 *
 */
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao = null;
	/**
	 * 添加客户
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
	 * 修改客户信息
	 */
	@Override
	public boolean updateCustomer(Customer customer) {
		customerDao = new CustomerDao();
		
		return customerDao.updateCustomer(customer);
	}
	
	/***
	 * 删除
	 */
	@Override
	public boolean updateCustomer(String id, Integer available) {
		// TODO Auto-generated method stub
		customerDao = new CustomerDao();
		
		return customerDao.updateCustomer(id, available);
	}
	
	
	

}
