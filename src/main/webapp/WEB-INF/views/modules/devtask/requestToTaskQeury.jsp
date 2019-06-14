<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>


<html>
<head>
<title>开发任务创建管理</title>
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

	</ul>
	<form:form id="searchForm" modelAttribute="requirements"
		action="${ctx}/requirementchildpro/requirementChild/queryTaskQ?tete=${cdt}"
		method="post" class="breadcrumb form-search">
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
				<th>测试号</th>
				<th>需求编号</th>
				<th>标题</th>
				<th>业务系统</th>
				<th>状态</th>
				<th>测试负责人</th>
				<th>实际开始时间</th>
				<th>实际完成时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="requirements">
				<tr>
					<td>${requirements.id}</td>
					<td>${requirements.rcId}</td>
					<td>核心开发测试</td>
					<td>${fns:getDictLabel(requirements.businessSystem, 'business_system', '')}</td>
					<td>测试中</td>
					<td>刘工</td>
					<td>2019.06.01 00:02:00</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>