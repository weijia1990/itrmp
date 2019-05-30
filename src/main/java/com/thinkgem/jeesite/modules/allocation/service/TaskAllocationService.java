/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.allocation.entity.TaskAllocation;
import com.thinkgem.jeesite.modules.allocation.dao.TaskAllocationDao;

/**
 * 需求分配Service
 * @author weijia
 * @version 2019-05-30
 */
@Service
@Transactional(readOnly = true)
public class TaskAllocationService extends CrudService<TaskAllocationDao, TaskAllocation> {

	public TaskAllocation get(String id) {
		return super.get(id);
	}
	
	public List<TaskAllocation> findList(TaskAllocation taskAllocation) {
		return super.findList(taskAllocation);
	}
	
	public Page<TaskAllocation> findPage(Page<TaskAllocation> page, TaskAllocation taskAllocation) {
		return super.findPage(page, taskAllocation);
	}
	
	@Transactional(readOnly = false)
	public void save(TaskAllocation taskAllocation) {
		super.save(taskAllocation);
	}
	
	@Transactional(readOnly = false)
	public void delete(TaskAllocation taskAllocation) {
		super.delete(taskAllocation);
	}
	
}