package com.cjzy.model;

/**|
 * ²Ù×÷Ô±bean
 * @author 61702
 *
 */

public class Operator {
	
	private String username;
	private String password;
	private String name;
	private String power;
	
	public Operator() {
		
	}
	public Operator(String username,String password) {
		this.username = username;
		this.password = password;
	}
	public Operator(String username,String password,String name,String power) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.power = power;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	
	@Override
	public String toString() {
		return "Operator [name=" + name + ", password=" + password + ", username=" + username + ", power=" + power
				+ "]";
	}
	
	
	
	
	

}
