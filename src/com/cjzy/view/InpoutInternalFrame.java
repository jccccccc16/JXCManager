package com.cjzy.view;

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

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.CommonUtils;
import com.cjzy.model.GoodInfo;
import com.cjzy.model.Inpout;
import com.cjzy.model.Item;
import com.cjzy.model.Provider;
import com.cjzy.service.GoodService;
import com.cjzy.service.InpoutService;
import com.cjzy.service.ProviderService;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

/***
 * ������
 * 
 * @author 61702
 *
 */
public class InpoutInternalFrame extends JInternalFrame implements ActionListener{
	private JTextField idTf;
	private JTextField conTf;
	private JTextField timeFt;
	private JTextField sponsorTf;
	private MyTableModel<GoodInfo> tableModel;
	private JTable table; // �����ڻ����������
	private JTextField numberTf;
	private JTextField moneyTf;
	private JTextField comTf;
	private JTextField operatorTf;
	private ProviderService providerService;
	JComboBox comboBox;
	private Item providerSelectedItem;
	private GoodService goodService;
	private InpoutService inpoutService;
	private double price;
	private String number;
	private String goodId;
	JComboBox comboBox_1;
	/**
	 * Create the frame.
	 */
	public InpoutInternalFrame() {
		setTitle("������");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width / 12, screenSize.height / 20, screenSize.width / 2, screenSize.height / 2);
		setClosable(true); // ֧�ִ��ڿɹر�
		setIconifiable(true);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JLabel label_1 = new JLabel("��Ʒ������");

		numberTf = new JTextField();
		numberTf.setColumns(25);

		JLabel lblNewLabel_5 = new JLabel("�ϼƽ�");

		moneyTf = new JTextField();
		moneyTf.setEditable(false);
		moneyTf.setColumns(25);

		JLabel lblNewLabel_6 = new JLabel("���ս��ۣ�");

		comTf = new JTextField();
		comTf.setColumns(25);

		JLabel lblNewLabel_7 = new JLabel("������Ա��");

		operatorTf = new JTextField();
		operatorTf.setEditable(false);
		operatorTf.setColumns(25);

		JButton inpoutBtn = new JButton("���");
		inpoutBtn.addActionListener(this);

		JButton confirmBtn = new JButton("ȷ��");
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

		JLabel lblNewLabel = new JLabel("�������ţ�");

		idTf = new JTextField();
		idTf.setEditable(false);
		idTf.setColumns(25);

		JLabel lblNewLabel_1 = new JLabel("��Ӧ�̣�");

		JLabel label = new JLabel("��ϵ�ˣ�");

		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(25);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				providerSelectAction();
			}
		});

		conTf = new JTextField();
		conTf.setEditable(false);
		conTf.setColumns(25);

		JLabel lblNewLabel_2 = new JLabel("����ʱ�䣺");

		timeFt = new JTextField();
		timeFt.setEditable(false);
		timeFt.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("���㷽ʽ��");

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] { "\u73B0\u91D1", "\u94F6\u8054\u5237\u5361", "\u8F6C\u8D26" }));
		
		JLabel lblNewLabel_4 = new JLabel("�����ˣ�");

		sponsorTf = new JTextField();
		sponsorTf.setColumns(25);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(30)
				.addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel).addComponent(lblNewLabel_2))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING, false).addComponent(timeFt).addComponent(idTf))
				.addGap(41)
				.addGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3).addComponent(lblNewLabel_1))
				.addGap(14)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(label).addPreferredGap(ComponentPlacement.RELATED).addComponent(conTf,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_4)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(sponsorTf, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
				.addGap(147)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1
						.createSequentialGroup().addGap(
								5)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(idTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label).addComponent(conTf, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(timeFt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3).addComponent(lblNewLabel_4).addComponent(sponsorTf,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		String[] columnNames = {"��Ʒ���","��Ʒȫ��","��Ʒ���","����"
				,"���","��װ","����","��׼�ĺ�","�۸�","��ע","��Ӧ��" };
		tableModel = new MyTableModel(columnNames);
		// ����һ��������
		table = new JTable(tableModel);
		// ���ô�С
		table.setPreferredScrollableViewportSize(new Dimension(screenSize.width * 2 / 3 - 60, screenSize.height / 3));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				ListSelectionModel model = (ListSelectionModel) e.getSource();
				int maxSelectionIndex = model.getMaxSelectionIndex();
				try {
					price = (double) table.getValueAt(maxSelectionIndex, 8);
					goodId = (String) table.getValueAt(maxSelectionIndex, 0);
				}catch (Exception e1) {
					// TODO: handle exception
				}

			}
		});
		// ��ͼ�߶����
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);

		// �����ŵ�������
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
		providerService = CommonFactory.getProviderService();
		goodService = CommonFactory.getGoodService();
		inpoutService = CommonFactory.getInpoutService();
		//��ʼ���Ӵ�
		//������Ա
		operatorTf.setText(MainFrame.operator.getName());
		
		
		initComboBox();

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
			item.setContacts(customer.getContacts());
			comboBox.addItem(item);
		}
	}
	/***
	 * ������ѡ���¼�
	 */
	public void providerSelectAction() {

		if (!(comboBox.getSelectedItem() instanceof Item)) {
			return;
		}
		providerSelectedItem = (Item) comboBox.getSelectedItem();
		// ������ϵ��
		conTf.setText(providerSelectedItem.getContacts());
		GoodInfo goodInfo = new GoodInfo();
		goodInfo.setProviderId(providerSelectedItem.getId());
		updateData(goodInfo);
	}

	/***
	 * ���±�����
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
	/***
	 * ȷ������������
	 */
	public void insertInfo() {
		//id
		idTf.setText(inpoutService.getId());
		//�¼�
		timeFt.setText(CommonUtils.dateToString(new Date()));
		//��Ǯ
		//��ȡ����
		String number = numberTf.getText();
		moneyTf.setText(price*Double.parseDouble(number)+"");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		String target = e.getActionCommand();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		switch (target) {
		case "���":
			JOptionPane.showConfirmDialog(null, "�Ƿ���⣿", "��ܰ��ʾ", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			
			Date date = new Date();
			long time = date.getTime();
			Inpout inpout = new Inpout(idTf.getText().trim(), Integer.parseInt(numberTf.getText().trim()),Float.parseFloat(moneyTf.getText().trim()),comTf.getText().trim(), providerSelectedItem.getId(),new java.sql.Date(time), MainFrame.operator.getName(),sponsorTf.getText().trim(),comboBox_1.getSelectedItem().toString(),goodId);
			inpoutService.addInport(inpout);
			JOptionPane.showMessageDialog(null, "���ɹ�!", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "ȷ��":
			insertInfo();
		default:
			break;
		}
		
	}
	
}
