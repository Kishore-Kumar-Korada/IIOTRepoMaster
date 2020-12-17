package com.kishorekumarkorada.IIOTDataVisualizer.model;

public class UserModel {
	
	private String userName;
	private String userLoginId;
	private String userLoginPassword;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getUserLoginPassword() {
		return userLoginPassword;
	}
	public void setUserLoginPassword(String userLoginPassword) {
		this.userLoginPassword = userLoginPassword;
	}
	
	@Override
	public String toString() {
		return this.userName+" "+this.userLoginId;
	}
}
