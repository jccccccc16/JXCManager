package com.cjzy.service;

import java.util.List;

import com.cjzy.model.Good;
import com.cjzy.model.GoodInfo;

public interface GoodService {
	
	public boolean addGood(Good good);
	
	public String getGoodId();
	
	public List<Good> findGoods(Good good);
	
	/**
	 * ������Ʒ����޸���Ʒ��Ϣ
	 * @param good
	 * @return boolean
	 */
	public boolean updateGood(Good good);
	

	/***
	 * ����available �޸ģ�0 ��ɾ����1���һ�
	 * @param id
	 * @return
	 */
	public boolean updateGood(String id,Integer available) ;
	
	
	public List<GoodInfo> findGoodInfo(GoodInfo goodInfo);
}
