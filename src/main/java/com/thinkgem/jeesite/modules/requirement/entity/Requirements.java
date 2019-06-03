/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.google.common.collect.Lists;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 需求管理Entity
 * 
 * @author weijia
 * @version 2019-05-28
 */
public class Requirements extends DataEntity<Requirements> {

	private static final long serialVersionUID = 1L;
	private String requirementSource; // 需求来源
	private String requirementClassify; // 需求分类
	private String businessSystem; // 业务系统
	private String requirementEmergency; // 需求紧急程度
	private String expectAndIntention; // 业务期待及意向简介
	private String signNo; // 签报号
	private Date expectOnline; // 期望上线时间
	private String relatedBusinessRequirements; // 关联性业务需求
	private String reasonsChange; // 变更原因
	private String currentBusiProcScenario; // 当前业务处理方案
	private String submitTo; // 提请方
	private String requiremenPresentationOffice; // 需求提出处室
	private String isAllocation; // 是否分配
	private String proposer; // 申请人
	private String contact; // 联系方式
	private String requirementCauseDescription; // 需求原因描述
	private String requirementContent; // 需求内容
	private String annexList; // 资料附件清单
	private String requirementAcceptancePerson; // 需求验收联系人
	private String requirementAcceptancePhone; // 联系电话
	private String requirementStatus; // 需求状态
	private String relatedBusinessDemand; // 关联业务需求
	private String comments; // 备注
	private String lastUpdate; // 最后更新者
	private Date latUpdateTime; // 最后更新时间
	private List<Problem> problemList = Lists.newArrayList(); // 子表列表

	public Requirements() {
		super();
	}

	public Requirements(String id) {
		super(id);
	}

	@Length(min = 0, max = 50, message = "需求来源长度必须介于 0 和 50 之间")
	public String getRequirementSource() {
		return requirementSource;
	}

	public void setRequirementSource(String requirementSource) {
		this.requirementSource = requirementSource;
	}

	@Length(min = 0, max = 50, message = "需求分类长度必须介于 0 和 50 之间")
	public String getRequirementClassify() {
		return requirementClassify;
	}

	public void setRequirementClassify(String requirementClassify) {
		this.requirementClassify = requirementClassify;
	}

	@Length(min = 0, max = 50, message = "业务系统长度必须介于 0 和 50 之间")
	public String getBusinessSystem() {
		return businessSystem;
	}

	public void setBusinessSystem(String businessSystem) {
		this.businessSystem = businessSystem;
	}

	@Length(min = 0, max = 50, message = "需求紧急程度长度必须介于 0 和 50 之间")
	public String getRequirementEmergency() {
		return requirementEmergency;
	}

	public void setRequirementEmergency(String requirementEmergency) {
		this.requirementEmergency = requirementEmergency;
	}

	@Length(min = 0, max = 200, message = "业务期待及意向简介长度必须介于 0 和 200 之间")
	public String getExpectAndIntention() {
		return expectAndIntention;
	}

	public void setExpectAndIntention(String expectAndIntention) {
		this.expectAndIntention = expectAndIntention;
	}

	@Length(min = 0, max = 100, message = "签报号长度必须介于 0 和 100 之间")
	public String getSignNo() {
		return signNo;
	}

	public void setSignNo(String signNo) {
		this.signNo = signNo;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExpectOnline() {
		return expectOnline;
	}

	public void setExpectOnline(Date expectOnline) {
		this.expectOnline = expectOnline;
	}

	@Length(min = 0, max = 1000, message = "关联性业务需求长度必须介于 0 和 1000 之间")
	public String getRelatedBusinessRequirements() {
		return relatedBusinessRequirements;
	}

	public void setRelatedBusinessRequirements(String relatedBusinessRequirements) {
		this.relatedBusinessRequirements = relatedBusinessRequirements;
	}

	@Length(min = 0, max = 1000, message = "变更原因长度必须介于 0 和 1000 之间")
	public String getReasonsChange() {
		return reasonsChange;
	}

	public void setReasonsChange(String reasonsChange) {
		this.reasonsChange = reasonsChange;
	}

	@Length(min = 0, max = 1000, message = "当前业务处理方案长度必须介于 0 和 1000 之间")
	public String getCurrentBusiProcScenario() {
		return currentBusiProcScenario;
	}

	public void setCurrentBusiProcScenario(String currentBusiProcScenario) {
		this.currentBusiProcScenario = currentBusiProcScenario;
	}

	@Length(min = 0, max = 50, message = "提请方长度必须介于 0 和 50 之间")
	public String getSubmitTo() {
		return submitTo;
	}

	public void setSubmitTo(String submitTo) {
		this.submitTo = submitTo;
	}

	@Length(min = 0, max = 50, message = "需求提出处室长度必须介于 0 和 50 之间")
	public String getRequiremenPresentationOffice() {
		return requiremenPresentationOffice;
	}

	public void setRequiremenPresentationOffice(String requiremenPresentationOffice) {
		this.requiremenPresentationOffice = requiremenPresentationOffice;
	}

	@Length(min = 0, max = 1, message = "是否分配必须介于 0 和 1 之间")
	public String getIsAllocation() {
		return isAllocation;
	}

	public void setIsAllocation(String isAllocation) {
		this.isAllocation = isAllocation;
	}

	@Length(min = 0, max = 50, message = "申请人长度必须介于 0 和 50 之间")
	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	@Length(min = 0, max = 50, message = "联系方式长度必须介于 0 和 50 之间")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Length(min = 0, max = 500, message = "需求原因描述长度必须介于 0 和 500 之间")
	public String getRequirementCauseDescription() {
		return requirementCauseDescription;
	}

	public void setRequirementCauseDescription(String requirementCauseDescription) {
		this.requirementCauseDescription = requirementCauseDescription;
	}

	@Length(min = 0, max = 500, message = "需求内容长度必须介于 0 和 500 之间")
	public String getRequirementContent() {
		return requirementContent;
	}

	public void setRequirementContent(String requirementContent) {
		this.requirementContent = requirementContent;
	}

	@Length(min = 0, max = 500, message = "资料附件清单长度必须介于 0 和 500 之间")
	public String getAnnexList() {
		return annexList;
	}

	public void setAnnexList(String annexList) {
		this.annexList = annexList;
	}

	@Length(min = 0, max = 50, message = "需求验收联系人长度必须介于 0 和 50 之间")
	public String getRequirementAcceptancePerson() {
		return requirementAcceptancePerson;
	}

	public void setRequirementAcceptancePerson(String requirementAcceptancePerson) {
		this.requirementAcceptancePerson = requirementAcceptancePerson;
	}

	@Length(min = 0, max = 50, message = "联系电话长度必须介于 0 和 50 之间")
	public String getRequirementAcceptancePhone() {
		return requirementAcceptancePhone;
	}

	public void setRequirementAcceptancePhone(String requirementAcceptancePhone) {
		this.requirementAcceptancePhone = requirementAcceptancePhone;
	}

	@Length(min = 0, max = 20, message = "需求状态长度必须介于 0 和 20 之间")
	public String getRequirementStatus() {
		return requirementStatus;
	}

	public void setRequirementStatus(String requirementStatus) {
		this.requirementStatus = requirementStatus;
	}

	@Length(min = 0, max = 20, message = "关联业务需求长度必须介于 0 和 20 之间")
	public String getRelatedBusinessDemand() {
		return relatedBusinessDemand;
	}

	public void setRelatedBusinessDemand(String relatedBusinessDemand) {
		this.relatedBusinessDemand = relatedBusinessDemand;
	}

	@Length(min = 0, max = 500, message = "备注长度必须介于 0 和 500 之间")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Length(min = 0, max = 20, message = "最后更新者长度必须介于 0 和 20 之间")
	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLatUpdateTime() {
		return latUpdateTime;
	}

	public void setLatUpdateTime(Date latUpdateTime) {
		this.latUpdateTime = latUpdateTime;
	}

	public List<Problem> getProblemList() {
		return problemList;
	}

	public void setProblemList(List<Problem> problemList) {
		this.problemList = problemList;
	}
}