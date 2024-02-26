package com.opentpi.qa.feedback.model;

import java.io.Serializable;

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer dataId;

	private String userName;

	private Integer password;
	
	private String serNo;

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	
	public Integer getDataId() {
		return dataId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setPassword(Integer password) {
		this.password = password;
	}
	
	public Integer getPassword() {
		return password;
	}
	
	
	public void setSerNo(String serNo) {
		this.serNo = serNo;
	}
	
	public String getSerNo() {
		return serNo;
	}
}
