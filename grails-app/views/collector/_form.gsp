



<%--<div class="fieldcontain ${hasErrors(bean: collectorInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="collectorCode">
		<g:message code="collector.code.label" default="Collector Code" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Collector Code" class="form-control" name="collectorCode" maxlength="6" value="${collectorInstance?.collectorCode}"/>
	</div>
</div>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="firstName">
		<g:message code="collector.firstName.label" default="First Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="First Name" class="form-control"  name="firstName" maxlength="100" value="${collectorInstance?.firstName}"/>
	</div>
</div>


<div class="form-group">
	<label  class="col-sm-2 control-label" for="lastName">
		<g:message code="collector.lastName.label" default="Last Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Last Name" class="form-control"  name="lastName" maxlength="100" value="${collectorInstance?.lastName}"/>
	</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="otherNames">
		<g:message code="collector.otherNames.label" default="Other Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Other Name" class="form-control"  name="otherNames" maxlength="100" value="${collectorInstance?.otherNames}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="homeAddress">
		<g:message code="collector.homeAddress.label" default="Home Address" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Home Address" class="form-control"  name="homeAddress" maxlength="100" value="${collectorInstance?.homeAddress}"/>
	</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="telephone">
		<g:message code="collector.telephone.label" default="Telephone" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Telephone" class="form-control"  name="telephone" maxlength="100" value="${collectorInstance?.telephone}"/>
	</div>
</div>
<div class="form-group ">
	<label class="col-sm-2 control-label" for="typeOfId">
		<g:message code="category.typeOfId.label" default="Type of ID" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="typeOfId" name="typeOfId" from="${['Passport','Drivers License','National ID']}"  required="" value="${categoryInstance?.typeOfId}"  class="form-control search-select"/>
	</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="ID Number">
		<g:message code="collector.idNumber.label" default="ID Number" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="ID Number" class="form-control"  name="idNumber" maxlength="20" value="${collectorInstance?.idNumber}"/>
	</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="guarantorName">
		<g:message code="collector.guarantorName.label" default="Guarantor's Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Guarantor's Name" class="form-control"  name="guarantorName" maxlength="100" value="${collectorInstance?.guarantorName}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="guarantorPlaceofwork">
		<g:message code="collector.guarantorPlaceofwork.label" default="Guarantor's Place of Work" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Guarantor's Place of Work" class="form-control"  name="guarantorPlaceofwork" maxlength="100" value="${collectorInstance?.guarantorPlaceofwork}"/>
	</div>
</div>


<div class="form-group ">
	<label class="col-sm-2 control-label"  for="guaranteeValue">
		<g:message code="collector.guaranteeValue.label" default="Guarantee Amount" />
		
	</label>
	<div class="col-sm-9">
	<g:field  type="number" placeholder="0.00" class="form-control" name="guaranteeValue" value="${fieldValue(bean: collectorInstance, field: 'guaranteeValue')}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="type">
		<g:message code="collector.type.label" default="Collector Type" />
	</label>
	<div class="col-sm-9">
	<g:select id="type" name="type.id" from="${dametro.Lookup.list()}" optionKey="id" required="" value="${collectorInstance?.type?.id}" optionValue="label" class="form-control search-select"/>
	</div>
</div>





