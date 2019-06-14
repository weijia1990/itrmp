<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>测试任务创建管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
		//$("#name").focus();
		$("#inputForm").validate({
			submitHandler : function(form) {
				loading('正在提交，请稍等...');
				form.submit();
			},
			errorContainer : "#messageBox",
			errorPlacement : function(error, element) {
				$("#messageBox").text("输入有误，请先更正。");
				if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
					error.appendTo(element.parent().parent());
				} else {
					error.insertAfter(element);
				}
			}
		});
	});
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/esttasktest/estTaskTest/">测试任务创建列表</a></li>
		<li class="active"><a
			href="${ctx}/esttasktest/estTaskTest/form?id=${estTaskTest.id}">测试任务创建<shiro:hasPermission
					name="esttasktest:estTaskTest:edit">${not empty estTaskTest.id?'修改':'添加'}</shiro:hasPermission>
				</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="estTaskTest"
		action="${ctx}/esttasktest/estTaskTest/save?requestId=${estTaskTest.requestId}"
		method="post" class="form-horizontal">
		<form:hidden path="id" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">测试任务来源：</label>
			<div class="controls">
				<form:input path="requirementSource" htmlEscape="false"
					maxlength="100" class="input-xlarge " value="需求部门" disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务标题：</label>
			<div class="controls">
				<form:input path="requirementClassify" htmlEscape="false"
					maxlength="100" class="input-xlarge " value="核心系统开发"
					disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">涉及系统：</label>
			<div class="controls">
				<form:input path="businessSystem" htmlEscape="false" maxlength="100"
					class="input-xlarge " value="核保系统" disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">紧急程度：</label>
			<div class="controls">
				<form:input path="requirementEmergency" htmlEscape="false"
					maxlength="100" class="input-xlarge " value="紧急" disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">申请人：</label>
			<div class="controls">
				<form:input path="taskTestTitle" htmlEscape="false" maxlength="200"
					class="input-xlarge " value="王工" disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">关联需求：</label>
			<div class="controls">
				<form:input path="signNo" htmlEscape="false" maxlength="1000"
					class="input-xlarge " value="A00001" disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">测试负责人：</label>
			<div class="controls">
				<form:select path="testIncharge" class="input-xlarge ">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('')}" itemLabel="label"
						itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">计划UAT完成时间：</label>
			<div class="controls">
				<form:input path="developIncharge" htmlEscape="false"
					maxlength="100" class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="developWorkAccount" htmlEscape="false"
					maxlength="200" class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务概述：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4"
					maxlength="255" class="input-xxlarge
				required" />
			</div>
		</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" name="esttasktest:estTaskTest:edit"
				class="btn btn-primary" type="submit" value="保 存" />&nbsp; <input
				id="btnSubmit" name="esttasktest:estTaskTest:edit"
				class="btn btn-primary" type="submit" value="提 交" />&nbsp; <input
				id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>