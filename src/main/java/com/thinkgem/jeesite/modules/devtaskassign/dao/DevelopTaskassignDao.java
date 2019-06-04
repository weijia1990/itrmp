/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskassign.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.devtaskassign.entity.DevelopTaskassign;

/**
 * 开发任务指派DAO接口
 * @author ygj
 * @version 2019-06-03
 */
@MyBatisDao
public interface DevelopTaskassignDao extends CrudDao<DevelopTaskassign> {
	
}