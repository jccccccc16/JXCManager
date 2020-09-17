package com.cjzy.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cjzy.model.Operator;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainFrame extends JFrame {
	private static MainFrame mainFrame = null;
	private JPanel contentPane;
	public static String username = null;
	public static Operator operator = null;  //�����¼��Ĳ���Ա�Ķ���

	/***
	 * ��ʼ����
	 * @return
	 */
	public static MainFrame getMainFrame() {
		if(mainFrame==null) {
			mainFrame = new MainFrame();
		}
		return mainFrame;
	}
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		//��ȡ��Ļ�ĳߴ�
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(screenSize.width/6, screenSize.height/6, screenSize.width*2/3, screenSize.height*2/3);
		setForeground(Color.WHITE);
		setTitle("\u4F01\u4E1A\u8FDB\u9500\u5B58\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("������Ϣ����");
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/cjzy/images/\u57FA\u7840\u4FE1\u606F\u7BA1\u7406.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("���۹���");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/cjzy/images/\u9500\u552E(2).png")));
		menuBar.add(mnNewMenu_1);
		
		JMenu menu = new JMenu("��ѯͳ��");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/com/cjzy/images/\u67E5\u8BE2.png")));
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("��������");
		menu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/com/cjzy/images/\u7CFB\u7EDF.png")));
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("������");
		menu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/com/cjzy/images/\u5E93\u5B58.png")));
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("ϵͳ����");
		menu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/com/cjzy/images/\u7CFB\u7EDF.png")));
		menuBar.add(menu_3);
		menu_3.addActionListener(MainAction.clickOperatorInternalFrame());
		
		if(operator.getPower().equals("��������Ա")) {
			JMenuItem menuItem = new JMenuItem("�ͻ���Ϣ");
			menuItem.setHorizontalAlignment(SwingConstants.LEFT);
			menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/cjzy/images/\u5BA2\u6237\u4FE1\u606F.png")));
			mnNewMenu.add(menuItem);
			//�ͻ���Ϣ����¼�
			menuItem.addActionListener(MainAction.clickCustomerInfoManager());
			
			JMenuItem menuItem_1 = new JMenuItem("��Ӧ����Ϣ");
			mnNewMenu.add(menuItem_1);
			menuItem_1.addActionListener(MainAction.clickProviderInfoManager());
		
			
			JMenuItem menuItem_2 = new JMenuItem("��Ʒ��Ϣ");
			mnNewMenu.add(menuItem_2);
			menuItem_2.addActionListener(MainAction.clickGoodInternalFrame());
			
			
			JMenuItem menuItem_5 = new JMenuItem("���۵�");
			mnNewMenu_1.add(menuItem_5);
			
			JMenuItem menuItem_6 = new JMenuItem("�����˻�");
			mnNewMenu_1.add(menuItem_6);
			
			
			
			JMenuItem customerSearch = new JMenuItem("�ͻ���ѯ");
			menu.add(customerSearch);
			customerSearch.addActionListener(MainAction.clickCustomerInforSearch());
			
			JMenuItem menuItem_7_1 = new JMenuItem("��Ӧ�̲�ѯ");
			menu.add(menuItem_7_1);
			//���¼�
			menuItem_7_1.addActionListener(MainAction.clickProviderInforSearch());
			
			JMenuItem menuItem_8 = new JMenuItem("��Ʒ��ѯ");
			menu.add(menuItem_8);
			menuItem_8.addActionListener(MainAction.clickGoodSearchInternalFrame());
			
			JMenuItem menuItem_9 = new JMenuItem("���۲�ѯ");
			menu.add(menuItem_9);
			
			JMenuItem menuItem_10 = new JMenuItem("�����˻���ѯ");
			menu.add(menuItem_10);
			
			JMenuItem menuItem_11 = new JMenuItem("����ѯ");
			menu.add(menuItem_11);
			menuItem_11.addActionListener(MainAction.clickInpoutInforSearchInternalFrame());
	
			
			JMenuItem menuItem_12 = new JMenuItem("����˻���ѯ");
			menu.add(menuItem_12);
			menuItem_12.addActionListener(MainAction.clickOutportInternalFrame());
			
			JMenuItem menuItem_15 = new JMenuItem("��������");
			menu.add(menuItem_15);
			
			
			
			JMenuItem menuItem_3 = new JMenuItem("������");
			menu_1.add(menuItem_3);
			menuItem_3.addActionListener(MainAction.clickInpoutInternalFrame());
			
			JMenuItem  menuItem_4= new JMenuItem("�����˻�");
			menu_1.add(menuItem_4);
			menuItem_4.addActionListener(MainAction.clickInpoutCancelInternalFrame());
			
			
			
			JMenuItem menuItem_13 = new JMenuItem("����̵�");
			menu_2.add(menuItem_13);
			
			JMenuItem menuItem_14 = new JMenuItem("�۸����");
			menu_2.add(menuItem_14);
			
			
			
			JMenuItem menuItem_17 = new JMenuItem("��������");
			menu_3.add(menuItem_17);
			menuItem_17.addActionListener(MainAction.clickPasswordInternalFrame());
			JMenuItem menuItem_16 = new JMenuItem("����Ա����");
			menu_3.add(menuItem_16);
			menuItem_16.addActionListener(MainAction.clickOperatorInternalFrame());
			
			JMenuItem menuItem_18 = new JMenuItem("Ȩ�޹���");
			menu_3.add(menuItem_18);
			menuItem_18.addActionListener(MainAction.clickPowerInternalFrame());
			
		}else if(operator.getPower().equals("��ͨ����Ա")) {
			JMenuItem menuItem = new JMenuItem("�ͻ���Ϣ");
			menuItem.setHorizontalAlignment(SwingConstants.LEFT);
			menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/com/cjzy/images/\u5BA2\u6237\u4FE1\u606F.png")));
			mnNewMenu.add(menuItem);
			//�ͻ���Ϣ����¼�
			menuItem.addActionListener(MainAction.clickCustomerInfoManager());
			
			JMenuItem menuItem_1 = new JMenuItem("��Ӧ����Ϣ");
			mnNewMenu.add(menuItem_1);
			menuItem_1.addActionListener(MainAction.clickProviderInfoManager());
		
			
			JMenuItem menuItem_2 = new JMenuItem("��Ʒ��Ϣ");
			mnNewMenu.add(menuItem_2);
			menuItem_2.addActionListener(MainAction.clickGoodInternalFrame());
			
			
			JMenuItem menuItem_5 = new JMenuItem("���۵�");
			mnNewMenu_1.add(menuItem_5);
			
			JMenuItem menuItem_6 = new JMenuItem("�����˻�");
			mnNewMenu_1.add(menuItem_6);
			
			
			
			JMenuItem customerSearch = new JMenuItem("�ͻ���ѯ");
			menu.add(customerSearch);
			customerSearch.addActionListener(MainAction.clickCustomerInforSearch());
			
			JMenuItem menuItem_7_1 = new JMenuItem("��Ӧ�̲�ѯ");
			menu.add(menuItem_7_1);
			//���¼�
			menuItem_7_1.addActionListener(MainAction.clickProviderInforSearch());
			
			JMenuItem menuItem_8 = new JMenuItem("��Ʒ��ѯ");
			menu.add(menuItem_8);
			menuItem_8.addActionListener(MainAction.clickGoodSearchInternalFrame());
			
		
			JMenuItem menuItem_9 = new JMenuItem("���۲�ѯ");
			menu.add(menuItem_9);
			
			JMenuItem menuItem_10 = new JMenuItem("�����˻���ѯ");
			menu.add(menuItem_10);
			
			//���
			JMenuItem menuItem_11 = new JMenuItem("����ѯ");
			menu.add(menuItem_11);
			menuItem_11.addActionListener(MainAction.clickInpoutInforSearchInternalFrame());
	
			
			JMenuItem menuItem_12 = new JMenuItem("����˻���ѯ");
			menu.add(menuItem_12);
			
			
			JMenuItem menuItem_15 = new JMenuItem("��������");
			menu.add(menuItem_15);
			
			
			
			JMenuItem menuItem_3 = new JMenuItem("������");
			menu_1.add(menuItem_3);
			menuItem_3.addActionListener(MainAction.clickInpoutInternalFrame());
			
			JMenuItem menuItem_4 = new JMenuItem("�����˻�");
			menu_1.add(menuItem_4);
			menuItem_4.addActionListener(MainAction.clickInpoutCancelInternalFrame());
			
			
			
			
			
			JMenuItem menuItem_13 = new JMenuItem("����̵�");
			menu_2.add(menuItem_13);
			
			JMenuItem menuItem_14 = new JMenuItem("�۸����");
			menu_2.add(menuItem_14);
			
			
			
			JMenuItem menuItem_17 = new JMenuItem("��������");
			menu_3.add(menuItem_17);
		}else if(operator.getPower().equals("������Ա")) {
			//���۹���
			JMenuItem menuItem_5 = new JMenuItem("���۵�");
			mnNewMenu_1.add(menuItem_5);
			
			JMenuItem menuItem_6 = new JMenuItem("�����˻�");
			mnNewMenu_1.add(menuItem_6);
			
			//���۲�ѯ
			JMenuItem menuItem_9 = new JMenuItem("���۲�ѯ");
			menu.add(menuItem_9);
			
			JMenuItem menuItem_10 = new JMenuItem("�����˻���ѯ");
			menu.add(menuItem_10);

			JMenuItem menuItem_17 = new JMenuItem("��������");
			menu_3.add(menuItem_17);
			
		}else if(operator.getPower().equals("�ɹ���Ա")) {
			
			

			JMenuItem menuItem_3 = new JMenuItem("������");
			menu_1.add(menuItem_3);
			menuItem_3.addActionListener(MainAction.clickInpoutInternalFrame());
			
			JMenuItem menuItem_4 = new JMenuItem("�����˻�");
			menu_1.add(menuItem_4);
			menuItem_4.addActionListener(MainAction.clickInpoutCancelInternalFrame());
			

			JMenuItem customerSearch = new JMenuItem("�ͻ���ѯ");
			menu.add(customerSearch);
			customerSearch.addActionListener(MainAction.clickCustomerInforSearch());
			
			JMenuItem menuItem_8 = new JMenuItem("��Ʒ��ѯ");
			menu.add(menuItem_8);
			menuItem_8.addActionListener(MainAction.clickGoodSearchInternalFrame());
			
			
			JMenuItem menuItem_17 = new JMenuItem("��������");
			menu_3.add(menuItem_17);
			
		}else if(operator.getPower().equals("�ֿ���Ա")){
			
			JMenuItem menuItem_11 = new JMenuItem("����ѯ");
			menu.add(menuItem_11);
			menuItem_11.addActionListener(MainAction.clickInpoutInforSearchInternalFrame());
	
			
			JMenuItem menuItem_12 = new JMenuItem("����˻���ѯ");
			menu.add(menuItem_12);
			
			
			
			JMenuItem menuItem_13 = new JMenuItem("����̵�");
			menu_2.add(menuItem_13);
			
			
			JMenuItem menuItem_17 = new JMenuItem("��������");
			menu_3.add(menuItem_17);
			
		}
				
				
				
			
		
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u4F01\u4E1A\u7ECF\u9500\u5B58\u7BA1\u7406\u7CFB\u7EDF");
		label.setIcon(new ImageIcon(MainFrame.class.getResource("/com/cjzy/images/\u6B22\u8FCE\u8BED(1).png")));
		label.setForeground(Color.GRAY);
		label.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("��ǰʱ��");
		
		JLabel lblNewLabel_2 = new JLabel("��ǰ����");
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					Date now = new Date(); 
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//���Է�����޸����ڸ�ʽ
					String time[] = dateFormat.format(now).split(" ");
					String colock = time[1];
					String date = time[0];
					lblNewLabel_1.setText(colock);
					lblNewLabel_2.setText(date);
				}
			}
		});
		thread.start();
		
		JLabel lblNewLabel = new JLabel("��ǰ�û���"+operator.getName());
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 1052, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(68))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
	}
}
