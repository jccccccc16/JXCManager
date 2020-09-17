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
		setTitle("操作员信息管理");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,screenSize.width/2,screenSize.height/2);
		setClosable(true);  //支持窗口可关闭
		setIconifiable(true);  //支持窗口最小化显示*
		//final CustormerAddPanel addPanel = new CustormerAddPanel();
		final OperatorAddPanel addPanel = new OperatorAddPanel();
		final OperatorEditPanel editPanel = new OperatorEditPanel();
		JTabbedPane tabPane = new JTabbedPane();
		//想选项卡添加面板
		tabPane.addTab("操作员信息添加",null,addPanel,"操作员信息添加");
		tabPane.addTab("操作员信息编辑",null,editPanel,"操作员信息编辑");
		
		//向frame窗口添加选项卡
		getContentPane().add(tabPane);
		//给选项卡设置改变监听
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
