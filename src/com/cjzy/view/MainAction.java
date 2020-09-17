package com.cjzy.view;
/***
 * 主界面的点击事件
 * @author 61702
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAction {
	/**
	 * 客户信息管理
	 * @return
	 */
	public static ActionListener clickCustomerInfoManager() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CustomerInternalFrame customerInternalFrame = new CustomerInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(customerInternalFrame);
				customerInternalFrame.setVisible(true);
			}
		};
	}
	/**
	 * 供应商信息管理
	 * @return
	 */
	public static ActionListener clickProviderInfoManager() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProviderInternalFrame providerInternalFrame =new ProviderInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(providerInternalFrame);
				providerInternalFrame.setVisible(true);
			}
		};
	}
	/**
	 * 跳转到供应商查询
	 * @return
	 */
	public static ActionListener clickProviderInforSearch() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProviderInforSearchFrame providerInforSearchFrame =new ProviderInforSearchFrame();
				MainFrame.getMainFrame().getContentPane().add(providerInforSearchFrame);
				providerInforSearchFrame.setVisible(true);
			}
		};
	}
	
	
	
	
	
	/***
	 * 跳转到客户查询界面
	 * @return
	 */
	public static ActionListener clickCustomerInforSearch() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerInforSearchInterFrame inforSearchInterFrame = new CustomerInforSearchInterFrame();
				MainFrame.getMainFrame().getContentPane().add(inforSearchInterFrame);
				inforSearchInterFrame.setVisible(true);
				
			}
		};
	}
	
	
	
	
	/***
	 * 跳转到商品信息管理界面
	 * @return
	 */
	public static ActionListener clickGoodInternalFrame() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GoodInternalFrame goodInternalFrame = new GoodInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(goodInternalFrame);
				goodInternalFrame.setVisible(true);
				
			}
		};
	}
	
	
	/***
	 * 跳转到商品搜索界面
	 * @return
	 */
	public static ActionListener clickGoodSearchInternalFrame() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GoodInforSearchInterFrame goodInternalFrame = new GoodInforSearchInterFrame();
				MainFrame.getMainFrame().getContentPane().add(goodInternalFrame);
				goodInternalFrame.setVisible(true);
				
			}
		};
	}
	
	
	
	/***
	 * 跳转到进货单搜索界面
	 * @return
	 */
	public static ActionListener clickInpoutInternalFrame() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InpoutInternalFrame InternalFrame = new InpoutInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(InternalFrame);
				InternalFrame.setVisible(true);
				
			}
		};
	}
	
	
	/***
	 * 跳转到进货退货界面
	 * @return
	 */
	public static ActionListener clickInpoutCancelInternalFrame() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InportCanelInternalFrame InternalFrame = new InportCanelInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(InternalFrame);
				InternalFrame.setVisible(true);
				
			}
		};
	}
	
	/***
	 * 跳转到入库查询界面
	 * @return
	 */
	public static ActionListener clickInpoutInforSearchInternalFrame() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InportInforSearchFrame InternalFrame = new InportInforSearchFrame();
				MainFrame.getMainFrame().getContentPane().add(InternalFrame);
				InternalFrame.setVisible(true);
				
			}
		};
	}
	
	
	/***
	 * 跳转到入库查询界面
	 * @return
	 */
	public static ActionListener clickOperatorInternalFrame() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OperatorInternalFrame InternalFrame = new OperatorInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(InternalFrame);
				InternalFrame.setVisible(true);
				
			}
		};
	}
	
	
	/***
	 * 跳转到修改密码界面
	 * @return
	 */
	public static ActionListener clickPasswordInternalFrame() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PasswordInternalFrame InternalFrame = new PasswordInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(InternalFrame);
				InternalFrame.setVisible(true);
				
			}
		};
	}
	
	
	/***
	 * 跳转到入库退货查询
	 * @return
	 */
	public static ActionListener clickOutportInternalFrame() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OutportInternalFrame InternalFrame = new OutportInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(InternalFrame);
				InternalFrame.setVisible(true);
				
			}
		};
	}
	
	
	/***
	 * 跳转到入库退货查询
	 * @return
	 */
	public static ActionListener clickPowerInternalFrame() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PowerInternalFrame InternalFrame = new PowerInternalFrame();
				MainFrame.getMainFrame().getContentPane().add(InternalFrame);
				InternalFrame.setVisible(true);
				
			}
		};
	}
	
	
	

}
