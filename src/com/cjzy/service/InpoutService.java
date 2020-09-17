package com.cjzy.service;

import java.util.List;

import com.cjzy.model.InportInfor;
import com.cjzy.model.Inpout;
import com.cjzy.model.Operator;

/**
 * ���ҵ��ӿ�
 * @author 61702
 *
 */
public interface InpoutService {

	/**
	 * ��ȡid
	 * @return
	 */
	public String getId();
	/**
	 * ���һ��
	 * @param inpout
	 * @return
	 */
	public boolean addInport(Inpout inpout);
	
	
	/***
	 * ɾ��
	 * @param id
	 * @param available
	 * @return
	 */
	public boolean delete(String id,Integer available);
	
	
	/**
	 * ����
	 * @param inpout
	 * @return
	 */
	public boolean update(Inpout inpout);
	
	/***
	 * ����
	 * @param t
	 * @return
	 */
	public List<Inpout> query(Inpout inpout);
	
	/***
	 * 
	 * @param inportInfor
	 * @return
	 */
	public List<InportInfor> queryInportInfors(InportInfor inportInfor);
		
	
	
}
