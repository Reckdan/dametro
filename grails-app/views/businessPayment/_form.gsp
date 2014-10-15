



<%--<div class="fieldcontain ${hasErrors(bean: businesspaymentInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="business">
		<g:message code="businesspayment.accountNo.label" default="Business" />
		
	</label>
	<div class="col-sm-9">
		<g:textField  placeholder="businesspayment Name" class="form-control"  name="accountNo" maxlength="100" value="${businesspaymentInstance?.businesspaymentName}"/>
	</div>
</div>
<div id="details"></div>


<div class="form-group">
	<label  class="col-sm-2 control-label" for="businesspaymentName">
		<g:message code="businesspayment.businesspaymentName.label" default="businesspayment Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="businesspayment Name" class="form-control"  name="businesspaymentName" maxlength="100" value="${businesspaymentInstance?.businesspaymentName}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label"  for="minCharge">
		<g:message code="businesspayment.minCharge.label" default="Min Charge" />
		
	</label>
	<div class="col-sm-9">
	<g:field  type="number" placeholder="0.00" class="form-control" name="minCharge" value="${fieldValue(bean: businesspaymentInstance, field: 'minCharge')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="gcatId">
		<g:message code="businesspayment.gcatId.label" default="Gcat Id" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="gcatId" name="gcatId" from="${['P','B']}"  required="" value="${businesspaymentInstance?.gcatId}"  class="form-control search-select"/>
	</div>
</div>
<%--<<g:hiddenField name="userId" value="${ }"/>--%>
<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="businesspayment.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${businesspaymentInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: businesspaymentInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="businesspayment.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${businesspaymentInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="type">
		<g:message code="businesspayment.type.label" default="Type" />
	</label>
	<div class="col-sm-9">
	<g:select id="type" name="type.id" from="${dametro.Eventtype.list()}" optionKey="id" required="" value="${businesspaymentInstance?.type?.id}" optionValue="typeName" class="form-control search-select"/>
	</div>
</div>

<%--<div class="fieldcontain ${hasErrors(bean: businesspaymentInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="businesspayment.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${businesspaymentInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="businesspayment.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${businesspaymentInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['businesspayment.id': businesspaymentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>