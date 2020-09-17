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
import com.cjzy.view.operator.OperatorAddPanel;
import com.cjzy.view.operator.OperatorEditPanel;

public class OperatorInternalFrame extends JInternalFrame {


	public OperatorInternalFrame() {
		setTitle("����Ա��Ϣ����");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,screenSize.width/2,screenSize.height/2);
		setClosable(true);  //֧�ִ��ڿɹر�
		setIconifiable(true);  //֧�ִ�����С����ʾ*
		//final CustormerAddPanel addPanel = new CustormerAddPanel();
		final OperatorAddPanel addPanel = new OperatorAddPanel();
		final OperatorEditPanel editPanel = new OperatorEditPanel();
		JTabbedPane tabPane = new JTabbedPane();
		//��ѡ�������
		tabPane.addTab("����Ա��Ϣ���",null,addPanel,"����Ա��Ϣ���");
		tabPane.addTab("����Ա��Ϣ�༭",null,editPanel,"����Ա��Ϣ�༭");
		
		//��frame�������ѡ�
		getContentPane().add(tabPane);
		//��ѡ����øı����
		tabPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//editPanel.initComboBoxGood();
				//editPanel.initComboBoxProvider();
			}
		});

	}

}
