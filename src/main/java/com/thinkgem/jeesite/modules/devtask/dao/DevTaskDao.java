/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtask.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.devtask.entity.DevTask;

/**
 * 开发任务创建DAO接口
 * @author ygj
 * @version 2019-05-31
 */
@MyBatisDao
public interface DevTaskDao extends CrudDao<DevTask> {
	
}