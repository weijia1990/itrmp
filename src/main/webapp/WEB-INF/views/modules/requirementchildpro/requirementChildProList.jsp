<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>需求分析管理</title>
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
		<li class="active"><a href="${ctx}/requirement/requirements/">需求列表</a></li>
		<shiro:hasPermission name="requirement:requirements:edit">
			<li><a href="${ctx}/requirement/requirements/form">需求创建</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="requirements"
		action="${ctx}/requirement/requirements/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
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
			<li><label>期望上线时间：</label> <input name="expectOnline"
				type="text" readonly="readonly" maxlength="20"
				class="input-medium Wdate"
				value="<fmt:formatDate value="${requirements.expectOnline}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
			</li>
			<li><label>申请人：</label> <form:input path="proposer"
					htmlEscape="false" maxlength="50" class="input-medium" /></li>
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
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>需求编号</th>
				<th>子需求编号</th>
				<th>需求来源</th>
				<th>项目归属</th>
				<th>业务系统</th>
				<th>期望上线时间</th>
				<th>预计完成时间</th>
				<th>创建时间</th>
				<th>申请人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="requirements">
				<tr>
					<td>${requirements.id}</td>
					<td>${requirements.childId}</td>
					<td>${requirements.requirementSource}</td>
					<td>${requirements.itemBelonds}</td>
					<td><a
						href="${ctx}/requirementchildpro/requirementChild/form?id=${requirementChild.id}">修改</a>
						<a
						href="${ctx}/requirementchildpro/requirementChild/delete?id=${requirementChild.id}"
						onclick="return confirmx('确认要删除该子需求进度管理吗？', this.href)">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>