/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.esttasktest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.esttasktest.entity.EstTaskTest;
import com.thinkgem.jeesite.modules.esttasktest.dao.EstTaskTestDao;

/**
 * 测试任务创建Service
 * @author ygj
 * @version 2019-06-01
 */
@Service
@Transactional(readOnly = true)
public class EstTaskTestService extends CrudService<EstTaskTestDao, EstTaskTest> {

	public EstTaskTest get(String id) {
		return super.get(id);
	}
	
	public List<EstTaskTest> findList(EstTaskTest estTaskTest) {
		return super.findList(estTaskTest);
	}
	
	public Page<EstTaskTest> findPage(Page<EstTaskTest> page, EstTaskTest estTaskTest) {
		return super.findPage(page, estTaskTest);
	}
	
	@Transactional(readOnly = false)
	public void save(EstTaskTest estTaskTest) {
		super.save(estTaskTest);
	}
	
	@Transactional(readOnly = false)
	public void delete(EstTaskTest estTaskTest) {
		super.delete(estTaskTest);
	}
	
}