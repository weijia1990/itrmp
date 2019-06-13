/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collection.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.collection.entity.EditionCollection;

/**
 * 版本归集DAO接口
 * 
 * @author weijia
 * @version 2019-06-13
 */
@MyBatisDao
public interface EditionCollectionDao extends CrudDao<EditionCollection> {
}