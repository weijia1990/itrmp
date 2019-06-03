/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirement.dao.RequirementsDao;
import com.thinkgem.jeesite.modules.requirement.entity.Problem;
import com.thinkgem.jeesite.modules.requirement.dao.ProblemDao;

/**
 * 需求管理Service
 * 
 * @author weijia
 * @version 2019-05-28
 */
@Service
@Transactional(readOnly = true)
public class RequirementsService extends CrudService<RequirementsDao, Requirements> {

	@Autowired
	private ProblemDao problemDao;

	public Requirements get(String id) {
		Requirements requirements = super.get(id);
		requirements.setProblemList(problemDao.findList(new Problem(requirements)));
		return requirements;
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
		for (Problem problem : requirements.getProblemList()) {
			if (problem.getId() == null) {
				continue;
			}
			if (Problem.DEL_FLAG_NORMAL.equals(problem.getDelFlag())) {
				if (StringUtils.isBlank(problem.getId())) {
					problem.setRequirements(requirements);
					problem.preInsert();
					problemDao.insert(problem);
				} else {
					problem.preUpdate();
					problemDao.update(problem);
				}
			} else {
				problemDao.delete(problem);
			}
		}
	}

	@Transactional(readOnly = false)
	public void delete(Requirements requirements) {
		super.delete(requirements);
		problemDao.delete(new Problem(requirements));
	}

	public void update(Requirements requirements) {
		dao.update(requirements);
	}

}