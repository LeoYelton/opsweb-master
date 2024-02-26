package com.opentpi.qa.feedback.model;

import java.io.Serializable;


public class Record implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer dataId;//主键ID

	private Integer taskId;//任务ID

	private Integer taskState;//任务状态
	
	private Integer branchId;//营业部号
	
	private String recordor;//填报人
	
	private String joinUser;//参与人
	
	private Integer resultType;//测试结论
	
	private String fileName;//测试反馈表

	private String tel;//联系电话

	private String result;//测试结果

	private String createTime;//创建时间
	
	private String recordTime;//记录时间
	
	
	//@ApiModelProperty(hidden=true)
	private String serNo;//流水号

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	
	public Integer getDataId() {
		return dataId;
	}
	
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	public Integer getTaskId() {
		return taskId;
	}
	
	public Integer getTaskState() {
		return taskState;
	}

	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	
	public Integer getBranchId() {
		return branchId;
	}
	
	public void setRecordor(String recordor) {
		this.recordor = recordor;
	}
	
	public String getRecordor() {
		return recordor;
	}
	
	public void setJoinUser(String joinUser) {
		this.joinUser = joinUser;
	}
	
	public String getJoinUser() {
		return joinUser;
	}
	
	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}
	
	public Integer getResultType() {
		return resultType;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	
	public String getRecordTime() {
		return recordTime;
	}
	
	
	public void setSerNo(String serNo) {
		this.serNo = serNo;
	}
	
	public String getSerNo() {
		return serNo;
	}
}
