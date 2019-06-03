/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirementchild.web;

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
import com.thinkgem.jeesite.modules.requirementchild.entity.RequirementChild;
import com.thinkgem.jeesite.modules.requirementchild.service.RequirementChildService;

/**
 * 子需求管理Controller
 * 
 * @author weijia
 * @version 2019-06-02
 */
@Controller
@RequestMapping(value = "${adminPath}/requirementchild/requirementChild")
public class RequirementChildController extends BaseController {

	@Autowired
	private RequirementChildService requirementChildService;

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
		Page<RequirementChild> page = requirementChildService.findPage(new Page<RequirementChild>(request, response),
				requirementChild);
		model.addAttribute("page", page);
		return "modules/requirementchild/requirementChildList";
	}

	@RequestMapping(value = "form")
	public String form(RequirementChild requirementChild, HttpServletRequest request, Model model) {
		String requirementId = request.getParameter("requirementId");
		model.addAttribute("requirementChild", requirementChild);
		model.addAttribute("requirementId", requirementId);
		return "modules/requirementchild/requirementChildForm";
	}

	@RequestMapping(value = "save")
	public String save(RequirementChild requirementChild, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, requirementChild)) {
			return form(requirementChild, null, model);
		}
		requirementChildService.save(requirementChild);
		addMessage(redirectAttributes, "保存子需求管理成功");
		return "redirect:" + Global.getAdminPath() + "/requirement/requirements/requirementChild";
	}

	@RequestMapping(value = "delete")
	public String delete(RequirementChild requirementChild, RedirectAttributes redirectAttributes) {
		requirementChildService.delete(requirementChild);
		addMessage(redirectAttributes, "删除子需求管理成功");
		return "redirect:" + Global.getAdminPath() + "/requirementchild/requirementChild/?repage";
	}

}