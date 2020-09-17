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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;

import com.cjzy.common.CommonFactory;
import com.cjzy.dao.Utils;
import com.cjzy.model.Customer;
import com.cjzy.model.Provider;
import com.cjzy.service.CustomerService;
import com.cjzy.service.ProviderService;
import com.cjzy.view.MyTableModel;
import com.cjzy.view.customer.CustomerEditPanel;
import com.cjzy.view.customer.CustormerAddPanel;

public class ProviderInforSearchFrame extends JInternalFrame implements ActionListener{

	private JTextField searchValueText;
	private JComboBox comboBox;  //查询选项
	private JTable table;     //表格放在滑动面板里面
	private MyTableModel tableModel;  //自定义的魔板，为了适配我们的数据
	private ProviderService providerService;
	/**客户查询
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ProviderInforSearchFrame() {
		//支持放大缩小，可关闭
		super("供应商查询",true,true,true,true);
		setBounds(100, 100, 703, 453);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("请选择查询条件：");
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"供应商ID", "供应商全称", "供应商简称", "联系人"}));
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
		String[] columnNames = {"供应商编号","供应商全称","供应商简称","供应商地址","供应商邮编"
				,"供应商电话","供应商传真","联系人","联系电话","开户银行","银行账号","供应商邮箱"};
		tableModel = new MyTableModel(columnNames);
		//创建一个表格面板
		table = new JTable(tableModel);
		
		//设置大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width*2/3-60,screenSize.height/3));
		//视图高度填充
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		providerService = CommonFactory.getProviderService();
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
			Provider provider  =  new Provider();
			switch (type) {
			case "供应商ID":
				provider.setId(searchValue);
				break;
			case "供应商全称":
				provider.setProviderName(searchValue);;
			case "供应商简称":
				provider.setShorts(searchValue);
			case "联系人":
				provider.setContacts(searchValue);
			default:
				break;
			}
			List<Provider> providers = providerService.findProviders(provider);
			if(providers!=null) {
				Vector<Provider> list = new Vector<Provider>();
				for(Provider c:providers) {
					list.add(c);
				}
				tableModel.updateData(list);
			}
			
			break;
		case "显示全部信息":
			List<Provider> providers1 = providerService.findProviders(null);
			if(providers1!=null) {
				Vector<Provider> list = new Vector<Provider>();
				for(Provider c:providers1) {
					System.out.println(c);
					list.add(c);
				}
				
				tableModel.updateData(list);
			}
		default:
			break;
		}
		
	}
	
	

}
