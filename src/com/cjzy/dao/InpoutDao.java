package com.cjzy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.cjzy.common.Constants;
import com.cjzy.common.ErrorManager;
import com.cjzy.model.Good;
import com.cjzy.model.InportInfor;
import com.cjzy.model.Inpout;

public class InpoutDao extends BaseDao {
	

	/**
	 * ��ȡid
	 * 
	 * @return
	 */
	public String getId() {
		String prefix = "IP";
		return getId("select MAX(id) id from t_inport", prefix);
	}

	/**
	 * ���һ��
	 * 
	 * @param inpout
	 * @return
	 */
	public boolean addInpout(Inpout inpout) {
		String sql = "INSERT INTO t_inport VALUES(#{id},#{number},#{price},#{comment},#{providerId},#{inportTime},#{operatePerson},#{sponsor},#{paytype},#{goodsId})";
		return update(sql, inpout);
	}

	/**
	 * ��ɾ������
	 */

	public boolean delete(String id, Integer type) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM t_inport WHERE id = #{id}";
		// ��װ����
		Inpout inpout = new Inpout();
		inpout.setId(id);
		return update(sql, inpout);
	}

	/***
	 * ���²���
	 */

	public boolean update(Inpout t) {
		// TODO Auto-generated method stub
		String sql = "update t_inport set number=#{number},price=#{price},comment=#{comment}"
				+ ",provider_id=#{providerId},inport_time=#{inportTime},operateperson=#{operatePerson},sponsor=#{sponsor},paytype=#{payType},goods_id=#{goodsId} where id=#{id}";
		return update(sql, t);
	}
	
	/***
	 * ��ȡȫ��
	 * @param t
	 * @return
	 */
	public List<Inpout> queryInport(Inpout inpout) {
		// TODO Auto-generated method stub
		String sql  = null;
		if(inpout==null) {
			sql = "select * from t_inport";
		}else if(inpout.getId()!=null&&!inpout.getId().equals("")) {
			sql = "select * from t_inport where id = #{id}";
		}
		return selectList(sql, inpout,Inpout.class);
	}
	
	

	
	
	/***
	 * ����
	 * @param inportInfor
	 * @return
	 */
	public List<InportInfor> queryInportInfors(InportInfor inportInfor){
		String sql=null;
		if(inportInfor==null) {
			sql = "SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype FROM t_inport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id";
		}else {
			if(inportInfor.getId()!=null&&!inportInfor.getId().equals("")) {
				 sql =" SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype from t_inport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND i.id = #{id}";
			}else if(inportInfor.getProviderName()!=null&&!inportInfor.getProviderName().equals("")) {//���ݹ�Ӧ��
				 sql="SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype  FROM t_inport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND p.provider_name LIKE #{providerName}";
			}else if(inportInfor.getGoodsName()!=null&&!inportInfor.getGoodsName().equals("")) {//������Ʒ����
				 sql = "SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype FROM t_inport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND goods_name like #{goodsName}";
			}else if (inportInfor.getSponsor()!=null&&!inportInfor.getSponsor().equals("")) {//���ݾ�����
				 sql = "SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype FROM t_inport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND i.sponsor like #{sponsor}";
			}else if(inportInfor.getEndTime()!=null&&inportInfor.getStartTime()!=null) { //�������ڲ�ѯ
				 sql="SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype FROM t_inport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND inport_time BETWEEN #{startTime} AND #{endTime}";
			}
		}
		
		return selectList(sql, inportInfor, InportInfor.class);
	}


}
