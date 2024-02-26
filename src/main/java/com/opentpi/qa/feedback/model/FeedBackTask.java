package com.opentpi.qa.feedback.model;

import java.io.Serializable;

public class FeedBackTask implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer dataId;//主键ID

	private String taskName;//任务名称

	private String testDate;//测试日期

	private Integer recordState;//填报状态

	private Integer taskState;//任务状态

	private String createUser;//创建人

	private String joinUser;//参与人

	private String joinBranch;//参与分支机构

	private String fileCode;//文件编号

	private String issueDate;//发布日期

	private String fileInfo;//文件信息

	private String createTime;//创建时间
	
	private String serNo;//流水号

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	
	public Integer getDataId() {
		return dataId;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
	
	public String getTestDate() {
		return testDate;
	}
	
	public void setRecordState(Integer recordState) {
		this.recordState = recordState;
	}
	
	public Integer getRecordState() {
		return recordState;
	}
	
	public Integer getTaskState() {
		return taskState;
	}

	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	
	public void setJoinUser(String joinUser) {
		this.joinUser = joinUser;
	}
	
	public String getJoinUser() {
		return joinUser;
	}
	
	public void setJoinBranch(String joinBranch) {
		this.joinBranch = joinBranch;
	}
	
	public String getJoinBranch() {
		return joinBranch;
	}
	
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	
	public String getFileCode() {
		return fileCode;
	}
	
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	
	public String getIssueDate() {
		return issueDate;
	}
	
	public void setFileInfo(String fileInfo) {
		this.fileInfo = fileInfo;
	}
	
	public String getFileInfo() {
		return fileInfo;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	
	public void setSerNo(String serNo) {
		this.serNo = serNo;
	}
	
	public String getSerNo() {
		return serNo;
	}
}
