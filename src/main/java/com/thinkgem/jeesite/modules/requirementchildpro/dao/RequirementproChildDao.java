/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchildpro.dao;

import java.util.List;
import java.util.Map;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirementchildpro.entity.RequirementproChild;

/**
 * 子需求进度管理DAO接口
 * 
 * @author weijia
 * @version 2019-06-03
 */
@MyBatisDao
public interface RequirementproChildDao extends CrudDao<RequirementproChild> {

	List<Map<String, String>> query(Requirements requirements);

}