/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskcancel.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 开发任务撤销Entity
 * @author ygj
 * @version 2019-06-03
 */
public class DevelopTaskcancel extends DataEntity<DevelopTaskcancel> {
	
	private static final long serialVersionUID = 1L;
	private Date cancelTime;		// 撤销日期
	private String cancelDesc;		// 撤销说明
	private String taskId;		// 任务编号
	
	public DevelopTaskcancel() {
		super();
	}

	public DevelopTaskcancel(String id){
		super(id);
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	
	@Length(min=0, max=20, message="撤销说明长度必须介于 0 和 20 之间")
	public String getCancelDesc() {
		return cancelDesc;
	}

	public void setCancelDesc(String cancelDesc) {
		this.cancelDesc = cancelDesc;
	}
	
	@Length(min=0, max=1000, message="任务编号长度必须介于 0 和 1000 之间")
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
}