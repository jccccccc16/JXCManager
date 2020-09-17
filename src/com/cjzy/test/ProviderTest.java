package com.cjzy.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.Constants;
import com.cjzy.model.Customer;
import com.cjzy.model.Provider;
import com.cjzy.service.CustomerService;
import com.cjzy.service.ProviderService;

public class ProviderTest {
	

	ProviderService providerService = null;
	@Before
	public void init() {
		providerService = (ProviderService) CommonFactory.getProviderService();
	}
	
	/**
	 * 添加供应商
	 */
	@Test
	public void addProvider() {
		Provider provider=new Provider("PD1005","大台北奶茶店", "大台北"
				, "开平苍城", "529300", "13425874658", 
				"200-120", "张世强","13425874658", 
				"广东农业银行","1423567223", "10852@qq.789", 1);
		
		boolean result =providerService.addProvider(provider);
		if(result==true) {
			System.out.println("添加成功");
		}else {
			System.out.println("失败");
		}
	}
	
	@Test
	public void getProviderId() {
		// TODO Auto-generated method stub
		String idString = providerService.getProviderId();
		System.out.println(idString);
	}
	
	/**
	 * 查找
	 */
	@Test
	public void findProviders() {
		Provider provider =new Provider();
		provider.setShorts("英");
		List<Provider> list = providerService.findProviders(null);
		for (Provider provider2 : list) {
			System.out.println(provider2);
		}
	}
	
	/**
	 * 查找
	 */
	@Test
	public void findProvidersById() {
		Provider provider =new Provider();
		provider.setId("PD1001");
		List<Provider> list = providerService.findProviders(provider);
		for (Provider provider2 : list) {
			System.out.println(provider2);
		}
	}
	
	/**
	 * 根据全称查找
	 */
	@Test
	public void findProvidersByPorviderName() {
		Provider provider =new Provider();
		provider.setProviderName("英记糖水");
		List<Provider> list = providerService.findProviders(provider);
		for (Provider provider2 : list) {
			System.out.println(provider2);
		}
	}
	
	
	/**
	 * 根据简称查找
	 */
	@Test
	public void findProvidersByShorts() {
		Provider provider =new Provider();
		provider.setShorts("英记");
		List<Provider> list = providerService.findProviders(provider);
		for (Provider provider2 : list) {
			System.out.println(provider2);
		}
	}
	
	
	/**
	 * 根据联系人查找
	 */
	@Test
	public void findProvidersByContacts() {
		Provider provider =new Provider();
		provider.setContacts("关文英");
		List<Provider> list = providerService.findProviders(provider);
		for (Provider provider2 : list) {
			System.out.println(provider2);
		}
	}
	

}
