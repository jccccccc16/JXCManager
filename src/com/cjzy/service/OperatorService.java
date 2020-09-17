package com.cjzy.service;

import java.util.List;

import com.cjzy.model.Operator;

/**
 * ����Աҵ��ӿ�
 * @author 61702
 *
 */
public interface OperatorService {
	/***
	 * ��¼
	 * @param operator����Ҫusername ��password
	 * @return true:��ѯ�ɹ���false����ȷ
	 */
	boolean loginCheck(Operator operator);
	
	
	/***
	 * 
	 * @param username
	 * @return
	 */
	public boolean delete(String username);
	
	/***
	 * �޸�
	 * @param t ʵ����
	 * @return
	 */
	public boolean update(Operator t);
	
	/***
	 * ����ȫ��
	 * @param t
	 * @return
	 */
	public List<Operator> query(Operator operator);
	
	/***
	 * ͨ���û�������
	 * @param name
	 * @return
	 */
	public Operator queryByUserName(String username);
	
	/***
	 * ���һ��
	 * @param t
	 * @return
	 */
	public boolean addOperator(Operator t);
	
	
}
