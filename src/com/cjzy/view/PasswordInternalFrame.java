package com.cjzy.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cjzy.common.CommonFactory;
import com.cjzy.model.Operator;
import com.cjzy.service.OperatorService;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PasswordInternalFrame extends JInternalFrame {
	private JPasswordField passwordTf1;
	private JPasswordField passwordTf2;
	private OperatorService operatorService;

	/**
	 * Create the frame.
	 */
	public PasswordInternalFrame() {
		super("修改密码",true,true,true,true);
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		
		passwordTf1 = new JPasswordField();
		passwordTf1.setColumns(25);
		
		JLabel Jlabal = new JLabel("新密码：");
		
		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				alterPassword();
			}
		});
		
		passwordTf2 = new JPasswordField();
		passwordTf2.setColumns(25);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(Jlabal)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(passwordTf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(passwordTf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordTf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(Jlabal)
						.addComponent(passwordTf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(button)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		operatorService=CommonFactory.getOperatorService();
	}
	
	public void alterPassword() {
		
		Operator operator = MainFrame.operator;
		if(operator.getPassword().equals(String.valueOf(passwordTf1.getPassword()))) {
			operator.setPassword(String.valueOf(passwordTf2.getPassword()).trim());
			operatorService.update(operator);
			JOptionPane.showMessageDialog(null, "修改成功","提示",JOptionPane.INFORMATION_MESSAGE);
			setNull();
			return ;
		}else {
			JOptionPane.showMessageDialog(null, "旧密码不正确！","警告",JOptionPane.WARNING_MESSAGE);
			return ;
		}
		
		
	}
	
	public void setNull() {
		
		passwordTf1.setText("");
		passwordTf2.setText("");
		
	}

}
