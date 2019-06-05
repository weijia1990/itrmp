/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtask.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.devtaskassign.entity.DevelopTaskassign;
import com.thinkgem.jeesite.modules.devtaskpro.entity.DevelopTaskpro;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;

/**
 * 开发任务创建Entity
 * @author ygj
 * @version 2019-05-31
 */
public class ReqTaskUn extends DataEntity<ReqTaskUn> {
	
	private static final long serialVersionUID = 1L;
	private DevTask devtask;
	private Requirements requirements;
	private DevelopTaskassign developTaskassign;
	private DevelopTaskpro developTaskpro;
	public DevTask getDevtask() {
		return devtask;
	}
	public void setDevtask(DevTask devtask) {
		this.devtask = devtask;
	}
	public Requirements getRequirements() {
		return requirements;
	}
	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}
	public DevelopTaskassign getDevelopTaskassign() {
		return developTaskassign;
	}
	public void setDevelopTaskassign(DevelopTaskassign developTaskassign) {
		this.developTaskassign = developTaskassign;
	}
	public DevelopTaskpro getDevelopTaskpro() {
		return developTaskpro;
	}
	public void setDevelopTaskpro(DevelopTaskpro developTaskpro) {
		this.developTaskpro = developTaskpro;
	}
	
	
}