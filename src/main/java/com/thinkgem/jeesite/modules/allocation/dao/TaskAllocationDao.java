/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.allocation.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.allocation.entity.TaskAllocation;

/**
 * 需求分配DAO接口
 * @author weijia
 * @version 2019-05-30
 */
@MyBatisDao
public interface TaskAllocationDao extends CrudDao<TaskAllocation> {
	
}