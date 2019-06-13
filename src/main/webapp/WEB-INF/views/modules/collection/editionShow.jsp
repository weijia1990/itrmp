<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>版本归集管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {
		//$("#name").focus();
		$("#btnButton").click(function() {
			var html = "<div style='padding:10px;'>需求编号：<input type='text' id='requirement' name='requirement' /></div>";
			var submit = function(v, h, f) {
				if (f.requirement == '') {
					$.jBox.tip("请输入需求编号", 'error', {
						focusId : "requirement"
					}); // 关闭设置 yourname 为焦点  
					return false;
				}
				$("#reId").val(f.requirement);
				$("#btnSubmit").submit();
				return;
			};
			$.jBox(html, {
				title : "添加新需求",
				submit : submit
			});
			return false;
		});
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
		action="${ctx}/collection/edition/addRequirement" method="post"
		class="form-horizontal">
		<input type="hidden" name="reId" id="reId" />
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
					htmlEscape="false" maxlength="50" class="input-xlarge "
					disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上线时间：</label>
			<div class="controls">
				<form:input path="editionCollectionList[0].timeOnline"
					htmlEscape="false" maxlength="50" class="input-xlarge "
					disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="remarks" htmlEscape="false" maxlength="50"
					class="input-xlarge " disabled="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><b>版本归集需求信息：</b></label>
			<div class="controls">
				<table id="contentTable"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th class="hide"></th>
							<th>需求编号</th>
							<th>需求来源</th>
							<th>需求分类</th>
							<th>业务系统</th>
							<th>总需求号</th>
							<th>创建时间</th>
							<th>创建人</th>
							<shiro:hasPermission name="requirement:requirements:edit">
								<th width="10">&nbsp;</th>
							</shiro:hasPermission>
						</tr>
					</thead>
					<tbody id="requirementList">
					</tbody>
				</table>
				<script type="text/template" id="requirementTpl">//<!--
						<tr id="requirementList{{idx}}">
							<td class="hide">
								<input id=""requirementList"{{idx}}_id" name=""requirementList"[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id=""requirementList"{{idx}}_delFlag" name=""requirementList"[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_id" name="requirementList[{{idx}}].id" type="text" value="{{row.id}}" maxlength="1000" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_requirementSource" name="requirementList[{{idx}}].requirementSource" type="text" value="{{row.requirementSource}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_requirementClassify" name="requirementList[{{idx}}].requirementClassify" type="text" value="{{row.requirementClassify}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_businessSystem" name="requirementList[{{idx}}].businessSystem" type="text" value="{{row.businessSystem}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_reId" name="requirementList[{{idx}}].reId" type="text" value="{{row.reId}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_createDate" name="requirementList[{{idx}}].createDate" type="text" value="{{row.createDate}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_createBy" name="requirementList[{{idx}}].createBy" type="text" value="{{row.createBy}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<shiro:hasPermission name="requirement:requirements:edit"><td class="text-center" width="10">
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
				<script type="text/javascript">
						var requirementRowIdx = 0, requirementTpl = $("#requirementTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirementList)};
							for (var i=0; i<data.length; i++){
								addRow('#requirementList', requirementRowIdx, requirementTpl, data[i]);
								requirementRowIdx = requirementRowIdx + 1;
							}
						});
					</script>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><b>版本返回修改原因：</b></label>
			<div class="controls">
				<table id="contentTable"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th class="hide"></th>
							<th>序号</th>
							<th>修改原因</th>
							<th>返回修改时间</th>
							<th>审批人</th>
							<shiro:hasPermission name="requirement:requirements:edit">
								<th width="10">&nbsp;</th>
							</shiro:hasPermission>
						</tr>
					</thead>
					<tbody id="requirementList">
					</tbody>
				</table>
				<script type="text/template" id="problemTpl">//<!--
						<tr id="requirementList{{idx}}">
							<td class="hide">
								<input id="requirementList{{idx}}_id" name="requirementList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="requirementList{{idx}}_delFlag" name="requirementList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_problemDesc" name="requirementList[{{idx}}].problemDesc" type="text" value="{{row.problemDesc}}" maxlength="1000" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_problemNo" name="requirementList[{{idx}}].problemNo" type="text" value="{{row.problemNo}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_problemNo" name="requirementList[{{idx}}].problemNo" type="text" value="{{row.problemNo}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<td>
								<input id="requirementList{{idx}}_problemNo" name="requirementList[{{idx}}].problemNo" type="text" value="{{row.problemNo}}" maxlength="20" class="input-small "  disabled="true"/>
							</td>
							<shiro:hasPermission name="requirement:requirements:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#requirementList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
				<script type="text/javascript">
						var problemRowIdx = 0, problemTpl = $("#problemTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirements.requirementList)};
							for (var i=0; i<data.length; i++){
								addRow('#requirementList', requirementRowIdx, requirementTpl, data[i]);
								requirementRowIdx = requirementRowIdx + 1;
							}
						});
					</script>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" type="hidden" /> <input id="btnButton"
				class="btn btn-primary" type="button" value="添加新需求" />&nbsp; <input
				id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>