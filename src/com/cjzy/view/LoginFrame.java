package com.cjzy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cjzy.common.CommonFactory;
import com.cjzy.model.Operator;
import com.cjzy.service.OperatorService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class LoginFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setForeground(Color.PINK);
		setFont(new Font("微软雅黑", Font.PLAIN, 13));
		setTitle("\u679C\u95F4\u9152\u5E97");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/com/cjzy/images/\u697C(2).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 605, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JButton LoginBtn = new JButton("登录");
		LoginBtn.setForeground(new Color(100, 149, 237));
		LoginBtn.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/cjzy/images/\u767B\u5F55.png")));
		LoginBtn.addActionListener(this);  //给登录绑定
		JButton CancelBtn = new JButton("退出");
		CancelBtn.setForeground(new Color(100, 149, 237));
		CancelBtn.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/cjzy/images/\u9000\u51FA.png")));
		CancelBtn.addActionListener(this);
		JLabel label_2 = new JLabel("\u679C\u95F4\u9152\u5E97\u8FDB\u9500\u5B58\u7BA1\u7406\u7CFB\u7EDF");
		label_2.setForeground(Color.PINK);
		label_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/cjzy/images/\u697C(3).png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addComponent(LoginBtn)
					.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
					.addComponent(CancelBtn)
					.addGap(133))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(128, Short.MAX_VALUE)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
					.addGap(73))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(label_2)
					.addGap(36)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginBtn)
						.addComponent(CancelBtn))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A  ");
		label_1.setForeground(new Color(100, 149, 237));
		label_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/cjzy/images/\u5BC6\u7801.png")));
		panel_1.add(label_1);
		
		password = new JPasswordField();
		password.setColumns(26);
		panel_1.add(password);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setForeground(new Color(100, 149, 237));
		label.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/cjzy/images/\u8D26\u53F7.png")));
		panel.add(label);
		
		username = new JTextField();
		panel.add(username);
		username.setColumns(26);
		contentPane.setLayout(gl_contentPane);
	}
	/***
	 * 点击事件
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String btnCode = e.getActionCommand();//获取按钮上的文字
		switch (btnCode) {
		case "登录":
			String usernameString = username.getText().trim();
			String passwordString = String.valueOf(password.getPassword());
			if(usernameString.length()==0) {
				JOptionPane.showMessageDialog(null, "用户名不能为空","警告",JOptionPane.WARNING_MESSAGE);
			}else if(passwordString.trim().length()==0) {
				JOptionPane.showMessageDialog(null,"密码不能为空","警告",JOptionPane.WARNING_MESSAGE);
			}else{
				OperatorService service =CommonFactory.getOperatorService();
				boolean isPass=service.loginCheck(new Operator(usernameString,passwordString));  //验证登录
				if(isPass) {
					MainFrame.username=usernameString;
					MainFrame.operator = service.queryByUserName(usernameString);
					//跳转代码
					MainFrame.getMainFrame().setVisible(true);
					this.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null,"用户名或密码错误","警告",JOptionPane.WARNING_MESSAGE);
				}
			}
			break;
		case "退出":
			System.exit(0);
		default:
			break;
		}
		
	}
}
