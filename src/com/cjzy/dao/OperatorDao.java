package com.cjzy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cjzy.common.Constants;
import com.cjzy.common.ErrorManager;
import com.cjzy.model.Operator;

public class OperatorDao extends BaseDao{
	
	

	
	/**
	 * 真删除
	 */

	public boolean delete(String username) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM t_operator WHERE username= #{username}";
		Operator operator = new Operator();
		operator.setUsername(username);
		return update(sql,operator);
	}
	/**
	 * 修改操作
	 */
	
	public boolean update(Operator t) {
		// TODO Auto-generated method stub
		String sql = "update t_operator set password=#{password},name=#{name},power=#{power} where username=#{username} ";
		return update(sql, t);
	}
	/***
	 * 查询
	 */
	public List<Operator> query(Operator operator) {
		// TODO Auto-generated method stub
		String sql=null;
		if(operator==null) {//查询全部
			 sql="select * from t_operator";
		}else if(operator.getUsername()!=null&&!operator.getUsername().equals("")
				&&operator.getPassword()!=null&&!operator.getPassword().equals("")) {//登录
			sql="select * from t_operator where username=#{password} and password=#{password}";
		}else if(operator.getUsername()!=null&&!operator.getUsername().equals("")) {
			sql="select * from t_operator where username=#{username}";//通过用户名查找
		}
		return selectList(sql, operator, Operator.class);
	}
	
	/***
	 * 添加一个
	 * @param t
	 * @return
	 */
	public boolean addOperator(Operator t) {
		String sql="insert into t_operator values(#{username},#{password},#{name},#{power})";
		return update(sql, t);
	}
	/***
	 * 通过名字查找
	 * @param name
	 * @return
	 */
	public Operator queryByName(String name) {
		String sql="select * from t_operator where name=#{name}";
		Operator operator = new Operator();
		operator.setName(name);
		return selectList(sql, operator, Operator.class).get(0);
	}
	
	
	
	
	
	
	
	

}
