package com.cjzy.view.customer;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.ErrorManager;
import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.model.Customer;
import com.cjzy.service.CustomerService;
/***
 * 客户信息添加面板
 * @author 61702
 *
 */
public class CustormerAddPanel extends JPanel implements ActionListener {
	private JTextField customerNameTf;
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
	private CustomerService customerService = null;

	/**
	 * Create the panel.
	 */
	public CustormerAddPanel() {
		
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//setBounds(screenSize.width/12,screenSize.height/20,724,412);
		JLabel lblNewLabel = new JLabel("客户全称：");
		
		customerNameTf = new JTextField();
		customerNameTf.setColumns(30);
		
		JLabel label = new JLabel("客户地址：");
		
		addressTf = new JTextField();
		addressTf.setColumns(30);
		
		JLabel label_1 = new JLabel("客户简称：");
		
		shortsTf = new JTextField();
		shortsTf.setColumns(30);
		
		JLabel label_2 = new JLabel("客户邮编：");
		
		zipTf = new JTextField();
		zipTf.setColumns(30);
		
		JLabel label_3 = new JLabel("客户电话：");
		
		telTf = new JTextField();
		telTf.setColumns(30);
		
		JLabel label_4 = new JLabel("传真：   ");
		
		faxTf = new JTextField();
		faxTf.setColumns(30);
		
		JLabel label_6 = new JLabel("联系人：  ");
		
		contactsTf = new JTextField();
		contactsTf.setColumns(30);
		
		JLabel label_7 = new JLabel("\u8054\u7CFB\u4EBA\u7535\u8BDD\uFF1A");
		
		phoneTf = new JTextField();
		phoneTf.setColumns(30);
		
		JLabel lblNewLabel_1 = new JLabel("  e-mail:");
		
		emailTf = new JTextField();
		emailTf.setColumns(73);
		
		JLabel label_8 = new JLabel("开户银行：");
		
		bankTf = new JTextField();
		bankTf.setColumns(30);
		
		JLabel label_9 = new JLabel("银行账户：");
		
		accountTf = new JTextField();
		accountTf.setColumns(30);
		
		customerService = CommonFactory.getCustomerService();
		
		JLabel label_5 = new JLabel("");
		
		JButton saveBtn = new JButton("保存");
		saveBtn.addActionListener(this);
		
		JButton resetBtn = new JButton("重置");
		resetBtn.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(customerNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(shortsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(label_2))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(20)
								.addComponent(label_8)
								.addGap(18)
								.addComponent(bankTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(saveBtn)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(resetBtn))
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(25)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(label_6)
											.addComponent(label_3)))
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNewLabel_1)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(telTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(5)
										.addComponent(label_4))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(emailTf, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
											.addComponent(contactsTf, Alignment.LEADING))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(label_9)
											.addComponent(label_7))))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(zipTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(accountTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(customerNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(shortsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(zipTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(telTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4)))
								.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(5))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6)
								.addComponent(contactsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_7)
							.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_9)
							.addComponent(accountTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bankTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(saveBtn)
						.addComponent(resetBtn))
					.addGap(238))
		);
		setLayout(groupLayout);
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String target = e.getActionCommand();
		switch (target) {
		case "保存":
			if(customerNameTf.getText().trim().equals("")||
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
			String id = customerService.getCustomerId();
			//将客户添加到数据库
			Customer customer = new Customer(id, customerNameTf.getText().trim(), shortsTf.getText().trim(), addressTf.getText().trim(), 
					zipTf.getText().trim(), telTf.getText().trim(), faxTf.getText().trim(), contactsTf.getText().trim(), 
					phoneTf.getText().trim(), bankTf.getText().trim(), accountTf.getText().trim(), 
					emailTf.getText().trim(), 1);
			boolean result;
			try {
				result = customerService.addCustomer(customer);
			} catch (CustomerExistException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"警告",JOptionPane.WARNING_MESSAGE);
			}
			if(result=true) {
				JOptionPane.showMessageDialog(null, "客户信息添加成功","提示",JOptionPane.INFORMATION_MESSAGE);
				setNull();
			}else {
				JOptionPane.showMessageDialog(null, "客户信息添加失败","警告",JOptionPane.WARNING_MESSAGE);
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
		customerNameTf.setText(""); shortsTf.setText(""); addressTf.setText(""); 
		zipTf.setText("");telTf.setText(""); faxTf.setText(""); contactsTf.setText(""); 
		phoneTf.setText("");bankTf.setText(""); accountTf.setText(""); 
		emailTf.setText("");
	}
}
