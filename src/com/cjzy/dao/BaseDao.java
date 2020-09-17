package com.cjzy.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.TableStringConverter;

import com.cjzy.common.Constants;
import com.cjzy.common.ErrorManager;
import com.cjzy.model.Customer;
import com.cjzy.model.Good;
import com.cjzy.model.Inpout;
import com.cjzy.model.Provider;

import sun.reflect.generics.tree.ReturnType;

/**
 * 提取的供应商和客户信息
 * 
 * @author 61702
 *
 */
public class BaseDao {

	SqlManager sqlManager = null;

	public BaseDao() {
		sqlManager = SqlManager.createInstance();
		sqlManager.connectDB();
	}

	public boolean save(Object o, String sql) {
		Object[] params = Utils.getParams(o);
		boolean executeUpdate = sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
		return executeUpdate;

	}

	public String getId(String sql, String prefix) {

		ResultSet rs = sqlManager.executeQuery(sql, null, Constants.PSTM_TYPE);
		String id = prefix + "1001";
		try {
			if (rs != null && rs.next()) {
				String sid = rs.getString(1);
				if (sid != null) {
					String str = sid.substring(2);// 截取编号中的数字
					id = prefix + (Integer.parseInt(str) + 1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("baseDao  getId()", e);
		}
		return id;
	}

	/**
	 * 
	 * @param o   该对象包含了查询需要的条件
	 * @param sql
	 * @return
	 */

	/**
	 * public <T> List selectList(String sql, Object o) { Object[] params =
	 * Utils.getParams(o); String[] filedNames = Utils.getFieldNames_(o); String[]
	 * filedNames_ = Utils.getFieldNames_(o); // 获取下划线格式的属性名 Field[] fileds =
	 * Utils.getFields(o); ResultSet rs = sqlManager.executeQuery(sql, params,
	 * Constants.PSTM_TYPE); List<T> list = new ArrayList<T>(); try { while
	 * (rs.next()) { T element = (T) o.getClass().newInstance(); for (int i = 0; i <
	 * filedNames.length; i++) { String value = rs.getString(filedNames_[i]); Method
	 * setter =
	 * o.getClass().getDeclaredMethod(Utils.getSetterMethodName(filedNames[i]),
	 * fileds[i].getType().getClass()); setter.invoke(element, value); }
	 * list.add(element); } } catch (Exception e) { // TODO Auto-generated
	 * ErrorManager.printError("BaseDao query()", e); } return list; }
	 */

	/**
	 * 
	 * @param sql
	 * @param o          一个实体类对象,包含阐述
	 * @param returnType 返回类型
	 * @return
	 */

	public <T> List<T> selectList(String sql, Object o, Class<T> returnType) {

		String sqlwValue = Utils.getSqlWithingValue(sql, o);
		ResultSet rs = sqlManager.executeQuery(sqlwValue, null, Constants.PSTM_TYPE);
		List<T> list = new ArrayList<T>();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				T element = (T) returnType.newInstance();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnName_ = rsmd.getColumnName(i+1);
					
					Object value = rs.getObject(columnName_);
					String filedName = Utils._toCamel(columnName_); // _转小驼峰
					Field field = Utils.getField(filedName, returnType);
					if(field.getType().toString().equals("class java.util.Date")){
		                    Timestamp time = (Timestamp) value;
		                    Date date = new Date(time.getTime());
		                    value = date;
		             }
					Method setter = returnType.getDeclaredMethod(Utils.getSetterMethodName(filedName),field.getType());
					setter.invoke(element, value);
				}
				list.add(element);
			}
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/***
	 * 搜索一个结果
	 * 
	 * @param sql
	 * @param params     一个实体类对象,包含阐述
	 * @param returnType
	 * @return
	 */
	public <T> T selectOne(String sql, Object params, Class<T> returnType) {
		List list = null; // 存放结果
		String sqlwValue = Utils.getSqlWithingValue(sql, params);
		ResultSet rs = sqlManager.executeQuery(sqlwValue, null, Constants.PSTM_TYPE); // 执行sql语句
		try {
			if (isWrapClass(returnType)) {// 是基本类型
				rs.next();
				// 将结果添加进list
				list = new ArrayList<String>();
				list.add(rs.getObject(1));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) list.get(0);
	}

	/**
	 * 判断是否为基本类型
	 * 
	 * @param clz
	 * @return
	 */
	public static boolean isWrapClass(Class clz) {
		boolean flag;
		try {
			if (clz.getName().equals("java.lang.String")) {
				flag = true;
			} else {
				flag = ((Class) clz.getField("TYPE").get(null)).isPrimitive();
			}

		} catch (Exception e) {
			return false;
		}
		return flag;
	}

	/**
	 * 
	 * @param sql
	 * @param o
	 * @return
	 */
	public boolean update(String sql, Object o) {

		String sqlWithingValue = Utils.getSqlWithingValue(sql, o);
		boolean executeUpdate = sqlManager.executeUpdate(sqlWithingValue, null, Constants.PSTM_TYPE);
		return executeUpdate;

	}

	/*
	 * public abstract boolean update(Object object); public abstract List
	 * query(Object object); public abstract boolean delete(Object object); public
	 * abstract boolean add(Object object);
	 */
	public static void main(String[] args) {
		/*
		 * Customer c = new Customer(); c.setId("CT1002"); BaseDao baseDao =new
		 * BaseDao(); String sql ="select * from t_customer where id = #{id}";
		 * List<Customer> selectList = (List<Customer>) baseDao.selectList(sql, c,
		 * c.getClass()); for (Customer customer :selectList) {
		 * System.out.println(customer); }
		 * 
		 */
		/*
		 * Inpout inpout = new Inpout("IP1001",5, 50, "良好", "PD1001", new Date(),"管理员",
		 * "马风", "银联", "GD1001"); String sqlWithingValue = Utils.
		 * getSqlWithingValue("INSERT INTO t_inport VALUES(#{id},#{number},#{price},#{comment},#{providerId},#{inportTime},#{operatePerson},#{sponsor},#{payType},#{goodsId})"
		 * , inpout);
		 * 
		 */

		/*
		 * update("INSERT INTO t_inport VALUES(#{id},#{number},#{price},#{comment},#{providerId},#{inportTime},#{operatePerson},#{sponsor},#{payType},#{goodsId})"
		 * ,inpout);
		 */



	}

}
