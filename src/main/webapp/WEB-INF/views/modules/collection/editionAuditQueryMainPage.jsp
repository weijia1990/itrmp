<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>版本审批主页面</title>
<meta name="decorator" content="default" />

</head>
<body>

	<form id="searchForm" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" /> <input
			id="pageSize" name="pageSize" type="hidden" />
		<ul class="ul-form">
			<li><label>需求版本：</label> <input htmlEscape="false"
				maxlength="50" class="input-medium" /></li>

			<li><label style="width: 91px;">版本上线时间：</label> <input htmlEscape="false"
				maxlength="50" class="input-medium" /></li>
			<li><label style="width: 91px;">版本创建时间：</label> <input htmlEscape="false"
				maxlength="50" class="input-medium" /></li>
			<li><label>版本创建人：</label> <input htmlEscape="false"
				maxlength="50" class="input-medium" /></li>
			<li><label  style="width: 100px;">版本最后更新时间：</label> <input htmlEscape="false"
				maxlength="50" class="input-medium" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="审批通过" />
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="返回修改" /></li>

			<li class="clearfix"></li>
		</ul>
	</form>



		<table id="contentTable" class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<th>需求编号</th>
					<th>需求来源</th>
					<th>需求分类</th>
					<th>业务系统</th>
					<th>总需求编号</th>
					<th>创建时间</th>
					<th>创建人</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td>69d9c1e462224f97a7a27bc00cd00f6f</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>620f89d450a0409cb22832c40f45d1c9</td>
					<td>2019-6-14 18:30</td>
					<td>zhangsan</td>

				</tr>
				<tr>
					<td>6100c1e462224f97a7a27bc00cd00f6f</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>620f89d450a0409cb22832c40f45d1c9</td>
					<td>2019-6-13 19:30</td>
					<td>zhangsan</td>

				</tr>

			</tbody>

		</table>

		<table>
			<tr>
				<td><label>备注：</label></td>
				<td><textarea rows="5" cols="20">自行带出原因</textarea></td>
			</tr>
			<tr>
				<td><label>返回修改原因：</label></td>
				<td><textarea rows="5" cols="20">返回修改时需要填写</textarea></td>
			</tr>
			
		
		</table>
		
		
		<br/>
		
		

	

</body>
</html>