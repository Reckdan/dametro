



<%--<div class="fieldcontain ${hasErrors(bean: metroInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="metro">
		<g:message code="metro.metro.label" default="Metro Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Metro Name" class="form-control" name="metro" maxlength="50" value="${metroInstance?.code}"/>
	</div>
</div>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="city">
		<g:message code="metro.city.label" default="City" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="City" class="form-control"  name="city" maxlength="50" value="${metroInstance?.city}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label"  for="region">
		<g:message code="metro.region.label" default="Region" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Region" class="form-control" name="region" value="${fieldValue(bean: metroInstance, field: 'region')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="organizationType">
		<g:message code="metro.organizationType.label" default="Organization Type" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Organization Type" class="form-control" name="organizationType" value="${fieldValue(bean: metroInstance, field: 'organizationType')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="cordinatorsNumbers">
		<g:message code="metro.cordinatorsNumbers.label" default="Cordinators Number" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Cordinators Number" class="form-control" name="cordinatorsNumbers" value="${fieldValue(bean: metroInstance, field: 'cordinatorsNumbers')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="enquires">
		<g:message code="metro.enquires.label" default="Enquires" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Enquires" class="form-control" name="enquires" value="${fieldValue(bean: metroInstance, field: 'enquires')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="submetro">
		<g:message code="metro.enquires.label" default="Submetro" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Submetro" class="form-control" name="submetro" value="${fieldValue(bean: metroInstance, field: 'submetro')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="electoralArea">
		<g:message code="metro.enquires.label" default="Electoral Area" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Electoral Area" class="form-control" name="electoralArea" value="${fieldValue(bean: metroInstance, field: 'electoralArea')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="businessNotice">
		<g:message code="metro.businessNotice.label" default="Business Notice" />
		
	</label>
	<div class="col-sm-9">
	<g:textArea placeholder="Business Notice" class="form-control" name="businessNotice" value="${fieldValue(bean: metroInstance, field: 'businessNotice')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="billMsg">
		<g:message code="metro.billMsg.label" default="Bill Msg" />
		
	</label>
	<div class="col-sm-9">
	<g:textArea placeholder="Bill Msg" maxlength="160" class="form-control limited" name="billMsg" value="${fieldValue(bean: metroInstance, field: 'billMsg')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="paymentNotification">
		<g:message code="metro.paymentNotification.label" default="Payment Notification" />
		
	</label>
	<div class="col-sm-9">
	<g:textArea placeholder="Payment Notification" maxlength="160" class="form-control limited" name="paymentNotification" value="${fieldValue(bean: metroInstance, field: 'paymentNotification')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="logo">
		<g:message code="metro.logo.label" default="Metro Logo" />
		
	</label>
	<div class="col-sm-9">
	<div class="fileupload fileupload-new" data-provides="fileupload">
													<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image" alt=""/>
													</div>
													<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
													<div>
														<span class="btn btn-light-grey btn-file"><span class="fileupload-new"><i class="fa fa-picture-o"></i> Select image</span><span class="fileupload-exists"><i class="fa fa-picture-o"></i> Change</span>
															<input type="file" name="logo">
														</span>
														<a href="#" class="btn fileupload-exists btn-light-grey" data-dismiss="fileupload">
															<i class="fa fa-times"></i> Remove
														</a>
													</div>
												</div>

	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="logo">
		<g:message code="metro.logo.label" default="Metro Logo" />
		
	</label>
	<div class="col-sm-9">
	<div class="fileupload fileupload-new" data-provides="fileupload">
													<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image" alt=""/>
													</div>
													<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
													<div>
														<span class="btn btn-light-grey btn-file"><span class="fileupload-new"><i class="fa fa-picture-o"></i> Select image</span><span class="fileupload-exists"><i class="fa fa-picture-o"></i> Change</span>
															<input type="file" name="logo">
														</span>
														<a href="#" class="btn fileupload-exists btn-light-grey" data-dismiss="fileupload">
															<i class="fa fa-times"></i> Remove
														</a>
													</div>
												</div>

	</div>
</div>
<%--<<g:hiddenField name="userId" value="${ }"/>--%>
<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="metro.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${metroInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: metroInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="metro.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${metroInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="type">
		<g:message code="metro.type.label" default="Type" />
	</label>
	<div class="col-sm-9">
	<g:select id="type" name="type.id" from="${dametro.Eventtype.list()}" optionKey="id" required="" value="${metroInstance?.type?.id}" optionValue="typeName" class="form-control search-select"/>
	</div>
</div>

<%--<div class="fieldcontain ${hasErrors(bean: metroInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="metro.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${metroInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="metro.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${metroInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['metro.id': metroInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>