package com.cjzy.model;

import java.util.Date;

import com.cjzy.common.CommonUtils;

public class InportInfor {
	
	private String id;
	private String goodsName;
	private int number;
	private float price;
	private String providerName;
	private String comment;
	private Date inportTime;
	private String operatePerson;
	private String sponsor;
	private String paytype;
	private String startTime;
	private String endTime;
	
	
	public InportInfor() {
		super();
	}

	public InportInfor(String id, String goodsName, int number, float price, String providerName, String comment,
			Date inportTime, String operatorName, String sponsor, String payType) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.number = number;
		this.price = price;
		this.providerName = providerName;
		this.comment = comment;
		this.inportTime = inportTime;
		this.operatePerson = operatorName;
		this.sponsor = sponsor;
		this.paytype = payType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getInportTime() {
		return CommonUtils.dateToString(inportTime);
	}

	public void setInportTime(Date inportTime) {
		this.inportTime = inportTime;
	}

	public String getOperatePerson() {
		return operatePerson;
	}

	public void setOperatePerson(String operatorName) {
		this.operatePerson = operatorName;
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

	@Override
	public String toString() {
		return "InportInfor [id=" + id + ", goodsName=" + goodsName + ", number=" + number + ", price=" + price
				+ ", providerName=" + providerName + ", comment=" + comment + ", inportTime=" + inportTime
				+ ", operatorName=" + operatePerson + ", sponsor=" + sponsor + ", payType=" + paytype + "]";
	}
	
	
	

}
