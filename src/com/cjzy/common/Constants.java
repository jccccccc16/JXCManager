package com.cjzy.common;
/***
 * ������
 * ���峣���ӿ�
 * @author 61702
 *
 */

public interface Constants {
	//��ͳ��Ԥ�������
	public static final int PSTM_TYPE=0;
	//�洢����
	public static final int CALL_TYPE=1;
	public static final int DATA_DEL=0;//ɾ������
	public static final int DATA_FIND = 1;  // �һ�����
	//ҵ�������ȫ·��
	String OPERATOR_SERVICE_CLASS="com.cjzy.service.impl.OperatorServiceImpl";
	String CUSTOMER_SERVICE_CLASS="com.cjzy.service.impl.CustomerServiceImpl";//�ͻ�ҵ����
	String PROVIDER_SERVICE_CLASS="com.cjzy.service.impl.ProviderServiceImpl";
	String GOOD_SERVICE_CLASS = "com.cjzy.service.impl.GoodServiceImpl";
	String INPOUT_SERVICE_CLASS = "com.cjzy.service.impl.InpoutServiceImpl";
	String OUTPORT_SERVICE_CLASS = "com.cjzy.service.impl.OutPortServiceImpl";
}
