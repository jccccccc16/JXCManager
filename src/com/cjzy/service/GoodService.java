package com.cjzy.service;

import java.util.List;

import com.cjzy.model.Good;
import com.cjzy.model.GoodInfo;

public interface GoodService {
	
	public boolean addGood(Good good);
	
	public String getGoodId();
	
	public List<Good> findGoods(Good good);
	
	/**
	 * 根据商品标号修改商品信息
	 * @param good
	 * @return boolean
	 */
	public boolean updateGood(Good good);
	

	/***
	 * 根据available 修改，0 ：删除，1：找回
	 * @param id
	 * @return
	 */
	public boolean updateGood(String id,Integer available) ;
	
	
	public List<GoodInfo> findGoodInfo(GoodInfo goodInfo);
}
