package com.cjzy.service;

import java.util.List;

import com.cjzy.model.InportInfor;
import com.cjzy.model.Inpout;

/***
 * 进货退货业务
 * @author 61702
 *
 */
public interface OutPortService {
	
	/**
	 * 添加一条信息
	 * @param outport
	 * @return  boolean
	 */
	public boolean addOutPort(Inpout outport);
	
	
	/**
	 * 查找退货信息
	 * @param inportInfor
	 * @return
	 */
	public List<InportInfor> queryInportInfors(InportInfor inportInfor);

}
