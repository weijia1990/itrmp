/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testmanager.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.testmanager.entity.TaskTest;

/**
 * 测试管理DAO接口
 * @author weijia
 * @version 2019-06-14
 */
@MyBatisDao
public interface TaskTestDao extends CrudDao<TaskTest> {
	
}