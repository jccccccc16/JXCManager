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
import com.cjzy.view.provider.ProviderAddPanel;
import com.cjzy.view.provider.ProviderEditPanel;

public class ProviderInternalFrame extends JInternalFrame {

	/**
	 * Create the frame.
	 */
	public ProviderInternalFrame() {
		setTitle("��Ӧ����Ϣ����");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,screenSize.width/2,screenSize.height/2);
		setClosable(true);  //֧�ִ��ڿɹر�
		setIconifiable(true);  //֧�ִ�����С����ʾ*
		//final CustormerAddPanel addPanel = new CustormerAddPanel();
		final ProviderAddPanel addPanel = new ProviderAddPanel();
		final ProviderEditPanel editPanel = new ProviderEditPanel();
		JTabbedPane tabPane = new JTabbedPane();
		//��ѡ�������
		tabPane.addTab("��Ӧ����Ϣ���",null,addPanel,"��Ӧ����Ϣ���");
		tabPane.addTab("��Ӧ����Ϣ�༭",null,editPanel,"��Ӧ����Ϣ�༭");
		
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
