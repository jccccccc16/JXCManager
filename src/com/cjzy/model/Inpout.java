package com.cjzy.model;

import java.util.Date;

import com.cjzy.common.CommonUtils;

public class Inpout {
	
	private String id;
	private int number;
	private float price;
	private String comment;
	private String providerId;
	private Date inportTime;
	private String operatePerson;
	private String sponsor;
	private String paytype;
	private String goodsId;
	
	
	
	
	public Inpout() {
		super();
	}
	public Inpout(String id, int number, float price, String comment, String providerId, Date inportTime,
			String operatePerson, String sponsor, String payType, String goodsId) {
		super();
		this.id = id;
		this.number = number;
		this.price = price;
		this.comment = comment;
		this.providerId = providerId;
		this.inportTime =inportTime;
		this.operatePerson = operatePerson;
		this.sponsor = sponsor;
		this.paytype = payType;
		this.goodsId = goodsId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getInportTime() {
		
		return CommonUtils.dateToString(inportTime);
	}
	public void setInportTime(Date inportTime) {
		this.inportTime=inportTime;
	}
	public String getOperatePerson() {
		return operatePerson;
	}
	public void setOperatePerson(String operatePerson) {
		this.operatePerson = operatePerson;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	@Override
	public String toString() {
		return "Inpout [id=" + id + ", number=" + number + ", price=" + price + ", comment=" + comment + ", providerId="
				+ providerId + ", inportTime=" + inportTime + ", operatePerson=" + operatePerson + ", sponsor="
				+ sponsor + ", payType=" + paytype + ", goodsId=" + goodsId + "]";
	}
	
	
	

}
