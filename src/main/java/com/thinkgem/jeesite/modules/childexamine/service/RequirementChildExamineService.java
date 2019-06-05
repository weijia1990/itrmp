package com.thinkgem.jeesite.modules.childexamine.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.childexamine.dao.RequirementChildExamineDao;
import com.thinkgem.jeesite.modules.childexamine.entity.RequirementChildExamine;

@Service
@Transactional(readOnly = true)
public class RequirementChildExamineService extends CrudService<RequirementChildExamineDao, RequirementChildExamine> {

}
