package com.cjzy.dao;

import java.util.List;

import com.cjzy.model.InportInfor;
import com.cjzy.model.Inpout;

public class OutportDao extends BaseDao{
	

	

	/***
	 * ����
	 * @param t
	 * @return
	 */
	public List<Inpout> query(Inpout inpout) {
		// TODO Auto-generated method stub
		String sql  = null;
		if(inpout==null) {
			sql = "select * from t_outport";
		}else if(inpout.getId()!=null&&!inpout.getId().equals("")) {
			sql = "select * from t_outport where id = #{id}";
		}
		return selectList(sql, inpout,Inpout.class);
	}
	
	
	
	/***
	 * �����˻���Ϣ
	 * @param inportInfor
	 * @return
	 */
	public List<InportInfor> queryInportInfors(InportInfor inportInfor){
		String sql=null;
		if(inportInfor==null) {
			sql = "SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype FROM t_outport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id";
		}else {
			if(inportInfor.getId()!=null&&!inportInfor.getId().equals("")) {
				 sql =" SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype from t_outport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND i.id = #{id}";
			}else if(inportInfor.getProviderName()!=null&&!inportInfor.getProviderName().equals("")) {//���ݹ�Ӧ��
				 sql="SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype  FROM t_outport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND p.provider_name LIKE #{providerName}";
			}else if(inportInfor.getGoodsName()!=null&&!inportInfor.getGoodsName().equals("")) {//������Ʒ����
				 sql = "SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype FROM t_outport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND goods_name like #{goodsName}";
			}else if (inportInfor.getSponsor()!=null&&!inportInfor.getSponsor().equals("")) {//���ݾ�����
				 sql = "SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype FROM t_outport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND i.sponsor like #{sponsor}";
			}else if(inportInfor.getEndTime()!=null&&inportInfor.getStartTime()!=null) { //�������ڲ�ѯ
				 sql="SELECT i.id,g.goods_name,i.number,i.price,p.provider_name,i.comment,i.inport_time,i.operate_person,i.sponsor,i.paytype FROM t_outport i, t_goods g,t_provider p WHERE i.goods_id = g.id AND i.provider_id = p.id AND inport_time BETWEEN #{startTime} AND #{endTime}";
			}
		}
		
		return selectList(sql, inportInfor, InportInfor.class);
	}

	
	
	
	
	/**
	 * ���һ��
	 * 
	 * @param inpout
	 * @return
	 */
	public boolean addOutPort(Inpout outPort) {
		String sql = "INSERT INTO t_outport VALUES(#{id},#{number},#{price},#{comment},#{providerId},#{inportTime},#{operatePerson},#{sponsor},#{paytype},#{goodsId})";
		return update(sql, outPort);
	}
}
