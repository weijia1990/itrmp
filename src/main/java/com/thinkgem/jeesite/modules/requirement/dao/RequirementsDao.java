/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;

/**
 * 需求管理DAO接口
 * @author weijia
 * @version 2019-05-27
 */
@MyBatisDao
public interface RequirementsDao extends CrudDao<Requirements> {
	
}