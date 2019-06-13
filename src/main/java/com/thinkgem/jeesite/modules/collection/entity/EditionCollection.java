/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collection.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 版本归集Entity
 * @author weijia
 * @version 2019-06-13
 */
public class EditionCollection extends DataEntity<EditionCollection> {
	
	private static final long serialVersionUID = 1L;
	private Edition edition;		// 版本序号 父类
	private String timeOnline;		// 上线时间
	private String editionFiles;		// 版本包含需求清单
	private String comments;		// 备注
	
	public EditionCollection() {
		super();
	}

	public EditionCollection(String id){
		super(id);
	}

	public EditionCollection(Edition edition){
		this.edition = edition;
	}

	@Length(min=0, max=20, message="版本序号长度必须介于 0 和 20 之间")
	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}
	
	@Length(min=0, max=20, message="上线时间长度必须介于 0 和 20 之间")
	public String getTimeOnline() {
		return timeOnline;
	}

	public void setTimeOnline(String timeOnline) {
		this.timeOnline = timeOnline;
	}
	
	@Length(min=0, max=200, message="版本包含需求清单长度必须介于 0 和 200 之间")
	public String getEditionFiles() {
		return editionFiles;
	}

	public void setEditionFiles(String editionFiles) {
		this.editionFiles = editionFiles;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}