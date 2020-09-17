package com.cjzy.service.impl;

import java.util.List;

import com.cjzy.dao.InpoutDao;
import com.cjzy.model.InportInfor;
import com.cjzy.model.Inpout;
import com.cjzy.service.InpoutService;

public class InpoutServiceImpl implements InpoutService{
	
	InpoutDao inportDao;

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		inportDao = new InpoutDao();
		return inportDao.getId();
	}
	@Override
	public boolean addInport(Inpout inpout) {
		// TODO Auto-generated method stub
		inportDao = new InpoutDao();
		return inportDao.addInpout(inpout);
	}
	@Override
	public boolean delete(String id,Integer available) {
		// TODO Auto-generated method stub
		inportDao = new InpoutDao();
		return inportDao.delete(id,available);
	}
	@Override
	public boolean update(Inpout inpout) {
		// TODO Auto-generated method stub
		inportDao = new InpoutDao();
		return inportDao.update(inpout);
	}
	
	/**
	 * ≤È’“
	 */
	@Override
	public List<InportInfor> queryInportInfors(InportInfor inportInfor) {
		// TODO Auto-generated method stub
		inportDao = new InpoutDao();
		return inportDao.queryInportInfors(inportInfor);
	}
	
	/***
	 * ≤È’“
	 */
	
	@Override
	public List<Inpout> query(Inpout inpout) {
		// TODO Auto-generated method stub
		inportDao = new InpoutDao();
		return inportDao.queryInport(inpout);
	}
	

}
