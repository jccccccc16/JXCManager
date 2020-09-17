package com.cjzy.service.impl;

import java.util.List;

import com.cjzy.dao.GoodsDao;
import com.cjzy.model.Good;
import com.cjzy.model.GoodInfo;
import com.cjzy.service.GoodService;

public class GoodServiceImpl implements GoodService{

	
	GoodsDao goodsDao;
	
	@Override
	public boolean addGood(Good good) {
		// TODO Auto-generated method stub
		goodsDao = new GoodsDao();
		
		return goodsDao.addGood(good);
	}

	@Override
	public String getGoodId() {
		// TODO Auto-generated method stub
		goodsDao = new GoodsDao();
		return goodsDao.getGoodId();
	}

	@Override
	public List<Good> findGoods(Good good) {
		// TODO Auto-generated method stub
		goodsDao = new GoodsDao();
		return goodsDao.findGoods(good);
	}
	
	
	/**
	 * ������Ʒ����޸���Ʒ��Ϣ
	 * @param good
	 * @return boolean
	 */
	public boolean updateGood(Good good) {
		goodsDao = new GoodsDao();
		return goodsDao.updateGood(good);
	}

	
	/***
	 * ����available �޸ģ�0 ��ɾ����1���һ�
	 * @param id
	 * @return boolean
	 */
	@Override
	public boolean updateGood(String id, Integer available) {
		// TODO Auto-generated method stub
		goodsDao = new GoodsDao();
		return goodsDao.updateGood(id, available);
	}

	@Override
	public List<GoodInfo> findGoodInfo(GoodInfo goodInfo) {
		// TODO Auto-generated method stub
		goodsDao = new GoodsDao();
		return goodsDao.findGoodInfo(goodInfo);
	}
	
	


	
}
