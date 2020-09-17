package com.cjzy.service;

import java.util.List;

import com.cjzy.model.InportInfor;
import com.cjzy.model.Inpout;

/***
 * �����˻�ҵ��
 * @author 61702
 *
 */
public interface OutPortService {
	
	/**
	 * ���һ����Ϣ
	 * @param outport
	 * @return  boolean
	 */
	public boolean addOutPort(Inpout outport);
	
	
	/**
	 * �����˻���Ϣ
	 * @param inportInfor
	 * @return
	 */
	public List<InportInfor> queryInportInfors(InportInfor inportInfor);

}
