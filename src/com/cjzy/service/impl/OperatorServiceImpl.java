package com.cjzy.service.impl;

import java.util.List;

import com.cjzy.dao.OperatorDao;
import com.cjzy.model.Operator;
import com.cjzy.service.OperatorService;

/***
 * ʵ����
 * 
 * @author 61702
 *
 */
public class OperatorServiceImpl implements OperatorService {

	private OperatorDao operatorDao = null;

	/***
	 * ��¼
	 * 
	 * @param operator����Ҫusername ��password
	 * @return true:��ѯ�ɹ���false����ȷ
	 */
	@Override
	public boolean loginCheck(Operator operator) {
		operatorDao = new OperatorDao();
		boolean flag = false;
		if (operatorDao.query(operator).size()!= 0) {
			flag = true;
			
		}
		return flag;
	}

	@Override
	public boolean delete(String username) {
		// TODO Auto-generated method stub
		operatorDao = new OperatorDao();
		return operatorDao.delete(username);
	}

	@Override
	public boolean update(Operator t) {
		// TODO Auto-generated method stub
		operatorDao = new OperatorDao();
		return operatorDao.update(t);
	}

	/***
	 * ��ѯȫ��
	 */
	@Override
	public List<Operator> query(Operator operator) {
		// TODO Auto-generated method stub
		operatorDao = new OperatorDao();
		return operatorDao.query(operator);
	}

	/***
	 * ���һ��
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public boolean addOperator(Operator t) {
		// TODO Auto-generated method stub
		operatorDao = new OperatorDao();
		return operatorDao.addOperator(t);
	}

	/**
	 * ͨ���û�������
	 */
	@Override
	public Operator queryByUserName(String username) {
		// TODO Auto-generated method stub
		operatorDao = new OperatorDao();
		Operator operator = new Operator();
		operator.setUsername(username);
		return operatorDao.query(operator).get(0);
	}

}
