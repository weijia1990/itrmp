<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>开发任务撤销管理</title>
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
		<li class="active"><a href="${ctx}/devtaskcancel/developTaskcancel/">开发任务撤销列表</a></li>
		<shiro:hasPermission name="devtaskcancel:developTaskcancel:edit"><li><a href="${ctx}/devtaskcancel/developTaskcancel/form">开发任务撤销添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="developTaskcancel" action="${ctx}/devtaskcancel/developTaskcancel/" method="post" class="breadcrumb form-search">
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
				<shiro:hasPermission name="devtaskcancel:developTaskcancel:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="developTaskcancel">
			<tr>
				<td><a href="${ctx}/devtaskcancel/developTaskcancel/form?id=${developTaskcancel.id}">
					<fmt:formatDate value="${developTaskcancel.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${developTaskcancel.remarks}
				</td>
				<shiro:hasPermission name="devtaskcancel:developTaskcancel:edit"><td>
    				<a href="${ctx}/devtaskcancel/developTaskcancel/form?id=${developTaskcancel.id}">修改</a>
					<a href="${ctx}/devtaskcancel/developTaskcancel/delete?id=${developTaskcancel.id}" onclick="return confirmx('确认要删除该开发任务撤销吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>