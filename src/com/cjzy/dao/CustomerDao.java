package com.cjzy.dao;

import static org.junit.Assert.assertNotNull;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;
import com.cjzy.common.Constants;
import com.cjzy.common.ErrorManager;
import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.model.Customer;

public class CustomerDao extends BaseDao {

	/**
	 * 添加客户
	 * 
	 * @return
	 */
	public boolean addCustomer(Customer customer) {

		String sql = "insert into t_customer values(#{id},#{customerName},#{shorts},#{address},#{zip},#{telephone},#{fax},#{contacts},#{contactsTel},#{bank},#{account},#{mail},1)";
		return update(sql, customer);

	}

	/**
	 * 生成客户编号
	 * 
	 * @return
	 */
	public String getCustomerId() {
		String sql = "select MAX(id) id from t_customer";
		return getId(sql, "CT");
	}

	/**
	 * 查找客户
	 * 
	 * @param c 把需要查找的条件填写到Customer中
	 * @return
	 */
	public List<Customer> findCustomers(Customer c) {

		String sql = null;

		if (c == null) {
			sql = "select * from t_customer where available=1";
		} else {
			if (c.getId() != null && !c.getId().equals("")) {
				sql = "select * from t_customer where id=#{id} and available=1";

			} else if (c.getCustomerName() != null && !c.getCustomerName().equals("")) { // 全称查询
				sql = "select * from t_customer where customer_name like #{customerName} and available=1 ";

			} else if (c.getShorts() != null && !c.getShorts().equals("")) {// 简称
				sql = "select * from t_customer where shorts like #{shorts} and available=1 ";

			} else if (c.getContacts() != null && !c.getContacts().equals("")) {// 联系人
				sql = "select * from t_customer where contacts like #{contacts} and available=1 ";

			}
		}
		return selectList(sql, c, Customer.class);

	}

	/**
	 * 根据客户标号修改客户信息
	 * 
	 * @param customer
	 * @return
	 */
	public boolean updateCustomer(Customer customer) {
		String sql = "update t_customer set customer_name=#{customerName},shorts=#{shorts},address=#{address},zip=#{zip},telephone=#{telephone},fax=#{fax},contacts=#{contacts},contacts_tel=#{contactsTel},bank=#{bank},account=#{account},mail=#{mail} where id=#{id}";
		return update(sql, customer);
	}

	/***
	 * 根据available 修改，0 ：删除，1：找回
	 * 
	 * @param id
	 * @return
	 */
	public boolean updateCustomer(String id, Integer available) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setAvailable(available);
		String sql = "update t_customer set available= #{available} where id=#{id}";
		return update(sql, customer);
	}

}
