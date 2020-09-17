package com.cjzy.view.provider;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.model.Customer;
import com.cjzy.model.Provider;
import com.cjzy.service.CustomerService;
import com.cjzy.service.ProviderService;

public class ProviderAddPanel extends JPanel implements ActionListener{

	private JTextField providerNameTf;
	private JTextField addressTf;
	private JTextField shortsTf;
	private JTextField zipTf;
	private JTextField telTf;
	private JTextField faxTf;
	private JTextField contactsTf;
	private JTextField phoneTf;
	private JTextField emailTf;
	private JTextField bankTf;
	private JTextField accountTf;
	private ProviderService providerService = null;

	/**
	 * Create the panel.
	 */
	public ProviderAddPanel() {
		

		JLabel lblNewLabel = new JLabel("供应商全称：");
		
		providerNameTf = new JTextField();
		providerNameTf.setColumns(30);
		
		JLabel label = new JLabel("供应商地址：");
		
		addressTf = new JTextField();
		addressTf.setColumns(30);
		
		JLabel label_1 = new JLabel("供应商简称：");
		
		shortsTf = new JTextField();
		shortsTf.setColumns(30);
		
		JLabel label_2 = new JLabel("供应商邮编：");
		
		zipTf = new JTextField();
		zipTf.setColumns(30);
		
		JLabel label_3 = new JLabel("供应商电话：");
		
		telTf = new JTextField();
		telTf.setColumns(30);
		
		JLabel label_4 = new JLabel("传真：   ");
		
		faxTf = new JTextField();
		faxTf.setColumns(30);
		
		JLabel label_6 = new JLabel("\u8054\u7CFB\u4EBA\uFF1A");
		
		contactsTf = new JTextField();
		contactsTf.setColumns(30);
		
		JLabel label_7 = new JLabel("\u8054\u7CFB\u4EBA\u7535\u8BDD\uFF1A");
		
		phoneTf = new JTextField();
		phoneTf.setColumns(30);
		
		JLabel lblNewLabel_1 = new JLabel("e-mail:");
		
		emailTf = new JTextField();
		emailTf.setColumns(30);
		
		JLabel label_8 = new JLabel("开户银行：");
		
		bankTf = new JTextField();
		bankTf.setColumns(30);
		
		JLabel label_9 = new JLabel("银行账户：");
		
		accountTf = new JTextField();
		accountTf.setColumns(30);
		
		providerService = CommonFactory.getProviderService();
		
		JLabel label_5 = new JLabel("");
		
		JButton saveBtn = new JButton("保存");
		saveBtn.addActionListener(this);
		
		JButton resetBtn = new JButton("重置");
		resetBtn.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(providerNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(label)
					.addGap(6)
					.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(label_1)
					.addGap(5)
					.addComponent(shortsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(label_2)
					.addGap(10)
					.addComponent(zipTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(label_3)
					.addGap(5)
					.addComponent(telTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(label_4)
					.addGap(27)
					.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(label_6)
					.addGap(35)
					.addComponent(contactsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(label_7)
					.addGap(6)
					.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(label_8)
					.addGap(20)
					.addComponent(bankTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(label_9)
					.addGap(21)
					.addComponent(accountTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1)
					.addGap(39)
					.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(saveBtn)
					.addGap(33)
					.addComponent(resetBtn))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(providerNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_1))
						.addComponent(shortsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(zipTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(telTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_6))
						.addComponent(contactsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(label_7))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_8))
						.addComponent(bankTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_9))
						.addComponent(accountTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(saveBtn)
						.addComponent(resetBtn)))
		);
		setLayout(groupLayout);
		
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String target = e.getActionCommand();
		switch (target) {
		case "保存":
			if(providerNameTf.getText().trim().equals("")||
					addressTf.getText().trim().equals("")||
					shortsTf.getText().trim().equals("")||
					zipTf.getText().trim().equals("")||
					telTf.getText().trim().equals("")||
					faxTf.getText().trim().equals("")||
					contactsTf.getText().trim().equals("")||
					phoneTf.getText().trim().equals("")||
					emailTf.getText().trim().equals("")||
					bankTf.getText().trim().equals("")||
					accountTf.getText().trim().equals("")) {
				
				JOptionPane.showMessageDialog(null, "请填写全部信息","温馨提示",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			//客户编号
			String id = providerService.getProviderId();
			//将客户添加到数据库
			Provider provider = new Provider(id, providerNameTf.getText().trim(), shortsTf.getText().trim(), addressTf.getText().trim(), 
					zipTf.getText().trim(), telTf.getText().trim(), faxTf.getText().trim(), contactsTf.getText().trim(), 
					phoneTf.getText().trim(), bankTf.getText().trim(), accountTf.getText().trim(), 
					emailTf.getText().trim(), 1);
			boolean result;
			
			result = providerService.addProvider(provider);
			
			if(result=true) {
				JOptionPane.showMessageDialog(null, "供应商信息添加成功","提示",JOptionPane.INFORMATION_MESSAGE);
				setNull();
			}else {
				JOptionPane.showMessageDialog(null, "供应商信息添加失败","警告",JOptionPane.WARNING_MESSAGE);
			}
			break;
		case "重置":
			setNull();
		default:
			break;
		}
	}
	/***
	 * 清空文本框
	 */
	private void setNull() {
		providerNameTf.setText(""); shortsTf.setText(""); addressTf.setText(""); 
		zipTf.setText("");telTf.setText(""); faxTf.setText(""); contactsTf.setText(""); 
		phoneTf.setText("");bankTf.setText(""); accountTf.setText(""); 
		emailTf.setText("");
	}

}
