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
import com.cjzy.common.ValidationManager;
import com.cjzy.model.Customer;
import com.cjzy.model.InportInfor;
import com.cjzy.service.CustomerService;
import com.cjzy.service.InpoutService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;

public class InportInforSearchFrame extends JInternalFrame implements ActionListener{


	private JTextField searchValueText;
	private JComboBox comboBox;  //查询选项
	private JTable table;     //表格放在滑动面板里面
	private MyTableModel tableModel;  //自定义的魔板，为了适配我们的数据
	private CustomerService customerService;
	private JTextField startTimeTf;
	private JTextField endTimeTf;
	private InpoutService inportSerivce;
	private JCheckBox DateCheckBox;
	/**客户查询
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public InportInforSearchFrame() {
		//支持放大缩小，可关闭
		super("入库查询",true,true,true,true);
		setBounds(100, 100, 780, 535);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("请选择查询条件：");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"入库单号", "供应商名称", "商品名称", "经手人"}));
		
		searchValueText = new JTextField();
		searchValueText.setColumns(25);
		
		JButton searchBtn = new JButton("查询");
		searchBtn.setIcon(new ImageIcon(CustomerInforSearchInterFrame.class.getResource("/com/cjzy/images/\u67E5\u8BE2.png")));
		searchBtn.addActionListener(this);
		
		JButton searchAllBtn = new JButton("显示全部信息");
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(5)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(searchValueText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchBtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchAllBtn))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(494, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(searchValueText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(searchBtn)
								.addComponent(searchAllBtn))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
					.addGap(26))
		);
		
		DateCheckBox = new JCheckBox("指定查询日期");
		
		startTimeTf = new JTextField();
		startTimeTf.setColumns(20);
		
		JLabel label = new JLabel("\u5230");
		
		endTimeTf = new JTextField();
		endTimeTf.setColumns(20);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(DateCheckBox)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(startTimeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(endTimeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(206, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(startTimeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(endTimeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(DateCheckBox))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		searchAllBtn.addActionListener(this);
		
		//创建表格魔板
		String[] columnNames = {"入库单号","商品名称","商品数量","合计金额","供应商名称"
				,"验收结论","入库时间","操作人员","经手人","支付方式"};
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
		inportSerivce = CommonFactory.getInpoutService();
		
		
		
		

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
				InportInfor customer  =  new InportInfor();
				String searchValue = searchValueText.getText().trim();
				
				if(DateCheckBox.isSelected()) {
					if(startTimeTf.getText().trim()==null||startTimeTf.getText().equals("")||endTimeTf.getText().trim()==null||endTimeTf.getText().trim().equals("")){
						JOptionPane.showMessageDialog(null,"请输入时间","警告",JOptionPane.WARNING_MESSAGE);	
					}else if(!ValidationManager.validateDate(startTimeTf.getText().trim())||!ValidationManager.validateDate(endTimeTf.getText().trim())){
						JOptionPane.showMessageDialog(null,"时间格式不正确","警告",JOptionPane.WARNING_MESSAGE);	
					}else {
						customer.setStartTime(startTimeTf.getText().trim());
						customer.setEndTime(endTimeTf.getText().trim());
						
					}
				}else {
					String type = comboBox.getSelectedItem().toString();
					if(searchValue==null || searchValue.length()==0) {
						JOptionPane.showMessageDialog(null,"请输入搜索值","警告",JOptionPane.WARNING_MESSAGE);	
					}
					switch (type) {
					
					case "入库单号":
						customer.setId(searchValue);
						break;
					case "供应商名称":
						customer.setProviderName(searchValue);;
					case "商品名称":
						customer.setGoodsName(searchValue);
					case "经手人":
						customer.setSponsor(searchValue); 
					default:
						break;
					}
				}
	
				List<InportInfor> customers = inportSerivce.queryInportInfors(customer);
				if(customers!=null) {
					Vector<InportInfor> list = new Vector<InportInfor>();
					for(InportInfor c:customers) {
						System.out.println(c);
						list.add(c);
					}
					tableModel.updateData(list);
				}else {
					JOptionPane.showMessageDialog(null,"搜索为空","提示",JOptionPane.INFORMATION_MESSAGE);	
					return;
				}
				
				break;
			case "显示全部信息":
				List<InportInfor> customers1 = inportSerivce.queryInportInfors(null);
				if(customers1!=null) {
					Vector<InportInfor> list = new Vector<InportInfor>();
					for(InportInfor c:customers1) {
						list.add(c);
					}
					tableModel.updateData(list);
				}
			default:
				break;
		}
		
	}
}
