<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>


<html>
<head>
	<title>开发任务创建管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/devtask/devTask/">开发任务列表</a></li>
		<li><a href="${ctx}/devtask/devTask/form">开发任务创建添加</a> 
	</ul>
	<form:form id="searchForm" modelAttribute="devTask" action="${ctx}/devtask/devTask/list?tt=${tasksn}" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		
			<li><label>需求来源：</label> <form:select path="requirementSource"
					class="input-medium">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('requirement_source')}"
						itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select></li>
			<li><label>需求分类：</label> <form:select path="requirementClassify"
					class="input-medium">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('requirement_classify')}"
						itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select></li>
			<li><label>业务系统：</label> <form:select path="businessSystem"
					class="input-medium">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('business_system')}"
						itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select></li>
			<li><label>需求紧急程度：</label> <form:select
					path="requirementEmergency" class="input-medium">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('requirement_emergency')}"
						itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select></li>
			<li><label>创建时间：</label> <input name="createDate" type="text"
				readonly="readonly" maxlength="20" class="input-medium Wdate"
				value="<fmt:formatDate value="${requirements.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>开发任务编号</th>
				<th>创建时间</th>
				<shiro:hasPermission name="devtask:devTask:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="devTask">
			<tr>
					<td>${devTask.id}</td>
					<td><fmt:formatDate value="${devTask.createDate}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>				
				<c:choose>
				  <c:when test="${tasksn=='assign'}">
				   <a href="${ctx}/devtaskassign/developTaskassign/form?requirementsId=${devTask.id}">指派</a>
				 
				  </c:when>
				  <c:when test="${tasksn=='cancel'}">
				   <a href="${ctx}/devtaskcancel/developTaskcancel/form?requirementsId=${devTask.id}">撤销</a>
				  
				  </c:when>
				  <c:when test="${tasksn=='pro'}">
				   <a href="${ctx}/devtaskpro/developTaskpro/form?requirementsId=${devTask.id}">跟进</a>
				  
				  </c:when>
				  <c:otherwise>
				  </c:otherwise>
				</c:choose>
    				<a href="${ctx}/devtask/devTask/form?id=${devTask.id}">修改</a>
					<a href="${ctx}/devtask/devTask/delete?id=${devTask.id}" onclick="return confirmx('确认要删除该开发任务创建吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>