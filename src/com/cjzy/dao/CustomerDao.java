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
	 * ��ӿͻ�
	 * 
	 * @return
	 */
	public boolean addCustomer(Customer customer) {

		String sql = "insert into t_customer values(#{id},#{customerName},#{shorts},#{address},#{zip},#{telephone},#{fax},#{contacts},#{contactsTel},#{bank},#{account},#{mail},1)";
		return update(sql, customer);

	}

	/**
	 * ���ɿͻ����
	 * 
	 * @return
	 */
	public String getCustomerId() {
		String sql = "select MAX(id) id from t_customer";
		return getId(sql, "CT");
	}

	/**
	 * ���ҿͻ�
	 * 
	 * @param c ����Ҫ���ҵ�������д��Customer��
	 * @return
	 */
	public List<Customer> findCustomers(Customer c) {

		String sql = null;

		if (c == null) {
			sql = "select * from t_customer where available=1";
		} else {
			if (c.getId() != null && !c.getId().equals("")) {
				sql = "select * from t_customer where id=#{id} and available=1";

			} else if (c.getCustomerName() != null && !c.getCustomerName().equals("")) { // ȫ�Ʋ�ѯ
				sql = "select * from t_customer where customer_name like #{customerName} and available=1 ";

			} else if (c.getShorts() != null && !c.getShorts().equals("")) {// ���
				sql = "select * from t_customer where shorts like #{shorts} and available=1 ";

			} else if (c.getContacts() != null && !c.getContacts().equals("")) {// ��ϵ��
				sql = "select * from t_customer where contacts like #{contacts} and available=1 ";

			}
		}
		return selectList(sql, c, Customer.class);

	}

	/**
	 * ���ݿͻ�����޸Ŀͻ���Ϣ
	 * 
	 * @param customer
	 * @return
	 */
	public boolean updateCustomer(Customer customer) {
		String sql = "update t_customer set customer_name=#{customerName},shorts=#{shorts},address=#{address},zip=#{zip},telephone=#{telephone},fax=#{fax},contacts=#{contacts},contacts_tel=#{contactsTel},bank=#{bank},account=#{account},mail=#{mail} where id=#{id}";
		return update(sql, customer);
	}

	/***
	 * ����available �޸ģ�0 ��ɾ����1���һ�
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
