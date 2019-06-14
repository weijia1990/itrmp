<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>测试管理管理</title>
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
		<li class="active"><a href="${ctx}/testmanager/requirementChild/">测试管理列表</a></li>
		<li><a href="${ctx}/testmanager/requirementChild/form">测试管理添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="requirementChild"
		action="${ctx}/testmanager/requirementChild/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>业务系统：</label> <form:select path="businessSystem"
					class="input-medium">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('')}" itemLabel="label"
						itemValue="value" htmlEscape="false" />
				</form:select></li>
			<li><label>需求紧急程度：</label> <form:select
					path="requirementEmergency" class="input-medium">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('')}" itemLabel="label"
						itemValue="value" htmlEscape="false" />
				</form:select></li>
			<li><label>受理人：</label> <form:input path="responsibleTaxPerson"
					htmlEscape="false" maxlength="1000" class="input-medium" /></li>
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
				<th>需求编号</th>
				<th>子需求标题</th>
				<th>项目归属</th>
				<th>业务系统</th>
				<shiro:hasPermission name="testmanager:requirementChild:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="requirementChild">
				<tr>
					<td><a
						href="${ctx}/testmanager/requirementChild/form?id=${requirementChild.id}">
							${requirementChild.requirements} </a></td>
					<td>${requirementChild.requirementChildTitle}</td>
					<td>${fns:getDictLabel(requirementChild.itemBelonds, '', '')}
					</td>
					<td>${fns:getDictLabel(requirementChild.businessSystem, '', '')}
					</td>
					<shiro:hasPermission name="testmanager:requirementChild:edit">
						<td><a
							href="${ctx}/testmanager/requirementChild/form?id=${requirementChild.id}">修改</a>
							<a
							href="${ctx}/testmanager/requirementChild/delete?id=${requirementChild.id}"
							onclick="return confirmx('确认要删除该测试管理吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>