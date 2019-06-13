/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collection.dao;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.collection.entity.Edition;

/**
 * 版本归集DAO接口
 * 
 * @author weijia
 * @version 2019-06-13
 */
@MyBatisDao
public interface EditionDao extends CrudDao<Edition> {
	List<Map<String, String>> query(Edition edition);

	List<Map<String, String>> editionShow(Edition edition);

	void addRequirement(Map<String, String> param);
}