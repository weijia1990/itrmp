/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchild.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;
import com.thinkgem.jeesite.modules.requirementchild.dao.RequirementChildDao;
import com.thinkgem.jeesite.modules.requirementchild.entity.ProblemChild;
import com.thinkgem.jeesite.modules.requirementchild.dao.ProblemChildDao;

/**
 * 子需求管理Service
 * @author weijia
 * @version 2019-06-02
 */
@Service
@Transactional(readOnly = true)
public class RequirementChildService extends CrudService<RequirementChildDao, RequirementChild> {

	@Autowired
	private ProblemChildDao problemDao;
	
	public RequirementChild get(String id) {
		RequirementChild requirementChild = super.get(id);
		requirementChild.setProblemList(problemDao.findList(new ProblemChild(requirementChild)));
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
		for (ProblemChild problem : requirementChild.getProblemList()){
			if (problem.getId() == null){
				continue;
			}
			if (ProblemChild.DEL_FLAG_NORMAL.equals(problem.getDelFlag())){
				if (StringUtils.isBlank(problem.getId())){
					problem.setRequirementChild(requirementChild);
					problem.preInsert();
					problemDao.insert(problem);
				}else{
					problem.preUpdate();
					problemDao.update(problem);
				}
			}else{
				problemDao.delete(problem);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(RequirementChild requirementChild) {
		super.delete(requirementChild);
		problemDao.delete(new ProblemChild(requirementChild));
	}
	
}