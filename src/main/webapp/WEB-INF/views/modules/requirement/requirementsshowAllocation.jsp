<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>需求任务待分配管理</title>
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

	function deal() {
		var states = {};
		states.state1 = {
			content : '是否进行需求拆分',
			buttons : {
				'不拆分' : 1,
				'拆    分' : 0
			},
			submit : function(v, h, f) {
				//if v ==1 then 不拆分 else v==0 拆分
				href = "";
				if (v == 1) {
					href = $("#noRequirementChild").attr("href");
				} else {
					href = $("#requirementChild").attr("href");
				}
				window.location.href = href;
			}
		}
		$.jBox.open(states, '需求处理', 300, 'auto');
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/requirement/requirements/examines">需求分配查询列表</a></li>
		<li class="active"><a
			href="${ctx}/requirement/requirements/form?id=${requirements.id}">需求分配</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="requirements"
		action="${ctx}/allocation/taskAllocation/save" method="post"
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
							<shiro:hasPermission name="requirement:requirements:edit">
								<th width="10">&nbsp;</th>
							</shiro:hasPermission>
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
			</div>
		</div>

		<div class="control-group">
			<label class="control-label"><b>任务分配信息：</b></label>
			<div class="controls">
				<table id="contentTable"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th class="hide"></th>
							<th>需求负责人</th>
							<th>预计完成时间</th>
							<shiro:hasPermission name="requirement:requirements:edit">
								<th width="10">&nbsp;</th>
							</shiro:hasPermission>
						</tr>
					</thead>
					<tbody id="allocationList">
					</tbody>
				</table>
				<script type="text/template" id="allocationTpl">//<!--
						<tr id="allocationList{{idx}}">
							<td class="hide">
								<input id="allocationList{{idx}}_id" name="allocationList.id" type="hidden" value="{{row.id}}"/>
								<input id="allocationList{{idx}}_delFlag" name="allocationList.delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input disabled="true" id="allocationList{{idx}}_requirementResponsePerson" name="allocationList.requirementResponsePerson" type="text" value="{{row.requirementResponsePerson}}" maxlength="1000" class="input-small required"  />
								<span class="help-inline"><font color="red">*</font> </span>
							</td>
							<td>
								<input disabled="true" id="allocationList{{idx}}_expectFinsh" name="allocationList.expectFinsh" type="text" value="{{row.expectFinsh}}" maxlength="1000" class="required Wdate"  /><span class="help-inline"><font color="red">*</font> </span>
							</td>
						</tr>//-->
					</script>
				<script type="text/javascript">
						var problemRowIdx = 0, problemTpl = $("#problemTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						var allocationRowIdx = 0, allocationTpl = $("#allocationTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirements.problemList)};
							for (var i=0; i<data.length; i++){
								addRow('#problemList', problemRowIdx, problemTpl, data[i]);
								problemRowIdx = problemRowIdx + 1;
							}
							
							var data2 = ${fns:toJson(allocation)};
							for (var i=0; i<data2.length; i++){
								addRow('#allocationList', allocationRowIdx, allocationTpl, data2[i]);
								allocationRowIdx = allocationRowIdx + 1;
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
	<a href="${ctx}/requirementchild/requirementChild/form"
		id="requirementChild"></a>
	<a href="${ctx}/requirementchild/requirementChild/forma"
		id="noRequirementChild" /></a>
</body>
</html>