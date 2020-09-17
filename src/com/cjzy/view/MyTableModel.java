package com.cjzy.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.cjzy.dao.Utils;
import com.cjzy.model.Customer;

/***|
 * �Զ���������ħ�壬Ҳ����˵ ����Ҫ������ʾ
 * @author 61702
 *
 */
	//�����Ż�
class MyTableModel<T> extends AbstractTableModel {
	
	private Vector<T> data=new Vector<T>() ; //����Դ
	
	private String[] columnNames;  //��ı�����
	
	private Class<T> cls;
	
	
	
	public MyTableModel(String[] columnNames) {
		super();
		this.columnNames = columnNames;
		
	}

	@Override
	public int getColumnCount() {   //�е�����
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() { //�е�����
		// TODO Auto-generated method stub
		return data.size();
	}
	
	/**
	 * ��ȡ����
	 */
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
		
	}
	/**
	 * ��ȡ��Ӧ�У���Ӧ�е����ݣ�Ҳ���ǵ�row�������еĵ�col������ֵ
	 */
	@Override
	public Object getValueAt(int row, int col) {
		T c = data.get(row);
		return Utils.getValueAt(c, col);   //����*/
	}
	/**
	 * ��ȡÿһ�ж�Ӧ������
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex){
		return getValueAt(0, columnIndex).getClass();
	}
	
	/***
	 * �Ƿ�ɱ༭
	 */
	@Override
	public boolean isCellEditable(int rowIndex,int columnIndex) {
		return false;
	}
	
	/****
	 * ��������
	 * @param customers
	 */
	public void updateData(Vector<T> data) {
		this.data = data;
		if(data.size()==0) {
			data = new Vector<T>();
		}else {  //�������
			fireTableRowsInserted(0, data.size()-1);
		}
	}
	
	
	
	
}