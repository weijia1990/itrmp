/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskpro.web;

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
import com.thinkgem.jeesite.modules.devtaskpro.entity.DevelopTaskpro;
import com.thinkgem.jeesite.modules.devtaskpro.service.DevelopTaskproService;

/**
 * 开发任务跟进Controller
 * @author ygj
 * @version 2019-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/devtaskpro/developTaskpro")
public class DevelopTaskproController extends BaseController {

	@Autowired
	private DevelopTaskproService developTaskproService;
	
	@ModelAttribute
	public DevelopTaskpro get(@RequestParam(required=false) String id) {
		DevelopTaskpro entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = developTaskproService.get(id);
		}
		if (entity == null){
			entity = new DevelopTaskpro();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(DevelopTaskpro developTaskpro, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DevelopTaskpro> page = developTaskproService.findPage(new Page<DevelopTaskpro>(request, response), developTaskpro); 
		model.addAttribute("page", page);
		return "modules/devtaskpro/developTaskproList";
	}

	@RequestMapping(value = "form")
	public String form(DevelopTaskpro developTaskpro, Model model) {
		model.addAttribute("developTaskpro", developTaskpro);
		return "modules/devtaskpro/developTaskproForm";
	}

	@RequestMapping(value = "save")
	public String save(DevelopTaskpro developTaskpro, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, developTaskpro)){
			return form(developTaskpro, model);
		}
		developTaskproService.save(developTaskpro);
		addMessage(redirectAttributes, "保存开发任务跟进成功");
		return "redirect:"+Global.getAdminPath()+"/devtaskpro/developTaskpro/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(DevelopTaskpro developTaskpro, RedirectAttributes redirectAttributes) {
		developTaskproService.delete(developTaskpro);
		addMessage(redirectAttributes, "删除开发任务跟进成功");
		return "redirect:"+Global.getAdminPath()+"/devtaskpro/developTaskpro/?repage";
	}

}