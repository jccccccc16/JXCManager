package com.cjzy.view.good;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.Constants;
import com.cjzy.model.Customer;
import com.cjzy.model.Good;
import com.cjzy.model.Item;
import com.cjzy.model.Provider;
import com.cjzy.service.GoodService;
import com.cjzy.service.ProviderService;

public class GoodEditPanel extends JPanel implements ActionListener{


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
	private JComboBox comboBox;
	private GoodService goodService = null;
	private ProviderService providerService = null;
	private Item goodSelectedItem;
	private JComboBox providerComboBox;
	private Item providerSelectedItem;
	

	/**
	 * Create the panel.
	 */
	public GoodEditPanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/12,screenSize.height/20,715,407);
		
		goodService = CommonFactory.getGoodService();
		
		JLabel label_5 = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("商品全称：");
		
		goodsNameTf = new JTextField();
		goodsNameTf.setColumns(30);
		
		JLabel label = new JLabel("简称：");
		
		shortsTf = new JTextField();
		shortsTf.setColumns(30);
		
		JLabel label_1 = new JLabel("产地：");
		
		productPlaceTf = new JTextField();
		productPlaceTf.setColumns(30);
		
		JLabel label_4 = new JLabel("\u6279\u53F7:");
		
		productCodeTf = new JTextField();
		productCodeTf.setColumns(30);
		
		JLabel priceJLabel = new JLabel("批准文号：  ");
		
		promit_codeTf= new JTextField();
		promit_codeTf.setColumns(30);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EF7\u683C\uFF1A");
		
		priceTf= new JTextField();
		priceTf.setColumns(30);
		
		JLabel label_2 = new JLabel("规格：");
		
		sizeTf = new JTextField();
		sizeTf.setColumns(30);
		
		JLabel label_3 = new JLabel("包装：");
		
		packageTf = new JTextField();
		packageTf.setColumns(30);
		
		JLabel lblNewLabel_1 = new JLabel("备注：");
		
		memoTf = new JTextField();
		memoTf.setColumns(30);
		
		JLabel label_6 = new JLabel("\u4F9B\u5E94\u5546\u5168\u79F0\uFF1A");
		
		JPanel panel = new JPanel();
		
		providerComboBox = new JComboBox();
		providerComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				providerSelectAction();
			}
		});
		 
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
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
							.addComponent(providerComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(209)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
					.addGap(233))
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
							.addComponent(providerComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(96))
		);
		
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u6D4B\u8BD51", "\u6D4B\u8BD52", "\u5F69\u82722" }));
		panel.add(comboBox);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 选择商品
				selectAction();
			}
		});

		JButton button = new JButton("修改");
		panel.add(button);
		button.addActionListener(this);

		JButton button_1 = new JButton("删除");
		panel.add(button_1);
		button_1.addActionListener(this);

		JList list = new JList();
		add(list);

		goodService = CommonFactory.getGoodService();
		providerService = CommonFactory.getProviderService();

		// 初始化商品下拉框
		initComboBoxGood();
		//初始化供应商下拉框
		initComboBoxProvider();
		setLayout(groupLayout);
		


	}
	// 初始化商品下来框
	public void initComboBoxGood() {

			List<Good> list = goodService.findGoods(null);
			List<Item> items = new ArrayList<Item>();
			comboBox.removeAllItems();
			// 迭代处理数据
			for (Good good : list) {
				Item item = new Item();
				item.setId(good.getId());
				item.setName(good.getGoodsName());
				System.out.println(item);
				System.out.println(good);
				comboBox.addItem(item);
			}
			
			
	}
	/**
	 * 初始化供应商下来框
	 */
	public void initComboBoxProvider() {

			List<Provider> list = providerService.findProviders(null);
			List<Item> items = new ArrayList<Item>();
			providerComboBox.removeAllItems();
			// 迭代处理数据
			for (Provider provider : list) {
				Item item = new Item();
				item.setId(provider.getId());
				item.setName(provider.getProviderName());
				System.out.println(item);
				System.out.println(provider);
				if(items.contains(item)) {
					continue;
				}
				providerComboBox.addItem(item);
			}

		}

	/**
	 * 选择下拉框商品
	 */
		public void selectAction() {

			if (!(comboBox.getSelectedItem() instanceof Item)) {
				return;
			}
			//查找被选 商品信息
			goodSelectedItem = (Item) comboBox.getSelectedItem();
			System.out.println(goodSelectedItem);
			Good good = new Good();
			good.setId(goodSelectedItem.getId());
			//查询
			List<Good> list = goodService.findGoods(good);
			//填充信息
			setData(list.get(0));
		}
		
		public void providerSelectAction() {
			
			if(!(providerComboBox.getSelectedItem() instanceof Item)) {
				return ;
			}
			providerSelectedItem = (Item) providerComboBox.getSelectedItem();
		}

		/**
		 * 给组件添加数据，更新数据
		 * goodsNameTf.getText().trim().equals("")||
					shortsTf.getText().trim().equals("")||
					productPlaceTf.getText().trim().equals("")||
					sizeTf.getText().trim().equals("")||
					packageTf.getText().trim().equals("")||
					productCodeTf.getText().trim().equals("")||
					promit_codeTf.getText().trim().equals("")||
					priceTf.getText().trim().equals("")||
					memoTf.getText().trim().equals("")||
					providerNameTf.getText().trim().equals(""))
		 * @param c
		 */
		private void setData(Good c) {
			goodsNameTf.setText(c.getGoodsName());
			shortsTf.setText(c.getShorts());
			productPlaceTf.setText(c.getProductPlace());
			sizeTf.setText(c.getSize());
			packageTf.setText(c.getPackages());
			productCodeTf.setText(c.getPromitCode());
			promit_codeTf.setText(c.getPromitCode());
			priceTf.setText(c.getPrice()+"");
			memoTf.setText(c.getMemo());
			
			for(int i =0;i<providerComboBox.getItemCount();i++) {
				Item providerItem = (Item) providerComboBox.getItemAt(i);
				if(providerItem.getId().equals(c.getProviderId())) {
					providerComboBox.setSelectedIndex(i);
				}
			}
		
			/*
			//显示provider
			Provider provider = new Provider();
			provider.setId(c.getProviderId());
			//获取对应的provider
			List<Provider> providers = providerService.findProviders(provider);
			Provider p = providers.get(0);
			Item item = new Item();
			item.setId(p.getId());
			item.setName(p.getProviderName());
			providerComboBox.setSelectedItem(item);     //把provider item显示到下拉框
			*/
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String target = e.getActionCommand();
			String id = goodSelectedItem.getId();
			switch (target) {
			case "修改":
				//验证非空
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
					
					JOptionPane.showMessageDialog(null, "请填写全部信息","温馨提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				
				String pid = providerSelectedItem.getId();
				Good good = new Good(id, goodsNameTf.getText().trim(), shortsTf.getText().trim(), productPlaceTf.getText().trim(), 
						sizeTf.getText().trim(), packageTf.getText().trim(), productCodeTf.getText().trim(), promit_codeTf.getText().trim(), 
						Double.parseDouble(priceTf.getText().trim()), memoTf.getText().trim(), pid,
						1);
				boolean result = goodService.updateGood(good);
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
					goodService.updateGood(id, Constants.DATA_DEL);
					initComboBoxGood();
				}

			default:
				break;
			}

		}
}
