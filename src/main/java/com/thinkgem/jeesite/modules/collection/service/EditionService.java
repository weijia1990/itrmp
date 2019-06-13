/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collection.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.collection.dao.EditionCollectionDao;
import com.thinkgem.jeesite.modules.collection.dao.EditionDao;
import com.thinkgem.jeesite.modules.collection.dao.EditionRevertDao;
import com.thinkgem.jeesite.modules.collection.entity.Edition;
import com.thinkgem.jeesite.modules.collection.entity.EditionCollection;
import com.thinkgem.jeesite.modules.collection.entity.EditionRevert;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * 版本归集Service
 * 
 * @author weijia
 * @version 2019-06-13
 */
@Service
@Transactional(readOnly = true)
public class EditionService extends CrudService<EditionDao, Edition> {

	@Autowired
	private EditionCollectionDao editionCollectionDao;
	@Autowired
	private EditionRevertDao editionRevertDao;

	public Edition get(String id) {
		Edition edition = super.get(id);
		edition.setEditionCollectionList(editionCollectionDao.findList(new EditionCollection(edition)));
		edition.setEditionRevertList(editionRevertDao.findList(new EditionRevert(edition)));
		return edition;
	}

	public List<Edition> findList(Edition edition) {
		return super.findList(edition);
	}

	public Page<Edition> findPage(Page<Edition> page, Edition edition) {
		return super.findPage(page, edition);
	}

	@Transactional(readOnly = false)
	public void save(Edition edition) {
		super.save(edition);
		for (EditionCollection editionCollection : edition.getEditionCollectionList()) {
			if (editionCollection.getId() == null) {
				continue;
			}
			if (EditionCollection.DEL_FLAG_NORMAL.equals(editionCollection.getDelFlag())) {
				if (StringUtils.isBlank(editionCollection.getId())) {
					editionCollection.setEdition(edition);
					editionCollection.preInsert();
					editionCollectionDao.insert(editionCollection);
				} else {
					editionCollection.preUpdate();
					editionCollectionDao.update(editionCollection);
				}
			} else {
				editionCollectionDao.delete(editionCollection);
			}
		}
		for (EditionRevert editionRevert : edition.getEditionRevertList()) {
			if (editionRevert.getId() == null) {
				continue;
			}
			if (EditionRevert.DEL_FLAG_NORMAL.equals(editionRevert.getDelFlag())) {
				if (StringUtils.isBlank(editionRevert.getId())) {
					editionRevert.setEdition(edition);
					editionRevert.preInsert();
					editionRevertDao.insert(editionRevert);
				} else {
					editionRevert.preUpdate();
					editionRevertDao.update(editionRevert);
				}
			} else {
				editionRevertDao.delete(editionRevert);
			}
		}
	}

	@Transactional(readOnly = false)
	public void delete(Edition edition) {
		super.delete(edition);
		editionCollectionDao.delete(new EditionCollection(edition));
		editionRevertDao.delete(new EditionRevert(edition));
	}

	public List<Map<String, String>> query(Edition edition) {
		return dao.query(edition);
	}

	public List<Map<String, String>> editionShow(Edition edition) {
		List<Map<String, String>> editionShow = dao.editionShow(edition);
		Iterator<Map<String, String>> iterator = editionShow.iterator();
		while (iterator.hasNext()) {
			Map<String, String> next = iterator.next();
			Set<String> keySet = next.keySet();
			Iterator<String> iterator2 = keySet.iterator();
			while (iterator2.hasNext()) {
				String next2 = iterator2.next();
				if ("requirementSource".equals(next2)) {
					String string = next.get(next2);
					next.put(next2, DictUtils.getDictLabel(string, "requirement_source", ""));
				} else if ("requirementClassify".equals(next2)) {
					String string = next.get(next2);
					next.put(next2, DictUtils.getDictLabel(string, "requirement_classify", ""));
				} else if ("businessSystem".equals(next2)) {
					String string = next.get(next2);
					next.put(next2, DictUtils.getDictLabel(string, "business_system", ""));
				} else if ("createBy".equals(next2)) {
					String string = next.get(next2);
					next.put(next2, DictUtils.getDictLabel(string, "create_by", ""));
				}
			}
		}
		return editionShow;
	}

	public void addRequirement(Map<String, String> param) {
		dao.addRequirement(param);
	}
}