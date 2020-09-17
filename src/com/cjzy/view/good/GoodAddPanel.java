package com.cjzy.view.good;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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
import com.cjzy.model.Good;
import com.cjzy.model.Item;
import com.cjzy.model.Provider;
import com.cjzy.service.CustomerService;
import com.cjzy.service.GoodService;
import com.cjzy.service.ProviderService;
import com.cjzy.service.impl.ProviderServiceImpl;
import javax.swing.JComboBox;

public class GoodAddPanel extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	private JTextField goodsNameTf;
	private JTextField shortsTf;
	private JTextField productPlaceTf;
	private JTextField sizeTf;
	private JTextField packageTf;
	private JTextField productCodeTf;
	private JTextField promit_codeTf;
	private JTextField priceTf;
	private JTextField providerShortsTf;
	private JTextField memoTf;
	private GoodService goodService = null;
	private ProviderService providerService = null;
	private JComboBox comboBox;
	private Item selectedItem;
	/**
	 * Create the panel.
	 */
	public GoodAddPanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,715,407);
	
		/*
		JLabel providerNameJLabel = new JLabel("��λ��");
		add(providerNameJLabel);
		
		providerShortsTf = new JTextField();
		add(providerShortsTf);
		providerShortsTf.setColumns(30);*/
		
		
		JPanel panel = new JPanel();
		
		JButton saveBtn = new JButton("����");
		saveBtn.addActionListener(this);
		
		JButton resetBtn = new JButton("����");
		resetBtn.addActionListener(this);
		
		goodService = CommonFactory.getGoodService();
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(saveBtn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(resetBtn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(saveBtn)
						.addComponent(resetBtn)))
		);
		panel.setLayout(gl_panel);
		
		JLabel label_5 = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("��Ʒȫ�ƣ�");
		
		goodsNameTf = new JTextField();
		goodsNameTf.setColumns(30);
		
		JLabel label = new JLabel("��ƣ�");
		
		shortsTf = new JTextField();
		shortsTf.setColumns(30);
		
		JLabel label_1 = new JLabel("���أ�");
		
		productPlaceTf = new JTextField();
		productPlaceTf.setColumns(30);
		
		JLabel label_4 = new JLabel("\u6279\u53F7:");
		
		productCodeTf = new JTextField();
		productCodeTf.setColumns(30);
		
		JLabel priceJLabel = new JLabel("��׼�ĺţ�  ");
		
		promit_codeTf= new JTextField();
		promit_codeTf.setColumns(30);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTf= new JTextField();
		priceTf.setColumns(30);
		
		JLabel label_2 = new JLabel("���");
		
		sizeTf = new JTextField();
		sizeTf.setColumns(30);
		
		JLabel label_3 = new JLabel("��װ��");
		
		packageTf = new JTextField();
		packageTf.setColumns(30);
		
		JLabel lblNewLabel_1 = new JLabel("��ע��");
		
		memoTf = new JTextField();
		memoTf.setColumns(30);
		
		JLabel label_6 = new JLabel("\u4F9B\u5E94\u5546\uFF1A");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u6D4B\u8BD51", "\u6D4B\u8BD52", "\u5F69\u82722" }));
		add(comboBox);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectAction();
			}
		});
		providerService = CommonFactory.getProviderService();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(priceJLabel)
								.addComponent(label_3)
								.addComponent(lblNewLabel_1)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(packageTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(productPlaceTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(memoTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(promit_codeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(goodsNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_2)
										.addComponent(lblNewLabel_2)
										.addComponent(label_4))
									.addGap(26)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(sizeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(shortsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(productCodeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(priceTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(309)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel)
							.addComponent(goodsNameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label))
						.addComponent(shortsTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(productPlaceTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4)
								.addComponent(productCodeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(priceJLabel)
									.addComponent(promit_codeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(priceTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(sizeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(packageTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(memoTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_6)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(362))
		);
		setLayout(groupLayout);
		
		initComboBox();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String target = e.getActionCommand();
		switch (target) {
		case "����":
			if(goodsNameTf.getText().trim().equals("")||
					shortsTf.getText().trim().equals("")||
					productPlaceTf.getText().trim().equals("")||
					sizeTf.getText().trim().equals("")||
					packageTf.getText().trim().equals("")||
					productCodeTf.getText().trim().equals("")||
					promit_codeTf.getText().trim().equals("")||
					priceTf.getText().trim().equals("")||
					memoTf.getText().trim().equals(""))
					 {
				
				JOptionPane.showMessageDialog(null, "����дȫ����Ϣ","��ܰ��ʾ",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			//�ͻ����
			String id = goodService.getGoodId();
			//��ȡ��Ӧ��id
			String pid =selectedItem.getId();
			//���ͻ���ӵ����ݿ�

			Good good = new Good(id, goodsNameTf.getText().trim(), shortsTf.getText().trim(), productPlaceTf.getText().trim(), 
					sizeTf.getText().trim(), packageTf.getText().trim(), productCodeTf.getText().trim(), promit_codeTf.getText().trim(), 
					Double.parseDouble(priceTf.getText().trim()), memoTf.getText().trim(), pid,
					1);
			boolean result;
			try {
				result = goodService.addGood(good);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.WARNING_MESSAGE);
			}
			if(result=true) {
				JOptionPane.showMessageDialog(null, "�ͻ���Ϣ��ӳɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
				setNull();
			}else {
				JOptionPane.showMessageDialog(null, "�ͻ���Ϣ���ʧ��","����",JOptionPane.WARNING_MESSAGE);
			}
			break;
		case "����":
			setNull();
		default:
			break;
		}
	}
	
	/***
	 * ������ѡ��
	 */
	public void selectAction() {

		if (!(comboBox.getSelectedItem() instanceof Item)) {
			return;
		}
		selectedItem = (Item) comboBox.getSelectedItem();
		/*System.out.println(selectedItem);
		Provider provider = new Provider();
		provider.setId(selectedItem.getId());
		List<Provider> list = providerService.findProviders(provider);*/
		//setData(list.get(0));
	}
	
	
	// ��ʼ��������
		public void initComboBox() {

			List<Provider> list = providerService.findProviders(null);
			List<Item> items = new ArrayList<Item>();
			comboBox.removeAllItems();
			// ������������
			for (Provider customer : list) {
				Item item = new Item();
				item.setId(customer.getId());
				item.setName(customer.getProviderName());
				System.out.println(item);
				System.out.println(customer);
				comboBox.addItem(item);
			}

		}

	
	
	/***
	 * ����ı���
	 */
	private void setNull() {
		goodsNameTf.setText(""); shortsTf.setText(""); productPlaceTf.setText(""); 
		sizeTf.setText("");packageTf.setText(""); productCodeTf.setText(""); promit_codeTf.setText(""); 
		priceTf.setText("");memoTf.setText(""); 
		
	}
}
