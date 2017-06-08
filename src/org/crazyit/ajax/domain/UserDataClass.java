package org.crazyit.ajax.domain;

public class UserDataClass {
	
	private static int id = 1002;
	private String name;
	private String phone;
	
	public UserDataClass(){
		
	}
	
	public UserDataClass(String _name, String _phone) {
		this.name = _name;
		this.phone = _phone;
	}
	
	public void setUser(String _name, String _phone) {
		//增加新用户
		id++;
		this.name = _name;
		this.phone = _phone;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
}
