package com.cjzy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cjzy.common.Constants;
import com.cjzy.common.ErrorManager;
import com.cjzy.common.exception.CustomerExistException;
import com.cjzy.model.Customer;
import com.cjzy.model.Provider;

public class ProviderDao extends BaseDao {

	
	public boolean addProvider(Provider provider){
		String sql = "insert into t_provider values(#{id},#{providerName},#{shorts},#{address},#{zip},#{telephone},#{fax},#{contacts},#{contactsTel},#{bank},#{account},#{mail},1)";

		return update(sql, provider);

	}
	
	/**
	 * 生成客户编号
	 * 
	 * @return
	 */
	public String getProviderId() {
		String sql = "select MAX(id) id from t_provider";
		
		return getId(sql, "PD");
	}
	
	
	
	public List<Provider> findProviders(Provider provider) {
		String sql = null;

		// 解析结果集
		if (provider == null) {
			sql = "select * from t_provider where available=1";
		} else {
			if(provider.getId()!=null && !provider.getId().equals("")) {
				sql = "select * from t_provider where id=#{id} and available=1";
				
			}else if(provider.getProviderName()!=null && !provider.getProviderName().equals("")) { //全称查询
				sql = "select * from t_provider where provider_name like #{providerName} and available=1 ";
				
			}else if(provider.getShorts()!=null&&!provider.getShorts().equals("")) {
				sql = "select * from t_provider where shorts like #{shorts} and available=1 ";
				
			}else if(provider.getContacts()!=null&&!provider.getContacts().equals("")) {
				sql = "select * from t_provider where contacts like #{contacts} and available=1 ";
			}
		}
		return selectList(sql, provider, Provider.class);
	}

	
	/**
	 * 根据供应商标号修改客户信息
	 * @param customer
	 * @return
	 */
	public boolean updateProvider(Provider provider) {
		String sql = "update t_provider set provider_name=?,shorts=?,address=?,zip=?,telephone=?,fax=?,contacts=?,contacts_tel=?,bank=?,account=?,mail=? where id=?";
		Object[] params=new Object[] {provider.getProviderName(),provider.getShorts(),provider.getAddress(),provider.getZip(),
				provider.getTelephone(),provider.getFax(),provider.getContacts(),provider.getContactsTel(),provider.getBank(),provider.getAccount(),
				provider.getMail(),provider.getId()
				};
		return sqlManager.executeUpdate(sql, params,Constants.PSTM_TYPE);
		
	}
	
	
	/***
	 * 根据available 修改，0 ：删除，1：找回
	 * @param id
	 * @return
	 */
	public boolean updateProvider(String id,Integer available) {
		String sql = "update t_provider set available=? where id=?";
		Object[] params = new Object[] {available!=null?available:1,id};
		return sqlManager.executeUpdate(sql, params, Constants.PSTM_TYPE);
	}
	


}
