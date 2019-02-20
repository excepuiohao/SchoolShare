package com.zhaohao.schoolshare.bean;

public class User {
	private String userId;
	private String userPassword;
	private int userCredit;
	private int userIntegral;
	private String userName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserCredit() {
		return userCredit;
	}
	public void setUserCredit(int userCredit) {
		this.userCredit = userCredit;
	}
	public int getUserIntegral() {
		return userIntegral;
	}
	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPassword=" + userPassword + ", userCredit=" + userCredit
				+ ", userIntegral=" + userIntegral + ", userName=" + userName + "]";
	}

}
