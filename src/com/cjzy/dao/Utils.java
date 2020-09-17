package com.cjzy.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Matcher;

import com.cjzy.model.Customer;
import com.cjzy.model.Provider;

public class Utils {
	
	/**
	 * ��ȡ�����е�����ֵ��
	 * @param o
	 * @return
	 */
	public static Object[] getParams(Object o) {
		
		String[] filedNames = getFieldNames(o);
		Object[] params = new Object[filedNames.length];
		for(int i=0;i<filedNames.length;i++) {
			/*String firstLetter = filedNames[i].substring(0,1).toUpperCase();
			String getter = "get"+firstLetter+filedNames[i].substring(1);    //ƴ�ӵõ�������getXXX()*/
			String getter = getGetterMethodName(filedNames[i]);
			try {
				Method method = o.getClass().getMethod(getter, new Class[] {});
				Object value = method.invoke(o, new Object[]{});    //���÷�����ȡ����ֵ
				if(value!=null) {       //������ֵ��Ϊ��ʱ
					params[i] = value;
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return params;
	}
	
	/***
	 * ��ȡһ������ֵ
	 * @param paramName
	 * @param o
	 * @return
	 */
	public static Object getParam(String paramName,Object o) {
		String getterMethodName = getGetterMethodName(paramName);
		Object value =null;
		try {
			Method method = o.getClass().getMethod(getterMethodName, new Class[] {});
			value = method.invoke(o,new Object[] {});
			if(value!=null) {
				return value;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	

	
	
	/**
	 * ͨ�����������õ�����getter��
	 * @param filedName
	 * @return
	 */
	public static String getGetterMethodName(String filedName) {
		String firstLetter = filedName.substring(0,1).toUpperCase();
		String getter = "get"+firstLetter+filedName.substring(1);    //ƴ�ӵõ�������getXXX()
		return getter;
	}
	/***
	 * ͨ�����������õ�����setter��
	 * @param filedName
	 * @return
	 */
	public static String getSetterMethodName(String filedName) {
		String firstLetter = filedName.substring(0,1).toUpperCase();
		String setter = "set"+firstLetter+filedName.substring(1);    //ƴ�ӵõ�������getXXX()

		return setter;
	}
	
	
	
	/**
	 * ��ȡ�������б�
	 * @param o
	 * @return
	 */
	public static String[] getFieldNames(Object o) {
		
		Field[] fields = getFields(o);
		String[] fieldNames = new String[fields.length];
		for(int i=0;i<fields.length;i++) {
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}
	
	/**
	 * ��ȡ����������б�
	 * @param o
	 * @return
	 */
	public static Field[] getFields(Object o) {
		return o.getClass().getDeclaredFields();
		
	}
	
	/***
	 * �������������ض�Ӧ��field
	 * @param fieldName
	 * @param type
	 * @return
	 */
	public static <T> Field getField(String fieldName,Class<T> type) {
		
		try {
			return type.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/***
	 * ��ȡ�����б�,��С�շ�ת��Ϊ�»���_��ʽ
	 * @return
	 */
	public static String[] getFieldNames_(Object o){
		Field[] fields =getFields(o);
		String[] fieldNames = new String[fields.length];
		for(int i=0;i<fields.length;i++) {
			String name = camelTo_(fields[i].getName());
			fieldNames[i] = name;
		}
		return fieldNames;
	}
	
	
	/**
	 * С�շ�ת��Ϊ�»��߸�ʽ
	 * @param name
	 * @return
	 */
	public static String camelTo_(String name) {
		
		StringBuffer sb = new StringBuffer();
		char[] charArray = name.toCharArray();
		for(char c:charArray) {
			if(Character.isUpperCase(c)) {
				sb.append('_');
				c = Character.toLowerCase(c);
			}
			sb.append(c);
		}
	
		return sb.toString();	
	}
	/**
	 * �»���תС�շ�
	 * @param name
	 * @return
	 */
	public static String _toCamel(String name) {
		StringBuffer sb = new StringBuffer();
		char[] charArray = name.toCharArray();
		boolean flag=false;
		for (char c : charArray) {
			if(c=='_') {
				flag=true;
				continue;
			}
			if(flag) {
				c=Character.toUpperCase(c);
				flag=false;
			}
			sb.append(c);
		}
		return sb.toString();
		
	}
	
	
	
	public static String getFieldName() {
		
		return null;
	}
	

	/**
	 * ��ȡ�ö���ĵڼ�������ֵ
	 * @param o
	 * @param no
	 * @return
	 */
	public static Object getValueAt(Object o,int no) {
		
		Object[] params = getParams(o);
		Object object = params[no];
		return object;
	}
	
	/**
	 * ��ȡ��ֵ��sql���,sql��ʽselect * from t_goods where id = #{id}
	 * @return
	 */
	public static String getSqlWithingValue(String sql,Object o) {
		
		char[] sqlCharArray = sql.toCharArray();
		StringBuffer result;
		if(o!=null) {
			result = new StringBuffer();
			for(int i=0;i<sqlCharArray.length;i++) {
				if(sqlCharArray[i]=='#') {		
					if(sqlCharArray[i+1]=='{') {
						StringBuffer param = new StringBuffer();
						i = i+2;
						char c = ' ';
						c = sqlCharArray[i];
						result.append('"');
						while(c!='}') {
							param.append(c);
							i = i+1;
							c=sqlCharArray[i];
						}
						
						String paramVlue = String.valueOf(getParam(param.toString(),o));
						if(sql.toLowerCase().contains("like")) { 
							result.append("%");
							result.append(paramVlue);
							result.append("%");
						}else {
							result.append(paramVlue);
						}
						result.append('"');
						
					}
				}else {
					result.append(sqlCharArray[i]);
				}
			}
		}else {
			result =new StringBuffer(sql);
		}
		
		System.out.println(result.toString());
		return result.toString();
	}

	
	
	
	
	public static void main(String[] args) {
		Customer customer = new Customer();
		/*customer.setId("CT1052");
		String id = (String) getParam("id",customer);
		System.out.println(id);
		
		String sql = getSqlWithingValue("select * from t_customer where id=#{id}",customer);
		System.out.println(sql);*/
		/*
		String[] fieldNames_ = getFieldNames_(customer);
		for (String string : fieldNames_) {
			System.out.println(string);
		}*/
		/*
		Customer c = new Customer();
		c.setId("CT");
		String param =  (String) getParam("id", c);
		System.out.println(param);*/
		/*String setter = getGetterMethodName("id");
		System.out.println(setter);*/
		/*String fieldName_ = getFieldName_("provideName");
		System.out.println(fieldName_);*/
		String _toCamel = _toCamel("provider_name");
		System.out.println(_toCamel);
	
	}
	
	
	
	
	
	

}
