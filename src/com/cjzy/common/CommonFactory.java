package com.cjzy.common;

import com.cjzy.service.CustomerService;
import com.cjzy.service.GoodService;
import com.cjzy.service.InpoutService;
import com.cjzy.service.OperatorService;
import com.cjzy.service.OutPortService;
import com.cjzy.service.ProviderService;

/***
 * ��������ҵ����Ķ���
 * @author 61702
 *
 */

public class CommonFactory {
	
	/***
	 * ��ȡOperatorServiceʵ����Ķ���
	 * @return
	 */
	public static OperatorService getOperatorService() {
		try {
			return (OperatorService) Class.forName(Constants.OPERATOR_SERVICE_CLASS).newInstance();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("CommonFactory getOperatorService()", e);
		}
		return null;
	}
	
	/***
	 * ��ȡCustomerServiceʵ����Ķ���
	 * @return
	 */
	public static CustomerService getCustomerService() {
		try {
			return (CustomerService) Class.forName(Constants.CUSTOMER_SERVICE_CLASS).newInstance();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("CommonFactory getOperatorService()", e);
		}
		return null;
	}
	
	
	/***
	 * ��ȡProviderServiceʵ����Ķ���
	 * @return
	 */
	public static ProviderService getProviderService() {
		try {
			return  (ProviderService) Class.forName(Constants.PROVIDER_SERVICE_CLASS).newInstance();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("CommonFactory getOperatorService()", e);
		}
		return null;
	}
	
	
	/***
	 * ��ȡgoodServiceʵ����Ķ���
	 * @return
	 */
	public static GoodService getGoodService() {
		try {
			return  (GoodService) Class.forName(Constants.GOOD_SERVICE_CLASS).newInstance();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("CommonFactory getGoodService()", e);
		}
		return null;
	}
	
	/***
	 * ��ȡInpoutServiceʵ����Ķ���
	 * @return
	 */
	public static InpoutService getInpoutService() {
		try {
			return  (InpoutService) Class.forName(Constants.INPOUT_SERVICE_CLASS).newInstance();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("CommonFactory getInpoutService()", e);
		}
		return null;
	}
	
	
	/***
	 * ��ȡOutPortServiceʵ����Ķ���
	 * @return
	 */
	public static OutPortService getOutPortService() {
		try {
			return  (OutPortService) Class.forName(Constants.OUTPORT_SERVICE_CLASS).newInstance();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			ErrorManager.printError("CommonFactory getInpoutService()", e);
		}
		return null;
	}
	
	
}
