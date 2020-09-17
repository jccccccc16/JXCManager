package com.cjzy.service;

import java.util.List;

import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.model.Customer;

/***
 * �ͻ�ҵ��ӿ�
 * @author 61702
 *
 */
public interface CustomerService {
	/**
	 * ��ӿͻ�
	 * @return
	 * @throws CustomerExistException 
	 */
	public boolean addCustomer(Customer customer) throws CustomerExistException;
	
	public String getCustomerId();
	
	public List<Customer> findCustomers(Customer customer);
	
	/**
	 * ���ݿͻ�����޸Ŀͻ���Ϣ
	 * @param customer
	 * @return
	 */
	public boolean updateCustomer(Customer customer);
	
	
	public boolean updateCustomer(String id,Integer available);
}
