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
	private JComboBox comboBox;  //��ѯѡ��
	private JTable table;     //�����ڻ����������
	private MyTableModel tableModel;  //�Զ����ħ�壬Ϊ���������ǵ�����
	private CustomerService customerService;
	/**�ͻ���ѯ
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CustomerInforSearchInterFrame() {
		//֧�ַŴ���С���ɹر�
		super("�ͻ���ѯ",true,true,true,true);
		setBounds(100, 100, 703, 453);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("��ѡ���ѯ������");
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"�ͻ�ID", "�ͻ�ȫ��", "�ͻ����", "��ϵ��"}));
		panel.add(comboBox);
		
		searchValueText = new JTextField();
		panel.add(searchValueText);
		searchValueText.setColumns(25);
		
		JButton searchBtn = new JButton("��ѯ");
		searchBtn.setIcon(new ImageIcon(CustomerInforSearchInterFrame.class.getResource("/com/cjzy/images/\u67E5\u8BE2.png")));
		panel.add(searchBtn);
		searchBtn.addActionListener(this);
		
		JButton searchAllBtn = new JButton("��ʾȫ����Ϣ");
		panel.add(searchAllBtn);
		searchAllBtn.addActionListener(this);
		
		//�������ħ��
		String[] columnNames = {"�ͻ����","�ͻ�ȫ��","�ͻ����","�ͻ���ַ","�ͻ��ʱ�"
				,"�ͻ��绰","�ͻ�����","��ϵ��","��ϵ�绰","��������","�����˺�","�ͻ�����"};
		tableModel = new MyTableModel(columnNames);
		//����һ��������
		table = new JTable(tableModel);
		
		//���ô�С
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width*2/3-60,screenSize.height/3));
		//��ͼ�߶����
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		customerService = CommonFactory.getCustomerService();
		//�����ŵ�������
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		
		
		

	}
	
	/***|
	 * �Զ���������ħ�壬Ҳ����˵ ����Ҫ������ʾ
	 * @author 61702
	 *
	 */
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String target = e.getActionCommand();
		switch (target) {
			case "��ѯ":
				String searchValue = searchValueText.getText().trim();
				if(searchValue==null || searchValue.length()==0) {
					JOptionPane.showMessageDialog(null,"����������ֵ","����",JOptionPane.WARNING_MESSAGE);	
				}
				String type = comboBox.getSelectedItem().toString();
				Customer customer  =  new Customer();
				switch (type) {
				case "�ͻ�ID":
					customer.setId(searchValue);
					break;
				case "�ͻ�ȫ��":
					customer.setCustomerName(searchValue);;
				case "�ͻ����":
					customer.setShorts(searchValue);
				case "��ϵ��":
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
			case "��ʾȫ����Ϣ":
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
