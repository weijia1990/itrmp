/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.requirement.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirement.service.RequirementsService;

/**
 * 需求管理Controller
 * @author weijia
 * @version 2019-05-28
 */
@Controller
@RequestMapping(value = "${adminPath}/requirement/requirements")
public class RequirementsController extends BaseController {

	@Autowired
	private RequirementsService requirementsService;
	
	@ModelAttribute
	public Requirements get(@RequestParam(required=false) String id) {
		Requirements entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = requirementsService.get(id);
		}
		if (entity == null){
			entity = new Requirements();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(Requirements requirements, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Requirements> page = requirementsService.findPage(new Page<Requirements>(request, response), requirements); 
		model.addAttribute("page", page);
		return "modules/requirement/requirementsList";
	}

	@RequestMapping(value = "form")
	public String form(Requirements requirements, Model model) {
		model.addAttribute("requirements", requirements);
		return "modules/requirement/requirementsForm";
	}

	@RequestMapping(value = "save")
	public String save(Requirements requirements, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, requirements)){
			return form(requirements, model);
		}
		requirementsService.save(requirements);
		addMessage(redirectAttributes, "保存需求创建成功");
		return "redirect:"+Global.getAdminPath()+"/requirement/requirements/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Requirements requirements, RedirectAttributes redirectAttributes) {
		requirementsService.delete(requirements);
		addMessage(redirectAttributes, "删除需求创建成功");
		return "redirect:"+Global.getAdminPath()+"/requirement/requirements/?repage";
	}

}