package com.app.service.bean;

import java.io.Serializable;

public class ItemBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String name;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", name=" + name + "]";
	}
	
	public ItemBean() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemBean(String userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

}
