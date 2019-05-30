/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.allocation.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 需求分配Entity
 * @author weijia
 * @version 2019-05-30
 */
public class TaskAllocation extends DataEntity<TaskAllocation> {
	
	private static final long serialVersionUID = 1L;
	private String requirementsId;		// 需求编号
	private String requirementResponsePerson;		// 需求负责人
	private Date expectFinsh;		// 预计完成时间
	
	public TaskAllocation() {
		super();
	}

	public TaskAllocation(String id){
		super(id);
	}

	@Length(min=0, max=32, message="需求编号长度必须介于 0 和 32 之间")
	public String getRequirementsId() {
		return requirementsId;
	}

	public void setRequirementsId(String requirementsId) {
		this.requirementsId = requirementsId;
	}
	
	@Length(min=0, max=100, message="需求负责人长度必须介于 0 和 100 之间")
	public String getRequirementResponsePerson() {
		return requirementResponsePerson;
	}

	public void setRequirementResponsePerson(String requirementResponsePerson) {
		this.requirementResponsePerson = requirementResponsePerson;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="预计完成时间不能为空")
	public Date getExpectFinsh() {
		return expectFinsh;
	}

	public void setExpectFinsh(Date expectFinsh) {
		this.expectFinsh = expectFinsh;
	}
	
}