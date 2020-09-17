package com.cjzy.service.impl;

import java.util.List;

import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.dao.CustomerDao;
import com.cjzy.dao.ProviderDao;
import com.cjzy.model.Customer;
import com.cjzy.model.Provider;
import com.cjzy.service.ProviderService;

public class ProviderServiceImpl implements ProviderService{
	
	
	private ProviderDao providerDao = null;


	/***
	 * 添加供应商
	 */
	@Override
	public boolean addProvider(Provider provider) {
		// TODO Auto-generated method stub
		providerDao = new ProviderDao();
		return providerDao.addProvider(provider);
		
		
	}


	@Override
	public String getProviderId() {
		// TODO Auto-generated method stub
		providerDao = new ProviderDao();
		return providerDao.getProviderId();
	}
	
	/***
	 * 查找供应商
	 * @param customer
	 * @return
	 */
	@Override
	public List<Provider> findProviders(Provider provider) {
		// TODO Auto-generated method stub
		providerDao = new ProviderDao();
		return providerDao.findProviders(provider);
	}


	@Override
	public boolean updateProvider(Provider provider) {
		providerDao = new ProviderDao();
		return providerDao.updateProvider(provider);
	}


	@Override
	public boolean updateProvider(String id, Integer available) {
		// TODO Auto-generated method stub
		providerDao = new ProviderDao();
		return providerDao.updateProvider(id, available);
	}


	

}
