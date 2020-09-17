package com.cjzy.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cjzy.common.CommonFactory;
import com.cjzy.model.Item;
import com.cjzy.model.Operator;
import com.cjzy.service.OperatorService;
import com.sun.corba.se.impl.protocol.AddressingDispositionException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class PowerInternalFrame extends JInternalFrame implements ActionListener{
	private OperatorService operatorService;
	private JComboBox operatorCombobox;
	private JTextField nameTf;
	private JComboBox comboBox;
	private Item selectoperatorItem;
	public PowerInternalFrame() {
		super("权限管理",true,true,true,true);
		setTitle("\u6743\u9650\u7BA1\u7406");
		
		JLabel label = new JLabel("\u9009\u62E9\u64CD\u4F5C\u5458\uFF1A");
		
		operatorCombobox = new JComboBox();

		operatorCombobox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selection();
			}
		});
		JLabel label_1 = new JLabel("\u6743\u9650\uFF1A");
		
		JButton button = new JButton("修改");
		button.addActionListener(this);
		JLabel label_2 = new JLabel("\u64CD\u4F5C\u5458\u59D3\u540D\uFF1A");
		
		nameTf = new JTextField();
		nameTf.setEditable(false);
		nameTf.setColumns(20);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"超级管理员", "普通管理员", "仓库人员", "销售人员", "采购人员"}));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(operatorCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(label_2)
									.addGap(6)
									.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(button))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(operatorCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(button)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		operatorService = CommonFactory.getOperatorService();
		initCombobox();
	}
	
	
	
	public void initCombobox() {
		List<Operator> operators = operatorService.query(null);
		for (Operator operator : operators) {
			Item item = new Item();
			item.setId(operator.getName());
			item.setName(operator.getUsername());
			item.setPower(operator.getPower());
			if(!MainFrame.operator.equals(operator)) {
				operatorCombobox.addItem(item);
			}
		}
		selectoperatorItem = (Item) operatorCombobox.getSelectedItem();
		initPowerCombobox();
		setData();
	}
	
	public void initPowerCombobox() {
		
		for(int i=0;i<comboBox.getItemCount();i++) {
			String item = (String) comboBox.getItemAt(i);
			if(item.equals(selectoperatorItem.getPower())) {
				comboBox.setSelectedIndex(i);
			}
		}
	}
	
	public void selection() {
		selectoperatorItem = (Item) operatorCombobox.getSelectedItem();
		initPowerCombobox();
		setData();
	}


	/**
	 * 修改
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Item operatorItem = (Item) operatorCombobox.getSelectedItem();
		Operator operator = new Operator();
		operator.setUsername(operatorItem.getName());
		List<Operator> operators = operatorService.query(operator);
		Operator temp = operators.get(0);
		temp.setPower(String.valueOf(comboBox.getSelectedItem()));
		operatorService.update(temp);
		JOptionPane.showMessageDialog(null, "权限修改成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
		initCombobox();
		setData();
	}
	
	
	public void setData() {
		
		nameTf.setText(selectoperatorItem.getId());
		
	}
	
	
	
	
}
