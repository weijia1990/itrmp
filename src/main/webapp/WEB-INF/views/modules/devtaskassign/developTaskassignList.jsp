<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>开发任务指派管理</title>
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
		<li class="active"><a href="${ctx}/devtaskassign/developTaskassign/">开发任务指派列表</a></li>
		<shiro:hasPermission name="devtaskassign:developTaskassign:edit"><li><a href="${ctx}/devtaskassign/developTaskassign/form">开发任务指派添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="developTaskassign" action="${ctx}/devtaskassign/developTaskassign/" method="post" class="breadcrumb form-search">
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
				<shiro:hasPermission name="devtaskassign:developTaskassign:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="developTaskassign">
			<tr>
				<td><a href="${ctx}/devtaskassign/developTaskassign/form?id=${developTaskassign.id}">
					<fmt:formatDate value="${developTaskassign.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${developTaskassign.remarks}
				</td>
				<td>
    				<a href="${ctx}/devtaskassign/developTaskassign/form?id=${developTaskassign.id}">修改</a>
					<a href="${ctx}/devtaskassign/developTaskassign/delete?id=${developTaskassign.id}" onclick="return confirmx('确认要删除该开发任务指派吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>