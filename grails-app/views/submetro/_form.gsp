



<%--<div class="fieldcontain ${hasErrors(bean: submetroInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="submetroName">
		<g:message code="submetro.code.label" default="Sub Metro" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Sub Metro Name" class="form-control" name="submetroName" maxlength="50" value="${submetroInstance?.submetroName}"/>
	</div>
</div>



