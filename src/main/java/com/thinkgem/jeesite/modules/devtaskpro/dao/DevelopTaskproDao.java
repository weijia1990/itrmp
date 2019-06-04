/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskpro.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.devtaskpro.entity.DevelopTaskpro;

/**
 * 开发任务跟进DAO接口
 * @author ygj
 * @version 2019-06-03
 */
@MyBatisDao
public interface DevelopTaskproDao extends CrudDao<DevelopTaskpro> {
	
}