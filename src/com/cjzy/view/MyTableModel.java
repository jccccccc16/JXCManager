package com.cjzy.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.cjzy.dao.Utils;
import com.cjzy.model.Customer;

/***|
 * 自定义表格数据魔板，也就是说 数据要怎样显示
 * @author 61702
 *
 */
	//可以优化
class MyTableModel<T> extends AbstractTableModel {
	
	private Vector<T> data=new Vector<T>() ; //数据源
	
	private String[] columnNames;  //表的标题栏
	
	private Class<T> cls;
	
	
	
	public MyTableModel(String[] columnNames) {
		super();
		this.columnNames = columnNames;
		
	}

	@Override
	public int getColumnCount() {   //列的数量
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() { //行的数量
		// TODO Auto-generated method stub
		return data.size();
	}
	
	/**
	 * 获取列名
	 */
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
		
	}
	/**
	 * 获取对应行，对应列的数据，也就是第row个对象中的第col个属性值
	 */
	@Override
	public Object getValueAt(int row, int col) {
		T c = data.get(row);
		return Utils.getValueAt(c, col);   //获列*/
	}
	/**
	 * 获取每一列对应属性类
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex){
		return getValueAt(0, columnIndex).getClass();
	}
	
	/***
	 * 是否可编辑
	 */
	@Override
	public boolean isCellEditable(int rowIndex,int columnIndex) {
		return false;
	}
	
	/****
	 * 更新数据
	 * @param customers
	 */
	public void updateData(Vector<T> data) {
		this.data = data;
		if(data.size()==0) {
			data = new Vector<T>();
		}else {  //填充数据
			fireTableRowsInserted(0, data.size()-1);
		}
	}
	
	
	
	
}