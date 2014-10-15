



<%--<div class="fieldcontain ${hasErrors(bean: lookupTypeInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="typeDesc">
		<g:message code="lookupType.typeDesc.label" default="typeDesc" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Lookup Type" class="form-control" name="typeDesc" maxlength="50" value="${lookupTypeInstance?.typeDesc}"/>
	</div>
</div>



