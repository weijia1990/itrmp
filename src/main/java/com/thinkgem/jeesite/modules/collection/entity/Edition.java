/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collection.entity;

import java.util.List;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;

/**
 * 版本归集Entity
 * 
 * @author weijia
 * @version 2019-06-13
 */
public class Edition extends DataEntity<Edition> {

	private static final long serialVersionUID = 1L;
	private List<EditionCollection> editionCollectionList = Lists.newArrayList(); // 子表列表
	private List<EditionRevert> editionRevertList = Lists.newArrayList(); // 子表列表
	private List<RequirementChild> requirementChildList = Lists.newArrayList(); // 子表列表

	public Edition() {
		super();
	}

	public Edition(String id) {
		super(id);
	}

	public List<EditionCollection> getEditionCollectionList() {
		return editionCollectionList;
	}

	public void setEditionCollectionList(List<EditionCollection> editionCollectionList) {
		this.editionCollectionList = editionCollectionList;
	}

	public List<EditionRevert> getEditionRevertList() {
		return editionRevertList;
	}

	public void setEditionRevertList(List<EditionRevert> editionRevertList) {
		this.editionRevertList = editionRevertList;
	}

	public List<RequirementChild> getRequirementChildList() {
		return requirementChildList;
	}

	public void setRequirementChildList(List<RequirementChild> requirementChildList) {
		this.requirementChildList = requirementChildList;
	}
}