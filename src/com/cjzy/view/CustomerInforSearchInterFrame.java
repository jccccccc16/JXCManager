package com.cjzy.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.cjzy.common.CommonFactory;
import com.cjzy.dao.Utils;
import com.cjzy.model.Customer;
import com.cjzy.service.CustomerService;
import com.mysql.fabric.xmlrpc.base.Data;

import sun.security.action.GetBooleanAction;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerInforSearchInterFrame extends JInternalFrame implements ActionListener{
	private JTextField searchValueText;
	private JComboBox comboBox;  //查询选项
	private JTable table;     //表格放在滑动面板里面
	private MyTableModel tableModel;  //自定义的魔板，为了适配我们的数据
	private CustomerService customerService;
	/**客户查询
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CustomerInforSearchInterFrame() {
		//支持放大缩小，可关闭
		super("客户查询",true,true,true,true);
		setBounds(100, 100, 703, 453);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("请选择查询条件：");
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"客户ID", "客户全称", "客户简称", "联系人"}));
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
		String[] columnNames = {"客户编号","客户全称","客户简称","客户地址","客户邮编"
				,"客户电话","客户传真","联系人","联系电话","开户银行","银行账号","客户邮箱"};
		tableModel = new MyTableModel(columnNames);
		//创建一个表格面板
		table = new JTable(tableModel);
		
		//设置大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width*2/3-60,screenSize.height/3));
		//视图高度填充
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		customerService = CommonFactory.getCustomerService();
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
				Customer customer  =  new Customer();
				switch (type) {
				case "客户ID":
					customer.setId(searchValue);
					break;
				case "客户全称":
					customer.setCustomerName(searchValue);;
				case "客户简称":
					customer.setShorts(searchValue);
				case "联系人":
					customer.setContacts(searchValue);
				default:
					break;
				}
				List<Customer> customers = customerService.findCustomers(customer);
				if(customers!=null) {
					Vector<Customer> list = new Vector<Customer>();
					for(Customer c:customers) {
						list.add(c);
					}
					tableModel.updateData(list);
				}
				
				break;
			case "显示全部信息":
				List<Customer> customers1 = customerService.findCustomers(null);
				if(customers1!=null) {
					Vector<Customer> list = new Vector<Customer>();
					for(Customer c:customers1) {
						list.add(c);
					}
					tableModel.updateData(list);
				}
			default:
				break;
		}
		
	}
	

}
