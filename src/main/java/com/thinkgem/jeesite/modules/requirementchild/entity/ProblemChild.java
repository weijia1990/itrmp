/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchild.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 子需求管理Entity
 * @author weijia
 * @version 2019-06-02
 */
public class ProblemChild extends DataEntity<ProblemChild> {
	
	private static final long serialVersionUID = 1L;
	private String requirements;		// 需求表流水号
	private RequirementChild requirementChild;		// 子需求表流水号 父类
	private String problemDesc;		// 问题描述
	private String problemNo;		// 问题单编号
	
	public ProblemChild() {
		super();
	}

	public ProblemChild(String id){
		super(id);
	}

	public ProblemChild(RequirementChild requirementChild){
		this.requirementChild = requirementChild;
	}

	@Length(min=0, max=32, message="需求表流水号长度必须介于 0 和 32 之间")
	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	
	@Length(min=0, max=32, message="子需求表流水号长度必须介于 0 和 32 之间")
	public RequirementChild getRequirementChild() {
		return requirementChild;
	}

	public void setRequirementChild(RequirementChild requirementChild) {
		this.requirementChild = requirementChild;
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