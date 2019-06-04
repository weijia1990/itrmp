/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskpro.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 开发任务跟进Entity
 * @author ygj
 * @version 2019-06-03
 */
public class DevelopTaskpro extends DataEntity<DevelopTaskpro> {
	
	private static final long serialVersionUID = 1L;
	private String requirementSource;		// 需求来源
	private String requirementClassify;		// 需求分类
	private String businessSystem;		// 业务系统
	private String requirementEmergency;		// 紧急程度
	private String taskTitle;		// 任务标题
	private String signNo;		// 签报号
	private Date acutalBeginTime;		// 实际开始日期
	private Date acutalEndTime;		// 实际结束时间
	private String executor;		// 执行人员
	private String acutalWorkAccounts;		// 实际工作量
	private String status;		// 状态
	private String developResult;		// 开发结果
	private String testResult;		// 测试结果
	private String taskId;		// 任务编号
	
	public DevelopTaskpro() {
		super();
	}

	public DevelopTaskpro(String id){
		super(id);
	}

	@Length(min=0, max=100, message="需求来源长度必须介于 0 和 100 之间")
	public String getRequirementSource() {
		return requirementSource;
	}

	public void setRequirementSource(String requirementSource) {
		this.requirementSource = requirementSource;
	}
	
	@Length(min=0, max=100, message="需求分类长度必须介于 0 和 100 之间")
	public String getRequirementClassify() {
		return requirementClassify;
	}

	public void setRequirementClassify(String requirementClassify) {
		this.requirementClassify = requirementClassify;
	}
	
	@Length(min=0, max=100, message="业务系统长度必须介于 0 和 100 之间")
	public String getBusinessSystem() {
		return businessSystem;
	}

	public void setBusinessSystem(String businessSystem) {
		this.businessSystem = businessSystem;
	}
	
	@Length(min=0, max=100, message="紧急程度长度必须介于 0 和 100 之间")
	public String getRequirementEmergency() {
		return requirementEmergency;
	}

	public void setRequirementEmergency(String requirementEmergency) {
		this.requirementEmergency = requirementEmergency;
	}
	
	@Length(min=0, max=1000, message="任务标题长度必须介于 0 和 1000 之间")
	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	@Length(min=0, max=1000, message="签报号长度必须介于 0 和 1000 之间")
	public String getSignNo() {
		return signNo;
	}

	public void setSignNo(String signNo) {
		this.signNo = signNo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAcutalBeginTime() {
		return acutalBeginTime;
	}

	public void setAcutalBeginTime(Date acutalBeginTime) {
		this.acutalBeginTime = acutalBeginTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getAcutalEndTime() {
		return acutalEndTime;
	}

	public void setAcutalEndTime(Date acutalEndTime) {
		this.acutalEndTime = acutalEndTime;
	}
	
	@Length(min=0, max=100, message="执行人员长度必须介于 0 和 100 之间")
	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}
	
	@Length(min=0, max=1000, message="实际工作量长度必须介于 0 和 1000 之间")
	public String getAcutalWorkAccounts() {
		return acutalWorkAccounts;
	}

	public void setAcutalWorkAccounts(String acutalWorkAccounts) {
		this.acutalWorkAccounts = acutalWorkAccounts;
	}
	
	@Length(min=0, max=1000, message="状态长度必须介于 0 和 1000 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=1000, message="开发结果长度必须介于 0 和 1000 之间")
	public String getDevelopResult() {
		return developResult;
	}

	public void setDevelopResult(String developResult) {
		this.developResult = developResult;
	}
	
	@Length(min=0, max=64, message="测试结果长度必须介于 0 和 64 之间")
	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	
	@Length(min=0, max=1000, message="任务编号长度必须介于 0 和 1000 之间")
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
}