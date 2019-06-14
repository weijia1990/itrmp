/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.collection.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.collection.entity.Edition;
import com.thinkgem.jeesite.modules.collection.service.EditionService;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;
import com.thinkgem.jeesite.modules.requirementchild.service.RequirementChildService;

/**
 * 版本归集Controller
 * 
 * @author weijia
 * @version 2019-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/collection/edition")
public class EditionController extends BaseController {

	@Autowired
	private EditionService editionService;
	@Autowired
	private RequirementChildService requirementChildService;

	@ModelAttribute
	public Edition get(@RequestParam(required = false) String id) {
		Edition entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = editionService.get(id);
		}
		if (entity == null) {
			entity = new Edition();
		}
		return entity;
	}

	@RequestMapping(value = "editionAuditQueryMainPage")
	public String editionAuditQueryMainPage(Edition edition,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		return "modules/collection/editionAuditQueryMainPage";
	}

	@RequestMapping(value = "editionAuditQuery")
	public String editionAuditQuery(Edition edition,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		return "modules/collection/editionAuditQuery";
	}

	@RequestMapping(value = "editionOnlineApl")
	public String editionOnlineApply(Edition edition,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		return "modules/collection/editionOnlineApl";
	}

	@RequestMapping(value = "editionOnlineAudit")
	public String editionOnlineAudit(Edition edition,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		return "modules/collection/editionOnlineAudit";
	}

	@RequestMapping(value = "editionOnlineImpl")
	public String editionOnlineImpl(Edition edition,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		return "modules/collection/editionOnlineImpl";
	}

	@RequestMapping(value = { "list", "" })
	public String list(Edition edition, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<Edition> page = editionService.findPage(new Page<Edition>(request,
				response), edition);
		model.addAttribute("page", page);
		return "modules/collection/editionList";
	}

	@RequestMapping(value = "query")
	public String query(Edition edition, Model model) {
		List<Map<String, String>> query = editionService.query(edition);
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		page.setList(query);
		model.addAttribute("page", page);
		return "modules/collection/editionList";
	}

	@RequestMapping(value = "form")
	public String form(Edition edition, Model model) {
		model.addAttribute("edition", edition);
		return "modules/collection/editionForm";
	}

	@RequestMapping(value = "addRequirement")
	public String addRequirement(Edition edition, Model model,
			HttpServletRequest request) {
		model.addAttribute("edition", edition);
		String reId = request.getParameter("reId");
		try {
			RequirementChild requirementChild = requirementChildService
					.get(reId);
		} catch (Exception e) {
			model.addAttribute("message", "需求编号不存在！");
			return "redirect:" + Global.getAdminPath()
					+ "/collection/edition/show?id=" + edition.getId();
		}

		Map<String, String> param = new HashMap<String, String>();
		param.put("reId", reId);
		param.put("editionId", edition.getId());
		editionService.addRequirement(param);
		return "redirect:" + Global.getAdminPath()
				+ "/collection/edition/show?id=" + edition.getId();
	}

	@RequestMapping(value = "show")
	public String show(Edition edition, Model model) {
		edition = editionService.get(edition.getId());
		List<Map<String, String>> editionShow = editionService
				.editionShow(edition);
		model.addAttribute("edition", edition);
		model.addAttribute("requirementList", editionShow);
		return "modules/collection/editionShow";
	}

	@RequestMapping(value = "save")
	public String save(Edition edition, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, edition)) {
			return form(edition, model);
		}
		editionService.save(edition);
		addMessage(redirectAttributes, "保存版本归集成功");
		return "redirect:" + Global.getAdminPath()
				+ "/collection/edition/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Edition edition, RedirectAttributes redirectAttributes) {
		editionService.delete(edition);
		addMessage(redirectAttributes, "删除版本归集成功");
		return "redirect:" + Global.getAdminPath()
				+ "/collection/edition/?repage";
	}

}