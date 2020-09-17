package com.cjzy.model;

/***
 * ÏÂÀ­¿ò
 * @author 61702
 *
 */
public class Item {
	private String id;
	private String name;
	private String contacts;
	private String power;
	
	
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return  name;
	}
	
}
