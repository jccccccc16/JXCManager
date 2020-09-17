package com.cjzy.view.provider;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.Constants;
import com.cjzy.model.Customer;
import com.cjzy.model.Item;
import com.cjzy.model.Provider;
import com.cjzy.service.CustomerService;
import com.cjzy.service.ProviderService;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ProviderEditPanel extends JPanel implements ActionListener{

	private JTextField ProviderNameTf;
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
	private ProviderService providerService;;
	private JComboBox comboBox;
	private Item selectedItem;

	/**
	 * Create the panel.
	 */
	public ProviderEditPanel() {

		JLabel lblNewLabel = new JLabel("供应商全称：");

		ProviderNameTf = new JTextField();
		ProviderNameTf.setColumns(30);

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
		
				JLabel label_5 = new JLabel("选择客户：");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addGap(5)
					.addComponent(ProviderNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(label)
					.addGap(5)
					.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(label_1)
					.addGap(5)
					.addComponent(shortsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(label_2)
					.addGap(5)
					.addComponent(zipTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(3)
					.addComponent(label_3)
					.addGap(6)
					.addComponent(telTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(label_4)
					.addGap(25)
					.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(label_6)
					.addGap(33)
					.addComponent(contactsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(label_7)
					.addGap(6)
					.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(label_8)
					.addGap(18)
					.addComponent(bankTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(label_9)
					.addGap(18)
					.addComponent(accountTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblNewLabel_1)
					.addGap(37)
					.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(197)
					.addComponent(label_5)
					.addGap(6)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(button)
					.addGap(8)
					.addComponent(button_1))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(ProviderNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label))
						.addComponent(addressTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
							.addGap(6)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(telTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(label_4))
						.addComponent(faxTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_6))
						.addComponent(contactsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(label_7))
						.addComponent(phoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
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
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(emailTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(label_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button)
						.addComponent(button_1)))
		);
		setLayout(groupLayout);

		providerService = CommonFactory.getProviderService();

		// 初始化客户下拉框
		initComboBox();
	}

	// 初始化下来框
	public void initComboBox() {

		List<Provider> list = providerService.findProviders(null);
		List<Item> items = new ArrayList<Item>();
		comboBox.removeAllItems();
		// 迭代处理数据
		for (Provider provider : list) {
			Item item = new Item();
			item.setId(provider.getId());
			item.setName(provider.getProviderName());
			System.out.println(item);
			System.out.println(provider);
			comboBox.addItem(item);
		}

	}

	public void selectAction() {

		if (!(comboBox.getSelectedItem() instanceof Item)) {
			return;
		}
		selectedItem = (Item) comboBox.getSelectedItem();
		System.out.println(selectedItem);
		Provider provider = new Provider();
		provider.setId(selectedItem.getId());
		List<Provider> list = providerService.findProviders(provider);
		setData(list.get(0));
	}

	/**
	 * 给组件添加数据
	 * 
	 * @param c
	 */
	private void setData(Provider c) {
		ProviderNameTf.setText(c.getProviderName());
		addressTf.setText(c.getAddress());
		shortsTf.setText(c.getShorts());
		zipTf.setText(c.getZip());
		telTf.setText(c.getTelephone());
		faxTf.setText(c.getFax());
		contactsTf.setText(c.getContacts());
		phoneTf.setText(c.getTelephone());
		bankTf.setText(c.getBank());
		accountTf.setText(c.getAccount());
		emailTf.setText(c.getMail());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String target = e.getActionCommand();
		String id = selectedItem.getId();
		switch (target) {
		case "修改":
			if(ProviderNameTf.getText().trim().equals("")||
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
			Provider provider = new Provider(id, ProviderNameTf.getText().trim(), shortsTf.getText().trim(),
					addressTf.getText().trim(), zipTf.getText().trim(), telTf.getText().trim(), faxTf.getText().trim(),
					contactsTf.getText().trim(), phoneTf.getText().trim(), bankTf.getText().trim(),
					accountTf.getText().trim(), emailTf.getText().trim(), 1);
			boolean result = providerService.updateProvider(provider);
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
				 providerService.updateProvider(id, type);
				initComboBox();
			}

		default:
			break;
		}

	}
}
