/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.requirement.entity.Problem;

/**
 * 需求管理DAO接口
 * @author ygj
 * @version 2019-05-28
 */
@MyBatisDao
public interface ProblemDao extends CrudDao<Problem> {
	
}