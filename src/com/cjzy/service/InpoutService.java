package com.cjzy.service;

import java.util.List;

import com.cjzy.model.InportInfor;
import com.cjzy.model.Inpout;
import com.cjzy.model.Operator;

/**
 * 入库业务接口
 * @author 61702
 *
 */
public interface InpoutService {

	/**
	 * 获取id
	 * @return
	 */
	public String getId();
	/**
	 * 添加一条
	 * @param inpout
	 * @return
	 */
	public boolean addInport(Inpout inpout);
	
	
	/***
	 * 删除
	 * @param id
	 * @param available
	 * @return
	 */
	public boolean delete(String id,Integer available);
	
	
	/**
	 * 更新
	 * @param inpout
	 * @return
	 */
	public boolean update(Inpout inpout);
	
	/***
	 * 查找
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
