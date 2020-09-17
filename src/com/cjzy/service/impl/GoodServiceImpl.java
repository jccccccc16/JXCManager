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
	 * 根据商品标号修改商品信息
	 * @param good
	 * @return boolean
	 */
	public boolean updateGood(Good good) {
		goodsDao = new GoodsDao();
		return goodsDao.updateGood(good);
	}

	
	/***
	 * 根据available 修改，0 ：删除，1：找回
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
