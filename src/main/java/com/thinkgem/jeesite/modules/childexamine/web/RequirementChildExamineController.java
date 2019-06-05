/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.childexamine.web;

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
import com.thinkgem.jeesite.modules.childexamine.entity.RequirementChildExamine;
import com.thinkgem.jeesite.modules.childexamine.service.RequirementChildExamineService;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;
import com.thinkgem.jeesite.modules.requirementchild.service.RequirementChildService;
import com.thinkgem.jeesite.modules.requirementchildpro.service.RequirementChildProService;

/**
 * 需求审核管理Controller
 * 
 * @author weijia
 * @version 2019-06-04
 */
@Controller
@RequestMapping(value = "${adminPath}/childexamine/requirementChild")
public class RequirementChildExamineController extends BaseController {

	@Autowired
	private RequirementChildService requirementChildService;

	@Autowired
	private RequirementChildProService requirementChildProService;

	@Autowired
	private RequirementChildExamineService requirementChildExamineService;

	@ModelAttribute
	public RequirementChild get(@RequestParam(required = false) String id) {
		RequirementChild entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = requirementChildService.get(id);
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
		return "modules/childexamine/childExamineList";
	}

	@RequestMapping(value = "form")
	public String form(RequirementChild requirementChild, Model model) {
		model.addAttribute("requirementChild", requirementChild);
		return "modules/childexamine/childExamineForm";
	}

	@RequestMapping(value = "updateExamine")
	public String updateExamine(RequirementChild requirementChild, Model model) {
		model.addAttribute("requirementChild", new RequirementChild());
		model.addAttribute("requirements", new Requirements());

		List<RequirementChildExamine> examineList = requirementChild.getRequirementChildExamineList();

		if (examineList.size() > 0) {
			RequirementChildExamine requirementChildExamine = examineList.get(0);
			requirementChildExamine.setRequirementChild(requirementChild);
			requirementChildExamineService.save(requirementChildExamine);
			addMessage(model, "需求审核未通过!");
			return "modules/childexamine/childExamineList";
		}

		requirementChildService.updateExamine(requirementChild);
		addMessage(model, "需求审核通过!");
		return "modules/childexamine/childExamineList";
	}

	@RequestMapping(value = "save")
	public String save(RequirementChild requirementChild, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, requirementChild)) {
			return form(requirementChild, model);
		}
		requirementChildService.save(requirementChild);
		addMessage(redirectAttributes, "保存需求审核管理成功");
		return "redirect:" + Global.getAdminPath() + "/childexamine/requirementChild/?repage";
	}

	@RequestMapping(value = "query")
	public String query(Requirements requirements, Model model) {
		List<Map<String, String>> query = requirementChildProService.queryExamine(requirements);
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		page.setList(query);
		model.addAttribute("page", page);
		return "modules/childexamine/childExamineList";
	}

	@RequestMapping(value = "delete")
	public String delete(RequirementChild requirementChild, RedirectAttributes redirectAttributes) {
		requirementChildService.delete(requirementChild);
		addMessage(redirectAttributes, "删除需求审核管理成功");
		return "redirect:" + Global.getAdminPath() + "/childexamine/requirementChild/?repage";
	}

}