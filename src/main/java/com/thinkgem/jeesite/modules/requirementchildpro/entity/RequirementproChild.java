/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchildpro.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;

/**
 * 子需求进度管理Entity
 * 
 * @author weijia
 * @version 2019-06-03
 */
public class RequirementproChild extends DataEntity<RequirementproChild> {

	private static final long serialVersionUID = 1L;
	private RequirementChild requirementChild; // 子需求编号 父类
	private String requirementproChildTitle; // 子需求进度
	private String requirementpFile; // 需求文档查看
	private String requirementproChildTrack; // 子需求进度追踪

	public RequirementproChild() {
		super();
	}

	public RequirementproChild(String id) {
		super(id);
	}

	public RequirementproChild(RequirementChild requirementChild) {
		this.requirementChild = requirementChild;
	}

	@Length(min = 0, max = 20, message = "子需求编号长度必须介于 0 和 20 之间")
	public RequirementChild getRequirementChild() {
		return requirementChild;
	}

	public void setRequirementChild(RequirementChild requirementChild) {
		this.requirementChild = requirementChild;
	}

	@Length(min = 0, max = 50, message = "子需求进度长度必须介于 0 和 50 之间")
	public String getRequirementproChildTitle() {
		return requirementproChildTitle;
	}

	public void setRequirementproChildTitle(String requirementproChildTitle) {
		this.requirementproChildTitle = requirementproChildTitle;
	}

	@Length(min = 0, max = 50, message = "需求文档查看长度必须介于 0 和 50 之间")
	public String getRequirementpFile() {
		return requirementpFile;
	}

	public void setRequirementpFile(String requirementpFile) {
		this.requirementpFile = requirementpFile;
	}

	@Length(min = 0, max = 50, message = "子需求进度追踪长度必须介于 0 和 50 之间")
	public String getRequirementproChildTrack() {
		return requirementproChildTrack;
	}

	public void setRequirementproChildTrack(String requirementproChildTrack) {
		this.requirementproChildTrack = requirementproChildTrack;
	}

}