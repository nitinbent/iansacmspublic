package com.hamdibouallegue.datarestdemo.dto;

import java.io.Serializable;

public class LoginRequest implements Serializable{

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = 2546774670439137446L;
	
	
	private String userName;
	private String userPassword;
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	

}
