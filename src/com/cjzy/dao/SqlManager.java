package com.cjzy.dao;
/***
 * ���ݿ���ʹ����࣬�������ݿ�ĵײ����
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
	// ��֤����
	private static SqlManager manager = null;
	// ������Դ�ļ�
	private PropertyResourceBundle bundle = null;
	private static String jdbcDrive = null;
	private String DBhost = "";
	private String DBname = "";
	private String DBport = "";
	private String DBuser = "";
	private String DBpassword = "";
	private String strcon = null; // �����ַ���

	private Connection connection = null;
	private PreparedStatement pstm = null;
	private CallableStatement cstm = null; // ���̺����ӿ�

	/***
	 * ˽�й���
	 */
	private SqlManager() {
		// ��ȡ�����ļ�
		try {
			bundle = new PropertyResourceBundle(SqlManager.class.getResourceAsStream("SqlConfig.properties"));
			this.DBhost = getString("DBhost");
			this.DBname = getString("DBname");
			this.DBport = getString("DBport");
			this.DBuser = getString("DBuser");
			this.DBpassword = getString("DBpassword");
			String database_type = getString("database-type");
			if (database_type != null) {
				if (database_type.toLowerCase().equals("mysql")) { // ����mysql���ݿ����������������ַ�
					jdbcDrive = "com.mysql.jdbc.Driver";
					strcon = "jdbc:mysql://" + DBhost + ":" + DBport + "/" + DBname;
				} else if (database_type.toLowerCase().equals("oracle")) {

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("SqlManager ���췽��", e);
		}

	}

	/***
	 * ��ȡ�����ļ��е�ֵ
	 * 
	 * @param key �����е�key
	 * @return key��Ӧ��ֵ
	 */
	private String getString(String key) {
		return this.bundle.getString(key);
	}

	/***
	 * F ����ģʽ��ȡʵ��
	 * 
	 * @return
	 */
	public static SqlManager createInstance() {
		if (manager == null) {
			manager = new SqlManager();
			// ��ʼ��
			manager.initDB();
		}
		return manager;
	}

	/***
	 * ��ʼ�����Ӳ�������ָ����DBtype����
	 */
	public void initDB() {
		try {
			Class.forName(jdbcDrive);
		} catch (Exception e) {
			// TODO: handle exception
			ErrorManager.printError("SqlManager initDB()", e);
		}
		System.out.println("�ɹ�����������");
	}

	public void connectDB() {
		try {
			connection = DriverManager.getConnection(strcon, DBuser, DBpassword);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO: handle exception
			if (e.getErrorCode() == 0) {
				JOptionPane.showMessageDialog(null, "���ݿ�δ����������", "����", JOptionPane.WARNING_MESSAGE);
			}
			if (e.getErrorCode() == 1045) {
				JOptionPane.showMessageDialog(null, "���Ӵ���,�����û����������Ƿ���ȷ", "����", JOptionPane.WARNING_MESSAGE);
			}
			ErrorManager.printError("SqlManager connectDB", e);
		}
		System.out.println("�ɹ����ӵ����ݿ�");
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
				for(int i=0;i<params.length;i++) {  //�����������
					pstm.setObject(i+1, params[i]); //������1��ʼ
				}
			}
		} catch (SQLException e) {
			ErrorManager.printError("SqlManager setPrepareStatementParams()", e);
		}
	}
	/***
	 * ����
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
	 * ִ�в�ѯ
	 * @param sql��sql���
	 * @param params�������б�
	 * @param type��sql�������
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object[] params,int type) {
		ResultSet rs=null;
		try {
			switch (type) {
			case Constants.PSTM_TYPE:  //Ԥ����
				manager.setPrepareStatementParams(sql, params);
				rs=pstm.executeQuery();
				break;
			case Constants.CALL_TYPE:  //���̺���
				manager.setCallableStatementParams(sql, params);
				rs = cstm.executeQuery();
				break;
			default:
				throw new Exception("�����ڸ�ѡ��");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("SqlManager executeQuery()", e);
		}
		return rs;
	}

	/***
	 * �������ݿ�����
	 * @param sql��
	 * @param params��
	 * @param type��
	 * @return
	 */
	public  boolean executeUpdate(String sql,Object[] params,int type) {
		boolean result = false;//
		try {
		switch (type) {
			
		case Constants.PSTM_TYPE:
				manager.setPrepareStatementParams(sql, params);
				pstm.executeUpdate();
				//�ύ����
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
			throw new Exception("�����ڸ�ѡ��");
		}
		}catch (Exception e) {
			ErrorManager.printError("SqlManager executeUpdate()", e);
		}
		return result;
	}
	
	private void commitChange() {
		try {
			connection.commit();
			System.out.println("�����ύ�ɹ�");
		} catch (Exception e) {
			// TODO: handle exception
			ErrorManager.printError("SqlManager commitChange", e);
		}
	}
	
	
}
