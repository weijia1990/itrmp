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
		<li class="active"><a href="${ctx}/devtask/devTask/">开发任务创建列表</a></li>
		<shiro:hasPermission name="devtask:devTask:edit"><li><a href="${ctx}/devtask/devTask/form">开发任务创建添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="devTask" action="${ctx}/devtask/devTask/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新日期</th>
				<th>标记</th>
				<shiro:hasPermission name="devtask:devTask:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="devTask">
			<tr>
				<td><a href="${ctx}/devtask/devTask/form?id=${devTask.id}">
					<fmt:formatDate value="${devTask.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${devTask.remarks}
				</td>
				<td>
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