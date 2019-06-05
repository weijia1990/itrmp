/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtask.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 开发任务创建Entity
 * @author ygj
 * @version 2019-05-31
 */
public class DevTask extends DataEntity<DevTask> {
	
	private static final long serialVersionUID = 1L;
	private String requirementSource;		// 需求来源
	private String requirementClassify;		// 需求分类
	private String businessSystem;		// 业务系统
	private String requirementEmergency;		// 需求紧急程度
	private String taskTitle;		// 任务标题
	private String signNo;		// 签报号
	private String personIncgarge;		// 负责人
	private String majorSystem;		// 主系统
	private String relatedSystem;		// 涉及系统
	private String developTaskCancelTime;		// 开发任务撤销日期
	private Date exceptOnline;		// 期望上线时间
	private String comments;		// 备注
	private String taskDesc;		// 任务概述
	private String attachment;		// 附件
	private Date explanEnd;		// 计划结束日期
	private String executor;		// 执行人员
	private String explanWorkCacounts;		// 计划工作量
	private Date expactFinish;		// 预计完成时间
	private String developTaskCancelDesc;		// 开发任务撤销说明
	private Date explanBegin;		// 计划开始日期
	private String requerstId;   
	private String isAssign;
	private String isCancel;
	private String ispro;
	
	
	
	public String getIsAssign() {
		return isAssign;
	}

	public void setIsAssign(String isAssign) {
		this.isAssign = isAssign;
	}

	public String getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}

	public String getIspro() {
		return ispro;
	}

	public void setIspro(String ispro) {
		this.ispro = ispro;
	}

	public DevTask() {
		super();
	}

	public String getRequerstId() {
		return requerstId;
	}

	public void setRequerstId(String requerstId) {
		this.requerstId = requerstId;
	}

	public DevTask(String id){
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
	
	@Length(min=0, max=100, message="需求紧急程度长度必须介于 0 和 100 之间")
	public String getRequirementEmergency() {
		return requirementEmergency;
	}

	public void setRequirementEmergency(String requirementEmergency) {
		this.requirementEmergency = requirementEmergency;
	}
	
	@Length(min=0, max=200, message="任务标题长度必须介于 0 和 200 之间")
	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	@Length(min=0, max=20, message="签报号长度必须介于 0 和 20 之间")
	public String getSignNo() {
		return signNo;
	}

	public void setSignNo(String signNo) {
		this.signNo = signNo;
	}
	
	@Length(min=0, max=100, message="负责人长度必须介于 0 和 100 之间")
	public String getPersonIncgarge() {
		return personIncgarge;
	}

	public void setPersonIncgarge(String personIncgarge) {
		this.personIncgarge = personIncgarge;
	}
	
	@Length(min=0, max=200, message="主系统长度必须介于 0 和 200 之间")
	public String getMajorSystem() {
		return majorSystem;
	}

	public void setMajorSystem(String majorSystem) {
		this.majorSystem = majorSystem;
	}
	
	@Length(min=0, max=100, message="涉及系统长度必须介于 0 和 100 之间")
	public String getRelatedSystem() {
		return relatedSystem;
	}

	public void setRelatedSystem(String relatedSystem) {
		this.relatedSystem = relatedSystem;
	}
	
	@Length(min=0, max=1000, message="开发任务撤销日期长度必须介于 0 和 1000 之间")
	public String getDevelopTaskCancelTime() {
		return developTaskCancelTime;
	}

	public void setDevelopTaskCancelTime(String developTaskCancelTime) {
		this.developTaskCancelTime = developTaskCancelTime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExceptOnline() {
		return exceptOnline;
	}

	public void setExceptOnline(Date exceptOnline) {
		this.exceptOnline = exceptOnline;
	}
	
	@Length(min=0, max=1000, message="备注长度必须介于 0 和 1000 之间")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Length(min=0, max=1000, message="任务概述长度必须介于 0 和 1000 之间")
	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	
	@Length(min=0, max=1000, message="附件长度必须介于 0 和 1000 之间")
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExpactFinish() {
		return expactFinish;
	}

	public void setExpactFinish(Date expactFinish) {
		this.expactFinish = expactFinish;
	}
	
	@Length(min=0, max=1000, message="开发任务撤销说明长度必须介于 0 和 1000 之间")
	public String getDevelopTaskCancelDesc() {
		return developTaskCancelDesc;
	}

	public void setDevelopTaskCancelDesc(String developTaskCancelDesc) {
		this.developTaskCancelDesc = developTaskCancelDesc;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExplanBegin() {
		return explanBegin;
	}

	public void setExplanBegin(Date explanBegin) {
		this.explanBegin = explanBegin;
	}
	
}