package com.cjzy.view;
/***
 * ������ĵ���¼�
 * @author 61702
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAction {
	/**
	 * �ͻ���Ϣ����
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
	 * ��Ӧ����Ϣ����
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
	 * ��ת����Ӧ�̲�ѯ
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
	 * ��ת���ͻ���ѯ����
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
	 * ��ת����Ʒ��Ϣ�������
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
	 * ��ת����Ʒ��������
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
	 * ��ת����������������
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
	 * ��ת�������˻�����
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
	 * ��ת������ѯ����
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
	 * ��ת������ѯ����
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
	 * ��ת���޸��������
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
	 * ��ת������˻���ѯ
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
	 * ��ת������˻���ѯ
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
