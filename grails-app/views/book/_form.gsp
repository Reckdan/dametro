

<div class="form-group ${hasErrors(bean: bookInstance, field: 'startSerial', 'has-error')} required">
	<label  class="col-sm-2 control-label" for="startSerial">
		<g:message code="book.startSerial.label" default="Start Serial" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-9">
	<g:field class="form-control" name="startSerial" type="number" min="10000" value="${bookInstance.startSerial}" required=""/>
	</div>
</div>

<div class="form-group ${hasErrors(bean: bookInstance, field: 'endSerial', 'has-error')} required">
	<label  class="col-sm-2 control-label" for="endSerial">
		<g:message code="book.endSerial.label" default="End Serial" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-9">
	<g:field class="form-control" name="endSerial" type="number" min="10000" value="${bookInstance.endSerial}" required=""/>
	</div>
</div>

<div class="form-group ${hasErrors(bean: bookInstance, field: 'voucherNo', 'has-error')} ">
	<label  class="col-sm-2 control-label" for="voucherNo">
		<g:message code="book.voucherNo.label" default="Voucher No" />
		
	</label>
	<div class="col-sm-9">
	<g:textField class="form-control" name="voucherNo" maxlength="20" value="${bookInstance?.voucherNo}"/>
	</div>
</div>

<div class="form-group ${hasErrors(bean: bookInstance, field: 'date', 'has-error')} ">
	<label  class="col-sm-2 control-label" for="date">
		<g:message code="book.date.label" default="Date" />
		
	</label>
	<div class="col-sm-9">
	<g:datePicker class="form-control date-picker" name="date" precision="day"  value="${bookInstance?.date}" default="none" noSelection="['': '']" />
	</div>
</div>



<%--<div class="form-group ${hasErrors(bean: bookInstance, field: 'quantity', 'has-error')}">
	<label  class="col-sm-2 control-label" for="quantity">
		<g:message code="book.quantity.label" default="Quantity" />
	</label>
	<div class="col-sm-9">
	<g:field class="form-control" name="quantity" type="number" value="${bookInstance.quantity}" required=""/>
	</div>
</div>
--%>



<div class="form-group ${hasErrors(bean: bookInstance, field: 'type', 'has-error')}">
	<label  class="col-sm-2 control-label" for="type">
		<g:message code="book.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-9">
	<g:select id="type" name="type.id" from="${dametro.Lookup.list()}" optionKey="id" required="" value="${bookInstance?.type?.id}" optionValue="label" class="form-control search-select"/>
	</div>
</div>

