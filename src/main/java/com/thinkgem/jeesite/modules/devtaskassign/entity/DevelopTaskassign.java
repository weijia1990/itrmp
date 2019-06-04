/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskassign.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 开发任务指派Entity
 * @author ygj
 * @version 2019-06-03
 */
public class DevelopTaskassign extends DataEntity<DevelopTaskassign> {
	
	private static final long serialVersionUID = 1L;
	private String requirementSource;		// 需求来源
	private String requirementClassify;		// 需求分类
	private String businessSystem;		// 业务系统
	private String requirementEmergency;		// 紧急程度
	private String taskTitle;		// 任务标题
	private String signNo;		// 签报号
	private Date explanBegin;		// 计划开始日期
	private Date explanEnd;		// 计划结束日期
	private String executor;		// 执行人员
	private String explanWorkCacounts;		// 计划工作量
	private String taskDesc;		// 任务概述
	private String taskId;		// 任务编号
	
	public DevelopTaskassign() {
		super();
	}

	public DevelopTaskassign(String id){
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
	
	@Length(min=0, max=20, message="任务标题长度必须介于 0 和 20 之间")
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
	public Date getExplanBegin() {
		return explanBegin;
	}

	public void setExplanBegin(Date explanBegin) {
		this.explanBegin = explanBegin;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExplanEnd() {
		return explanEnd;
	}

	public void setExplanEnd(Date explanEnd) {
		this.explanEnd = explanEnd;
	}
	
	@Length(min=0, max=1000, message="执行人员长度必须介于 0 和 1000 之间")
	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}
	
	@Length(min=0, max=1000, message="计划工作量长度必须介于 0 和 1000 之间")
	public String getExplanWorkCacounts() {
		return explanWorkCacounts;
	}

	public void setExplanWorkCacounts(String explanWorkCacounts) {
		this.explanWorkCacounts = explanWorkCacounts;
	}
	
	@Length(min=0, max=1000, message="任务概述长度必须介于 0 和 1000 之间")
	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	
	@Length(min=0, max=1000, message="任务编号长度必须介于 0 和 1000 之间")
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
}