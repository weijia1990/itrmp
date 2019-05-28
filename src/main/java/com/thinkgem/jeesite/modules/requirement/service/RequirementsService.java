/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirement.dao.RequirementsDao;

/**
 * 需求管理Service
 * @author weijia
 * @version 2019-05-27
 */
@Service
@Transactional(readOnly = true)
public class RequirementsService extends CrudService<RequirementsDao, Requirements> {

	public Requirements get(String id) {
		return super.get(id);
	}
	
	public List<Requirements> findList(Requirements requirements) {
		return super.findList(requirements);
	}
	
	public Page<Requirements> findPage(Page<Requirements> page, Requirements requirements) {
		return super.findPage(page, requirements);
	}
	
	@Transactional(readOnly = false)
	public void save(Requirements requirements) {
		super.save(requirements);
	}
	
	@Transactional(readOnly = false)
	public void delete(Requirements requirements) {
		super.delete(requirements);
	}
	
}