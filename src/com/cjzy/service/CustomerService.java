package com.cjzy.service;

import java.util.List;

import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.model.Customer;

/***
 * 客户业务接口
 * @author 61702
 *
 */
public interface CustomerService {
	/**
	 * 添加客户
	 * @return
	 * @throws CustomerExistException 
	 */
	public boolean addCustomer(Customer customer) throws CustomerExistException;
	
	public String getCustomerId();
	
	public List<Customer> findCustomers(Customer customer);
	
	/**
	 * 根据客户标号修改客户信息
	 * @param customer
	 * @return
	 */
	public boolean updateCustomer(Customer customer);
	
	
	public boolean updateCustomer(String id,Integer available);
}
