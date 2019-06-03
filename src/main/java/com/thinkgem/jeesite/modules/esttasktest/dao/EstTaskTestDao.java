/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.esttasktest.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.esttasktest.entity.EstTaskTest;

/**
 * 测试任务创建DAO接口
 * @author ygj
 * @version 2019-06-01
 */
@MyBatisDao
public interface EstTaskTestDao extends CrudDao<EstTaskTest> {
	
}