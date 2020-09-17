package com.cjzy.model;

public class GoodInfo{
	private String id;
	private String goodsName;
	private String shorts;
	private String productPlace;
	private String size;
	private String packages;
	private String productCode;
	private String  promitCode;
	private double price;
	private String  memo;
	private String providerName;
	private String providerId;
	
	
	
	public GoodInfo() {
		super();
	}



	public GoodInfo(String id, String goodName, String shorts, String productPlace, String size, String packages,
			String productcode, String promitcode, double price, String memo, String providerName,String providerId) {
		super();
		this.id = id;
		this.goodsName = goodName;
		this.shorts = shorts;
		this.productPlace = productPlace;
		this.size = size;
		this.packages = packages;
		this.productCode = productcode;
		this.promitCode = promitcode;
		this.price = price;
		this.memo = memo;
		this.providerName = providerName;
		this.providerId=providerId;
	}



	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
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



	public void setGoodsName(String goodName) {
		this.goodsName = goodName;
	}



	public String getShorts() {
		return shorts;
	}



	public void setShorts(String shorts) {
		this.shorts = shorts;
	}



	public String getProductPlace() {
		return productPlace;
	}



	public void setProductPlace(String productPlace) {
		this.productPlace = productPlace;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



	public String getPackages() {
		return packages;
	}



	public void setPackages(String packages) {
		this.packages = packages;
	}



	



	public String getProductCode() {
		return productCode;
	}



	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}



	public String getPromitCode() {
		return promitCode;
	}



	public void setPromitCode(String promitCode) {
		this.promitCode = promitCode;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getMemo() {
		return memo;
	}



	public void setMemo(String memo) {
		this.memo = memo;
	}



	public String getProviderName() {
		return providerName;
	}



	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}



	@Override
	public String toString() {
		return "GoodInfo [id=" + id + ", goodName=" + goodsName + ", shorts=" + shorts + ", productPlace=" + productPlace
				+ ", size=" + size + ", packages=" + packages + ", productcode=" + productCode + ", promitcode="
				+ promitCode + ", price=" + price + ", memo=" + memo + ", providerName=" + providerName + "]";
	}
	
	
	
	
	
	
	
	
}
