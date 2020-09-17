package com.cjzy.service.impl;

import java.util.List;

import com.cjzy.dao.InpoutDao;
import com.cjzy.dao.OutportDao;
import com.cjzy.model.InportInfor;
import com.cjzy.model.Inpout;
import com.cjzy.service.OutPortService;

/***
 * 进货退货业务接口实现
 * @author 61702
 *
 */
public class OutPortServiceImpl implements OutPortService{

	OutportDao outportDao;
	
	@Override
	public boolean addOutPort(Inpout outport) {
		// TODO Auto-generated method stub
		outportDao = new OutportDao();
		return outportDao.addOutPort(outport);
	}

	@Override
	public List<InportInfor> queryInportInfors(InportInfor inportInfor) {
		// TODO Auto-generated method stub
		outportDao = new OutportDao();
		return outportDao.queryInportInfors(inportInfor);
	}
	
	
	

}
