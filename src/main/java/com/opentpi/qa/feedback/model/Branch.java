package com.opentpi.qa.feedback.model;

import java.io.Serializable;


public class Branch implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer branchNo;

	private String branchName;

	private Integer password;

	private Integer branchCompany;

	private Integer firstBranch;

	private String branchType;

	private String branchLevel;

	private String noticeUser;

	private String noticeTel;

	private String serNo;

	public Integer getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(Integer branchNo) {
		this.branchNo = branchNo;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setPassword(Integer password) {
		this.password = password;
	}
	
	public Integer getPassword() {
		return password;
	}
	
	public void setBranchCompany(Integer branchCompany) {
		this.branchCompany = branchCompany;
	}
	
	public Integer getBranchCompany() {
		return branchCompany;
	}
	
	public void setFirstBranch(Integer firstBranch) {
		this.firstBranch = firstBranch;
	}
	
	public Integer getFirstBranch() {
		return firstBranch;
	}
	
	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}
	
	public String getBranchType() {
		return branchType;
	}
	
	public void setBranchLevel(String branchLevel) {
		this.branchLevel = branchLevel;
	}
	
	public String getBranchLevel() {
		return branchLevel;
	}
	
	public void setNoticeUser(String noticeUser) {
		this.noticeUser = noticeUser;
	}
	
	public String getNoticeUser() {
		return noticeUser;
	}
	
	public void setNoticeTel(String noticeTel) {
		this.noticeTel = noticeTel;
	}
	
	public String getNoticeTel() {
		return noticeTel;
	}
	
	
	public void setSerNo(String serNo) {
		this.serNo = serNo;
	}
	
	public String getSerNo() {
		return serNo;
	}
}
