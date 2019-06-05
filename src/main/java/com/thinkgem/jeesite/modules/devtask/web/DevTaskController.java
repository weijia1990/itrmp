/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.devtask.web;

import java.util.List;
import java.util.Map;

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
import com.thinkgem.jeesite.modules.devtask.entity.ReqTaskUn;
import com.thinkgem.jeesite.modules.devtask.service.DevTaskService;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;

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
	//	Page<DevTask> page = devTaskService.findPage(new Page<DevTask>(request, response), devTask); 
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		Requirements requirements=new Requirements();
		model.addAttribute("requirements", requirements);
		model.addAttribute("page", page);
		String tasksn = request.getParameter("tt");
		model.addAttribute("tasksn", tasksn);
		return "modules/devtask/devTaskList";
	}
	@RequestMapping(value = "query")
	public String query(Requirements requirements,HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Map<String, String>> query = devTaskService.query(requirements);
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		page.setList(query);
		model.addAttribute("page", page);
		String tasksn = request.getParameter("tt");
		model.addAttribute("tasksn", tasksn);
		return "modules/devtask/devTaskList";
	}
	@RequestMapping(value = "form")
	public String form(DevTask devTask, Model model) {
		model.addAttribute("devTask", devTask);
		return "modules/devtask/devTaskForm";
	}
	@RequestMapping(value = "forms")
	public String forms(DevTask devTask,HttpServletRequest request, HttpServletResponse response, Model model) {
		String requestIds = request.getParameter("requestId");
		devTask.setRequerstId(requestIds);
		model.addAttribute("devTask", devTask);
		return "modules/devtask/devTaskForm";
	}
	@RequestMapping(value = "reqToTask")
	public String reqToTask(DevTask devTask, Model model) {
		model.addAttribute("devTask", devTask);
		String dev="dev";
		model.addAttribute("cdt", dev);
		return "modules/devtask/requestToTaskList";
	}
	@RequestMapping(value = "reqToTest")
	public String reqToTest(DevTask devTask, Model model) {
		model.addAttribute("devTask", devTask);
		String tests="tests";
		model.addAttribute("cdt", tests);
		return "modules/devtask/requestToTaskList";
	}

	@RequestMapping(value = "save")
	public String save(DevTask devTask, Model model,HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, devTask)){
			return form(devTask, model);
		}
		String requestIds = request.getParameter("requestId");
		devTask.setRequerstId(requestIds);
		
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