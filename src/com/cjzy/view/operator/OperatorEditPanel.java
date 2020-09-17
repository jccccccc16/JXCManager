package com.cjzy.view.operator;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.Constants;
import com.cjzy.model.Item;
import com.cjzy.model.Operator;
import com.cjzy.service.OperatorService;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


/***
 * 操作员编辑
 * @author 61702
 *
 */
public class OperatorEditPanel extends JPanel implements ActionListener{
	private JTextField nameTf;
	private OperatorService operatorService;
	private JComboBox operatorCombobox;
    private	JComboBox powerCombobox;
    private Item operItemselected;
    private Operator operatorselected;
    
	/**
	 * Create the panel.
	 */
	public OperatorEditPanel() {
		
		JLabel label = new JLabel("\u9009\u62E9\u64CD\u4F5C\u5458\uFF1A");
		
		operatorCombobox = new JComboBox();
		operatorCombobox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				selectAction();
			}

		});
		
		JLabel label_1 = new JLabel("\u64CD\u4F5C\u5458\u59D3\u540D\uFF1A");
		
		nameTf = new JTextField();
		nameTf.setColumns(25);
		
		JLabel label_2 = new JLabel("\u64CD\u4F5C\u5458\u6743\u9650\uFF1A");
		
		powerCombobox = new JComboBox();
		powerCombobox.setModel(new DefaultComboBoxModel(new String[] {"超级管理员", "普通管理员", "销售人员","采购人员","仓库人员"}));
		
		JButton editBtn = new JButton("修改");
		editBtn.addActionListener(this);
	
		JButton deleteBtn = new JButton("删除");
		deleteBtn.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(operatorCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(editBtn))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deleteBtn)
								.addComponent(powerCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(operatorCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(nameTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(powerCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(editBtn)
						.addComponent(deleteBtn))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		operatorService = CommonFactory.getOperatorService();
		initCombobox();
		
	}
	
	
	public void initCombobox(){
		
		List<Operator> operators = operatorService.query(null);
		operatorCombobox.removeAll();
		for (Operator operator : operators) {
			Item item = new Item();
			item.setId(operator.getUsername());
			item.setName(operator.getUsername());	
			operatorCombobox.addItem(item);
		}	
		
	}
	/**
	 * 初始化面板数据
	 */
	public void SetData() {
		String username = operItemselected.getId();
		Operator operator = new Operator();
		operator.setUsername(username);
		List<Operator> query = operatorService.query(operator);
		if(query!=null) {
			operatorselected = query.get(0);
			nameTf.setText(operatorselected.getName());
			for(int i=0;i<powerCombobox.getItemCount();i++) {
				String item =  (String) powerCombobox.getItemAt(i);
				if(item.equals(operatorselected.getPower())) {
					powerCombobox.setSelectedIndex(i);
				}
			}
		}
		
	}
	/**
	 * 选择事件
	 */
	public void selectAction() {
		Item selectedItem = (Item) operatorCombobox.getSelectedItem();
		operItemselected = selectedItem;
		SetData();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String target = e.getActionCommand();
		switch (target) {
		case "修改":
			if(!nameTf.getText().trim().equals("")) {
				operatorselected.setName(nameTf.getText().trim());
				operatorselected.setPower(String.valueOf(powerCombobox.getSelectedItem()));
				Boolean flag = operatorService.update(operatorselected);
				if(flag) {
					JOptionPane.showMessageDialog(null, "操作员修改成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "操作员修改失败!", "提示", JOptionPane.INFORMATION_MESSAGE);
					return ;
				}	
			}else {
				JOptionPane.showMessageDialog(null, "请填写完整信息！", "警告", JOptionPane.WARNING_MESSAGE);
				return ;
			}
			break;
		case "删除":
			int type = JOptionPane.showConfirmDialog(null, "是否删除?", "温馨提示", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (type == 0) {
				boolean delete = operatorService.delete(operatorselected.getUsername());
				if(delete) {
					JOptionPane.showMessageDialog(null, "删除成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
					initCombobox();
				}
			}else {
				return ;
			}
		default:
			break;
		}
	}
	
	
	

}
