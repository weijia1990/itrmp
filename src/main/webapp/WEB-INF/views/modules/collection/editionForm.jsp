<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>版本归集管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
		//$("#name").focus();
		$("#inputForm").validate({
			submitHandler : function(form) {
				loading('正在提交，请稍等...');
				form.submit();
			},
			errorContainer : "#messageBox",
			errorPlacement : function(error, element) {
				$("#messageBox").text("输入有误，请先更正。");
				if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
					error.appendTo(element.parent().parent());
				} else {
					error.insertAfter(element);
				}
			}
		});
	});
	function addRow(list, idx, tpl, row) {
		$(list).append(Mustache.render(tpl, {
			idx : idx,
			delBtn : true,
			row : row
		}));
		$(list + idx).find("select").each(function() {
			$(this).val($(this).attr("data-value"));
		});
		$(list + idx).find("input[type='checkbox'], input[type='radio']").each(function() {
			var ss = $(this).attr("data-value").split(',');
			for (var i = 0; i < ss.length; i++) {
				if ($(this).val() == ss[i]) {
					$(this).attr("checked", "checked");
				}
			}
		});
	}
	function delRow(obj, prefix) {
		var id = $(prefix + "_id");
		var delFlag = $(prefix + "_delFlag");
		if (id.val() == "") {
			$(obj).parent().parent().remove();
		} else if (delFlag.val() == "0") {
			delFlag.val("1");
			$(obj).html("&divide;").attr("title", "撤销删除");
			$(obj).parent().parent().addClass("error");
		} else if (delFlag.val() == "1") {
			delFlag.val("0");
			$(obj).html("&times;").attr("title", "删除");
			$(obj).parent().parent().removeClass("error");
		}
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/collection/edition/">版本归集列表</a></li>
		<li class="active"><a
			href="${ctx}/collection/edition/form?id=${edition.id}">版本归集<shiro:hasPermission
					name="collection:edition:edit">${not empty edition.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="collection:edition:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="edition"
		action="${ctx}/collection/edition/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<form:hidden path="editionCollectionList[0].id" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label"><b>版本归集基础信息：</b></label>
		</div>
		<div class="control-group">
			<label class="control-label">需求版本：</label>
			<div class="controls">
				<form:input path="editionCollectionList[0].editionFiles"
					htmlEscape="false" maxlength="50" class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上线时间：</label>
			<div class="controls">
				<form:input path="editionCollectionList[0].timeOnline"
					htmlEscape="false" maxlength="50" class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="remarks" htmlEscape="false" maxlength="50"
					class="input-xlarge " />
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit"
				value="保 存" />&nbsp; <input id="btnCancel" class="btn"
				type="button" value="返 回" onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>