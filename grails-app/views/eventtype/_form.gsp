



<%--<div class="fieldcontain ${hasErrors(bean: typeInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="code">
		<g:message code="type.code.label" default="Code" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Category Code" class="form-control" name="code" maxlength="6" value="${typeInstance?.code}"/>
	</div>
</div>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="typeName">
		<g:message code="eventtype.typeName.label" default="Type Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Type Name" class="form-control"  name="typeName" maxlength="100" value="${typeInstance?.typeName}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label"  for="budgeCode">
		<g:message code="type.budgetCode.label" default="Budget Code" />
		
	</label>
	<div class="col-sm-9">
	<g:field  type="number" placeholder="budget code" class="form-control" name="budgetCode" value="${fieldValue(bean: typeInstance, field: 'budgetCode')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="gcatId">
		<g:message code="type.gcatId.label" default="Gcat Id" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="gcatId" name="gcatId" from="${['P','B']}"  required="" value="${typeInstance?.gcatId}"  class="form-control search-select"/>
	</div>
</div>
<%--<<g:hiddenField name="userId" value="${ }"/>--%>
<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="type.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${typeInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: typeInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="type.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${typeInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>



<%--<div class="form-group">--%>
<%--	<label  class="col-sm-2 control-label" for="type">--%>
<%--		<g:message code="type.type.label" default="Type" />--%>
<%--	</label>--%>
<%--	<div class="col-sm-9">--%>
<%--	<g:select id="type" name="type.id" from="${dametro.Eventtype.list()}" optionKey="id" required="" value="${typeInstance?.type?.id}" optionValue="typeName" class="form-control search-select"/>--%>
<%--	</div>--%>
<%--</div>--%>

<%--<div class="fieldcontain ${hasErrors(bean: typeInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="type.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${typeInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="type.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${typeInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['type.id': typeInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>