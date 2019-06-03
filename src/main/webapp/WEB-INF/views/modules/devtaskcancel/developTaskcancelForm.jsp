<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>开发任务撤销管理</title>
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
		<li><a href="${ctx}/devtaskcancel/developTaskcancel/">开发任务撤销列表</a></li>
		<li class="active"><a href="${ctx}/devtaskcancel/developTaskcancel/form?id=${developTaskcancel.id}">开发任务撤销<shiro:hasPermission name="devtaskcancel:developTaskcancel:edit">${not empty developTaskcancel.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="devtaskcancel:developTaskcancel:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="developTaskcancel" action="${ctx}/devtaskcancel/developTaskcancel/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">撤销日期：</label>
			<div class="controls">
				<input name="cancelTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${developTaskcancel.cancelTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">撤销说明：</label>
			<div class="controls">
				<form:input path="cancelDesc" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			 <input id="btnSubmit" name="devtaskcancel:developTaskcancel:edit" class="btn btn-primary" type="submit" value="提交"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>