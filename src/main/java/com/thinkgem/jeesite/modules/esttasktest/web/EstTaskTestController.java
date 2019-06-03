/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.esttasktest.web;

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
import com.thinkgem.jeesite.modules.esttasktest.entity.EstTaskTest;
import com.thinkgem.jeesite.modules.esttasktest.service.EstTaskTestService;

/**
 * 测试任务创建Controller
 * @author ygj
 * @version 2019-06-01
 */
@Controller
@RequestMapping(value = "${adminPath}/esttasktest/estTaskTest")
public class EstTaskTestController extends BaseController {

	@Autowired
	private EstTaskTestService estTaskTestService;
	
	@ModelAttribute
	public EstTaskTest get(@RequestParam(required=false) String id) {
		EstTaskTest entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = estTaskTestService.get(id);
		}
		if (entity == null){
			entity = new EstTaskTest();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(EstTaskTest estTaskTest, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<EstTaskTest> page = estTaskTestService.findPage(new Page<EstTaskTest>(request, response), estTaskTest); 
		model.addAttribute("page", page);
		return "modules/esttasktest/estTaskTestList";
	}

	@RequestMapping(value = "form")
	public String form(EstTaskTest estTaskTest, Model model) {
		model.addAttribute("estTaskTest", estTaskTest);
		return "modules/esttasktest/estTaskTestForm";
	}

	@RequestMapping(value = "save")
	public String save(EstTaskTest estTaskTest, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, estTaskTest)){
			return form(estTaskTest, model);
		}
		estTaskTestService.save(estTaskTest);
		addMessage(redirectAttributes, "保存测试任务创建成功");
		return "redirect:"+Global.getAdminPath()+"/esttasktest/estTaskTest/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(EstTaskTest estTaskTest, RedirectAttributes redirectAttributes) {
		estTaskTestService.delete(estTaskTest);
		addMessage(redirectAttributes, "删除测试任务创建成功");
		return "redirect:"+Global.getAdminPath()+"/esttasktest/estTaskTest/?repage";
	}

}