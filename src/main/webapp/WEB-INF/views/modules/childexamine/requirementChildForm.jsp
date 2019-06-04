<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>需求审核管理管理</title>
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
		<li><a href="${ctx}/childexamine/requirementChild/">需求审核管理列表</a></li>
		<li class="active"><a href="${ctx}/childexamine/requirementChild/form?id=${requirementChild.id}">需求审核管理<shiro:hasPermission name="childexamine:requirementChild:edit">${not empty requirementChild.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="childexamine:requirementChild:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="requirementChild" action="${ctx}/childexamine/requirementChild/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">需求编号：</label>
			<div class="controls">
				<form:input path="requirements.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">子需求标题：</label>
			<div class="controls">
				<form:input path="requirementChildTitle" htmlEscape="false" maxlength="50" class="input-xlarge "/>
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
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="comments" htmlEscape="false" maxlength="1000" class="input-xlarge "/>
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
				<label class="control-label">问题单表：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>需求表流水号</th>
								<th>问题描述</th>
								<th>问题单编号</th>
								<th>标记</th>
								<shiro:hasPermission name="childexamine:requirementChild:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="problemList">
						</tbody>
						<shiro:hasPermission name="childexamine:requirementChild:edit"><tfoot>
							<tr><td colspan="6"><a href="javascript:" onclick="addRow('#problemList', problemRowIdx, problemTpl);problemRowIdx = problemRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="problemTpl">//<!--
						<tr id="problemList{{idx}}">
							<td class="hide">
								<input id="problemList{{idx}}_id" name="problemList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="problemList{{idx}}_delFlag" name="problemList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="problemList{{idx}}_requirements" name="problemList[{{idx}}].requirements.id" type="text" value="{{row.requirements.id}}" maxlength="32" class="input-small "/>
							</td>
							<td>
								<input id="problemList{{idx}}_problemDesc" name="problemList[{{idx}}].problemDesc" type="text" value="{{row.problemDesc}}" maxlength="1000" class="input-small "/>
							</td>
							<td>
								<input id="problemList{{idx}}_problemNo" name="problemList[{{idx}}].problemNo" type="text" value="{{row.problemNo}}" maxlength="20" class="input-small "/>
							</td>
							<td>
								<textarea id="problemList{{idx}}_remarks" name="problemList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="childexamine:requirementChild:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#problemList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var problemRowIdx = 0, problemTpl = $("#problemTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirementChild.problemList)};
							for (var i=0; i<data.length; i++){
								addRow('#problemList', problemRowIdx, problemTpl, data[i]);
								problemRowIdx = problemRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">子需求审核表：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>退回原因</th>
								<th>remarks</th>
								<shiro:hasPermission name="childexamine:requirementChild:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="requirementChildExamineList">
						</tbody>
						<shiro:hasPermission name="childexamine:requirementChild:edit"><tfoot>
							<tr><td colspan="4"><a href="javascript:" onclick="addRow('#requirementChildExamineList', requirementChildExamineRowIdx, requirementChildExamineTpl);requirementChildExamineRowIdx = requirementChildExamineRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="requirementChildExamineTpl">//<!--
						<tr id="requirementChildExamineList{{idx}}">
							<td class="hide">
								<input id="requirementChildExamineList{{idx}}_id" name="requirementChildExamineList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="requirementChildExamineList{{idx}}_delFlag" name="requirementChildExamineList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="requirementChildExamineList{{idx}}_returnReason" name="requirementChildExamineList[{{idx}}].returnReason" type="text" value="{{row.returnReason}}" maxlength="1024" class="input-small "/>
							</td>
							<td>
								<textarea id="requirementChildExamineList{{idx}}_remarks" name="requirementChildExamineList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small required">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="childexamine:requirementChild:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#requirementChildExamineList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var requirementChildExamineRowIdx = 0, requirementChildExamineTpl = $("#requirementChildExamineTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirementChild.requirementChildExamineList)};
							for (var i=0; i<data.length; i++){
								addRow('#requirementChildExamineList', requirementChildExamineRowIdx, requirementChildExamineTpl, data[i]);
								requirementChildExamineRowIdx = requirementChildExamineRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">需求文档表：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>需求文档名称</th>
								<th>需求文档内容</th>
								<th>remarks</th>
								<shiro:hasPermission name="childexamine:requirementChild:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="requirementFileList">
						</tbody>
						<shiro:hasPermission name="childexamine:requirementChild:edit"><tfoot>
							<tr><td colspan="5"><a href="javascript:" onclick="addRow('#requirementFileList', requirementFileRowIdx, requirementFileTpl);requirementFileRowIdx = requirementFileRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="requirementFileTpl">//<!--
						<tr id="requirementFileList{{idx}}">
							<td class="hide">
								<input id="requirementFileList{{idx}}_id" name="requirementFileList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="requirementFileList{{idx}}_delFlag" name="requirementFileList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="requirementFileList{{idx}}_requirementTitle" name="requirementFileList[{{idx}}].requirementTitle" type="text" value="{{row.requirementTitle}}" maxlength="50" class="input-small "/>
							</td>
							<td>
								<input id="requirementFileList{{idx}}_requirementpContent" name="requirementFileList[{{idx}}].requirementpContent" type="hidden" value="{{row.requirementpContent}}" maxlength="50"/>
								<sys:ckfinder input="requirementFileList{{idx}}_requirementpContent" type="files" uploadPath="/childexamine/requirementChild" selectMultiple="true"/>
							</td>
							<td>
								<textarea id="requirementFileList{{idx}}_remarks" name="requirementFileList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small required">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="childexamine:requirementChild:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#requirementFileList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var requirementFileRowIdx = 0, requirementFileTpl = $("#requirementFileTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirementChild.requirementFileList)};
							for (var i=0; i<data.length; i++){
								addRow('#requirementFileList', requirementFileRowIdx, requirementFileTpl, data[i]);
								requirementFileRowIdx = requirementFileRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">子需求进度表：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>子需求进度</th>
								<th>需求文档查看</th>
								<th>子需求进度追踪</th>
								<th>remarks</th>
								<shiro:hasPermission name="childexamine:requirementChild:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="requirementproChildList">
						</tbody>
						<shiro:hasPermission name="childexamine:requirementChild:edit"><tfoot>
							<tr><td colspan="6"><a href="javascript:" onclick="addRow('#requirementproChildList', requirementproChildRowIdx, requirementproChildTpl);requirementproChildRowIdx = requirementproChildRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="requirementproChildTpl">//<!--
						<tr id="requirementproChildList{{idx}}">
							<td class="hide">
								<input id="requirementproChildList{{idx}}_id" name="requirementproChildList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="requirementproChildList{{idx}}_delFlag" name="requirementproChildList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="requirementproChildList{{idx}}_requirementproChildTitle" name="requirementproChildList[{{idx}}].requirementproChildTitle" type="text" value="{{row.requirementproChildTitle}}" maxlength="50" class="input-small "/>
							</td>
							<td>
								<input id="requirementproChildList{{idx}}_requirementpFile" name="requirementproChildList[{{idx}}].requirementpFile" type="hidden" value="{{row.requirementpFile}}" maxlength="50"/>
								<sys:ckfinder input="requirementproChildList{{idx}}_requirementpFile" type="files" uploadPath="/childexamine/requirementChild" selectMultiple="true"/>
							</td>
							<td>
								<input id="requirementproChildList{{idx}}_requirementproChildTrack" name="requirementproChildList[{{idx}}].requirementproChildTrack" type="text" value="{{row.requirementproChildTrack}}" maxlength="50" class="input-small "/>
							</td>
							<td>
								<textarea id="requirementproChildList{{idx}}_remarks" name="requirementproChildList[{{idx}}].remarks" rows="4" maxlength="255" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="childexamine:requirementChild:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#requirementproChildList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var requirementproChildRowIdx = 0, requirementproChildTpl = $("#requirementproChildTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(requirementChild.requirementproChildList)};
							for (var i=0; i<data.length; i++){
								addRow('#requirementproChildList', requirementproChildRowIdx, requirementproChildTpl, data[i]);
								requirementproChildRowIdx = requirementproChildRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="childexamine:requirementChild:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>