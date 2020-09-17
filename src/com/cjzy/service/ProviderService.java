package com.cjzy.service;

import java.util.List;

import com.cjzy.model.Provider;

/***
 * 供应商业务接口
 * @author 61702
 *
 */
public interface ProviderService {
	
	public boolean addProvider(Provider provider);

	public String getProviderId();
	
	public List<Provider> findProviders(Provider provider);
	
	public boolean updateProvider(Provider provider);
	
	public boolean updateProvider(String id,Integer available);

}
