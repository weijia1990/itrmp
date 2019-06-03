<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>开发任务跟进管理</title>
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
		<li class="active"><a href="${ctx}/devtaskpro/developTaskpro/">开发任务跟进列表</a></li>
		<shiro:hasPermission name="devtaskpro:developTaskpro:edit"><li><a href="${ctx}/devtaskpro/developTaskpro/form">开发任务跟进添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="developTaskpro" action="${ctx}/devtaskpro/developTaskpro/" method="post" class="breadcrumb form-search">
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
				<shiro:hasPermission name="devtaskpro:developTaskpro:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="developTaskpro">
			<tr>
				<td><a href="${ctx}/devtaskpro/developTaskpro/form?id=${developTaskpro.id}">
					<fmt:formatDate value="${developTaskpro.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${developTaskpro.remarks}
				</td>
				<td>
    				<a href="${ctx}/devtaskpro/developTaskpro/form?id=${developTaskpro.id}">修改</a>
					<a href="${ctx}/devtaskpro/developTaskpro/delete?id=${developTaskpro.id}" onclick="return confirmx('确认要删除该开发任务跟进吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>