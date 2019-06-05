<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>需求审核管理</title>
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
		<li><a href="${ctx}/requirement/requirements/examines">需求审核查询列表</a></li>
		<li class="active"><a
			href="${ctx}/requirement/requirements/form?id=${requirements.id}">需求审核</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="requirements"
		action="${ctx}/requirement/requirements/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">需求来源：</label>
			<div class="controls">
				<form:select path="requirementSource" class="input-xlarge "
					disabled="true">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('requirement_source')}"
						itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求分类：</label>
			<div class="controls">
				<form:select path="requirementClassify" class="input-xlarge "
					disabled="true">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('requirement_classify')}"
						itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务系统：</label>
			<div class="controls">
				<form:select path="businessSystem" class="input-xlarge "
					disabled="true">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('business_system')}"
						itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求紧急程度：</label>
			<div class="controls">
				<form:select path="requirementEmergency" class="input-xlarge "
					disabled="true">
					<form:option value="" label="" />
					<form:options items="${fns:getDictList('requirement_emergency')}"
						itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务期待及意向简介：</label>
			<div class="controls">
				<form:input path="expectAndIntention" htmlEscape="false"
					maxlength="200" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">签报号：</label>
			<div class="controls">
				<form:input path="signNo" htmlEscape="false" maxlength="100"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">期望上线时间：</label>
			<div class="controls">
				<input name="expectOnline" type="text" readonly="readonly"
					disabled="true" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${requirements.expectOnline}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
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
			<label class="control-label">变更原因：</label>
			<div class="controls">
				<form:input path="reasonsChange" htmlEscape="false" maxlength="1000"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">当前业务处理方案：</label>
			<div class="controls">
				<form:input path="currentBusiProcScenario" htmlEscape="false"
					maxlength="1000" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">提请方：</label>
			<div class="controls">
				<form:input path="submitTo" htmlEscape="false" maxlength="50"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求提出处室：</label>
			<div class="controls">
				<form:input path="requiremenPresentationOffice" htmlEscape="false"
					maxlength="50" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">申请人：</label>
			<div class="controls">
				<form:input path="proposer" htmlEscape="false" maxlength="50"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系方式：</label>
			<div class="controls">
				<form:input path="contact" htmlEscape="false" maxlength="50"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求原因描述：</label>
			<div class="controls">
				<form:input path="requirementCauseDescription" htmlEscape="false"
					maxlength="500" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求内容：</label>
			<div class="controls">
				<form:input path="requirementContent" htmlEscape="false"
					maxlength="500" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">资料附件清单：</label>
			<div class="controls">
				<form:input path="annexList" htmlEscape="false" maxlength="500"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求验收联系人：</label>
			<div class="controls">
				<form:input path="requirementAcceptancePerson" htmlEscape="false"
					maxlength="50" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系电话：</label>
			<div class="controls">
				<form:input path="requirementAcceptancePhone" htmlEscape="false"
					maxlength="50" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求状态：</label>
			<div class="controls">
				<form:input path="requirementStatus" htmlEscape="false"
					maxlength="20" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">关联业务需求：</label>
			<div class="controls">
				<form:input path="relatedBusinessDemand" htmlEscape="false"
					maxlength="20" class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="comments" htmlEscape="false" maxlength="500"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">最后更新者：</label>
			<div class="controls">
				<form:input path="lastUpdate" htmlEscape="false" maxlength="20"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">最后更新时间：</label>
			<div class="controls">
				<input name="latUpdateTime" type="text" readonly="readonly"
					maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${requirements.latUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"
					disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><b>问题单信息：</b></label>
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
								<input id="problemList{{idx}}_problemDesc" name="problemList[{{idx}}].problemDesc" type="text" value="{{row.problemDesc}}" maxlength="1000" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="problemList{{idx}}_problemNo" name="problemList[{{idx}}].problemNo" type="text" value="{{row.problemNo}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
						</tr>//-->
					</script>
				<script type="text/javascript">
						var problemRowIdx = 0, problemTpl = $("#problemTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirements.problemList)};
							for (var i=0; i<data.length; i++){
								addRow('#problemList', problemRowIdx, problemTpl, data[i]);
								problemRowIdx = problemRowIdx + 1;
							}
						});
					</script>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label"><b>子需求基本信息：</b></label>
			<div class="controls">
				<table id="contentTable"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th class="hide"></th>
							<th>子需求编号</th>
							<th>子需求标题</th>
							<th>项目归属</th>
							<th>业务系统</th>
							<th>预计完成时间</th>
							<th>子需求状态</th>
							<th>完成时间</th>
							<th>工时</th>
							<th>处理人</th>
						</tr>
					</thead>
					<tbody id="requirementChildList">
					</tbody>
				</table>
				<script type="text/template" id="requirementChildTpl">//<!--
						<tr id="requirementChildList{{idx}}">
							<td class="hide">
								<input id="requirementChildList{{idx}}_id" name="requirementChildList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="requirementChildList{{idx}}_delFlag" name="requirementChildList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="requirementChildList{{idx}}_id" name="requirementChildList[{{idx}}].id" type="text" value="{{row.id}}" maxlength="1000" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementChildList{{idx}}_requirementChildTitle" name="requirementChildList[{{idx}}].requirementChildTitle" type="text" value="{{row.requirementChildTitle}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementChildList{{idx}}_itemBelonds" name="requirementChildList[{{idx}}].itemBelonds" type="text" value="{{row.itemBelonds}}" maxlength="1000" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementChildList{{idx}}_businessSystem" name="requirementChildList[{{idx}}].businessSystem" type="text" value="{{row.businessSystem}}" maxlength="1000" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input disabled="true" id="requirementChildList{{idx}}_expectFinsh" name="requirementChildList.expectFinsh" type="text" value="{{row.expectFinsh}}" maxlength="1000" class="Wdate"  />
							</td>
							<td>
							</td>
							<td>
							</td>
							<td>
							</td>
							<td>
								<input id="requirementChildList{{idx}}_responsibleTaxPerson" name="requirementChildList[{{idx}}].responsibleTaxPerson" type="text" value="{{row.responsibleTaxPerson}}" maxlength="1000" class="input-small "  disabled="true"/>
							</td>
						</tr>//-->
					</script>
				<script type="text/javascript">
						var requirementChildRowIdx = 0, requirementChildTpl = $("#requirementChildTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirements.requirementChildList)};
							for (var i=0; i<data.length; i++){
								addRow('#requirementChildList', requirementChildRowIdx, requirementChildTpl, data[i]);
								requirementChildRowIdx = requirementChildRowIdx + 1;
							}
						});
					</script>
			</div>
		</div>

		<div class="form-actions">
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>