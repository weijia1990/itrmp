/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchild.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.persistence.ActEntity;
import com.thinkgem.jeesite.modules.childexamine.entity.RequirementChildExamine;
import com.thinkgem.jeesite.modules.childexamine.entity.RequirementFile;
import com.thinkgem.jeesite.modules.requirementchildpro.entity.RequirementproChild;

/**
 * 子需求管理Entity
 * 
 * @author weijia
 * @version 2019-06-02
 */

public class RequirementChild extends ActEntity<RequirementChild> {

	private static final long serialVersionUID = 1L;
	private String requirements; // 需求编号
	private String requirementChildTitle; // 子需求标题
	private String itemBelonds; // 项目归属
	private String businessSystem; // 业务系统
	private String requirementEmergency; // 需求紧急程度
	private Date exceptFinish; // 预计完成时间
	private String responsibleTaxPerson; // 受理人
	private String relatedBusinessRequirements; // 关联性业务需求
	private String demandNo; // 需求编号
	private String targetDesc; // 目标描述
	private String contact; // 需求内容
	private String appendix; // 附件
	private String demandApprovePerson; // 需求审批联系人
	private String demandApprovePhone; // 需求审批联系人联系电话
	private String comments; // 备注
	private List<ProblemChild> ProblemChildList = Lists.newArrayList(); // 子表列表
	private List<RequirementChildExamine> requirementChildExamineList = Lists.newArrayList(); // 子表列表
	private List<RequirementFile> requirementFileList = Lists.newArrayList(); // 子表列表
	private List<RequirementproChild> requirementproChildList = Lists.newArrayList(); // 子表列表

	public RequirementChild() {
		super();
	}

	public RequirementChild(String id) {
		super(id);
	}

	@Length(min = 0, max = 32, message = "需求编号长度必须介于 0 和 32 之间")
	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	@Length(min = 0, max = 50, message = "子需求标题长度必须介于 0 和 50 之间")
	public String getRequirementChildTitle() {
		return requirementChildTitle;
	}

	public void setRequirementChildTitle(String requirementChildTitle) {
		this.requirementChildTitle = requirementChildTitle;
	}

	@Length(min = 0, max = 50, message = "项目归属长度必须介于 0 和 50 之间")
	public String getItemBelonds() {
		return itemBelonds;
	}

	public void setItemBelonds(String itemBelonds) {
		this.itemBelonds = itemBelonds;
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

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExceptFinish() {
		return exceptFinish;
	}

	public void setExceptFinish(Date exceptFinish) {
		this.exceptFinish = exceptFinish;
	}

	@Length(min = 0, max = 1000, message = "受理人长度必须介于 0 和 1000 之间")
	public String getResponsibleTaxPerson() {
		return responsibleTaxPerson;
	}

	public void setResponsibleTaxPerson(String responsibleTaxPerson) {
		this.responsibleTaxPerson = responsibleTaxPerson;
	}

	@Length(min = 0, max = 1000, message = "关联性业务需求长度必须介于 0 和 1000 之间")
	public String getRelatedBusinessRequirements() {
		return relatedBusinessRequirements;
	}

	public void setRelatedBusinessRequirements(String relatedBusinessRequirements) {
		this.relatedBusinessRequirements = relatedBusinessRequirements;
	}

	@Length(min = 0, max = 1000, message = "需求编号长度必须介于 0 和 1000 之间")
	public String getDemandNo() {
		return demandNo;
	}

	public void setDemandNo(String demandNo) {
		this.demandNo = demandNo;
	}

	@Length(min = 0, max = 1000, message = "目标描述长度必须介于 0 和 1000 之间")
	public String getTargetDesc() {
		return targetDesc;
	}

	public void setTargetDesc(String targetDesc) {
		this.targetDesc = targetDesc;
	}

	@Length(min = 0, max = 1000, message = "需求内容长度必须介于 0 和 1000 之间")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Length(min = 0, max = 1000, message = "附件长度必须介于 0 和 1000 之间")
	public String getAppendix() {
		return appendix;
	}

	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}

	@Length(min = 0, max = 1000, message = "需求审批联系人长度必须介于 0 和 1000 之间")
	public String getDemandApprovePerson() {
		return demandApprovePerson;
	}

	public void setDemandApprovePerson(String demandApprovePerson) {
		this.demandApprovePerson = demandApprovePerson;
	}

	@Length(min = 0, max = 1000, message = "需求审批联系人联系电话长度必须介于 0 和 1000 之间")
	public String getDemandApprovePhone() {
		return demandApprovePhone;
	}

	public void setDemandApprovePhone(String demandApprovePhone) {
		this.demandApprovePhone = demandApprovePhone;
	}

	@Length(min = 0, max = 1000, message = "备注长度必须介于 0 和 1000 之间")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<ProblemChild> getProblemChildList() {
		return ProblemChildList;
	}

	public void setProblemChildList(List<ProblemChild> problemChildList) {
		ProblemChildList = problemChildList;
	}

	public List<RequirementChildExamine> getRequirementChildExamineList() {
		return requirementChildExamineList;
	}

	public void setRequirementChildExamineList(List<RequirementChildExamine> requirementChildExamineList) {
		this.requirementChildExamineList = requirementChildExamineList;
	}

	public List<RequirementFile> getRequirementFileList() {
		return requirementFileList;
	}

	public void setRequirementFileList(List<RequirementFile> requirementFileList) {
		this.requirementFileList = requirementFileList;
	}

	public List<RequirementproChild> getRequirementproChildList() {
		return requirementproChildList;
	}

	public void setRequirementproChildList(List<RequirementproChild> requirementproChildList) {
		this.requirementproChildList = requirementproChildList;
	}
}