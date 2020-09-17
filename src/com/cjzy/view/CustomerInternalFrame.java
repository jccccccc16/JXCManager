package com.cjzy.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.cjzy.view.customer.CustomerEditPanel;
import com.cjzy.view.customer.CustormerAddPanel;
/***
 * �ͻ���Ϣ�������
 * @author 61702
 *
 */
public class CustomerInternalFrame extends JInternalFrame {

	/**
	 * Create the frame.
	 */
	public CustomerInternalFrame() {
		setTitle("\u5BA2\u6237\u4FE1\u606F\u7BA1\u7406");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,screenSize.width/2,screenSize.height/2);
		setClosable(true);  //֧�ִ��ڿɹر�
		setIconifiable(true);  //֧�ִ�����С����ʾ*
		final CustormerAddPanel addPanel = new CustormerAddPanel();
		final CustomerEditPanel editPanel = new CustomerEditPanel();
		JTabbedPane tabPane = new JTabbedPane();
		//��ѡ�������
		tabPane.addTab("�ͻ���Ϣ���",null,addPanel,"�ͻ���Ϣ���");
		tabPane.addTab("�ͻ���Ϣ�༭",null,editPanel,"�ͻ���Ϣ�༭");
		
		//��frame�������ѡ�
		getContentPane().add(tabPane);
		//��ѡ����øı����
		tabPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				editPanel.initComboBox();
			}
		});
		
		//pack();  //ͨ���ڲ�����Զ���ʾ���ڴ�С
		
		
		
	}

}
