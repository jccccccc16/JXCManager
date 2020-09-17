package com.cjzy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.CommonUtils;
import com.cjzy.dao.Utils;
import com.cjzy.model.GoodInfo;
import com.cjzy.model.Inpout;
import com.cjzy.model.Item;
import com.cjzy.model.Provider;
import com.cjzy.service.GoodService;
import com.cjzy.service.InpoutService;
import com.cjzy.service.OutPortService;
import com.cjzy.service.ProviderService;

public class InportCanelInternalFrame extends JInternalFrame implements ActionListener{
	private JTextField conTf;
	private JTextField timeFt;
	private JTextField sponsorTf;
	private MyTableModel<GoodInfo> tableModel;
	private JTable table; // 表格放在滑动面板里面
	private JTextField numberTf;
	private JTextField moneyTf;
	private JTextField comTf;
	private JTextField operatorTf;
	private ProviderService providerService;
	private Item providerSelectedItem;
	private GoodService goodService;
	private InpoutService inpoutService;
	private double price;
	private String number;
	private String goodId;
	private JTextField providerTf;
	private JTextField payTypeTf;
	private JComboBox inportIdCombobox;
	private OutPortService outPortService;
	private Inpout currentInpout;
	private GoodInfo goodInfo;
	/**
	 * Create the frame.
	 */
	public InportCanelInternalFrame() {
		providerService = CommonFactory.getProviderService();
		goodService = CommonFactory.getGoodService();
		inpoutService = CommonFactory.getInpoutService();
		outPortService = CommonFactory.getOutPortService();
		setTitle("进货退货");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width / 12, screenSize.height / 20, screenSize.width / 2, screenSize.height / 2);
		setClosable(true); // 支持窗口可关闭
		setIconifiable(true);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JLabel label_1 = new JLabel("商品数量：");

		numberTf = new JTextField();
		numberTf.setEditable(false);
		numberTf.setColumns(25);

		JLabel lblNewLabel_5 = new JLabel("合计金额：");

		moneyTf = new JTextField();
		moneyTf.setEditable(false);
		moneyTf.setColumns(25);

		JLabel lblNewLabel_6 = new JLabel("验收结论：");

		comTf = new JTextField();
		comTf.setColumns(25);

		JLabel lblNewLabel_7 = new JLabel("操作人员：");

		operatorTf = new JTextField();
		operatorTf.setEditable(false);
		operatorTf.setColumns(25);

		JButton inpoutBtn = new JButton("退货");
		inpoutBtn.addActionListener(this);
		JButton confirmBtn = new JButton("确定");
		confirmBtn.setEnabled(false);
		confirmBtn.addActionListener(this);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(69)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_6)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(comTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblNewLabel_7)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(operatorTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(inpoutBtn).addGap(18).addComponent(confirmBtn))
								.addGroup(gl_panel.createSequentialGroup().addComponent(label_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(numberTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblNewLabel_5)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(moneyTf,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(71, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
										.addComponent(numberTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5).addComponent(moneyTf, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(
										gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_6)
												.addComponent(comTf, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_7)
												.addComponent(operatorTf, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(inpoutBtn).addComponent(confirmBtn))));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("进货单号：");

		JLabel lblNewLabel_1 = new JLabel("供应商：");

		JLabel label = new JLabel("联系人：");

		conTf = new JTextField();
		conTf.setEditable(false);
		conTf.setColumns(25);

		JLabel lblNewLabel_2 = new JLabel("结算时间：");

		timeFt = new JTextField();
		timeFt.setEditable(false);
		timeFt.setColumns(25);

		JLabel lblNewLabel_3 = new JLabel("结算方式：");
		
		JLabel lblNewLabel_4 = new JLabel("经手人：");

		sponsorTf = new JTextField();
		sponsorTf.setEditable(false);
		sponsorTf.setColumns(25);
		
		inportIdCombobox = new JComboBox();
		inportIdCombobox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				showData();
				
			}
		});
		
		providerTf = new JTextField();
		providerTf.setEditable(false);
		providerTf.setColumns(25);
		
		payTypeTf = new JTextField();
		payTypeTf.setEditable(false);
		payTypeTf.setColumns(25);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(timeFt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(inportIdCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_1))
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(providerTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(payTypeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(conTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sponsorTf, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
					.addGap(147))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(label)
						.addComponent(conTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(inportIdCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(providerTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(timeFt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(sponsorTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(payTypeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		String[] columnNames = {"商品编号","商品全称","商品简称","产地"
				,"规格","包装","批号","批准文号","价格","备注","供应商" };
		tableModel = new MyTableModel(columnNames);
		// 创建一个表格面板
		table = new JTable(tableModel);
		// 设置大小
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width * 2 / 3 - 60, screenSize.height / 3));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				//ListSelectionModel model = (ListSelectionModel) e.getSource();
				/*int maxSelectionIndex = model.getMaxSelectionIndex();
				price = (double) table.getValueAt(maxSelectionIndex, 8);
				goodId = (String) table.getValueAt(maxSelectionIndex, 0);*/
				
			}
		});
		// 视图高度填充
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);

		// 将表格放到活动面板中
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(117)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(467, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(5)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(289, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		//初始化视窗
		
		
		
		initInportComboBox();

	}

	// 初始化下来框
	public void initInportComboBox() {
		inportIdCombobox.removeAllItems();
		List<Inpout> list = inpoutService.query(null);
		// 迭代处理数据
		for (Inpout customer : list) {
			Item item = new Item();
			item.setId(customer.getId());
			item.setName(customer.getId());
			inportIdCombobox.addItem(item);
		}
		show();
	}

	/***
	 * 更新表数据
	 */
	public void updateData(GoodInfo goodInfo) {
		List<GoodInfo> goodInfos = goodService.findGoodInfo(goodInfo);
		System.out.println(goodInfos);
		Vector<GoodInfo> goodInfos2 = new Vector<GoodInfo>();
		for (GoodInfo goodInfo2 : goodInfos) {
			goodInfos2.add(goodInfo2);
		}
		tableModel.updateData(goodInfos2);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		String target = e.getActionCommand();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		switch (target) {
		case "退货":
			JOptionPane.showConfirmDialog(null, "是否退货？", "温馨提示", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			Date date = null;
			try {
				date = sdf.parse(timeFt.getText().trim());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int number1 = Integer.parseInt(numberTf.getText().trim());
			int numberCurrent = currentInpout.getNumber();
			if(number1<numberCurrent) {    //如果输入的数量少于原来的数量，那么修改数量
				int number = numberCurrent-number1;
				String commentOld = currentInpout.getComment();
				currentInpout.setNumber(number);
				currentInpout.setComment(comTf.getText().trim());
				currentInpout.setPrice(Float.parseFloat(number*goodInfo.getPrice()+""));
				outPortService.addOutPort(currentInpout);
				currentInpout.setNumber(number1);
				currentInpout.setPrice(Float.parseFloat(number1*goodInfo.getPrice()+""));
				currentInpout.setComment(commentOld);
				inpoutService.update(currentInpout);	
			}else {  //大于，那么物理删除
				Item selectedItem = (Item) inportIdCombobox.getSelectedItem();
				inpoutService.delete(selectedItem.getId(), 1);
				outPortService.addOutPort(currentInpout);
			}
			
			JOptionPane.showMessageDialog(null, "退货成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
			initInportComboBox();
			break;
		case "确定":
		default:
			break;
		}
		
	}
	/***
	 * 显示数据到表格
	 */
	public void showData() {
		Item selectedItem = (Item) inportIdCombobox.getSelectedItem();
		
		if(selectedItem!=null) {
			Inpout inpout = new Inpout();
			inpout.setId(selectedItem.getId());
			currentInpout = inpoutService.query(inpout).get(0);
			Provider provider2 = new Provider();
			provider2.setId(currentInpout.getProviderId());
			Provider provider = providerService.findProviders(provider2).get(0);
			providerTf.setText(provider.getProviderName());
			conTf.setText(provider.getContacts());
			timeFt.setText(currentInpout.getInportTime());
			payTypeTf.setText(currentInpout.getPaytype());
			sponsorTf.setText(currentInpout.getSponsor());
			numberTf.setText(String.valueOf(currentInpout.getNumber()));
			moneyTf.setText(String.valueOf(currentInpout.getPrice()));
			comTf.setText(currentInpout.getComment());
			operatorTf.setText(currentInpout.getOperatePerson());
			goodInfo = new GoodInfo();
			goodInfo.setId(currentInpout.getGoodsId());
			updateData(goodInfo);
		}else {
			table.setVisible(true);
			providerTf.setText("");
			conTf.setText("");
			timeFt.setText("");
			payTypeTf.setText("");
			sponsorTf.setText("");
			numberTf.setText("");
			moneyTf.setText("");
			comTf.setText("");
			operatorTf.setText("");
			goodInfo.setId("");
		}
		
	
	}
}
