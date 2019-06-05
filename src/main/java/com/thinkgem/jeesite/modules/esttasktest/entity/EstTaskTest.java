/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.esttasktest.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;


/**
 * 测试任务创建Entity
 * @author ygj
 * @version 2019-06-01
 */
public class EstTaskTest extends DataEntity<EstTaskTest> {
	
	private static final long serialVersionUID = 1L;
	private String requirementSource;		// 需求来源
	private String requirementClassify;		// 需求分类
	private String businessSystem;		// 业务系统
	private String requirementEmergency;		// 需求紧急程度
	private String taskTestTitle;		// 任务标题
	private String signNo;		// 签报号
	private String testIncharge;		// 测试负责人
	private String developIncharge;		// 开发负责人
	private String developWorkAccount;		// 开发工作量
	private Date explanOnline;		// 计划上线时间
	private Date submitTestSystime;		// 提交系统测试时间
	private String developScale;		// 开发规模(代码行数)
	private String relatedSystem;		// 涉及系统
	private String comments;		// 备注
	private String testEnvironment;		// 测试环境
	private String testRange;		// 测试范围
	private String testApplicationDesc;		// 测试申请描述
	private String testPointsAdvice;		// 测试要点及建议
	private String appendix;		// 附件
	private String requestId;
	
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public EstTaskTest() {
		super();
	}

	public EstTaskTest(String id){
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
	public String getTaskTestTitle() {
		return taskTestTitle;
	}

	public void setTaskTestTitle(String taskTestTitle) {
		this.taskTestTitle = taskTestTitle;
	}
	
	@Length(min=0, max=1000, message="签报号长度必须介于 0 和 1000 之间")
	public String getSignNo() {
		return signNo;
	}

	public void setSignNo(String signNo) {
		this.signNo = signNo;
	}
	
	@Length(min=0, max=100, message="测试负责人长度必须介于 0 和 100 之间")
	public String getTestIncharge() {
		return testIncharge;
	}

	public void setTestIncharge(String testIncharge) {
		this.testIncharge = testIncharge;
	}
	
	@Length(min=0, max=100, message="开发负责人长度必须介于 0 和 100 之间")
	public String getDevelopIncharge() {
		return developIncharge;
	}

	public void setDevelopIncharge(String developIncharge) {
		this.developIncharge = developIncharge;
	}
	
	@Length(min=0, max=200, message="开发工作量长度必须介于 0 和 200 之间")
	public String getDevelopWorkAccount() {
		return developWorkAccount;
	}

	public void setDevelopWorkAccount(String developWorkAccount) {
		this.developWorkAccount = developWorkAccount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getExplanOnline() {
		return explanOnline;
	}

	public void setExplanOnline(Date explanOnline) {
		this.explanOnline = explanOnline;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSubmitTestSystime() {
		return submitTestSystime;
	}

	public void setSubmitTestSystime(Date submitTestSystime) {
		this.submitTestSystime = submitTestSystime;
	}
	
	@Length(min=0, max=1000, message="开发规模(代码行数)长度必须介于 0 和 1000 之间")
	public String getDevelopScale() {
		return developScale;
	}

	public void setDevelopScale(String developScale) {
		this.developScale = developScale;
	}
	
	@Length(min=0, max=64, message="涉及系统长度必须介于 0 和 64 之间")
	public String getRelatedSystem() {
		return relatedSystem;
	}

	public void setRelatedSystem(String relatedSystem) {
		this.relatedSystem = relatedSystem;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Length(min=0, max=64, message="测试环境长度必须介于 0 和 64 之间")
	public String getTestEnvironment() {
		return testEnvironment;
	}

	public void setTestEnvironment(String testEnvironment) {
		this.testEnvironment = testEnvironment;
	}
	
	@Length(min=0, max=64, message="测试范围长度必须介于 0 和 64 之间")
	public String getTestRange() {
		return testRange;
	}

	public void setTestRange(String testRange) {
		this.testRange = testRange;
	}
	
	@Length(min=0, max=1000, message="测试申请描述长度必须介于 0 和 1000 之间")
	public String getTestApplicationDesc() {
		return testApplicationDesc;
	}

	public void setTestApplicationDesc(String testApplicationDesc) {
		this.testApplicationDesc = testApplicationDesc;
	}
	
	@Length(min=0, max=1000, message="测试要点及建议长度必须介于 0 和 1000 之间")
	public String getTestPointsAdvice() {
		return testPointsAdvice;
	}

	public void setTestPointsAdvice(String testPointsAdvice) {
		this.testPointsAdvice = testPointsAdvice;
	}
	
	@Length(min=0, max=64, message="附件长度必须介于 0 和 64 之间")
	public String getAppendix() {
		return appendix;
	}

	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}
	
}