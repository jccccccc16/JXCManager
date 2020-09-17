package com.cjzy.view.operator;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.omg.PortableInterceptor.ORBInitInfoOperations;

import com.cjzy.common.CommonFactory;
import com.cjzy.model.Operator;
import com.cjzy.service.OperatorService;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class OperatorAddPanel extends JPanel implements ActionListener{
	private JTextField usernameTf;
	private JTextField nameTf;
	private JPasswordField passwordTf2;
	private JPasswordField passwordTf1;
	private JComboBox comboBox;
	private OperatorService operatorService;
	/**
	 * Create the panel.
	 */
	public OperatorAddPanel() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("登录名：");
		
		usernameTf = new JTextField();
		usernameTf.setColumns(25);
		
		JLabel label = new JLabel("用户姓名：");
		
		nameTf = new JTextField();
		nameTf.setColumns(25);
		
		JLabel label_1 = new JLabel("密码：");
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		
		passwordTf2 = new JPasswordField();
		passwordTf2.setColumns(25);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u6743\u9650\uFF1A");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"超级管理员", "普通管理员", "销售人员","采购人员","仓库人员"}));
		
		JButton addBtn = new JButton("添加");
		addBtn.addActionListener(this);
		
		JButton resetBtn = new JButton("重置");
		addBtn.addActionListener(this);
		
		passwordTf1 = new JPasswordField();
		passwordTf1.setColumns(25);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(addBtn)
							.addGap(29)
							.addComponent(resetBtn))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(lblNewLabel)
								.addComponent(label)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(usernameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addComponent(passwordTf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(passwordTf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(67))
		);  
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(usernameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordTf1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(passwordTf2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addBtn)
						.addComponent(resetBtn))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		operatorService = CommonFactory.getOperatorService();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String target = e.getActionCommand();
		switch (target) {
		case "添加":
			if(usernameTf.getText()!=null&&!usernameTf.getText().trim().equals("")||
					nameTf.getText()!=null&&!nameTf.getText().trim().equals("")||
					passwordTf1.getPassword()!=null&&!String.valueOf(passwordTf1.getPassword()).trim().equals("")||
					passwordTf2.getPassword()!=null&&!String.valueOf(passwordTf2.getPassword()).trim().equals("")) {
				if(!String.valueOf(passwordTf2.getPassword()).trim().equals(String.valueOf(passwordTf1.getPassword()).trim())) {
					JOptionPane.showMessageDialog(null, "密码不相同","温馨提示",JOptionPane.INFORMATION_MESSAGE);
					return ;
				}else {//保存操作员
					Operator operator = new Operator();
					operator.setName(nameTf.getText().trim());
					operator.setUsername(usernameTf.getText().trim());
					operator.setPower(comboBox.getSelectedItem().toString());
					operator.setPassword(String.valueOf(passwordTf2.getPassword()).trim());
					operatorService.addOperator(operator);
					JOptionPane.showMessageDialog(null, "添加成功","提示",JOptionPane.INFORMATION_MESSAGE);
					setNull();
				}
			
			}else {
				JOptionPane.showMessageDialog(null, "请填写全部信息","温馨提示",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			break;
		case "重置":
			setNull();
		default:
			break;
		}
		
	}
	/**
	 * 清空
	 */
	public void setNull() {
		usernameTf.setText("");
		passwordTf1.setText("");
		passwordTf2.setText("");
		nameTf.setText("");
	}
}
