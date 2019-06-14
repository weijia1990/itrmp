<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>版本上线实施</title>
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
		
	</ul>
	<form id="searchForm" 
		
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden"  />
		<input id="pageSize" name="pageSize" type="hidden"
			 />
		<ul class="ul-form">
			<li><label>需求版本：</label> <input
					 htmlEscape="false"
					maxlength="50" class="input-medium" /></li>
			<li><label>版本上线时间：</label> <input
				htmlEscape="false"
					maxlength="50" class="input-medium" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="实施完成" /></li>
			<li class="clearfix"></li>
		</ul>
	</form>
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
			</tr>
		</thead>
		<tbody>
		
				<tr>
					<td>6a516deb3ac645068fa84d768a13d478</td>
					<td>20190614</td>
					<td>2019-6-14 17:56</td>
					<td>2019-6-14 13:50</td>
					<td>zhangsan</td>
					
				</tr>
				<tr>
					<td>6s896deb3ac645068fa84d768a13d478</td>
					<td>20190613</td>
					<td>2019-6-13 17:50</td>
					<td>2019-6-13 13:40</td>
					<td>zhangsan</td>
					
				</tr>
			</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>