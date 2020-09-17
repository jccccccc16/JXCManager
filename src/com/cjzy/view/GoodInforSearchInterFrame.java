package com.cjzy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.cjzy.common.CommonFactory;
import com.cjzy.model.Customer;
import com.cjzy.model.Good;
import com.cjzy.model.GoodInfo;
import com.cjzy.service.CustomerService;
import com.cjzy.service.GoodService;

import sun.awt.IconInfo;

public class GoodInforSearchInterFrame extends JInternalFrame implements ActionListener{
	private JTextField searchValueText;
	private JComboBox comboBox;  //查询选项
	private JTable table;     //表格放在滑动面板里面
	private MyTableModel tableModel;  //自定义的魔板，为了适配我们的数据
	private GoodService goodService;
	/**客户查询
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GoodInforSearchInterFrame() {
		//支持放大缩小，可关闭
		super("商品查询",true,true,true,true);
		setBounds(100, 100, 703, 453);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("请选择查询条件：");
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"商品ID", "商品全称", "商品简称", "供应商全称"}));
		panel.add(comboBox);
		
		searchValueText = new JTextField();
		panel.add(searchValueText);
		searchValueText.setColumns(25);
		
		JButton searchBtn = new JButton("查询");
		searchBtn.setIcon(new ImageIcon(CustomerInforSearchInterFrame.class.getResource("/com/cjzy/images/\u67E5\u8BE2.png")));
		panel.add(searchBtn);
		searchBtn.addActionListener(this);
		
		JButton searchAllBtn = new JButton("显示全部信息");
		panel.add(searchAllBtn);
		searchAllBtn.addActionListener(this);
		
		//创建表格魔板
		String[] columnNames = {"商品编号","商品全称","商品简称","产地"
				,"规格","包装","批号","批准文号","价格","备注","供应商" };
		tableModel = new MyTableModel(columnNames);
		//创建一个表格面板
		table = new JTable(tableModel);
		
		//设置大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width*2/3-60,screenSize.height/3));
		//视图高度填充
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		goodService = CommonFactory.getGoodService();
		//将表格放到活动面板中
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		
		
		

	}
	
	/***|
	 * 自定义表格数据魔板，也就是说 数据要怎样显示
	 * @author 61702
	 *
	 */
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String target = e.getActionCommand();
		switch (target) {
			case "查询":
				String searchValue = searchValueText.getText().trim();
				if(searchValue==null || searchValue.length()==0) {
					JOptionPane.showMessageDialog(null,"请输入搜索值","警告",JOptionPane.WARNING_MESSAGE);	
				}
				String type = comboBox.getSelectedItem().toString();
				GoodInfo good  =  new GoodInfo();
				switch (type) {
				case "商品ID":
					good.setId(searchValue);
					break;
				case "商品全称":
					good.setGoodsName(searchValue);;
				case "商品简称":
					good.setShorts(searchValue);
				case "供应商全称":
					good.setProviderName(searchValue);
				default:
					break;
				}
				List<GoodInfo> goods = goodService.findGoodInfo(good);
				if(goods!=null) {
					Vector<GoodInfo> list = new Vector<GoodInfo>();
					for(GoodInfo c:goods) {
						list.add(c);
					}
					tableModel.updateData(list);
				}
				
				break;
			case "显示全部信息":
				List<GoodInfo> goods2 =goodService.findGoodInfo(null);
				if(goods2!=null) {
					Vector<GoodInfo> list = new Vector<GoodInfo>();
					for(GoodInfo c:goods2) {
						list.add(c);
					}
					tableModel.updateData(list);
				}
			default:
				break;
		}
		
	}

}
