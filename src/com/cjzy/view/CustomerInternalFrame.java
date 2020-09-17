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
 * 客户信息管理界面
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
		setClosable(true);  //支持窗口可关闭
		setIconifiable(true);  //支持窗口最小化显示*
		final CustormerAddPanel addPanel = new CustormerAddPanel();
		final CustomerEditPanel editPanel = new CustomerEditPanel();
		JTabbedPane tabPane = new JTabbedPane();
		//想选项卡添加面板
		tabPane.addTab("客户信息添加",null,addPanel,"客户信息添加");
		tabPane.addTab("客户信息编辑",null,editPanel,"客户信息编辑");
		
		//向frame窗口添加选项卡
		getContentPane().add(tabPane);
		//给选项卡设置改变监听
		tabPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				editPanel.initComboBox();
			}
		});
		
		//pack();  //通过内部组件自动显示窗口大小
		
		
		
	}

}
