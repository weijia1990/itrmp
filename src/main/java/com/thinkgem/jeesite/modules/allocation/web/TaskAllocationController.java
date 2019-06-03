/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.allocation.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.allocation.entity.TaskAllocation;
import com.thinkgem.jeesite.modules.allocation.service.TaskAllocationService;
import com.thinkgem.jeesite.modules.requirement.entity.Requirements;
import com.thinkgem.jeesite.modules.requirement.service.RequirementsService;

/**
 * 需求分配Controller
 * 
 * @author weijia
 * @version 2019-05-30
 */
@Controller
@RequestMapping(value = "${adminPath}/allocation/taskAllocation")
public class TaskAllocationController extends BaseController {

	@Autowired
	private TaskAllocationService taskAllocationService;
	@Autowired
	private RequirementsService requirementsService;

	@ModelAttribute
	public Requirements get(@RequestParam(required = false) String id) {
		return new Requirements();
	}

	@RequestMapping(value = "save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		String requirementsId = request.getParameter("id");
		String requirementResponsePerson = request.getParameter("allocationList.requirementResponsePerson");
		Date expectFinsh = DateUtils.parseDate(request.getParameter("allocationList.expectFinsh"));

		TaskAllocation taskAllocation = createTaskAllocation(requirementsId, requirementResponsePerson, expectFinsh);
		Requirements requirements = taskAllocationService.changeAllocationStatus(requirementsId, "1");

		taskAllocationService.save(taskAllocation);
		requirementsService.update(requirements);
		return "modules/requirement/requirementsAllocation";
	}

	private TaskAllocation createTaskAllocation(String requirementsId, String requirementResponsePerson,
			Date expectFinsh) {
		TaskAllocation taskAllocation = new TaskAllocation();
		taskAllocation.setRequirementsId(requirementsId);
		taskAllocation.setRequirementResponsePerson(requirementResponsePerson);
		taskAllocation.setExpectFinsh(expectFinsh);
		return taskAllocation;
	}
}