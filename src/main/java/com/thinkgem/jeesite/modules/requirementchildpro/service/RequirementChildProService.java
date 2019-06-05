/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchildpro.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.childexamine.dao.RequirementChildExamineDao;
import com.thinkgem.jeesite.modules.childexamine.entity.RequirementChildExamine;
import com.thinkgem.jeesite.modules.requirement.entity.Problem;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirementchild.dao.ProblemChildDao;
import com.thinkgem.jeesite.modules.requirementchild.dao.RequirementChildDao;
import com.thinkgem.jeesite.modules.requirementchild.entity.ProblemChild;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;
import com.thinkgem.jeesite.modules.requirementchildpro.dao.RequirementproChildDao;
import com.thinkgem.jeesite.modules.requirementchildpro.entity.RequirementproChild;

/**
 * 子需求进度管理Service
 * 
 * @author weijia
 * @version 2019-06-03
 */
@Service
@Transactional(readOnly = true)
public class RequirementChildProService extends CrudService<RequirementChildDao, RequirementChild> {

	@Autowired
	private ProblemChildDao problemDao;
	@Autowired
	private RequirementproChildDao requirementproChildDao;
	@Autowired
	private RequirementChildExamineDao requirementChildExamineDao;

	public RequirementChild get(String id) {
		RequirementChild requirementChild = super.get(id);
		requirementChild.setProblemChildList(problemDao.findList(new ProblemChild(requirementChild)));
		requirementChild
				.setRequirementproChildList(requirementproChildDao.findList(new RequirementproChild(requirementChild)));
		requirementChild.setRequirementChildExamineList(
				requirementChildExamineDao.findList(new RequirementChildExamine(requirementChild)));
		return requirementChild;
	}

	public List<RequirementChild> findList(RequirementChild requirementChild) {
		return super.findList(requirementChild);
	}

	public Page<RequirementChild> findPage(Page<RequirementChild> page, RequirementChild requirementChild) {
		return super.findPage(page, requirementChild);
	}

	@Transactional(readOnly = false)
	public void save(RequirementChild requirementChild) {
		super.save(requirementChild);
		for (ProblemChild problem : requirementChild.getProblemChildList()) {
			if (problem.getId() == null) {
				continue;
			}
			if (Problem.DEL_FLAG_NORMAL.equals(problem.getDelFlag())) {
				if (StringUtils.isBlank(problem.getId())) {
					problem.setRequirementChild(requirementChild);
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
		for (RequirementproChild requirementproChild : requirementChild.getRequirementproChildList()) {
			if (requirementproChild.getId() == null) {
				continue;
			}
			if (RequirementproChild.DEL_FLAG_NORMAL.equals(requirementproChild.getDelFlag())) {
				if (StringUtils.isBlank(requirementproChild.getId())) {
					requirementproChild.setRequirementChild(requirementChild);
					requirementproChild.preInsert();
					requirementproChildDao.insert(requirementproChild);
				} else {
					requirementproChild.preUpdate();
					requirementproChildDao.update(requirementproChild);
				}
			} else {
				requirementproChildDao.delete(requirementproChild);
			}
		}
	}

	@Transactional(readOnly = false)
	public void delete(RequirementChild requirementChild) {
		super.delete(requirementChild);
		problemDao.delete(new ProblemChild(requirementChild));
		requirementproChildDao.delete(new RequirementproChild(requirementChild));
	}

	public List<Map<String, String>> query(Requirements requirements) {
		return requirementproChildDao.query(requirements);
	}

	public List<Map<String, String>> queryExamine(Requirements requirements) {
		return requirementproChildDao.queryExamine(requirements);
	}
}