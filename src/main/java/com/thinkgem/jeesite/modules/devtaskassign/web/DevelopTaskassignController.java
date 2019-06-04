/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskassign.web;

import java.util.Date;

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
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.allocation.entity.TaskAllocation;
import com.thinkgem.jeesite.modules.devtaskassign.entity.DevelopTaskassign;
import com.thinkgem.jeesite.modules.devtaskassign.service.DevelopTaskassignService;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;

/**
 * 开发任务指派Controller
 * @author ygj
 * @version 2019-06-03
 */
@Controller
@RequestMapping(value = "${adminPath}/devtaskassign/developTaskassign")
public class DevelopTaskassignController extends BaseController {

	@Autowired
	private DevelopTaskassignService developTaskassignService;
	
	@ModelAttribute
	public DevelopTaskassign get(@RequestParam(required=false) String id) {
		DevelopTaskassign entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = developTaskassignService.get(id);
		}
		if (entity == null){
			entity = new DevelopTaskassign();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(DevelopTaskassign developTaskassign, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DevelopTaskassign> page = developTaskassignService.findPage(new Page<DevelopTaskassign>(request, response), developTaskassign); 
		model.addAttribute("page", page);
		return "modules/devtaskassign/developTaskassignList";
	}

	/*@RequestMapping(value = "form")
	public String form(DevelopTaskassign developTaskassign, Model model) {
		model.addAttribute("developTaskassign", developTaskassign);
		return "modules/devtaskassign/developTaskassignForm";
	}*/
	@RequestMapping(value = "form")
	public String forms(HttpServletRequest request, HttpServletResponse response,DevelopTaskassign developTaskassign, Model model) {
		String requirementsId = request.getParameter("requirementsId");
        developTaskassign.setTaskId(requirementsId);
		model.addAttribute("developTaskassign", developTaskassign);
		return "modules/devtaskassign/developTaskassignForm";
	}

	@RequestMapping(value = "save")
	public String save(DevelopTaskassign developTaskassign, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, developTaskassign)){
			return forms(null, null, developTaskassign, model);
		}
		developTaskassignService.save(developTaskassign);
		addMessage(redirectAttributes, "保存开发任务指派成功");
		return "redirect:"+Global.getAdminPath()+"/devtaskassign/developTaskassign/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(DevelopTaskassign developTaskassign, RedirectAttributes redirectAttributes) {
		developTaskassignService.delete(developTaskassign);
		addMessage(redirectAttributes, "删除开发任务指派成功");
		return "redirect:"+Global.getAdminPath()+"/devtaskassign/developTaskassign/?repage";
	}

	@RequestMapping(value = "assign")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		String requirementsId = request.getParameter("id");
		DevelopTaskassignService   developTaskassignService=new DevelopTaskassignService();
		DevelopTaskassign developTaskassign =new DevelopTaskassign();
		developTaskassign.setTaskId(requirementsId);
		developTaskassignService.save(developTaskassign);
		return "modules/devtaskassign/developTaskassignForm";
	}
	
}