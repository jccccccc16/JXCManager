package com.cjzy.model;

public class Provider {

	private String id;
	private String providerName;
	private String shorts;
	private String address;
	private String zip;
	private String telephone;
	private String fax;
	private String contacts;
	private String contactsTel;
	private String bank;
	private String account;
	private String mail;
	private int available;
	
	
	
	public Provider() {
		super();
	}



	public Provider(String id, String providerName, String shorts, String address, String zip, String telephone,
			String fax, String contacts, String contactsTel, String bank, String account, String mail, int available) {
		super();
		this.id = id;
		this.providerName = providerName;
		this.shorts = shorts;
		this.address = address;
		this.zip = zip;
		this.telephone = telephone;
		this.fax = fax;
		this.contacts = contacts;
		this.contactsTel = contactsTel;
		this.bank = bank;
		this.account = account;
		this.mail = mail;
		this.available = available;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getProviderName() {
		return providerName;
	}



	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}



	public String getShorts() {
		return shorts;
	}



	public void setShorts(String shorts) {
		this.shorts = shorts;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getZip() {
		return zip;
	}



	public void setZip(String zip) {
		this.zip = zip;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getFax() {
		return fax;
	}



	public void setFax(String fax) {
		this.fax = fax;
	}



	public String getContacts() {
		return contacts;
	}



	public void setContacts(String contacts) {
		this.contacts = contacts;
	}



	public String getContactsTel() {
		return contactsTel;
	}



	public void setContactsTel(String contactsTel) {
		this.contactsTel = contactsTel;
	}



	public String getBank() {
		return bank;
	}



	public void setBank(String bank) {
		this.bank = bank;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public int getAvailable() {
		return available;
	}



	public void setAvailable(int available) {
		this.available = available;
	}



	@Override
	public String toString() {
		return "Provider [id=" + id + ", providerName=" + providerName + ", shorts=" + shorts + ", address=" + address
				+ ", zip=" + zip + ", telephone=" + telephone + ", fax=" + fax + ", contacts=" + contacts
				+ ", contactsTel=" + contactsTel + ", bank=" + bank + ", account=" + account + ", mail=" + mail
				+ ", available=" + available + "]";
	}
	

}
