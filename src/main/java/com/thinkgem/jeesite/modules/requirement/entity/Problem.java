/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 需求管理Entity
 * @author weijia
 * @version 2019-05-28
 */
public class Problem extends DataEntity<Problem> {
	
	private static final long serialVersionUID = 1L;
	private Requirements requirements;		// requirements_id 父类
	private String requirementChildId;		// requirement_child_id
	private String problemDesc;		// problem_desc
	private String problemNo;		// problem_no
	
	public Problem() {
		super();
	}

	public Problem(String id){
		super(id);
	}

	public Problem(Requirements requirements){
		this.requirements = requirements;
	}

	@Length(min=0, max=32, message="requirements_id长度必须介于 0 和 32 之间")
	public Requirements getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}
	
	@Length(min=0, max=32, message="requirement_child_id长度必须介于 0 和 32 之间")
	public String getRequirementChildId() {
		return requirementChildId;
	}

	public void setRequirementChildId(String requirementChildId) {
		this.requirementChildId = requirementChildId;
	}
	
	@Length(min=0, max=1000, message="problem_desc长度必须介于 0 和 1000 之间")
	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}
	
	@Length(min=0, max=20, message="problem_no长度必须介于 0 和 20 之间")
	public String getProblemNo() {
		return problemNo;
	}

	public void setProblemNo(String problemNo) {
		this.problemNo = problemNo;
	}
	
}