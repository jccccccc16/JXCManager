package com.cjzy.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cjzy.common.CommonFactory;
import com.cjzy.common.Constants;
import com.cjzy.dao.Utils;
import com.cjzy.model.Customer;
import com.cjzy.model.Good;
import com.cjzy.model.GoodInfo;
import com.cjzy.service.GoodService;
import com.cjzy.service.impl.GoodServiceImpl;

public class GoodTest {
	GoodService goodService;
	
	@Before
	public void init() {
		goodService = CommonFactory.getGoodService();
	}
	
	@Test
	public void addGood() {
		Good good = new Good("GD1005", "50���ʵ�", "�ʵ�", "��ɽ", 
				"50��", "�а�װ", "200-200", "permit100", 
				2000, "meno100", "PD1001", 1);
		boolean addGood = goodService.addGood(good);
		if(addGood) {
			System.out.println("��ӳɹ�");
		}else {
			System.out.println("���ʧ��");
		}
	}
	
	@Test
	public void getGoodId() {
		
		String id = goodService.getGoodId();
		System.out.println(id);
	}
	
	@Test
	public void findGoods() {
		List<Good> goods = goodService.findGoods(null);
		for (Good good : goods) {
			System.out.println(good);
		}
	}
	
	@Test
	public void findByShorts() {
		Good good = new Good();
		good.setShorts("�ʵ�");
		List<Good> findGoods = goodService.findGoods(good);
		if(findGoods!=null) {
			Good good2 = findGoods.get(0);
			System.out.println(good2);
		}else {
			System.out.println("��Ʒ������");
		}
	}
	
	
	@Test
	public void findByGoodsName() {
		Good good = new Good();
		good.setGoodsName("��ʵ�");
		List<Good> findGoods = goodService.findGoods(good);
		if(findGoods!=null) {
			for (Good good2 : findGoods) {
				System.out.println(good2);
			}
		}else {
			System.out.println("��Ʒ������");
		}
	}
	
	@Test
	public void findByPlace() {
		Good good = new Good();
		good.setProductPlace("��ɽ");
		List<Good> findGoods = goodService.findGoods(good);
		if(findGoods!=null) {
			Good good2 = findGoods.get(0);
			System.out.println(good2);
		}else {
			System.out.println("��Ʒ������");
		}
	}
	
	/***
	 * �޸���Ϣ
	 */
	@Test
	public void updateGood() {
		Good good = new Good("GD1005", "40���ʵ�", "�ʵ�", "��ɽ", 
				"40��", "�а�װ", "200-200", "permit100", 
				1000, "meno100", "PD1001", 1);
		boolean result = goodService.updateGood(good);
		if(result==true) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	
	
	@Test
	public void deleteGood() {
		boolean result = goodService.updateGood("GD1001",Constants.DATA_DEL);
		if(result==true) {
			System.out.println("ɾ��/�һسɹ�");
		}else {
			System.out.println("ɾ��/�һ�ʧ��");
		}
	}
	
	@Test
	public void findGoodInfo() {
		GoodInfo goodInfo = new GoodInfo();
		goodInfo.setProviderId("PD1001");
		List<GoodInfo> findGoodInfo = goodService.findGoodInfo(goodInfo);
		for (GoodInfo goodInfo2 : findGoodInfo) {
			System.out.println(goodInfo2.toString());
		}
	}
	
	@Test
	public void sqlget() {
		Good good = new Good("GD1005", "50���ʵ�", "�ʵ�", "��ɽ", 
				"50��", "�а�װ", "200-200", "permit100", 
				1000, "meno100", "PD1001", 1);
		String sql = "insert into t_goods values(#{id},#{goodsName},#{shorts},#{productPlace},#{size},#{packages},#{productCode},#{promitCode},#{price},#{memo},#{providerId},1)";
		String sqlWithingValue = Utils.getSqlWithingValue(sql, good);
		System.out.println(sqlWithingValue);
	}
	

}
