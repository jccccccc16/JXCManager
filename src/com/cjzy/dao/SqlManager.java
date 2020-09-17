package com.cjzy.dao;
/***
 * 数据库访问工具类，进行数据库的底层操作
 * @author 61702
 *
 */

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;

import javax.swing.JOptionPane;

import com.cjzy.common.Constants;
import com.cjzy.common.ErrorManager;

public class SqlManager {
	// 保证单例
	private static SqlManager manager = null;
	// 配置资源文件
	private PropertyResourceBundle bundle = null;
	private static String jdbcDrive = null;
	private String DBhost = "";
	private String DBname = "";
	private String DBport = "";
	private String DBuser = "";
	private String DBpassword = "";
	private String strcon = null; // 链接字符串

	private Connection connection = null;
	private PreparedStatement pstm = null;
	private CallableStatement cstm = null; // 过程函数接口

	/***
	 * 私有构造
	 */
	private SqlManager() {
		// 读取配置文件
		try {
			bundle = new PropertyResourceBundle(SqlManager.class.getResourceAsStream("SqlConfig.properties"));
			this.DBhost = getString("DBhost");
			this.DBname = getString("DBname");
			this.DBport = getString("DBport");
			this.DBuser = getString("DBuser");
			this.DBpassword = getString("DBpassword");
			String database_type = getString("database-type");
			if (database_type != null) {
				if (database_type.toLowerCase().equals("mysql")) { // 设置mysql数据库的驱动程序和连接字符
					jdbcDrive = "com.mysql.jdbc.Driver";
					strcon = "jdbc:mysql://" + DBhost + ":" + DBport + "/" + DBname;
				} else if (database_type.toLowerCase().equals("oracle")) {

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("SqlManager 构造方法", e);
		}

	}

	/***
	 * 读取配置文件中的值
	 * 
	 * @param key 配置中的key
	 * @return key对应的值
	 */
	private String getString(String key) {
		return this.bundle.getString(key);
	}

	/***
	 * F 单例模式获取实例
	 * 
	 * @return
	 */
	public static SqlManager createInstance() {
		if (manager == null) {
			manager = new SqlManager();
			// 初始化
			manager.initDB();
		}
		return manager;
	}

	/***
	 * 初始化连接参数，由指定的DBtype生成
	 */
	public void initDB() {
		try {
			Class.forName(jdbcDrive);
		} catch (Exception e) {
			// TODO: handle exception
			ErrorManager.printError("SqlManager initDB()", e);
		}
		System.out.println("成功加载驱动类");
	}

	public void connectDB() {
		try {
			connection = DriverManager.getConnection(strcon, DBuser, DBpassword);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO: handle exception
			if (e.getErrorCode() == 0) {
				JOptionPane.showMessageDialog(null, "数据库未启动，请检查", "警告", JOptionPane.WARNING_MESSAGE);
			}
			if (e.getErrorCode() == 1045) {
				JOptionPane.showMessageDialog(null, "连接错误,请检查用户名和密码是否正确", "警告", JOptionPane.WARNING_MESSAGE);
			}
			ErrorManager.printError("SqlManager connectDB", e);
		}
		System.out.println("成功连接到数据库");
	}

	public void closeDB() {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (cstm != null) {
				cstm.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	private void setPrepareStatementParams(String sql,Object[] params) {
		try {
			pstm = connection.prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {  //遍历填充数据
					pstm.setObject(i+1, params[i]); //索引从1开始
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("SqlManager setPrepareStatementParams()", e);
		}
	}
	/***
	 * 设置
	 * @param sql
	 * @param params
	 */
	private void setCallableStatementParams(String sql,Object[] params) {
		try {
			cstm = connection.prepareCall(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					cstm.setObject(i+1, params[i]);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			ErrorManager.printError("SqlManager setCallableStatementParams()", e);
		}
	}
	
	/***
	 * 执行查询
	 * @param sql；sql语句
	 * @param params：参数列表
	 * @param type：sql语句类型
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object[] params,int type) {
		ResultSet rs=null;
		try {
			switch (type) {
			case Constants.PSTM_TYPE:  //预处理
				manager.setPrepareStatementParams(sql, params);
				rs=pstm.executeQuery();
				break;
			case Constants.CALL_TYPE:  //过程函数
				manager.setCallableStatementParams(sql, params);
				rs = cstm.executeQuery();
				break;
			default:
				throw new Exception("不存在该选项");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("SqlManager executeQuery()", e);
		}
		return rs;
	}

	/***
	 * 更新数据库库操作
	 * @param sql：
	 * @param params：
	 * @param type：
	 * @return
	 */
	public  boolean executeUpdate(String sql,Object[] params,int type) {
		boolean result = false;//
		try {
		switch (type) {
			
		case Constants.PSTM_TYPE:
				manager.setPrepareStatementParams(sql, params);
				pstm.executeUpdate();
				//提交事务
				commitChange();
				result=true;
				break;
		case Constants.CALL_TYPE:
				manager.setCallableStatementParams(sql, params);
				cstm.executeUpdate();
				commitChange();
				result=true;
				break;
		default:
			throw new Exception("不存在该选项");
		}
		}catch (Exception e) {
			ErrorManager.printError("SqlManager executeUpdate()", e);
		}
		return result;
	}
	
	private void commitChange() {
		try {
			connection.commit();
			System.out.println("数据提交成功");
		} catch (Exception e) {
			// TODO: handle exception
			ErrorManager.printError("SqlManager commitChange", e);
		}
	}
	
	
}
