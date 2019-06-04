/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.childexamine.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 需求审核管理Entity
 * @author weijia
 * @version 2019-06-04
 */
public class RequirementChildExamine extends DataEntity<RequirementChildExamine> {
	
	private static final long serialVersionUID = 1L;
	private RequirementChild requirementChild;		// 子需求编号 父类
	private String returnReason;		// 退回原因
	
	public RequirementChildExamine() {
		super();
	}

	public RequirementChildExamine(String id){
		super(id);
	}

	public RequirementChildExamine(RequirementChild requirementChild){
		this.requirementChild = requirementChild;
	}

	@Length(min=0, max=20, message="子需求编号长度必须介于 0 和 20 之间")
	public RequirementChild getRequirementChild() {
		return requirementChild;
	}

	public void setRequirementChild(RequirementChild requirementChild) {
		this.requirementChild = requirementChild;
	}
	
	@Length(min=0, max=1024, message="退回原因长度必须介于 0 和 1024 之间")
	public String getReturnReason() {
		return returnReason;
	}

	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	
}