

<div class="form-group">
	<label  class="col-sm-2 control-label" for="book">
		<g:message code="gcrtransfer.book.label" default="Book" />
	</label>
	<div class="col-sm-9">
	<g:select id="book" name="book.id" from="${dametro.Book.list()}" optionKey="id" required="" value="${gcrtransferInstance?.book?.id}" optionValue="fullName" class="form-control search-select"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="transferedtoCollector">
		<g:message code="gcrtransfer.transferedtoCollector.label" default="Transfer From" />
	</label>
	<div class="col-sm-9">
	<g:select id="collector" name="collector.id" from="${dametro.Collector.list()}" optionKey="id" required="" value="${gcrtransferInstance?.transferfromCollector?.id}" optionValue="fullName" class="form-control search-select"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="transferedtoCollector">
		<g:message code="gcrtransfer.transferedtoCollector.label" default="Transfer To" />
	</label>
	<div class="col-sm-9">
	<g:select id="collector" name="collector.id" from="${dametro.Collector.list()}" optionKey="id" required="" value="${gcrtransferInstance?.transferedtoCollector?.id}" optionValue="fullName" class="form-control search-select"/>
	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="datecreated">
		<g:message code="gcrtransfer.datetransferred.label" default="Date Transfered" />
		
	</label>
	<div class="col-sm-9">
	<g:datePicker class="form-control date-picker" name="datetransferred" precision="day"  value="${gcrtransferInstance?.datetransferred}" default="none" noSelection="['': '']" />
	</div>
</div>

<%--<div class="fieldcontain ${hasErrors(bean: gcrtransferInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
<label class="col-sm-2 control-label" for="">
	
		
	</label>
<div class="col-sm-9">
	<label class="checkbox-inline" for="isused">
		<g:checkBox name="isused" class="square-black" value="${gcrtransferInstance?.isused}" /><g:message code="gcrtransfer.isused.label" default="Is Used" />
		
	</label>
	
	<label class="checkbox-inline" for="isdamaged">
		<g:checkBox name="isdamaged" class="square-black" value="${gcrtransferInstance?.isdamaged}" /><g:message code="gcrtransfer.isdamaged.label" default="Is Damaged" />
		
	</label>	
	
		<label class="checkbox-inline" for="ismissing">
		<g:checkBox name="ismissing" class="square-black" value="${gcrtransferInstance?.ismissing}" /><g:message code="gcrtransfer.ismissing.label" default="Is Missing" />
		
	</label>	
	
</div>		
</div>
<div class="form-group">
	
</div>
<div class="form-group">
	
</div>



<%--<<g:hiddenField name="userId" value="${ }"/>--%>
<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="gcrtransfer.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${gcrtransferInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: gcrtransferInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="gcrtransfer.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${gcrtransferInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>





<%--<div class="fieldcontain ${hasErrors(bean: gcrtransferInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="gcrtransfer.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${gcrtransferInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="gcrtransfer.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${gcrtransferInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['gcrtransfer.id': gcrtransferInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>