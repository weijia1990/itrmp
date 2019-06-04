/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtaskcancel.web;

import java.util.List;

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
import com.thinkgem.jeesite.modules.devtaskcancel.entity.DevelopTaskcancel;
import com.thinkgem.jeesite.modules.devtaskcancel.service.DevelopTaskcancelService;

/**
 * 开发任务撤销Controller
 * @author ygj
 * @version 2019-06-03
 */
@Controller
@RequestMapping(value = "${adminPath}/devtaskcancel/developTaskcancel")
public class DevelopTaskcancelController extends BaseController {

	@Autowired
	private DevelopTaskcancelService developTaskcancelService;
	
	@ModelAttribute
	public DevelopTaskcancel get(@RequestParam(required=false) String id) {
		DevelopTaskcancel entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = developTaskcancelService.get(id);
		}
		if (entity == null){
			entity = new DevelopTaskcancel();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(DevelopTaskcancel developTaskcancel, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DevelopTaskcancel> page = developTaskcancelService.findPage(new Page<DevelopTaskcancel>(request, response), developTaskcancel); 
		model.addAttribute("page", page);
		return "modules/devtaskcancel/developTaskcancelList";
	}

	@RequestMapping(value = "form")
	public String forms(HttpServletRequest request, HttpServletResponse response,DevelopTaskcancel developTaskcancel, Model model) {
		String requirementsId = request.getParameter("requirementsId");
		List<DevelopTaskcancel> findList = developTaskcancelService.findList(developTaskcancel);
		if (findList.size()>0) {
			developTaskcancel.setDelFlag("1");
		}
		developTaskcancel.setTaskId(requirementsId);
		model.addAttribute("developTaskcancel", developTaskcancel);
		return "modules/devtaskcancel/developTaskcancelForm";
	}

	@RequestMapping(value = "save")
	public String save(DevelopTaskcancel developTaskcancel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, developTaskcancel)){
			return forms(null, null, developTaskcancel, model);
		}
		developTaskcancelService.save(developTaskcancel);
		addMessage(redirectAttributes, "保存开发任务撤销成功");
		return "redirect:"+Global.getAdminPath()+"/devtaskcancel/developTaskcancel/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(DevelopTaskcancel developTaskcancel, RedirectAttributes redirectAttributes) {
		developTaskcancelService.delete(developTaskcancel);
		addMessage(redirectAttributes, "删除开发任务撤销成功");
		return "redirect:"+Global.getAdminPath()+"/devtaskcancel/developTaskcancel/?repage";
	}

}