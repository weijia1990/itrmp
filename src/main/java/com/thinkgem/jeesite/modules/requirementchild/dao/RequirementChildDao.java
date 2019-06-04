/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchild.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;

/**
 * 子需求管理DAO接口
 * 
 * @author weijia
 * @version 2019-06-02
 */
@MyBatisDao
public interface RequirementChildDao extends CrudDao<RequirementChild> {

	List<RequirementChild> getAllByRequirementId(String requirementId);

}