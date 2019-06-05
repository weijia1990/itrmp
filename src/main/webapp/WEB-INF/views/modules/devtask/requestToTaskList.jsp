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
	    <li class="active"><a href="${ctx}/requirement/requirements/">需求列表</a></li>
		
	</ul>
		<form:form id="searchForm" modelAttribute="requirements" action="${ctx}/requirement/requirements/lists?tete=${cdt}" method="post" class="breadcrumb form-search">
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
				<th>更新时间</th>
				<th>标记</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="requirements">
			<tr>
				<td><a href="${ctx}/requirement/requirements/form?id=${requirements.id}"><>
					<fmt:formatDate value="${requirements.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${requirements.remarks}
				</td>
				<td>
				   <c:choose>
				      <c:when test="${tete=='dev'}">
    				     <a href="${ctx}/devtask/devTask/forms?requestId=${requirements.id}">创建开发任务</a>
				      </c:when>
				      <c:when test="${tete=='tests'}">
				           <a href="${ctx}/esttasktest/estTaskTest/forms?requestId=${requirements.id}">创建测试任务</a>
				      </c:when>
				      <c:otherwise></c:otherwise>
				   </c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div class="pagination">${page}</div>
</body>
</html>