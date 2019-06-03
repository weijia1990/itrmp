/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtask.web;

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
import com.thinkgem.jeesite.modules.devtask.entity.DevTask;
import com.thinkgem.jeesite.modules.devtask.service.DevTaskService;

/**
 * 开发任务创建Controller
 * @author ygj
 * @version 2019-05-31
 */
@Controller
@RequestMapping(value = "${adminPath}/devtask/devTask")
public class DevTaskController extends BaseController {

	@Autowired
	private DevTaskService devTaskService;
	
	@ModelAttribute
	public DevTask get(@RequestParam(required=false) String id) {
		DevTask entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = devTaskService.get(id);
		}
		if (entity == null){
			entity = new DevTask();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(DevTask devTask, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DevTask> page = devTaskService.findPage(new Page<DevTask>(request, response), devTask); 
		model.addAttribute("page", page);
		return "modules/devtask/devTaskList";
	}

	@RequestMapping(value = "form")
	public String form(DevTask devTask, Model model) {
		model.addAttribute("devTask", devTask);
		return "modules/devtask/devTaskForm";
	}

	@RequestMapping(value = "save")
	public String save(DevTask devTask, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, devTask)){
			return form(devTask, model);
		}
		devTaskService.save(devTask);
		addMessage(redirectAttributes, "保存开发任务创建成功");
		return "redirect:"+Global.getAdminPath()+"/devtask/devTask/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(DevTask devTask, RedirectAttributes redirectAttributes) {
		devTaskService.delete(devTask);
		addMessage(redirectAttributes, "删除开发任务创建成功");
		return "redirect:"+Global.getAdminPath()+"/devtask/devTask/?repage";
	}

}