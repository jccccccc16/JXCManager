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
	 * ��ӹ�Ӧ��
	 */
	@Test
	public void addProvider() {
		Provider provider=new Provider("PD1005","��̨���̲��", "��̨��"
				, "��ƽ�Գ�", "529300", "13425874658", 
				"200-120", "����ǿ","13425874658", 
				"�㶫ũҵ����","1423567223", "10852@qq.789", 1);
		
		boolean result =providerService.addProvider(provider);
		if(result==true) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("ʧ��");
		}
	}
	
	@Test
	public void getProviderId() {
		// TODO Auto-generated method stub
		String idString = providerService.getProviderId();
		System.out.println(idString);
	}
	
	/**
	 * ����
	 */
	@Test
	public void findProviders() {
		Provider provider =new Provider();
		provider.setShorts("Ӣ");
		List<Provider> list = providerService.findProviders(null);
		for (Provider provider2 : list) {
			System.out.println(provider2);
		}
	}
	
	/**
	 * ����
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
	 * ����ȫ�Ʋ���
	 */
	@Test
	public void findProvidersByPorviderName() {
		Provider provider =new Provider();
		provider.setProviderName("Ӣ����ˮ");
		List<Provider> list = providerService.findProviders(provider);
		for (Provider provider2 : list) {
			System.out.println(provider2);
		}
	}
	
	
	/**
	 * ���ݼ�Ʋ���
	 */
	@Test
	public void findProvidersByShorts() {
		Provider provider =new Provider();
		provider.setShorts("Ӣ��");
		List<Provider> list = providerService.findProviders(provider);
		for (Provider provider2 : list) {
			System.out.println(provider2);
		}
	}
	
	
	/**
	 * ������ϵ�˲���
	 */
	@Test
	public void findProvidersByContacts() {
		Provider provider =new Provider();
		provider.setContacts("����Ӣ");
		List<Provider> list = providerService.findProviders(provider);
		for (Provider provider2 : list) {
			System.out.println(provider2);
		}
	}
	

}
