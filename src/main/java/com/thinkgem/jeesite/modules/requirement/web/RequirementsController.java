/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.web;

import java.util.ArrayList;
import java.util.List;

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
import com.thinkgem.jeesite.modules.allocation.entity.TaskAllocation;
import com.thinkgem.jeesite.modules.allocation.service.TaskAllocationService;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirement.service.RequirementsService;

/**
 * 需求管理Controller
 * 
 * @author weijia
 * @version 2019-05-28
 */
@Controller
@RequestMapping(value = "${adminPath}/requirement/requirements")
public class RequirementsController extends BaseController {

	@Autowired
	private RequirementsService requirementsService;

	@Autowired
	private TaskAllocationService taskAllocationService;

	@ModelAttribute
	public Requirements get(@RequestParam(required = false) String id) {
		Requirements entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = requirementsService.get(id);
		}
		if (entity == null) {
			entity = new Requirements();
		}
		return entity;
	}

	@RequestMapping(value = { "list", "" })
	public String list(Requirements requirements, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<Requirements> page = requirementsService.findPage(new Page<Requirements>(request, response), requirements);
		model.addAttribute("page", page);
		return "modules/requirement/requirementsList";
	}

	@RequestMapping(value = "allocations")
	public String allocations(Requirements requirements, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<Requirements> page = requirementsService.findPage(new Page<Requirements>(request, response), requirements);
		model.addAttribute("page", page);
		return "modules/requirement/requirementsAllocation";
	}

	@RequestMapping(value = "form")
	public String form(Requirements requirements, Model model) {
		model.addAttribute("requirements", requirements);
		return "modules/requirement/requirementsForm";
	}

	@RequestMapping(value = "examine")
	public String examine(Requirements requirements, Model model) {
		model.addAttribute("requirements", requirements);
		return "modules/requirement/requirementsExamine";
	}

	@RequestMapping(value = "waitAllocation")
	public String waitAllocation(Requirements requirements, Model model) {
		model.addAttribute("requirements", requirements);
		return "modules/requirement/requirementswaitAllocation";
	}

	@RequestMapping(value = "showAllocation")
	public String showAllocation(Requirements requirements, Model model) {
		TaskAllocation allocation = taskAllocationService.getAllocationByRequirements(requirements.getId());
		List<TaskAllocation> allocations = new ArrayList<TaskAllocation>();
		allocations.add(allocation);
		model.addAttribute("requirements", requirements);
		model.addAttribute("allocation", allocations);
		return "modules/requirement/requirementsshowAllocation";
	}

	@RequestMapping(value = "allocation")
	public String allocation(Requirements requirements, Model model) {
		return "modules/requirement/requirementsAllocation";
	}

	@RequestMapping(value = "requirementChild")
	public String requirementChild(Requirements requirements, Model model) {
		return "modules/requirement/requirementsChild";
	}

	@RequestMapping(value = "requirementChilds")
	public String requirementChilds(Requirements requirements, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<Requirements> page = requirementsService.findPage(new Page<Requirements>(request, response), requirements);
		model.addAttribute("page", page);
		return "modules/requirement/requirementsChild";
	}

	@RequestMapping(value = "examines")
	public String examines(Requirements requirements, HttpServletRequest request, HttpServletResponse response,
			Model model) {

		if (requirements.getRequirementSource() != null && (!"".equals(requirements.getRequirementSource())
				|| !"".equals(requirements.getRequirementClassify()))) {
			Page<Requirements> page = requirementsService.findPage(new Page<Requirements>(request, response),
					requirements);
			model.addAttribute("page", page);
		}
		return "modules/requirement/requirementsExamines";
	}

	@RequestMapping(value = "save")
	public String save(Requirements requirements, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, requirements)) {
			return form(requirements, model);
		}
		requirementsService.save(requirements);
		addMessage(redirectAttributes, "保存需求创建成功");
		return "redirect:" + Global.getAdminPath() + "/requirement/requirements/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(Requirements requirements, RedirectAttributes redirectAttributes) {
		requirementsService.delete(requirements);
		addMessage(redirectAttributes, "删除需求创建成功");
		return "redirect:" + Global.getAdminPath() + "/requirement/requirements/?repage";
	}

}