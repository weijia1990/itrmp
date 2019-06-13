<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>版本归集管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/collection/edition/">版本归集列表</a></li>
		<shiro:hasPermission name="collection:edition:edit">
			<li><a href="${ctx}/collection/edition/form">版本归集添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="edition"
		action="${ctx}/collection/edition/query" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>需求版本：</label> <form:input
					path="editionCollectionList[0].editionFiles" htmlEscape="false"
					maxlength="50" class="input-medium" /></li>
			<li><label>版本上线时间：</label> <form:input
					path="editionCollectionList[0].timeOnline" htmlEscape="false"
					maxlength="50" class="input-medium" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>版本编号</th>
				<th>需求版本</th>
				<th>版本上线时间</th>
				<th>创建时间</th>
				<th>创建人</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="edition">
				<tr>
					<td>${edition.id}</td>
					<td>${edition.editionCollectionList[0].editionFiles}</td>
					<td>${edition.editionCollectionList[0].timeOnline}</td>
					<td>${edition.createDate}</td>
					<td>${edition.createBy}</td>
					<td><a href="${ctx}/collection/edition/show?id=${edition.id}">查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>