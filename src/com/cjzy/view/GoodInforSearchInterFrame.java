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
	private JComboBox comboBox;  //��ѯѡ��
	private JTable table;     //�����ڻ����������
	private MyTableModel tableModel;  //�Զ����ħ�壬Ϊ���������ǵ�����
	private GoodService goodService;
	/**�ͻ���ѯ
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GoodInforSearchInterFrame() {
		//֧�ַŴ���С���ɹر�
		super("��Ʒ��ѯ",true,true,true,true);
		setBounds(100, 100, 703, 453);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("��ѡ���ѯ������");
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"��ƷID", "��Ʒȫ��", "��Ʒ���", "��Ӧ��ȫ��"}));
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
		String[] columnNames = {"��Ʒ���","��Ʒȫ��","��Ʒ���","����"
				,"���","��װ","����","��׼�ĺ�","�۸�","��ע","��Ӧ��" };
		tableModel = new MyTableModel(columnNames);
		//����һ��������
		table = new JTable(tableModel);
		
		//���ô�С
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width*2/3-60,screenSize.height/3));
		//��ͼ�߶����
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		goodService = CommonFactory.getGoodService();
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
				GoodInfo good  =  new GoodInfo();
				switch (type) {
				case "��ƷID":
					good.setId(searchValue);
					break;
				case "��Ʒȫ��":
					good.setGoodsName(searchValue);;
				case "��Ʒ���":
					good.setShorts(searchValue);
				case "��Ӧ��ȫ��":
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
			case "��ʾȫ����Ϣ":
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
