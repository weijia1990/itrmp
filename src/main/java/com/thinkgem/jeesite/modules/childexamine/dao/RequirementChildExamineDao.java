/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.childexamine.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.childexamine.entity.RequirementChildExamine;

/**
 * 需求审核管理DAO接口
 * @author weijia
 * @version 2019-06-04
 */
@MyBatisDao
public interface RequirementChildExamineDao extends CrudDao<RequirementChildExamine> {
	
}