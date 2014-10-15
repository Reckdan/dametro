<div id="wizard" class="swMain">
	<ul>
		<li>
			<a href="#step-1">
			<div class="stepNumber">
				1
			</div>
			<span class="stepDesc"> Step 1
			<br />
			<small>General Business Information</small> </span>
			</a>
			</li>
			<li>
			<a href="#step-2">
			<div class="stepNumber">
			2
			</div>
			<span class="stepDesc"> Step 2
			<br />
			<small>Location Information</small> </span>
			</a>
			</li>
			<li>
			<a href="#step-3">
			<div class="stepNumber">
			3
			</div>
			<span class="stepDesc"> Step 3
			<br />
			<small>Other Information</small> </span>
			</a>
			</li>
	</ul>
			<div class="progress progress-striped active progress-sm">
			<div aria-valuemax="100" aria-valuemin="0" role="progressbar" class="progress-bar progress-bar-success step-bar">
				<span class="sr-only"> 0% Complete (success)</span>
			</div>
			</div>

<div id="step-1">
<h2 class="StepTitle">General Business Information</h2>

<%--<div class="fieldcontain ${hasErrors(bean: businessInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="accountNo">
		<g:message code="business.accountNo.label" default="Account Number" />
		<span class="symbol required"></span>
	</label>
	<div class="col-sm-3">
		<g:textField placeholder="Account Number" class="form-control" name="accountNo" 
		maxlength="10" value="${businessInstance?.accountNo}" required="true"/>
	</div>
	<label  class="col-sm-2 control-label" for="businessName">
		<g:message code="business.businessName.label" default="Business Name" />
		
	</label>
	<div class="col-sm-4">
		<g:textField  placeholder="Business Name" class="form-control"  name="businessName" maxlength="100" value="${businessInstance?.businessName}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="tin">
		<g:message code="business.tin.label" default="Tin" />
		
	</label>
	<div class="col-sm-3">
		<g:textField  placeholder="Tin" class="form-control"  name="tin" maxlength="100" value="${businessInstance?.tin}"/>
	</div>
	<label  class="col-sm-2 control-label" for="vatno">
		<g:message code="business.vatno.label" default="Vat Number" />
		
	</label>
	<div class="col-sm-4">
		<g:textField  placeholder="vatno" class="form-control"  name="vatno" maxlength="100" value="${businessInstance?.vatno}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="address">
		<g:message code="business.address.label" default="Address" />
		
	</label>
	<div class="col-sm-3">
		<g:textField  placeholder="Address" class="form-control"  name="address" maxlength="100" value="${businessInstance?.address}"/>
	</div>
	<label  class="col-sm-2 control-label" for="phoneno">
		<g:message code="business.phoneno.label" default="Phone Number" />
		
	</label>
	<div class="col-sm-4">
		<g:textField  placeholder="phoneno" class="form-control"  name="phoneno" maxlength="15" value="${businessInstance?.phoneno}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="fax">
		<g:message code="business.fax.label" default="Fax Number" />
		
	</label>
	<div class="col-sm-3">
		<g:textField  placeholder="Fax" class="form-control"  name="fax" maxlength="15" value="${businessInstance?.fax}"/>
	</div>
	<label class="col-sm-2 control-label"  for="email">
		<g:message code="business.email.label" default="Email" />
		
	</label>
	<div class="col-sm-4">
		<g:field  type="email" placeholder="Email" class="form-control" name="minCharge" value="${fieldValue(bean: businessInstance, field: 'email')}"/>
	</div>

</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="type">
		<g:message code="business.type.label" default="Type" />
		<span class="symbol required"></span>
	</label>
	<div class="col-sm-3">
		<g:select id="type" name="type.id" from="${types}" optionKey="id" required="" 
			value="${fixedfeeInstance?.type?.id}" optionValue="typeName" class="form-control search-select"
			noSelection="['-1': '-Select Type-']"
			onchange="${remoteFunction(action: 'listcategories',
                  onSuccess: 'populateCategories(data)',
                  params: '\'mtype=\' + this.value')}"/>
	</div>
	<label class="col-sm-2 control-label"  for="category">
		<g:message code="business.category.label" default="Category" />
		<span class="symbol required"></span>
	</label>
	<div class="col-sm-4">
	
	<g:select name="category.id" id="category" class="form-control search-select" from="${categories}" optionValue="categoryName" optionKey="id" />

	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label"  for="contacts">
		<g:message code="business.contact.label" default="Contacts" />
		
	</label>
	<div class="col-sm-3">
		<g:select name="category.id" id="category" class="form-control search-select" from="${contacts}"  optionKey="id" optionValue="fullName"/>
	</div>
	<label  class="col-sm-2 control-label" for="headoffice">
		<g:message code="business.headoffice.label" default="Head Office" />
		
	</label>
	<div class="col-sm-4">
		<g:select id="headoffice" name="headoffice.id" from="${headoffice}" optionKey="id" required="" 
			value="${businessInstance?.headoffice?.id}" optionValue="businessName" class="form-control search-select"
			noSelection="['-1': '-Select Head Office-']"/>
	</div>
</div>

<div class="form-group">
	<div class="col-sm-2 col-sm-offset-8">
		<button class="btn btn-blue next-step btn-block">
			Next <i class="fa fa-arrow-circle-right"></i>
		</button>
	</div>
</div>


</div>

<div id="step-2">
<h2 class="StepTitle">Location Information</h2>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="submetro">
		<g:message code="business.listpropertyby.label" default="List Properties By:" />
		
	</label>
	<div class="col-sm-3">
	<g:select id="listpropertyby" name="listpropertyby" from="${['Account Number','House Address'] }"  required="" 
	value="Account Number" class="form-control search-select"
	onchange="${remoteFunction(action: 'listproperties',
                  onSuccess: 'populateProperities(data)',
                  params: '\'pval=\' + this.value')}"/>
	</div>
	
	
	<label  class="col-sm-2 control-label" for="building">
		<g:message code="business.building.label" default="Property" />
		
	</label>
	<div class="col-sm-3">
		<g:select id="building" name="buiding.id" from="${buildings}" optionKey="id" required="" 
		value="${businessInstance?.building?.id}" optionValue="accountNo" class="form-control search-select"
		noSelection="['-1': '-Select Submetro-']"/>
	</div>
	<label class="checkbox-inline" for="useadd">
		<g:checkBox name="useadd" class="square-black"  id="useradd" /><g:message code="gcrtransfer.isused.label" default="Is Used" />
		
	</label>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="submetro">
		<g:message code="business.submetro.label" default="Submetro" />
		
	</label>
	<div class="col-sm-3">
		<g:select id="submetro" name="submetro.id" from="${submetros}" optionKey="id" required="" 
			value="${businessInstance?.submetro?.id}" optionValue="submetroName" class="form-control search-select"
			noSelection="['-1': '-Select Submetro-']"
			onchange="${remoteFunction(action: 'listconstituencies',
                  onSuccess: 'populateConstituencies(data)',
                  params: '\'mtype=\' + this.value')}"/>
	</div>
	<label  class="col-sm-2 control-label" for="constituency">
		<g:message code="business.constituency.label" default="Constituency" />
		
	</label>
	<div class="col-sm-4">
	<g:select id="constituency" name="constituency.id" from="${constituencies}" optionKey="id" required="" 
	value="${businessInstance?.constituency?.id}" optionValue="constituencyName" class="form-control search-select"
	noSelection="['-1': '-Select Constituency-']"
	onchange="${remoteFunction(action: 'listelectoralareas',
                  onSuccess: 'populateElectoralAreas(data)',
                  params: '\'mtype=\' + this.value')}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="electoralarea">
		<g:message code="business.electoralarea.label" default="Electoral Area" />
		
	</label>
	<div class="col-sm-3">
		<g:select id="electoralarea" name="electoralarea.id" from="${electoralareas}" optionKey="id" required="" 
			value="${businessInstance?.electoralarea?.id}" optionValue="electoralareaName" class="form-control search-select"
			noSelection="['-1': '-Select Electoral Area-']"
			onchange="${remoteFunction(action: 'listunits',
                  onSuccess: 'populateUnits(data)',
                  params: '\'mtype=\' + this.value')}"/>
	</div>
	<label  class="col-sm-2 control-label" for="unit">
		<g:message code="business.unit.label" default="Unit Committee Area" />
		
	</label>
	<div class="col-sm-4">
		<g:select id="unit" name="unitid" from="${units}" optionKey="id" required="" 
			value="${businessInstance?.unit?.id}" optionValue="unitName" class="form-control search-select"
			noSelection="['-1': '-Select Unit Committee Area-']"/>
	</div>
</div>


<div class="form-group">
	<label  class="col-sm-2 control-label" for="community">
		<g:message code="business.community.label" default="Community" />
		
	</label>
	<div class="col-sm-3">
		<g:select id="community" name="community.id" from="${communities}" optionKey="id" required="" 
			value="${businessInstance?.community?.id}" optionValue="communityName" class="form-control search-select"
			noSelection="['-1': '-Select Community-']"/>
	</div>
	<label  class="col-sm-2 control-label" for="street">
		<g:message code="business.street.label" default="Street" />
		
	</label>
	<div class="col-sm-4">
		<g:select id="street" name="street.id" from="${streets}" optionKey="id" required="" 
			value="${businessInstance?.street?.id}" optionValue="streetName" class="form-control search-select"
			noSelection="['-1': '-Select Street-']"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="housenumber">
		<g:message code="business.housenumber.label" default="House Number" />
	</label>
	<div class="col-sm-3">
	<g:textField id="housenumber"  placeholder="House Number" class="form-control"  name="housenumber" maxlength="10" value="${businessInstance?.housenumber}"/>
	</div>
	<label  class="col-sm-2 control-label" for="assessmentType">
		<g:message code="business.assessmentType.label" default="Assessment Type" />
		
	</label>
	<div class="col-sm-4">
		<g:select id="assessmentType" name="assessmentType.id" from="${assessmenttypes}" optionKey="id" required="" 
			value="${businessInstance?.assessmentType?.id}" optionValue="label" class="form-control search-select"
			noSelection="['-1': '-Select Assessment Type-']"/>
	</div>
</div>

<div class="form-group">
	<div class="col-sm-2 col-sm-offset-3">
		<button class="btn btn-light-grey back-step btn-block">
			<i class="fa fa-circle-arrow-left"></i> Back
		</button>
	</div>
	<div class="col-sm-2 col-sm-offset-3">
		<button class="btn btn-blue next-step btn-block">
			Next <i class="fa fa-arrow-circle-right"></i>
		</button>
	</div>
</div>

</div>

<div id="step-3">
<h2 class="StepTitle">Other Information</h2>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="registrationNo">
		<g:message code="business.registrationNo.label" default="Registration Number" />
		
	</label>
	<div class="col-sm-3">
		<g:textField  placeholder="Registration Number" class="form-control"  name="registrationNo" maxlength="100" value="${businessInstance?.registrationNo}"/>
	</div>
	<label  class="col-sm-2 control-label" for="registrationDate">
		<g:message code="business.registrationDate.label" default="Registration Date" />
	</label>
	<div class="col-sm-4">
	<g:datePicker name="registrationDate" precision="day"  value="${businessInstance?.registrationDate}" default="none" noSelection="['': '']" />
	
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="commencementDate">
		<g:message code="business.commencementDate.label" default="Commencement Date" />
		
	</label>
	<div class="col-sm-3">
		<g:datePicker name="commencementDate" precision="day"  value="${businessInstance?.commencementDate}" default="none" noSelection="['': '']" />
	</div>
	<label  class="col-sm-2 control-label" for="noOfEmployee">
		<g:message code="business.noOfEmployee.label" default="Number of Employees" />
	</label>
	<div class="col-sm-4">
	<g:field class="form-control" name="noOfEmployee" type="number" min="0" value="${businessInstance.noOfEmployee}" required=""/>
	
	</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="numMale">
		<g:message code="business.numMale.label" default="# Male Employees" />
		
	</label>
	<div class="col-sm-3">
	<g:field class="form-control" name="numMale" type="number" min="0" value="${businessInstance.numMale}" required=""/>
	
	</div>
	
	<label  class="col-sm-2 control-label" for="numFemale">
		<g:message code="business.numFemale.label" default="# Female Employees" />
		
	</label>
	<div class="col-sm-4">
	<g:field class="form-control" name="numFemale" type="number" min="0" value="${businessInstance.numFemale}" required=""/>
	
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="floorSpace">
		<g:message code="business.floorSpace.label" default="Floor Space" />
		
	</label>
	<div class="col-sm-3">
		<g:field class="form-control" name="floorSpace" type="number" min="0" value="${businessInstance.floorSpace}" required=""/>
	</div>
	<label  class="col-sm-2 control-label" for="premisestype">
		<g:message code="business.premisestype.label" default="Premises Type" />
		
	</label>
	<div class="col-sm-4">
		<g:select id="premisestype" name="premisestype.id" from="${premisestypes}" optionKey="id" required="" 
			value="${businessInstance?.premisetype?.id}" optionValue="label" class="form-control search-select"
			noSelection="['-1': '-Select Premise Type-']"/>
	</div>
</div>


<div class="form-group">
	<div class="col-sm-2 col-sm-offset-3">
		<button class="btn btn-light-grey back-step btn-block">
			<i class="fa fa-circle-arrow-left"></i> Back
		</button>
	</div>
	<div class="col-sm-2 col-sm-offset-3">
		<button class="btn btn-success finish-step btn-block">
			Save <i class="fa fa-arrow-circle-right"></i>
		</button>
	</div>
</div>

</div>



</div>