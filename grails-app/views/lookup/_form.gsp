



<%--<div class="fieldcontain ${hasErrors(bean: lookupInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="label">
		<g:message code="lookup.label.label" default="Description" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Lookup Code" class="form-control" name="label" maxlength="50" value="${lookupInstance?.label}"/>
	</div>
</div>
<div class="form-group">
<label class="col-sm-2 control-label" for="label">
	
		
	</label>
<div class="col-sm-9">
	<label class="checkbox-inline" for="active">
		<g:checkBox name="active" class="square-black" value="${lookupInstance?.active}" /><g:message code="gcrtransfer.active.label" default="Active" />
		
	</label>
	

</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="type">
		<g:message code="lookup.type.label" default="Type" />
	</label>
	<div class="col-sm-9">
	<g:select id="type" name="type.id" from="${dametro.LookupType.list()}" optionKey="id" required="" value="${lookupInstance?.type?.id}" optionValue="typeDesc" class="form-control search-select"/>
	</div>
</div>

<%--<div class="fieldcontain ${hasErrors(bean: lookupInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="lookup.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${lookupInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="lookup.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${lookupInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['lookup.id': lookupInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>