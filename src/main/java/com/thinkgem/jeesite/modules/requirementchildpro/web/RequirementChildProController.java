/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchildpro.web;

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
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;
import com.thinkgem.jeesite.modules.requirementchildpro.service.RequirementChildProService;

/**
 * 子需求进度管理Controller
 * 
 * @author weijia
 * @version 2019-06-03
 */
@Controller
@RequestMapping(value = "${adminPath}/requirementchildpro/requirementChild")
public class RequirementChildProController extends BaseController {

	@Autowired
	private RequirementChildProService requirementChildService;

	@ModelAttribute
	public RequirementChild get(@RequestParam(required = false) String id) {
		RequirementChild entity = null;
		if (StringUtils.isNotBlank(id)) {
			try {
				entity = requirementChildService.get(id);
			} catch (Exception e) {
			}
		}
		if (entity == null) {
			entity = new RequirementChild();
		}
		return entity;
	}

	@RequestMapping(value = { "list", "" })
	public String list(RequirementChild requirementChild, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		model.addAttribute("requirements", new Requirements());
		return "modules/requirementchildpro/requirementChildProList";
	}

	@RequestMapping(value = "form")
	public String form(RequirementChild requirementChild, Model model) {
		model.addAttribute("requirementChild", requirementChild);
		return "modules/requirementchildpro/requirementChildProForm";
	}

	@RequestMapping(value = "query")
	public String query(Requirements requirements, Model model) {
		List<Map<String, String>> query = requirementChildService.query(requirements);
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		page.setList(query);
		model.addAttribute("page", page);
		return "modules/requirementchildpro/requirementChildProList";
	}

	@RequestMapping(value = "queryTask")
	public String queryTask(Requirements requirements, Model model, HttpServletRequest request) {
		List<Map<String, String>> query = requirementChildService.queryExamined(requirements);
		String tete = request.getParameter("tete");
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		page.setList(query);
		model.addAttribute("page", page);
		model.addAttribute("tete", tete);
		model.addAttribute("cdt", "dev");
		return "modules/devtask/requestToTaskList";
	}

	@RequestMapping(value = "queryTaskQ")
	public String queryTaskQ(Requirements requirements, Model model, HttpServletRequest request) {
		List<Map<String, String>> query = requirementChildService.queryExamined(requirements);
		String tete = request.getParameter("tete");
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		page.setList(query);
		model.addAttribute("page", page);
		model.addAttribute("tete", tete);
		model.addAttribute("cdt", "dev");
		return "modules/devtask/requestToTaskQeury";
	}

	@RequestMapping(value = "examine")
	public String examine(RequirementChild requirementChild, Model model) {
		model.addAttribute("requirementChild", requirementChild);
		return "modules/requirementchild/requirementChildExamine";
	}

	@RequestMapping(value = "save")
	public String save(RequirementChild requirementChild, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, requirementChild)) {
			return form(requirementChild, model);
		}
		requirementChildService.save(requirementChild);
		addMessage(redirectAttributes, "保存子需求进度管理成功");
		return "redirect:" + Global.getAdminPath() + "/requirementchildpro/requirementChild/?repage";
	}

	@RequestMapping(value = "saveExamine")
	public String saveExamine(RequirementChild requirementChild, Model model, RedirectAttributes redirectAttributes) {
		if (StringUtils.isBlank(requirementChild.getAct().getFlag())
				|| StringUtils.isBlank(requirementChild.getAct().getComment())) {
			addMessage(model, "请填写审核意见。");
			return form(requirementChild, model);
		}
		requirementChildService.saveExamine(requirementChild);
		return "redirect:" + adminPath + "/act/task/todo/";
	}

	@RequestMapping(value = "delete")
	public String delete(RequirementChild requirementChild, RedirectAttributes redirectAttributes) {
		requirementChildService.delete(requirementChild);
		addMessage(redirectAttributes, "删除子需求进度管理成功");
		return "redirect:" + Global.getAdminPath() + "/requirementchildpro/requirementChild/?repage";
	}

}