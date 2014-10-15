<div class="form-group">
	<label  class="col-sm-2 control-label" for="firstName">
		<g:message code="contact.firstName.label" default="First Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="First Name" class="form-control"  name="firstName" maxlength="100" value="${contactInstance?.firstName}"/>
	</div>
</div>


<div class="form-group">
	<label  class="col-sm-2 control-label" for="lastName">
		<g:message code="contact.lastName.label" default="Last Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Last Name" class="form-control"  name="lastName" maxlength="100" value="${contactInstance?.lastName}"/>
	</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="otherNames">
		<g:message code="contact.otherNames.label" default="Other Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Other Name" class="form-control"  name="otherNames" maxlength="100" value="${contactInstance?.otherNames}"/>
	</div>
</div>



<div class="form-group">
	<label class="col-sm-2 control-label" for="organizationName">
		<g:message code="contact.organizationName.label" default="Organization Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Organization Name" class="form-control" name="organizationName" maxlength="6" value="${contactInstance?.organizationName}"/>
	</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="emailAddress">
		<g:message code="contact.emailAddress.label" default="Email Address" />
		
	</label>
	<div class="col-sm-9">
	<g:textField type="email"  placeholder="Email Address" class="form-control"  name="emailAddress" value="${contactInstance?.emailAddress}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="address">
		<g:message code="contact.address.label" default="Address"/>
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Address" class="form-control"  name="address" value="${contactInstance?.address}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="phone">
		<g:message code="contact.phone.label" default="Telephone" />
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Telephone" class="form-control"  name="phone" maxlength="18" value="${contactInstance?.telephone}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="mobile">
		<g:message code="contact.phone.label" default="Mobile Phone" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Mobile" class="form-control"  name="mobile" maxlength="18" value="${contactInstance?.mobile}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="city">
		<g:message code="contact.city.label" default="City" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="City" class="form-control"  name="city" maxlength="18" value="${contactInstance?.city}"/>
	</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="streetAddress">
		<g:message code="contact.streetAddress.label" default="Street Address" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Street Address" class="form-control"  name="streetAddress" maxlength="18" value="${contactInstance?.streetAddress}"/>
	</div>
</div>
<div class="form-group">
	<label  class="col-sm-2 control-label" for="isBusiness">
		
		
	</label>
	<div class="col-sm-9">
	<g:checkBox name="isBusiness" class="square-black" value="${contactInstance?.isBusiness}" /><g:message code="gcrtransfer.isBusiness.label" default="Is a  Business" />
	</div>
</div>


<div class="form-group ">
	<label class="col-sm-2 control-label" for="idType">
		<g:message code="category.idType.label" default="Type of ID" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="idType" name="idType" from="${['Passport','Drivers License','National ID']}"  required="" value="${categoryInstance?.idType}"  class="form-control search-select"/>
	</div>
</div>


<div class="form-group">
	<label  class="col-sm-2 control-label" for="ID Number">
		<g:message code="contact.idNumber.label" default="ID Number" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="ID Number" class="form-control"  name="idNumber" maxlength="20" value="${contactInstance?.idNumber}"/>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-2 control-label" for="dob">
		<g:message code="contact.dbo.label" default="Date of Birth" />
		
	</label>
	<div class="col-sm-9">
	<g:datePicker class="form-control date-picker" name="dob" precision="day"  value="${contactInstance?.dob}" default="1900-01-01" noSelection="['': '']" />
	</div>
</div>
