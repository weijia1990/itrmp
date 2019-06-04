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
public class RequirementFile extends DataEntity<RequirementFile> {
	
	private static final long serialVersionUID = 1L;
	private RequirementChild requirementChild;		// 子需求编号 父类
	private String requirementTitle;		// 需求文档名称
	private String requirementpContent;		// 需求文档内容
	
	public RequirementFile() {
		super();
	}

	public RequirementFile(String id){
		super(id);
	}

	public RequirementFile(RequirementChild requirementChild){
		this.requirementChild = requirementChild;
	}

	@Length(min=0, max=20, message="子需求编号长度必须介于 0 和 20 之间")
	public RequirementChild getRequirementChild() {
		return requirementChild;
	}

	public void setRequirementChild(RequirementChild requirementChild) {
		this.requirementChild = requirementChild;
	}
	
	@Length(min=0, max=50, message="需求文档名称长度必须介于 0 和 50 之间")
	public String getRequirementTitle() {
		return requirementTitle;
	}

	public void setRequirementTitle(String requirementTitle) {
		this.requirementTitle = requirementTitle;
	}
	
	@Length(min=0, max=50, message="需求文档内容长度必须介于 0 和 50 之间")
	public String getRequirementpContent() {
		return requirementpContent;
	}

	public void setRequirementpContent(String requirementpContent) {
		this.requirementpContent = requirementpContent;
	}
	
}