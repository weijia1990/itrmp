<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>测试管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/testmanager/requirementChild/">测试管理列表</a></li>
		<li class="active"><a href="${ctx}/testmanager/requirementChild/form?id=${requirementChild.id}">测试管理<shiro:hasPermission name="testmanager:requirementChild:edit">${not empty requirementChild.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="testmanager:requirementChild:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="requirementChild" action="${ctx}/testmanager/requirementChild/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">需求编号：</label>
			<div class="controls">
				<form:input path="requirements" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">子需求标题：</label>
			<div class="controls">
				<form:input disabled="true" path="requirementChildTitle" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目归属：</label>
			<div class="controls">
				<form:select path="itemBelonds" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">业务系统：</label>
			<div class="controls">
				<form:select path="businessSystem" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求紧急程度：</label>
			<div class="controls">
				<form:select path="requirementEmergency" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">预计完成时间：</label>
			<div class="controls">
				<input name="exceptFinish" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${requirementChild.exceptFinish}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">受理人：</label>
			<div class="controls">
				<form:input path="responsibleTaxPerson" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">关联性业务需求：</label>
			<div class="controls">
				<form:input path="relatedBusinessRequirements" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求编号：</label>
			<div class="controls">
				<form:input path="demandNo" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">目标描述：</label>
			<div class="controls">
				<form:input path="targetDesc" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求内容：</label>
			<div class="controls">
				<form:input path="contact" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附件：</label>
			<div class="controls">
				<form:input path="appendix" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求审批联系人：</label>
			<div class="controls">
				<form:input path="demandApprovePerson" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">需求审批联系人联系电话：</label>
			<div class="controls">
				<form:input path="demandApprovePhone" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">remarks：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">测试任务表：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>测试负责人</th>
								<th>计划SIT完成时间</th>
								<th>备注</th>
								<th>任务概述</th>
								<th>uat_comments</th>
								<th>uat_task</th>
								<th>remarks</th>
								<th width="10">&nbsp;</th>
							</tr>
						</thead>
						<tbody id="taskTestList">
						</tbody>
						<tfoot>
							<tr><td colspan="9"><a href="javascript:" onclick="addRow('#taskTestList', taskTestRowIdx, taskTestTpl);taskTestRowIdx = taskTestRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot>
					</table>
					<script type="text/template" id="taskTestTpl">//<!--
						<tr id="taskTestList{{idx}}">
							<td class="hide">
								<input id="taskTestList{{idx}}_id" name="taskTestList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="taskTestList{{idx}}_delFlag" name="taskTestList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<select id="taskTestList{{idx}}_testIncharge" name="taskTestList[{{idx}}].testIncharge" data-value="{{row.testIncharge}}" class="input-small ">
									<option value=""></option>
									<c:forEach items="${fns:getDictList('')}" var="dict">
										<option value="${dict.value}">${dict.label}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<input id="taskTestList{{idx}}_sitTime" name="taskTestList[{{idx}}].sitTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
									value="{{row.sitTime}}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
							</td>
							<td>
								<input id="taskTestList{{idx}}_sitComments" name="taskTestList[{{idx}}].sitComments" type="text" value="{{row.sitComments}}" maxlength="255" class="input-small "/>
							</td>
							<td>
								<input id="taskTestList{{idx}}_sitTask" name="taskTestList[{{idx}}].sitTask" type="text" value="{{row.sitTask}}" maxlength="255" class="input-small "/>
							</td>
							<td>
								<input id="taskTestList{{idx}}_uatComments" name="taskTestList[{{idx}}].uatComments" type="text" value="{{row.uatComments}}" maxlength="255" class="input-small "/>
							</td>
							<td>
								<input id="taskTestList{{idx}}_uatTask" name="taskTestList[{{idx}}].uatTask" type="text" value="{{row.uatTask}}" maxlength="255" class="input-small "/>
							</td>
							<td>
								<textarea id="taskTestList{{idx}}_remarks" name="taskTestList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small required">{{row.remarks}}</textarea>
							</td>
							<td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#taskTestList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var taskTestRowIdx = 0, taskTestTpl = $("#taskTestTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirementChild.taskTestList)};
							for (var i=0; i<data.length; i++){
								addRow('#taskTestList', taskTestRowIdx, taskTestTpl, data[i]);
								taskTestRowIdx = taskTestRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>