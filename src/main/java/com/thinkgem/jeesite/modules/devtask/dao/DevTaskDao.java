/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtask.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.devtask.entity.DevTask;
import com.thinkgem.jeesite.modules.devtask.entity.ReqTaskUn;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;

/**
 * 开发任务创建DAO接口
 * @author ygj
 * @version 2019-05-31
 */
@MyBatisDao
public interface DevTaskDao extends CrudDao<DevTask> {

	List<Map<String, String>> query(Requirements requirements);
	
}