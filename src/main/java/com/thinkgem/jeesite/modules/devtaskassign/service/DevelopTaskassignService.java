/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskassign.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.devtaskassign.entity.DevelopTaskassign;
import com.thinkgem.jeesite.modules.devtaskassign.dao.DevelopTaskassignDao;

/**
 * 开发任务指派Service
 * @author ygj
 * @version 2019-05-31
 */
@Service
@Transactional(readOnly = true)
public class DevelopTaskassignService extends CrudService<DevelopTaskassignDao, DevelopTaskassign> {

	public DevelopTaskassign get(String id) {
		return super.get(id);
	}
	
	public List<DevelopTaskassign> findList(DevelopTaskassign developTaskassign) {
		return super.findList(developTaskassign);
	}
	
	public Page<DevelopTaskassign> findPage(Page<DevelopTaskassign> page, DevelopTaskassign developTaskassign) {
		return super.findPage(page, developTaskassign);
	}
	
	@Transactional(readOnly = false)
	public void save(DevelopTaskassign developTaskassign) {
		super.save(developTaskassign);
	}
	
	@Transactional(readOnly = false)
	public void delete(DevelopTaskassign developTaskassign) {
		super.delete(developTaskassign);
	}
	
}