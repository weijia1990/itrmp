<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>子需求进度管理管理</title>
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
	function addProRow(list, idx, tpl, row) {
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
		$("#addNew").hide();
		var a = row.requirementproChildTitle;
		a = "requirementChildPro_" + a;
		$("#" + a).attr("selected", true);
	}
	function delProRow(obj, prefix) {
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
		$("#addNew").show();
	}
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
		<li class="active"><a
			href="${ctx}/requirementchildpro/requirementChild/form?id=${requirementChild.id}">子需求基本信息</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="requirementChild"
		action="${ctx}/requirement/requirements/saveExamine" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<form:hidden path="act.taskId" />
		<form:hidden path="act.taskName" />
		<form:hidden path="act.taskDefKey" />
		<form:hidden path="act.procInsId" />
		<form:hidden path="act.procDefId" />
		<form:hidden id="flag" path="act.flag" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">需求编号：</label>
			<div class="controls">
				<form:input path="requirements" htmlEscape="false" maxlength="32"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">子需求标题：</label>
			<div class="controls">
				<form:input path="requirementChildTitle" htmlEscape="false"
					maxlength="50" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目归属：</label>
			<div class="controls">
				<form:select path="itemBelonds" class="input-xlarge "
					disabled="true">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('')}" itemLabel="label"
						itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务系统：</label>
			<div class="controls">
				<form:select path="businessSystem" class="input-xlarge "
					disabled="true">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('')}" itemLabel="label"
						itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求紧急程度：</label>
			<div class="controls">
				<form:select path="requirementEmergency" class="input-xlarge "
					disabled="true">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('')}" itemLabel="label"
						itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">预计完成时间：</label>
			<div class="controls">
				<input disabled="true" name="exceptFinish" type="text"
					readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${requirementChild.exceptFinish}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">受理人：</label>
			<div class="controls">
				<form:input path="responsibleTaxPerson" htmlEscape="false"
					maxlength="1000" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">关联性业务需求：</label>
			<div class="controls">
				<form:input path="relatedBusinessRequirements" htmlEscape="false"
					maxlength="1000" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求编号：</label>
			<div class="controls">
				<form:input path="demandNo" htmlEscape="false" maxlength="1000"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">目标描述：</label>
			<div class="controls">
				<form:input path="targetDesc" htmlEscape="false" maxlength="1000"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求内容：</label>
			<div class="controls">
				<form:input path="contact" htmlEscape="false" maxlength="1000"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附件：</label>
			<div class="controls">
				<form:input path="appendix" htmlEscape="false" maxlength="1000"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求审批联系人：</label>
			<div class="controls">
				<form:input path="demandApprovePerson" htmlEscape="false"
					maxlength="1000" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求审批联系人联系电话：</label>
			<div class="controls">
				<form:input path="demandApprovePhone" htmlEscape="false"
					maxlength="1000" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="comments" htmlEscape="false" maxlength="1000"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">您的意见：</label>
			<div class="controls">
				<form:textarea path="act.comment" class="required" rows="5"
					maxlength="20" cssStyle="width:500px" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">问题单表：</label>
			<div class="controls">
				<table id="contentTable"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th class="hide"></th>
							<th>问题描述</th>
							<th>问题单编号</th>
						</tr>
					</thead>
					<tbody id="problemList">
					</tbody>
				</table>
				<script type="text/template" id="problemTpl">//<!--
						<tr id="problemList{{idx}}">
							<td class="hide">
								<input id="problemList{{idx}}_id" name="problemList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="problemList{{idx}}_delFlag" name="problemList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="problemList{{idx}}_problemDesc" name="problemList[{{idx}}].problemDesc" type="text" value="{{row.problemDesc}}" maxlength="1000" class="input-small " disabled="true"/>
							</td>
							<td>
								<input id="problemList{{idx}}_problemNo" name="problemList[{{idx}}].problemNo" type="text" value="{{row.problemNo}}" maxlength="20" class="input-small " disabled="true"/>
							</td>
						</tr>//-->
					</script>
				<script type="text/javascript">
						var problemRowIdx = 0, problemTpl = $("#problemTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirementChild.problemChildList)};
							for (var i=0; i<data.length; i++){
								addRow('#problemList', problemRowIdx, problemTpl, data[i]);
								problemRowIdx = problemRowIdx + 1;
							}
						});
					</script>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">子需求进度表：</label>
			<div class="controls">
				<table id="contentTable"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th class="hide"></th>
							<th>子需求进度</th>
							<th>需求文档查看</th>
							<th>子需求进度追踪</th>
						</tr>
					</thead>
					<tbody id="requirementproChildList">
					</tbody>
					<tfoot id="addNew">
						<tr>
							<td colspan="6"><a href="javascript:"
								onclick="addProRow('#requirementproChildList', requirementproChildRowIdx, requirementproChildTpl);requirementproChildRowIdx = requirementproChildRowIdx + 1;"
								class="btn">新增</a></td>
						</tr>
					</tfoot>
				</table>
				<script type="text/template" id="requirementproChildTpl">//<!--
						<tr id="requirementproChildList{{idx}}">
							<td class="hide">
								<input id="requirementproChildList{{idx}}_id" name="requirementproChildList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="requirementproChildList{{idx}}_delFlag" name="requirementproChildList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
							<select id="requirementproChildList{{idx}}_requirementproChildTitle" name="requirementproChildList[{{idx}}].requirementproChildTitle" >
								<c:forEach items="${fns:getDictList('requirement_child_pro')}" var="title">
									<option id ="requirementChildPro_${title.value}" value ="${title.value}">${title}</option>
								</c:forEach>
							</select>
							</td>
							<td>
								<input id="requirementproChildList{{idx}}_requirementpFile" name="requirementproChildList[{{idx}}].requirementpFile" type="hidden" value="{{row.requirementpFile}}" maxlength="50"/>
								<sys:ckfinder input="requirementproChildList{{idx}}_requirementpFile" type="files" uploadPath="/requirementchildpro/requirementChild" selectMultiple="true"/>
							</td>
							<td>
								<input id="requirementproChildList{{idx}}_requirementproChildTrack" name="requirementproChildList[{{idx}}].requirementproChildTrack" type="text" value="{{row.requirementproChildTrack}}" maxlength="50" class="input-small "/>
							</td>
							<td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delProRow(this, '#requirementproChildList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td>
						</tr>//-->
					</script>
				<script type="text/javascript">
						var requirementproChildRowIdx = 0, requirementproChildTpl = $("#requirementproChildTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirementChild.requirementproChildList)};
							for (var i=0; i<data.length; i++){
								addProRow('#requirementproChildList', requirementproChildRowIdx, requirementproChildTpl, data[i]);
								requirementproChildRowIdx = requirementproChildRowIdx + 1;
							}
						});
					</script>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">退回原因：</label>
			<div class="controls">
				<form:input path="requirementChildExamineList[0].returnReason"
					htmlEscape="false" maxlength="1000" class="input-xlarge "
					disabled="true" />
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit"
				value="保 存" onclick="$('#flag').val('yes')" />&nbsp; <input
				id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
		<act:histoicFlow procInsId="${requirements.act.procInsId}" />
	</form:form>
</body>
</html>