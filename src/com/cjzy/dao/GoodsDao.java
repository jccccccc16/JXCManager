package com.cjzy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cjzy.common.Constants;
import com.cjzy.common.ErrorManager;
import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.model.Customer;
import com.cjzy.model.Good;
import com.cjzy.model.GoodInfo;

/***
 * ��Ʒdao
 * 
 * @author 61702
 *
 */
public class GoodsDao extends BaseDao {
	

	/**
	 * ��ӿͻ�
	 * 
	 * @return
	 */
	public boolean addGood(Good good) {
		String sql = "insert into t_goods values(#{id},#{goodsName},#{shorts},#{productPlace},#{size},#{packages},#{productCode},#{promitCode},#{price},#{memo},#{providerId},1)";
		return update(sql, good);

	}

	/**
	 * ������Ʒ���
	 * 
	 * @return
	 */
	public String getGoodId() {
		String sql = "select MAX(id) id from t_goods";
		return getId(sql, "GD");
	}

	/**
	 * ������Ʒ
	 * 
	 * @param c
	 * @return List<Customer>
	 */

	public List<Good> findGoods(Good c) {

		String sql = null;
		// ���������
		if (c == null) {
			sql = "select * from t_goods where available=1";
		} else {
			if (c.getId() != null && !c.getId().equals("")) {
				sql = "select * from t_goods where id=#{id}and available=1";

			} else if (c.getGoodsName() != null && !c.getGoodsName().equals("")) { // ȫ�Ʋ�ѯ
				sql = "select * from t_goods where goods_name like #{goodsName} and available=1 ";
			} else if (c.getShorts() != null && !c.getShorts().equals("")) {// ���
				sql = "select * from t_goods where shorts like #{shorts} and available=1 ";

			} else if (c.getProductPlace() != null && !c.getProductPlace().equals("")) {// ����
				sql = "select * from t_goods where product_place like #{productPlace} and available=1 ";
			}
		}
		return selectList(sql, c, Good.class);
	}

	
	/**
	 * ����goodInfo
	 * 
	 * @param c
	 * @return List<Goodinfo>
	 */
	public List<GoodInfo> findGoodInfo(GoodInfo c) {

		String sql = null;

		// ���������
		if (c == null) {
			sql = "select g.id,g.goods_name,g.shorts,g.product_place,g.size,g.packages,g.product_code,g.promit_code,g.price,g.memo,g.provider_id,p.provider_name from t_goods g,t_provider p"
					+ " where g.available=1 and g.provider_id=p.id";
		} else {
			if (c.getId() != null && !c.getId().equals("")) {
				sql = "select g.id,g.goods_name,g.shorts,g.product_place,g.size,g.packages,g.product_code,g.promit_code,"
						+ " g.price,g.memo,g.provider_id,p.provider_name from t_goods g,t_provider p "
						+ " where g.available=1 and g.provider_id=p.id and g.id =#{id}";

			} else if (c.getGoodsName() != null && !c.getGoodsName().equals("")) { // ȫ�Ʋ�ѯ
				sql = "select g.id,g.goods_name,g.shorts,g.product_place,g.size,g.packages,g.product_code,g.promit_code,"
						+ " g.price,g.memo,g.provider_id,p.provider_name from t_goods g,t_provider p "
						+ " where g.available=1 and g.provider_id=p.id and g.goods_name like #{goodsName}";

			} else if (c.getShorts() != null && !c.getShorts().equals("")) {// ���
				sql = "select g.id,g.goods_name,g.shorts,g.product_place,g.size,g.packages,g.product_code,g.promit_code,"
						+ " g.price,g.memo,g.provider_id,p.provider_name from t_goods g,t_provider p "
						+ " where g.available=1 and g.provider_id=p.id and g.shorts like #{shorts}";

			} else if (c.getProviderName() != null && !c.getProviderName().equals("")) {// ��Ӧ��ȫ��
				sql = "select g.id,g.goods_name,g.shorts,g.product_place,g.size,g.packages,g.product_code,g.promit_code,"
						+ " g.price,g.memo,g.provider_id,p.provider_name from t_goods g,t_provider p "
						+ " where g.available=1 and g.provider_id=p.id and p.provider_name like #{providerName}";

			} else if (c.getProviderId() != null && !c.getProviderId().equals("")) {// ��Ӧ��ȫ��
				sql = "select g.id,g.goods_name,g.shorts,g.product_place,g.size,g.packages,g.product_code,g.promit_code,"
						+ " g.price,g.memo,g.provider_id,p.provider_name from t_goods g,t_provider p "
						+ " where g.available=1 and g.provider_id=p.id and p.id = #{providerId}";

			}
		}

		return selectList(sql, c, GoodInfo.class);

	}

	/**
	 * ������Ʒ����޸���Ʒ��Ϣ
	 * 
	 * @param good
	 * @return boolean
	 */
	public boolean updateGood(Good good) {
		String sql = "update t_goods set goods_name=#{goodsName},shorts=#{shorts},product_place=#{productPlace},size=#{size},packages=#{packages},product_code=#{productCode},promit_code=#{promitCode},price=#{price},memo=#{memo},provider_id=#{providerId},available=1 where id=#{id}";
		return update(sql, good);

	}

	/***
	 * ����available �޸ģ�0 ��ɾ����1���һ�
	 * 
	 * @param id
	 * @return
	 */
	public boolean updateGood(String id, Integer available) {
		String sql = "update t_goods set available=#{available} where id=#{id}";
		Good good = new Good();
		good.setId(id);
		good.setAvailable(available);
		return update(sql, good);
	}

}
