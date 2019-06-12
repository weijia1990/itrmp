/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchild.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;
import com.thinkgem.jeesite.modules.requirementchildpro.dao.RequirementproChildDao;
import com.thinkgem.jeesite.modules.requirementchildpro.entity.RequirementproChild;
import com.thinkgem.jeesite.modules.requirementchild.dao.RequirementChildDao;
import com.thinkgem.jeesite.modules.requirementchild.entity.ProblemChild;
import com.thinkgem.jeesite.modules.act.service.ActTaskService;
import com.thinkgem.jeesite.modules.childexamine.dao.RequirementChildExamineDao;
import com.thinkgem.jeesite.modules.childexamine.dao.RequirementFileDao;
import com.thinkgem.jeesite.modules.childexamine.entity.RequirementChildExamine;
import com.thinkgem.jeesite.modules.childexamine.entity.RequirementFile;
import com.thinkgem.jeesite.modules.requirementchild.dao.ProblemChildDao;

/**
 * 子需求管理Service
 * 
 * @author weijia
 * @version 2019-06-02
 */
@Service
@Transactional(readOnly = true)
public class RequirementChildService extends CrudService<RequirementChildDao, RequirementChild> {

	@Autowired
	private ProblemChildDao problemDao;
	@Autowired
	RequirementChildDao requirementChildDao;
	@Autowired
	private RequirementChildExamineDao requirementChildExamineDao;
	@Autowired
	private RequirementproChildDao requirementproChildDao;
	@Autowired
	private RequirementFileDao requirementFileDao;
	@Autowired
	private ActTaskService actTaskService;

	public RequirementChild get(String id) {
		RequirementChild requirementChild = super.get(id);
		requirementChild.setProblemChildList(problemDao.findList(new ProblemChild(requirementChild)));
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
			if (ProblemChild.DEL_FLAG_NORMAL.equals(problem.getDelFlag())) {
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
		for (RequirementChildExamine requirementChildExamine : requirementChild.getRequirementChildExamineList()) {
			if (requirementChildExamine.getId() == null) {
				continue;
			}
			if (RequirementChildExamine.DEL_FLAG_NORMAL.equals(requirementChildExamine.getDelFlag())) {
				if (StringUtils.isBlank(requirementChildExamine.getId())) {
					requirementChildExamine.setRequirementChild(requirementChild);
					requirementChildExamine.preInsert();
					requirementChildExamineDao.insert(requirementChildExamine);
				} else {
					requirementChildExamine.preUpdate();
					requirementChildExamineDao.update(requirementChildExamine);
				}
			} else {
				requirementChildExamineDao.delete(requirementChildExamine);
			}
		}
		for (RequirementFile requirementFile : requirementChild.getRequirementFileList()) {
			if (requirementFile.getId() == null) {
				continue;
			}
			if (RequirementFile.DEL_FLAG_NORMAL.equals(requirementFile.getDelFlag())) {
				if (StringUtils.isBlank(requirementFile.getId())) {
					requirementFile.setRequirementChild(requirementChild);
					requirementFile.preInsert();
					requirementFileDao.insert(requirementFile);
				} else {
					requirementFile.preUpdate();
					requirementFileDao.update(requirementFile);
				}
			} else {
				requirementFileDao.delete(requirementFile);
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

		// 设置意见
		requirementChild.getAct().setComment(("yes".equals(requirementChild.getAct().getFlag()) ? "[同意] " : "[驳回] ")
				+ requirementChild.getAct().getComment());

		requirementChild.preUpdate();

		// 提交流程任务
		Map<String, Object> vars = Maps.newHashMap();
		vars.put("pass", "yes".equals(requirementChild.getAct().getFlag()) ? "1" : "0");
		actTaskService.complete(requirementChild.getAct().getTaskId(), requirementChild.getAct().getProcInsId(),
				requirementChild.getAct().getComment(), vars);
	}

	@Transactional(readOnly = false)
	public void delete(RequirementChild requirementChild) {
		super.delete(requirementChild);
		problemDao.delete(new ProblemChild(requirementChild));
		requirementChildExamineDao.delete(new RequirementChildExamine(requirementChild));
		requirementFileDao.delete(new RequirementFile(requirementChild));
		requirementproChildDao.delete(new RequirementproChild(requirementChild));
	}

	public List<RequirementChild> getAllByRequirementId(String requirementId) {
		return requirementChildDao.getAllByRequirementId(requirementId);
	}

	public void updateExamine(RequirementChild requirementChild) {
		requirementChildDao.updateExamine(requirementChild);
	}

}