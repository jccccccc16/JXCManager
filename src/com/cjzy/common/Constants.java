package com.cjzy.common;
/***
 * 常量类
 * 定义常亮接口
 * @author 61702
 *
 */

public interface Constants {
	//传统的预处理操作
	public static final int PSTM_TYPE=0;
	//存储过程
	public static final int CALL_TYPE=1;
	public static final int DATA_DEL=0;//删除数据
	public static final int DATA_FIND = 1;  // 找回数据
	//业务类包名全路径
	String OPERATOR_SERVICE_CLASS="com.cjzy.service.impl.OperatorServiceImpl";
	String CUSTOMER_SERVICE_CLASS="com.cjzy.service.impl.CustomerServiceImpl";//客户业务类
	String PROVIDER_SERVICE_CLASS="com.cjzy.service.impl.ProviderServiceImpl";
	String GOOD_SERVICE_CLASS = "com.cjzy.service.impl.GoodServiceImpl";
	String INPOUT_SERVICE_CLASS = "com.cjzy.service.impl.InpoutServiceImpl";
	String OUTPORT_SERVICE_CLASS = "com.cjzy.service.impl.OutPortServiceImpl";
}
