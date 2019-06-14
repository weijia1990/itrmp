/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testmanager.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;

/**
 * 测试管理Entity
 * 
 * @author weijia
 * @version 2019-06-14
 */
public class TaskTest extends DataEntity<TaskTest> {

	private static final long serialVersionUID = 1L;
	private RequirementChild requirementChild; // requirement_child_id 父类
	private String testIncharge; // 测试负责人
	private Date sitTime; // 计划SIT完成时间
	private String sitComments; // 备注
	private String sitTask; // 任务概述
	private String uatComments; // uat_comments
	private String uatTask; // uat_task

	public TaskTest() {
		super();
	}

	public TaskTest(String id) {
		super(id);
	}

	public TaskTest(RequirementChild requirementChild) {
		this.requirementChild = requirementChild;
	}

	@Length(min = 0, max = 32, message = "requirement_child_id长度必须介于 0 和 32 之间")
	public RequirementChild getRequirementChild() {
		return requirementChild;
	}

	public void setRequirementChild(RequirementChild requirementChild) {
		this.requirementChild = requirementChild;
	}

	@Length(min = 0, max = 100, message = "测试负责人长度必须介于 0 和 100 之间")
	public String getTestIncharge() {
		return testIncharge;
	}

	public void setTestIncharge(String testIncharge) {
		this.testIncharge = testIncharge;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSitTime() {
		return sitTime;
	}

	public void setSitTime(Date sitTime) {
		this.sitTime = sitTime;
	}

	@Length(min = 0, max = 255, message = "备注长度必须介于 0 和 255 之间")
	public String getSitComments() {
		return sitComments;
	}

	public void setSitComments(String sitComments) {
		this.sitComments = sitComments;
	}

	@Length(min = 0, max = 255, message = "任务概述长度必须介于 0 和 255 之间")
	public String getSitTask() {
		return sitTask;
	}

	public void setSitTask(String sitTask) {
		this.sitTask = sitTask;
	}

	@Length(min = 0, max = 255, message = "uat_comments长度必须介于 0 和 255 之间")
	public String getUatComments() {
		return uatComments;
	}

	public void setUatComments(String uatComments) {
		this.uatComments = uatComments;
	}

	@Length(min = 0, max = 255, message = "uat_task长度必须介于 0 和 255 之间")
	public String getUatTask() {
		return uatTask;
	}

	public void setUatTask(String uatTask) {
		this.uatTask = uatTask;
	}

}