/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirement.dao.RequirementsDao;
import com.thinkgem.jeesite.modules.requirement.entity.Problem;
import com.thinkgem.jeesite.modules.act.service.ActTaskService;
import com.thinkgem.jeesite.modules.act.utils.ActUtils;
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

	@Autowired
	private ActTaskService actTaskService;

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
		// 启动流程
		actTaskService.startProcess(ActUtils.PD_REQUIREMENT[0], ActUtils.PD_REQUIREMENT[1], requirements.getId(),
				requirements.getComments());
	}

	@Transactional(readOnly = false)
	public void delete(Requirements requirements) {
		super.delete(requirements);
		problemDao.delete(new Problem(requirements));
	}

	public void update(Requirements requirements) {
		dao.update(requirements);
	}

	public void saveExamine(Requirements requirements) {

		String taskDefKey = requirements.getAct().getTaskDefKey();

		// 设置意见
		requirements.getAct().setComment(("yes".equals(requirements.getAct().getFlag()) ? "[同意] " : "[驳回] ")
				+ requirements.getAct().getComment());

		if ("examine".equals(taskDefKey)) {
			requirements.setIsAllocation("1");
		} else if ("allocation".equals(taskDefKey)) {
			requirements.setIsAllocation("2");
		}

		requirements.preUpdate();

		// 提交流程任务
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("pass", "yes".equals(requirements.getAct().getFlag()) ? "1" : "0");
		actTaskService.complete(requirements.getAct().getTaskId(), requirements.getAct().getProcInsId(),
				requirements.getAct().getComment(), vars);

	}

}