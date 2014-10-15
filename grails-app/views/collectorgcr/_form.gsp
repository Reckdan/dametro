



<%--<div class="fieldcontain ${hasErrors(bean: collectorgcrInstance, field: 'code', 'error')} ">--%>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="book">
		<g:message code="collectorgcr.book.label" default="Book" />
	</label>
	<div class="col-sm-9">
	<g:select id="type" name="type.id" from="${dametro.Book.list()}" optionKey="id" required="" value="${collectorgcrInstance?.type?.id}" optionValue="serialrange" class="form-control search-select"/>
	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="code">
		<g:message code="collectorgcr.code.label" default="Code" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Collectorgcr Code" class="form-control" name="code" maxlength="6" value="${collectorgcrInstance?.code}"/>
	</div>
</div>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="collectorgcrName">
		<g:message code="collectorgcr.collectorgcrName.label" default="Collectorgcr Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Collectorgcr Name" class="form-control"  name="collectorgcrName" maxlength="100" value="${collectorgcrInstance?.collectorgcrName}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label"  for="minCharge">
		<g:message code="collectorgcr.minCharge.label" default="Min Charge" />
		
	</label>
	<div class="col-sm-9">
	<g:field  type="number" placeholder="0.00" class="form-control" name="minCharge" value="${fieldValue(bean: collectorgcrInstance, field: 'minCharge')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="gcatId">
		<g:message code="collectorgcr.gcatId.label" default="Gcat Id" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="gcatId" name="gcatId" from="${['P','B']}"  required="" value="${collectorgcrInstance?.gcatId}"  class="form-control search-select"/>
	</div>
</div>
<%--<<g:hiddenField name="userId" value="${ }"/>--%>
<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="collectorgcr.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${collectorgcrInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: collectorgcrInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="collectorgcr.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${collectorgcrInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>





<%--<div class="fieldcontain ${hasErrors(bean: collectorgcrInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="collectorgcr.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${collectorgcrInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="collectorgcr.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${collectorgcrInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['collectorgcr.id': collectorgcrInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>