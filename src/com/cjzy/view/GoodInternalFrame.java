package com.cjzy.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.cjzy.view.good.GoodAddPanel;
import com.cjzy.view.good.GoodEditPanel;
import com.cjzy.view.provider.ProviderAddPanel;
import com.cjzy.view.provider.ProviderEditPanel;

public class GoodInternalFrame extends JInternalFrame {



	/**
	 * Create the frame.
	 */
	public GoodInternalFrame() {
		setTitle("��Ʒ��Ϣ����");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,screenSize.width/2,screenSize.height/2);
		setClosable(true);  //֧�ִ��ڿɹر�
		setIconifiable(true);  //֧�ִ�����С����ʾ*
		//final CustormerAddPanel addPanel = new CustormerAddPanel();
		final GoodAddPanel addPanel = new GoodAddPanel();
		final GoodEditPanel editPanel = new GoodEditPanel();
		JTabbedPane tabPane = new JTabbedPane();
		//��ѡ�������
		tabPane.addTab("��Ʒ��Ϣ���",null,addPanel,"��Ʒ��Ϣ���");
		tabPane.addTab("��Ʒ��Ϣ�༭",null,editPanel,"��Ʒ��Ϣ�༭");
		
		//��frame�������ѡ�
		getContentPane().add(tabPane);
		//��ѡ����øı����
		tabPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				editPanel.initComboBoxGood();
				editPanel.initComboBoxProvider();
			}
		});

	}

}
