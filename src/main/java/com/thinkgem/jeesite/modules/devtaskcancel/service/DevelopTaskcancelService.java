/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskcancel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.devtaskcancel.entity.DevelopTaskcancel;
import com.thinkgem.jeesite.modules.devtaskcancel.dao.DevelopTaskcancelDao;

/**
 * 开发任务撤销Service
 * @author ygj
 * @version 2019-06-01
 */
@Service
@Transactional(readOnly = true)
public class DevelopTaskcancelService extends CrudService<DevelopTaskcancelDao, DevelopTaskcancel> {

	public DevelopTaskcancel get(String id) {
		return super.get(id);
	}
	
	public List<DevelopTaskcancel> findList(DevelopTaskcancel developTaskcancel) {
		return super.findList(developTaskcancel);
	}
	
	public Page<DevelopTaskcancel> findPage(Page<DevelopTaskcancel> page, DevelopTaskcancel developTaskcancel) {
		return super.findPage(page, developTaskcancel);
	}
	
	@Transactional(readOnly = false)
	public void save(DevelopTaskcancel developTaskcancel) {
		super.save(developTaskcancel);
	}
	
	@Transactional(readOnly = false)
	public void delete(DevelopTaskcancel developTaskcancel) {
		super.delete(developTaskcancel);
	}
	
}