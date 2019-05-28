<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>需求创建管理</title>
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
		<li class="active"><a href="${ctx}/requirement/requirements/">需求创建列表</a></li>
		<shiro:hasPermission name="requirement:requirements:edit"><li><a href="${ctx}/requirement/requirements/form">需求创建添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="requirements" action="${ctx}/requirement/requirements/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>签报号：</label>
				<form:input path="signNo" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>需求来源</th>
				<th>签报号</th>
				<shiro:hasPermission name="requirement:requirements:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="requirements">
			<tr>
				<td><a href="${ctx}/requirement/requirements/form?id=${requirements.id}">
					${fns:getDictLabel(requirements.requirementSource, '', '')}
				</a></td>
				<td>
					${requirements.signNo}
				</td>
				<shiro:hasPermission name="requirement:requirements:edit"><td>
    				<a href="${ctx}/requirement/requirements/form?id=${requirements.id}">修改</a>
					<a href="${ctx}/requirement/requirements/delete?id=${requirements.id}" onclick="return confirmx('确认要删除该需求创建吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>