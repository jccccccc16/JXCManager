package com.cjzy.view.customer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.Constants;
import com.cjzy.model.Customer;
import com.cjzy.model.Item;
import com.cjzy.service.CustomerService;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/****
 * 客户信息修改，删除面板
 * 
 * @author 61702
 *
 */
public class CustomerEditPanel extends JPanel implements ActionListener {
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
	private JComboBox comboBox;
	private Item selectedItem;

	/**
	 * Create the panel.
	 */
	public CustomerEditPanel() {

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

		JLabel label_7 = new JLabel("联系人电话");

		phoneTf = new JTextField();
		phoneTf.setColumns(30);

		JLabel lblNewLabel_1 = new JLabel("e-mail:");

		emailTf = new JTextField();
		emailTf.setColumns(25);

		JLabel label_8 = new JLabel("开户银行：");

		bankTf = new JTextField();
		bankTf.setColumns(30);

		JLabel label_9 = new JLabel("银行账户：");

		accountTf = new JTextField();
		accountTf.setColumns(30);

		JPanel panel = new JPanel();

		JLabel label_5 = new JLabel("选择客户：");
		panel.add(label_5);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u6D4B\u8BD51", "\u6D4B\u8BD52", "\u5F69\u82722" }));
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectAction();
			}
		});

		JButton button = new JButton("修改");
		button.addActionListener(this);

		JButton button_1 = new JButton("删除");
		button_1.addActionListener(this);

		JList list = new JList();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customerNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(11)
										.addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(shortsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(14)
												.addComponent(label_3))
											.addGroup(groupLayout.createSequentialGroup()
												.addContainerGap()
												.addComponent(label_8)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(contactsTf)
											.addComponent(telTf)
											.addComponent(bankTf)
											.addComponent(emailTf))))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(label_6)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_4)
										.addComponent(label_2)))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_9)
										.addComponent(label_7))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(accountTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(zipTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(191)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(button)
							.addGap(5)
							.addComponent(button_1)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(customerNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label)
							.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(shortsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(zipTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(telTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(contactsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bankTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(label_9)
						.addComponent(accountTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(238, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

		customerService = CommonFactory.getCustomerService();

		// 初始化客户下拉框
		initComboBox();
	}

	// 初始化下来框
	public void initComboBox() {

		List<Customer> list = customerService.findCustomers(null);
		List<Item> items = new ArrayList<Item>();
		comboBox.removeAllItems();
		// 迭代处理数据
		for (Customer customer : list) {
			Item item = new Item();
			item.setId(customer.getId());
			item.setName(customer.getCustomerName());
			System.out.println(item);
			System.out.println(customer);
			comboBox.addItem(item);
		}

	}

	public void selectAction() {

		if (!(comboBox.getSelectedItem() instanceof Item)) {
			return;
		}
		selectedItem = (Item) comboBox.getSelectedItem();
		System.out.println(selectedItem);
		Customer customer = new Customer();
		customer.setId(selectedItem.getId());
		List<Customer> list = customerService.findCustomers(customer);
		setData(list.get(0));
	}

	/**
	 * 给组件添加数据
	 * 
	 * @param c
	 */
	private void setData(Customer c) {
		customerNameTf.setText(c.getCustomerName());
		addressTf.setText(c.getAddress());
		shortsTf.setText(c.getShorts());
		zipTf.setText(c.getZip());
		telTf.setText(c.getTelephone());
		faxTf.setText(c.getFax());
		contactsTf.setText(c.getContacts());
		phoneTf.setText(c.getTelephone());
		bankTf.setText(c.getBank());
		accountTf.setText(c.getBank());
		emailTf.setText(c.getMail());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String target = e.getActionCommand();
		String id = selectedItem.getId();
		switch (target) {
		case "修改":
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
			Customer customer = new Customer(id, customerNameTf.getText().trim(), shortsTf.getText().trim(),
					addressTf.getText().trim(), zipTf.getText().trim(), telTf.getText().trim(), faxTf.getText().trim(),
					contactsTf.getText().trim(), phoneTf.getText().trim(), bankTf.getText().trim(),
					accountTf.getText().trim(), emailTf.getText().trim(), 1);
			boolean result = customerService.updateCustomer(customer);
			if (result == true) {
				JOptionPane.showMessageDialog(null, "客户修改成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "客户信息修改失败!", "警告", JOptionPane.WARNING_MESSAGE);

			}
			break;
		case "删除":
			// 0 是 ，1 否
			int type = JOptionPane.showConfirmDialog(null, "是否删除?", "温馨提示", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (type == 0) {
				customerService.updateCustomer(id, Constants.DATA_DEL);
				initComboBox();
			}

		default:
			break;
		}

	}

}
