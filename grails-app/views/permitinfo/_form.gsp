



<%--<div class="fieldcontain ${hasErrors(bean: categoryInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="code">
		<g:message code="category.code.label" default="Code" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Category Code" class="form-control" name="code" maxlength="6" value="${categoryInstance?.code}"/>
	</div>
</div>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="categoryName">
		<g:message code="category.categoryName.label" default="Category Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Category Name" class="form-control"  name="categoryName" maxlength="100" value="${categoryInstance?.categoryName}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label"  for="minCharge">
		<g:message code="category.minCharge.label" default="Min Charge" />
		
	</label>
	<div class="col-sm-9">
	<g:field  type="number" placeholder="0.00" class="form-control" name="minCharge" value="${fieldValue(bean: categoryInstance, field: 'minCharge')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="gcatId">
		<g:message code="category.gcatId.label" default="Gcat Id" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="gcatId" name="gcatId" from="${['P','B']}"  required="" value="${categoryInstance?.gcatId}"  class="form-control search-select"/>
	</div>
</div>
<%--<<g:hiddenField name="userId" value="${ }"/>--%>
<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="category.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${categoryInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: categoryInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="category.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${categoryInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="type">
		<g:message code="category.type.label" default="Type" />
	</label>
	<div class="col-sm-9">
	<g:select id="type" name="type.id" from="${dametro.Eventtype.list()}" optionKey="id" required="" value="${categoryInstance?.type?.id}" optionValue="typeName" class="form-control search-select"/>
	</div>
</div>

<%--<div class="fieldcontain ${hasErrors(bean: categoryInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="category.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${categoryInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="category.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${categoryInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['category.id': categoryInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>