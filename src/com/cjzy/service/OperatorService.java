package com.cjzy.service;

import java.util.List;

import com.cjzy.model.Operator;

/**
 * 操作员业务接口
 * @author 61702
 *
 */
public interface OperatorService {
	/***
	 * 登录
	 * @param operator：需要username 和password
	 * @return true:查询成功，false不正确
	 */
	boolean loginCheck(Operator operator);
	
	
	/***
	 * 
	 * @param username
	 * @return
	 */
	public boolean delete(String username);
	
	/***
	 * 修改
	 * @param t 实体类
	 * @return
	 */
	public boolean update(Operator t);
	
	/***
	 * 查找全部
	 * @param t
	 * @return
	 */
	public List<Operator> query(Operator operator);
	
	/***
	 * 通过用户名查找
	 * @param name
	 * @return
	 */
	public Operator queryByUserName(String username);
	
	/***
	 * 添加一个
	 * @param t
	 * @return
	 */
	public boolean addOperator(Operator t);
	
	
}
