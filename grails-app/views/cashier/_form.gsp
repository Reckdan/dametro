



<%--<div class="fieldcontain ${hasErrors(bean: cashierInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="firstName">
		<g:message code="cashier.firstName.label" default="First Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="First Name" class="form-control" name="firstName" maxlength="50" value="${cashierInstance?.firstName}"/>
	</div>
</div>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="Last Name">
		<g:message code="cashier.lastName.label" default="Last Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Last Name" class="form-control"  name="lastName" maxlength="50" value="${cashierInstance?.firstName}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label"  for="otherNames">
		<g:message code="cashier.otherNames.label" default="Other Names" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Other Names" class="form-control" name="otherNames" value="${fieldValue(bean: cashierInstance, field: 'otherNames')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="houseAddress">
		<g:message code="cashier.houseAddress.label" default="House Address" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Home Address" class="form-control" name="houseAddress" value="${fieldValue(bean: cashierInstance, field: 'homeAddress')}"/>
	</div>
</div>
<div class="form-group ">
	<label class="col-sm-2 control-label" for="postalAddress">
		<g:message code="cashier.postalAddress.label" default="Postal Address" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Postal Address" class="form-control" name="postalAddress" value="${fieldValue(bean: cashierInstance, field: 'postalAddress')}"/>
	</div>
</div>
<div class="form-group ">
	<label class="col-sm-2 control-label" for="telephone">
		<g:message code="cashier.telephone.label" default="Telephone" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Telephone" class="form-control" name="telephone" value="${fieldValue(bean: cashierInstance, field: 'telephone')}"/>
	</div>
</div>
<div class="form-group ">
	<label class="col-sm-2 control-label" for="email">
		<g:message code="cashier.email.label" default="Email" />
		
	</label>
	<div class="col-sm-9">
	<g:textField type="email"  placeholder="Email" class="form-control" name="email" value="${fieldValue(bean: cashierInstance, field: 'email')}"/>
	</div>
</div>
<div class="form-group ">
	<label class="col-sm-2 control-label" for="pctCommission">
		<g:message code="cashier.pctCommission.label" default="Percentage Commission" />
		
	</label>
	<div class="col-sm-9">
	<g:field type="number"  placeholder="% Commission" class="form-control" name="pctCommission" value="${fieldValue(bean: cashierInstance, field: 'pctCommission')}"/>
	</div>
</div>
<%--<<g:hiddenField name="userId" value="${ }"/>--%>
<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="cashier.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${cashierInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: cashierInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="cashier.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${cashierInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>





<%--<div class="fieldcontain ${hasErrors(bean: cashierInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="cashier.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${cashierInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="cashier.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${cashierInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['cashier.id': cashierInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>