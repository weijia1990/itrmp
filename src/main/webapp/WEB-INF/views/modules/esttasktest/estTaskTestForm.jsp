<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>测试任务创建管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
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
		<li class="active"><a href="${ctx}/esttasktest/estTaskTest/form?id=${estTaskTest.id}">测试任务创建<shiro:hasPermission name="esttasktest:estTaskTest:edit">${not empty estTaskTest.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="esttasktest:estTaskTest:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="estTaskTest" action="${ctx}/esttasktest/estTaskTest/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">需求来源：</label>
			<div class="controls">
				<form:input path="requirementSource" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求分类：</label>
			<div class="controls">
				<form:input path="requirementClassify" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务系统：</label>
			<div class="controls">
				<form:input path="businessSystem" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求紧急程度：</label>
			<div class="controls">
				<form:input path="requirementEmergency" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务标题：</label>
			<div class="controls">
				<form:input path="taskTestTitle" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">签报号：</label>
			<div class="controls">
				<form:input path="signNo" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">测试负责人：</label>
			<div class="controls">
				<form:select path="testIncharge" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开发负责人：</label>
			<div class="controls">
				<form:input path="developIncharge" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开发工作量：</label>
			<div class="controls">
				<form:input path="developWorkAccount" htmlEscape="false" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">计划上线时间：</label>
			<div class="controls">
				<input name="explanOnline" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${estTaskTest.explanOnline}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">提交系统测试时间：</label>
			<div class="controls">
				<input name="submitTestSystime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${estTaskTest.submitTestSystime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开发规模(代码行数)：</label>
			<div class="controls">
				<form:input path="developScale" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">涉及系统：</label>
			<div class="controls">
				<form:select path="relatedSystem" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="comments" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">测试环境：</label>
			<div class="controls">
				<form:input path="testEnvironment" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">测试范围：</label>
			<div class="controls">
				<form:input path="testRange" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">测试申请描述：</label>
			<div class="controls">
				<form:input path="testApplicationDesc" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">测试要点及建议：</label>
			<div class="controls">
				<form:input path="testPointsAdvice" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附件：</label>
			<div class="controls">
				<form:input path="appendix" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit"  name="esttasktest:estTaskTest:edit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>