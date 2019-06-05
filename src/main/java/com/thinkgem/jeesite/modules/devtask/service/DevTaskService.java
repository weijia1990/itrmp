/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtask.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.devtask.entity.DevTask;
import com.thinkgem.jeesite.modules.devtask.dao.DevTaskDao;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;

/**
 * 开发任务创建Service
 * @author ygj
 * @version 2019-05-31
 */
@Service
@Transactional(readOnly = true)
public class DevTaskService extends CrudService<DevTaskDao, DevTask> {

	@Autowired
	private DevTaskDao devTaskDao;
	
	public DevTask get(String id) {
		return super.get(id);
	}
	
	public List<DevTask> findList(DevTask devTask) {
		return super.findList(devTask);
	}
	
	public Page<DevTask> findPage(Page<DevTask> page,DevTask devTask) {
		return super.findPage(page, devTask);
	}
	
	@Transactional(readOnly = false)
	public void save(DevTask devTask) {
		super.save(devTask);
	}
	
	@Transactional(readOnly = false)
	public void delete(DevTask devTask) {
		super.delete(devTask);
	}

	public List<Map<String, String>> query(Requirements requirements) {
		return devTaskDao.query(requirements);
	}
	
}