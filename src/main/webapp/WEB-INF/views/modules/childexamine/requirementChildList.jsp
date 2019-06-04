<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>需求审核管理管理</title>
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
		<li class="active"><a href="${ctx}/childexamine/requirementChild/">需求审核管理列表</a></li>
		<shiro:hasPermission name="childexamine:requirementChild:edit"><li><a href="${ctx}/childexamine/requirementChild/form">需求审核管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="requirementChild" action="${ctx}/childexamine/requirementChild/" method="post" class="breadcrumb form-search">
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
				<th>修改日期</th>
				<th>remarks</th>
				<shiro:hasPermission name="childexamine:requirementChild:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="requirementChild">
			<tr>
				<td><a href="${ctx}/childexamine/requirementChild/form?id=${requirementChild.id}">
					<fmt:formatDate value="${requirementChild.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${requirementChild.remarks}
				</td>
				<shiro:hasPermission name="childexamine:requirementChild:edit"><td>
    				<a href="${ctx}/childexamine/requirementChild/form?id=${requirementChild.id}">修改</a>
					<a href="${ctx}/childexamine/requirementChild/delete?id=${requirementChild.id}" onclick="return confirmx('确认要删除该需求审核管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>