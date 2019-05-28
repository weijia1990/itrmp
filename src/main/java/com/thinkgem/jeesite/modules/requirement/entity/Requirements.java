/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 需求管理Entity
 * 
 * @author weijia
 * @version 2019-05-27
 */
public class Requirements extends DataEntity<Requirements> {

	private static final long serialVersionUID = 1L;
	private String requirementSource; // requirement_source
	private String requirementClassify; // requirement_classify
	private String businessSystem; // business_system
	private String requirementEmergency; // requirement_emergency
	private String expectAndIntention; // expect_and_intention
	private String signNo; // sign_no
	private Date expectOnline; // expect_online
	private String relatedBusinessRequirements; // related_business_requirements
	private String reasonsChange; // reasons_change
	private String currentBusiProcScenario; // current_busi_proc_scenario
	private String submitTo; // submit_to
	private String requiremenPresentationOffice; // requiremen_presentation_office
	private String proposer; // proposer
	private String contact; // contact
	private String requirementCauseDescription; // requirement_cause_description
	private String requirementContent; // requirement_content
	private String annexList; // annex_list
	private String requirementAcceptancePerson; // requirement_acceptance_person
	private String requirementAcceptancePhone; // requirement_acceptance_phone
	private String requirementStatus; // requirement_status
	private String relatedBusinessDemand; // related_business_demand
	private String comments; // comments
	private String lastUpdate; // last_update
	private Date latUpdateTime; // lat_update_time
	private String taskAssignId; // task_assign_id
	private String proId; // pro_id
	private String requirementChildId; // requirement_child_id

	public Requirements() {
		super();
	}

	public Requirements(String id) {
		super(id);
	}

	@Length(min = 0, max = 50, message = "requirement_source长度必须介于 0 和 50 之间")
	public String getRequirementSource() {
		return requirementSource;
	}

	public void setRequirementSource(String requirementSource) {
		this.requirementSource = requirementSource;
	}

	@Length(min = 0, max = 50, message = "requirement_classify长度必须介于 0 和 50 之间")
	public String getRequirementClassify() {
		return requirementClassify;
	}

	public void setRequirementClassify(String requirementClassify) {
		this.requirementClassify = requirementClassify;
	}

	@Length(min = 0, max = 50, message = "business_system长度必须介于 0 和 50 之间")
	public String getBusinessSystem() {
		return businessSystem;
	}

	public void setBusinessSystem(String businessSystem) {
		this.businessSystem = businessSystem;
	}

	@Length(min = 0, max = 50, message = "requirement_emergency长度必须介于 0 和 50 之间")
	public String getRequirementEmergency() {
		return requirementEmergency;
	}

	public void setRequirementEmergency(String requirementEmergency) {
		this.requirementEmergency = requirementEmergency;
	}

	@Length(min = 0, max = 200, message = "expect_and_intention长度必须介于 0 和 200 之间")
	public String getExpectAndIntention() {
		return expectAndIntention;
	}

	public void setExpectAndIntention(String expectAndIntention) {
		this.expectAndIntention = expectAndIntention;
	}

	@Length(min = 0, max = 100, message = "sign_no长度必须介于 0 和 100 之间")
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

	@Length(min = 0, max = 1000, message = "related_business_requirements长度必须介于 0 和 1000 之间")
	public String getRelatedBusinessRequirements() {
		return relatedBusinessRequirements;
	}

	public void setRelatedBusinessRequirements(String relatedBusinessRequirements) {
		this.relatedBusinessRequirements = relatedBusinessRequirements;
	}

	@Length(min = 0, max = 1000, message = "reasons_change长度必须介于 0 和 1000 之间")
	public String getReasonsChange() {
		return reasonsChange;
	}

	public void setReasonsChange(String reasonsChange) {
		this.reasonsChange = reasonsChange;
	}

	@Length(min = 0, max = 1000, message = "current_busi_proc_scenario长度必须介于 0 和 1000 之间")
	public String getCurrentBusiProcScenario() {
		return currentBusiProcScenario;
	}

	public void setCurrentBusiProcScenario(String currentBusiProcScenario) {
		this.currentBusiProcScenario = currentBusiProcScenario;
	}

	@Length(min = 0, max = 50, message = "submit_to长度必须介于 0 和 50 之间")
	public String getSubmitTo() {
		return submitTo;
	}

	public void setSubmitTo(String submitTo) {
		this.submitTo = submitTo;
	}

	@Length(min = 0, max = 50, message = "requiremen_presentation_office长度必须介于 0 和 50 之间")
	public String getRequiremenPresentationOffice() {
		return requiremenPresentationOffice;
	}

	public void setRequiremenPresentationOffice(String requiremenPresentationOffice) {
		this.requiremenPresentationOffice = requiremenPresentationOffice;
	}

	@Length(min = 0, max = 50, message = "proposer长度必须介于 0 和 50 之间")
	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	@Length(min = 0, max = 50, message = "contact长度必须介于 0 和 50 之间")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Length(min = 0, max = 500, message = "requirement_cause_description长度必须介于 0 和 500 之间")
	public String getRequirementCauseDescription() {
		return requirementCauseDescription;
	}

	public void setRequirementCauseDescription(String requirementCauseDescription) {
		this.requirementCauseDescription = requirementCauseDescription;
	}

	@Length(min = 0, max = 500, message = "requirement_content长度必须介于 0 和 500 之间")
	public String getRequirementContent() {
		return requirementContent;
	}

	public void setRequirementContent(String requirementContent) {
		this.requirementContent = requirementContent;
	}

	@Length(min = 0, max = 500, message = "annex_list长度必须介于 0 和 500 之间")
	public String getAnnexList() {
		return annexList;
	}

	public void setAnnexList(String annexList) {
		this.annexList = annexList;
	}

	@Length(min = 0, max = 50, message = "requirement_acceptance_person长度必须介于 0 和 50 之间")
	public String getRequirementAcceptancePerson() {
		return requirementAcceptancePerson;
	}

	public void setRequirementAcceptancePerson(String requirementAcceptancePerson) {
		this.requirementAcceptancePerson = requirementAcceptancePerson;
	}

	@Length(min = 0, max = 50, message = "requirement_acceptance_phone长度必须介于 0 和 50 之间")
	public String getRequirementAcceptancePhone() {
		return requirementAcceptancePhone;
	}

	public void setRequirementAcceptancePhone(String requirementAcceptancePhone) {
		this.requirementAcceptancePhone = requirementAcceptancePhone;
	}

	@Length(min = 0, max = 20, message = "requirement_status长度必须介于 0 和 20 之间")
	public String getRequirementStatus() {
		return requirementStatus;
	}

	public void setRequirementStatus(String requirementStatus) {
		this.requirementStatus = requirementStatus;
	}

	@Length(min = 0, max = 20, message = "related_business_demand长度必须介于 0 和 20 之间")
	public String getRelatedBusinessDemand() {
		return relatedBusinessDemand;
	}

	public void setRelatedBusinessDemand(String relatedBusinessDemand) {
		this.relatedBusinessDemand = relatedBusinessDemand;
	}

	@Length(min = 0, max = 500, message = "comments长度必须介于 0 和 500 之间")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Length(min = 0, max = 20, message = "last_update长度必须介于 0 和 20 之间")
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

	@Length(min = 0, max = 20, message = "task_assign_id长度必须介于 0 和 20 之间")
	public String getTaskAssignId() {
		return taskAssignId;
	}

	public void setTaskAssignId(String taskAssignId) {
		this.taskAssignId = taskAssignId;
	}

	@Length(min = 0, max = 20, message = "pro_id长度必须介于 0 和 20 之间")
	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	@Length(min = 0, max = 20, message = "requirement_child_id长度必须介于 0 和 20 之间")
	public String getRequirementChildId() {
		return requirementChildId;
	}

	public void setRequirementChildId(String requirementChildId) {
		this.requirementChildId = requirementChildId;
	}

}