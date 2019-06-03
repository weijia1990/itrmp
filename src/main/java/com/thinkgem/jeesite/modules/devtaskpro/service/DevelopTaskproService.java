/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskpro.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.devtaskpro.entity.DevelopTaskpro;
import com.thinkgem.jeesite.modules.devtaskpro.dao.DevelopTaskproDao;

/**
 * 开发任务跟进Service
 * @author ygj
 * @version 2019-06-01
 */
@Service
@Transactional(readOnly = true)
public class DevelopTaskproService extends CrudService<DevelopTaskproDao, DevelopTaskpro> {

	public DevelopTaskpro get(String id) {
		return super.get(id);
	}
	
	public List<DevelopTaskpro> findList(DevelopTaskpro developTaskpro) {
		return super.findList(developTaskpro);
	}
	
	public Page<DevelopTaskpro> findPage(Page<DevelopTaskpro> page, DevelopTaskpro developTaskpro) {
		return super.findPage(page, developTaskpro);
	}
	
	@Transactional(readOnly = false)
	public void save(DevelopTaskpro developTaskpro) {
		super.save(developTaskpro);
	}
	
	@Transactional(readOnly = false)
	public void delete(DevelopTaskpro developTaskpro) {
		super.delete(developTaskpro);
	}
	
}