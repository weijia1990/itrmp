/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 需求管理Entity
 * @author ygj
 * @version 2019-05-28
 */
public class Problem extends DataEntity<Problem> {
	
	private static final long serialVersionUID = 1L;
	private Requirements requirements;		// 需求表流水号 父类
	private String requirementChildId;		// 子需求表流水号
	private String problemDesc;		// 问题描述
	private String problemNo;		// 问题单编号
	
	public Problem() {
		super();
	}

	public Problem(String id){
		super(id);
	}

	public Problem(Requirements requirements){
		this.requirements = requirements;
	}

	@Length(min=0, max=32, message="需求表流水号长度必须介于 0 和 32 之间")
	public Requirements getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}
	
	@Length(min=0, max=32, message="子需求表流水号长度必须介于 0 和 32 之间")
	public String getRequirementChildId() {
		return requirementChildId;
	}

	public void setRequirementChildId(String requirementChildId) {
		this.requirementChildId = requirementChildId;
	}
	
	@Length(min=0, max=1000, message="问题描述长度必须介于 0 和 1000 之间")
	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	
	@Length(min=0, max=20, message="问题单编号长度必须介于 0 和 20 之间")
	public String getProblemNo() {
		return problemNo;
	}

	public void setProblemNo(String problemNo) {
		this.problemNo = problemNo;
	}
	
}