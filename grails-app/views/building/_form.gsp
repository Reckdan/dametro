
<div id="wizard" class="swMain">
	<ul>
		<li><a href="#step-1">
				<div class="stepNumber">1</div> <span class="stepDesc"> Step
					1 <br /> <small>General Property Information</small>
			</span>
		</a></li>
		<li><a href="#step-2">
				<div class="stepNumber">2</div> <span class="stepDesc"> Step
					2 <br /> <small>Additional Information</small>
			</span>
		</a></li>

		
	</ul>
	<div class="progress progress-striped active progress-sm">
		<div aria-valuemax="100" aria-valuemin="0" role="progressbar"
			class="progress-bar progress-bar-success step-bar">
			<span class="sr-only"> 0% Complete (success)</span>
		</div>
	</div>

	<div id="step-1">
		<h2 class="StepTitle">General Property Information</h2>


		<%--<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'code', 'error')} ">--%>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="accountNo"> <g:message
					code="building.accountNo.label" default="Account Number" /><span class="symbol required"></span>
			</label>
			<div class="col-sm-3">
				<g:textField id="accountNo" placeholder="Account Number"
					class="form-control" name="accountNo" maxlength="10"
					value="${buildingInstance?.accountNo}" required="true"/>
			</div>
			<label class="col-sm-2 control-label" for="propertyUse"> <g:message
					code="building.propertyUse.label" default="Property Use" />

			</label>
			<div class="col-sm-4">
				<g:select id="propertyUse" name="propertyUse.id" from="${dametro.PropertyUse.list()}" optionKey="id"
					required="" value="${buildingInstance?.propertyUse?.id}"
					optionValue="propertyUse" class="form-control search-select"
					noSelection="['-1': '-Select Property Use-']" />
			</div>

		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label" for="type"> <g:message
					code="building.type.label" default="Type" />
					<span class="symbol required">
			</label>
			<div class="col-sm-3">
				<g:select id="type" name="type.id" from="${types}" optionKey="id"
					required="true" value="${fixedfeeInstance?.type?.id}"
					optionValue="typeName" class="form-control search-select"
					noSelection="['-1': '-Select Type-']"
					onchange="${remoteFunction(action: 'listcategories',
                  onSuccess: 'populateCategories(data)',
                  params: '\'mtype=\' + this.value')}" />
			</div>

			<label class="col-sm-2 control-label" for="category"> <g:message
					code="building.category.label" default="Category" />
					<span class="symbol required">

			</label>
			<div class="col-sm-4">

				<g:select name="category.id" id="category" required="true"
					class="form-control search-select" from="${categories}" optionKey="id" value="${fixedfeeInstance?.category?.id}"
					optionValue="categoryName" noSelection="['-1': '-Select Type-']"/>

			</div>
		</div>
		


		<div class="form-group">
			<label class="col-sm-2 control-label" for="submetro"> <g:message
					code="building.submetro.label" default="Submetro" />
					<span class="symbol required">

			</label>
			<div class="col-sm-3">
				<g:select id="submetro" name="submetro.id" from="${submetros}"
					optionKey="id" required="true"
					value="${buildingInstance?.submetro?.id}"
					optionValue="submetroName" class="form-control search-select"
					noSelection="['-1': '-Select Submetro-']"
					onchange="${remoteFunction(action: 'listconstituencies',
                  onSuccess: 'populateConstituencies(data)',
                  params: '\'mtype=\' + this.value')}" />
			</div>
			<label class="col-sm-2 control-label" for="constituency"> <g:message
					code="building.constituency.label" default="Constituency" />

			</label>
			<div class="col-sm-4">
				<g:select id="constituency" name="constituency.id"
					from="${constituencies}" optionKey="id" required=""
					value="${buildingInstance?.constituency?.id}"
					optionValue="constituencyName" class="form-control search-select"
					noSelection="['-1': '-Select Constituency-']"
					onchange="${remoteFunction(action: 'listelectoralareas',
                  onSuccess: 'populateElectoralAreas(data)',
                  params: '\'mtype=\' + this.value')}" />
			</div>


		</div>
		<div class="form-group">
			
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="electoralarea"> <g:message
					code="building.electoralarea.label" default="Electoral Area" />

			</label>
			<div class="col-sm-3">
				<g:select id="electoralarea" name="electoralarea.id"
					from="${electoralareas}" optionKey="id" required=""
					value="${buildingInstance?.electoralarea?.id}"
					optionValue="electoralareaName" class="form-control search-select"
					noSelection="['-1': '-Select Electoral Area-']"
					onchange="${remoteFunction(action: 'listunits',
                  onSuccess: 'populateUnits(data)',
                  params: '\'mtype=\' + this.value')}" />
			</div>
			<label class="col-sm-2 control-label" for="unit"> <g:message
					code="building.unit.label" default="Unit Committee Area" />

			</label>
			<div class="col-sm-4">
				<g:select id="unit" name="unit.id" from="${units}" optionKey="id"
					required="" value="${buildingInstance?.unit?.id}"
					optionValue="unitName" class="form-control search-select"
					noSelection="['-1': '-Select Unit Committee Area-']" />
			</div>

		</div>

		
		<div class="form-group">
			<label class="col-sm-2 control-label" for="community"> <g:message
					code="building.community.label" default="Community" />

			</label>
			<div class="col-sm-3">
				<g:select id="community" name="community.id" from="${communities}"
					optionKey="id" required=""
					value="${buildingInstance?.community?.id}"
					optionValue="communityName" class="form-control search-select"
					noSelection="['-1': '-Select Community-']" />
			</div>
		
			<label class="col-sm-2 control-label" for="street"> <g:message
					code="building.street.label" default="Street" />

			</label>
			<div class="col-sm-4">
				<g:select id="street" name="street.id" from="${streets}"
					optionKey="id" required="" value="${buildingInstance?.street?.id}"
					optionValue="streetName" class="form-control search-select"
					noSelection="['-1': '-Select Street-']" />
			</div>
		</div>

		
		<div class="form-group">
			<label class="col-sm-2 control-label" for="housenumber"> <g:message
					code="building.housenumber.label" default="House Number" />
			</label>
			<div class="col-sm-3">
				<g:textField id="housenumber" placeholder="House Number"
					class="form-control" name="housenumber" maxlength="10"
					value="${buildingInstance?.housenumber}" />
			</div>
			<label class="col-sm-2 control-label" for="rateableValue"> <g:message
					code="building.rateableValue.label" default="Rateable Value" />
					<span class="symbol required">
			</label>
			<div class="col-sm-4">
				<g:field class="form-control" name="rateableValue" type="number" min="0" value="${buildingInstance?.rateableValue}" required="true"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="longitude"> <g:message
					code="building.longitude.label" default="Longitude" />
			</label>
			<div class="col-sm-3">
				<g:textField id="longitude" placeholder="Longitude"
					class="form-control" name="longitude" maxlength="10"
					value="${buildingInstance?.longitude}" />
			</div>

			<label class="col-sm-2 control-label" for="latitude"> <g:message
					code="building.latitude.label" default="Latitude" />
			</label>
			<div class="col-sm-4">
				<g:textField id="latitude" placeholder="Latitude"
					class="form-control" name="latitude" maxlength="10"
					value="${buildingInstance?.latitude}" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label" for="division"> <g:message
					code="building.division.label" default="Division" />
			</label>
			<div class="col-sm-3">
				<g:textField id="division" placeholder="Division"
					class="form-control" name="division" maxlength="10"
					value="${buildingInstance?.division}" />
			</div>
			<label class="col-sm-2 control-label" for="serialNo"> <g:message
					code="building.serialNo.label" default="Serial Number" />
			</label>
			<div class="col-sm-4">
				<g:textField id="serialNo" placeholder="Serial Number"
					class="form-control" name="serialNo" maxlength="10"
					value="${buildingInstance?.serialNo}" />
			</div>
		</div>
		<div class="form-group">
			
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
		<h2 class="StepTitle">Other Property Information</h2>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="unit"> <g:message
					code="building.contact.label" default="Contact Person" />

			</label>
			<div class="col-sm-3">
				<g:select id="contact" name="contact.id" from="${contacts}" optionKey="id"
					required="" value="${buildingInstance?.contact?.id}"
					optionValue="fullName" class="form-control search-select"
					noSelection="['-1': '-Select Contact Person-']" />
			</div>
			<label class="col-sm-2 control-label" for="propertyFinancedBy"> <g:message
					code="building.propertyFinancedBy.label" default="Financed By" />

			</label>
			<div class="col-sm-4">
				<g:select id="propertyFinancedBy" name="propertyFinancedBy.id" from="${modesoffinance}" optionKey="id"
					required="" value="${buildingInstance?.propertyFinancedBy?.id}"
					optionValue="label" class="form-control search-select"
					noSelection="['-1': '-Select Mode of Finance-']" />
			</div>
			
		</div>


		<div class="form-group">
			<label class="col-sm-2 control-label" for="code"> <g:message
					code="building.valuationNo.label" default="Valuation Number" />

			</label>
			<div class="col-sm-3">
				<g:textField placeholder="Assessment Number" class="form-control"
					name="valuationNo" maxlength="6" value="${buildingInstance?.valuationNo}" />
			</div>
			<label  class="col-sm-2 control-label" for="valuationDate"><g:message code="building.valuationDate.label" default="Valuation Date" />
		
			</label>
			<div class="col-sm-4 input-group">
				<input type="text" data-date-format="mm-dd-yyyy" data-date-viewmode="years" class="form-control date-picker" name="valuationDate" value="${buildingInstance?.valuationDate}">
					<span class="input-group-addon"> <i class="fa fa-calendar"></i> </span>
									
				
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label" for="contructionMaterial"> <g:message
					code="building.contructionMaterial.label" default="Contruction Material" />

			</label>
			<div class="col-sm-3">
				<g:textField placeholder="Construction Material" class="form-control"
					name="contructionMaterial" maxlength="100"
					value="${buildingInstance?.contructionMaterial}" />
			</div>
			<label  class="col-sm-2 control-label" for="constructionYear"><g:message code="building.constructionYear.label" default="Construction Year" />
		
			</label>
			<div class="col-sm-4">
				<g:datePicker name="constructionYear" class="form-control date-picker" precision="year"  value="${buildingInstance?.constructionYear}" default="none" noSelection="['': '']" />
			</div>
		</div>



		<div class="form-group">
			<label class="col-sm-2 control-label" for="roofingMaterial"> <g:message
					code="building.roofingMaterial.label" default="Roofing Material" />

			</label>
			<div class="col-sm-3">
				<g:textField placeholder="Roofing Material" class="form-control"
					name="roofingMaterial" maxlength="100"
					value="${buildingInstance?.roofingMaterial}" />
			</div>
			<label class="col-sm-2 control-label" for="modeOfRefuseCollection"> <g:message
					code="building.modeOfRefuseCollection.label" default="Mode of Refuse Collection" />

			</label>
			<div class="col-sm-4">
				<g:textField placeholder="Mode of Refuse Collection" class="form-control"
					name="modeOfRefuseCollection" maxlength="6" value="${buildingInstance?.modeOfRefuseCollection}" />
			</div>
		</div>

	

		<div class="form-group ">
			<label class="col-sm-2 control-label" for="noOfBedrooms"> <g:message
					code="building.noOfBedrooms.label" default="# Bedrooms" />

			</label>
			<div class="col-sm-3">
				<g:field type="number" placeholder="0" class="form-control"
					name="noOfBedrooms"
					value="${fieldValue(bean: buildingInstance, field: 'noOfBedrooms')}" />
			</div>

			<label class="col-sm-2 control-label" for="noOfWcs"> <g:message
					code="building.noOfWcs.label" default="# Toilets" />

			</label>
			<div class="col-sm-4">
				<g:field type="number" placeholder="0" class="form-control"
					name="noOfWcs"
					value="${fieldValue(bean: buildingInstance, field: 'noOfWcs')}" />
			</div>
		</div>

		<div class="form-group ">
			<label class="col-sm-2 control-label" for="noOfBathrooms"> <g:message
					code="building.noOfBathrooms.label" default="# Bathrooms" />

			</label>
			<div class="col-sm-3">
				<g:field type="number" placeholder="0" class="form-control"
					name="noOfBathrooms"
					value="${fieldValue(bean: buildingInstance, field: 'noOfBathrooms')}" />
			</div>

			<label class="col-sm-2 control-label" for="noOfKitchens"> <g:message
					code="building.noOfBedrooms.label" default="# Kitchens" />

			</label>
			<div class="col-sm-4">
				<g:field type="number" placeholder="0.00" class="form-control"
					name="noOfKitchens"
					value="${fieldValue(bean: buildingInstance, field: 'noOfKitchens')}" />
			</div>
		</div>

		<div class="form-group ">
			<label class="col-sm-2 control-label" for="noOfGarages"> <g:message
					code="building.noOfGarages.label" default="# Garages" />

			</label>
			<div class="col-sm-3">
				<g:field type="number" placeholder="0" class="form-control"
					name="noOfGarages"
					value="${fieldValue(bean: buildingInstance, field: 'noOfGarages')}" />
			</div>

			<label class="col-sm-2 control-label" for="noOfShops"> <g:message
					code="building.noOfShops.label" default="# Shops" />

			</label>
			<div class="col-sm-4">
				<g:field type="number" placeholder="0.00" class="form-control"
					name="noOfShops"
					value="${fieldValue(bean: buildingInstance, field: 'noOfShops')}" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label" for="text1"> 

			</label>
			
			<div class="col-sm-9">
				<label class="checkbox-inline" for="gwc">
					<g:checkBox name="gwc" class="square-black" value="${buildingInstance?.gwc}" /><g:message code="building.gwc.label" default="Ghana Water?" />
		
				</label>
	
				<label class="checkbox-inline" for="gwcMetered">
					<g:checkBox name="gwcMetered" class="square-black" value="${buildingInstance?.gwcMetered}" /><g:message code="building.gwcMetered.label" default="Is GW Metered?" />
		
				</label>	
	
				<label class="checkbox-inline" for="ecg">
					<g:checkBox name="ecg" class="square-black" value="${buildingInstance?.ecg}" /><g:message code="building.ecg.label" default="Electricity?" />
		
				</label>	
				<label class="checkbox-inline" for="ecgMetered">
					<g:checkBox name="ecgMetered" class="square-black" value="${buildingInstance?.ecgMetered}" /><g:message code="building.ecgMetered.label" default="ECG Metered?" />
		
				</label>
				<label class="checkbox-inline" for="phone">
					<g:checkBox name="phone" class="square-black" value="${buildingInstance?.phone}" /><g:message code="building.phone.label" default="Phone?" />
		
				</label>
			</div>
	
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label" for="status"> <g:message
					code="building.status.label" default="Status" />

			</label>
			<div class="col-sm-9">
				<g:select id="status" name="status.id" from="${propstatus}" optionKey="id"
					required="" value="${buildingInstance?.status?.id}"
					optionValue="label" class="form-control search-select"
					noSelection="['-1': '-Select Record Status-']" />
			</div>
		</div>
		
		<div class="form-group">
			
		</div>
		<div class="form-group">
				<div class="col-sm-2 col-sm-offset-3">
					<button class="btn btn-light-grey back-step btn-block">
						<i class="fa fa-circle-arrow-left"></i> Back
					</button>
				</div>
				<div class="col-sm-2 col-sm-offset-3">
					<button class="btn btn-success finish-step btn-block">
						"${message(code: 'default.button.save.label', default: 'Save')}" <i class="fa fa-arrow-circle-right"></i>
					</button>	
				

				</div>
		</div>

	</div>

	%{-- <div id="step-3">
		<h2 class="StepTitle">Property Information Summary</div>
		<h3>Account Information</h3>
		<div class="form-group">
			<label class="col-sm-3 control-label">
				Username:
			</label>
			<div class="col-sm-7">
				<p class="form-control-static display-value" data-display="accountNo"></p>
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label">
				Username:
			</label>
			<div class="col-sm-7">
				<p class="form-control-static display-value" data-display="accountNo"></p>
			</div>
		</div>



	</div> --}%

		<%--<<g:hiddenField name="userId" value="${ }"/>--%>
		<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="building.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${buildingInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: buildingInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="building.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${buildingInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>


</div>