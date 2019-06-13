/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collection.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 版本归集Entity
 * @author weijia
 * @version 2019-06-13
 */
public class EditionRevert extends DataEntity<EditionRevert> {
	
	private static final long serialVersionUID = 1L;
	private Edition edition;		// 版本序号 父类
	private String editionRevertReason;		// 版本返回修改原因
	private Date editionRevertTime;		// 版本返回修改时间
	private String approver;		// 审批人
	private String comments;		// 备注
	
	public EditionRevert() {
		super();
	}

	public EditionRevert(String id){
		super(id);
	}

	public EditionRevert(Edition edition){
		this.edition = edition;
	}

	@Length(min=0, max=20, message="版本序号长度必须介于 0 和 20 之间")
	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}
	
	@Length(min=0, max=200, message="版本返回修改原因长度必须介于 0 和 200 之间")
	public String getEditionRevertReason() {
		return editionRevertReason;
	}

	public void setEditionRevertReason(String editionRevertReason) {
		this.editionRevertReason = editionRevertReason;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEditionRevertTime() {
		return editionRevertTime;
	}

	public void setEditionRevertTime(Date editionRevertTime) {
		this.editionRevertTime = editionRevertTime;
	}
	
	@Length(min=0, max=200, message="审批人长度必须介于 0 和 200 之间")
	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}