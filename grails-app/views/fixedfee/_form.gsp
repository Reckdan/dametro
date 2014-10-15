



<%--<div class="fieldcontain ${hasErrors(bean: fixedfeeInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="yyear">
		<g:message code="fixedfee.yyear.label" default="Year" />
		
	</label>
	<div class="col-sm-9">
<%--	<g:select id="yyear" name="yyear" from="${today[Calendar.YEAR]-5...today[Calendar.YEAR]+1}" required="" value="${fixedfeeInstance?.yyear}" class="form-control search-select"/>--%>
	<g:field class="form-control" name="yyear" id="yyear" type="number" Min="2010" value="${fixedfeeInstance?.yyear}" required=""/>
	</div>
</div>



<div class="form-group">
	<label  class="col-sm-2 control-label" for="type">
		<g:message code="fixedfee.type.label" default="Type" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="type" name="type.id" from="${type}" optionKey="id" required="" 
	value="${fixedfeeInstance?.type?.id}" optionValue="typeName" class="form-control search-select"
	noSelection="['-1': '-Select Type-']"
	onchange="${remoteFunction(action: 'listcategories',
                  onSuccess: 'populateCategories(data)',
                  params: '\'mtype=\' + this.value')}"/>
	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label"  for="category">
		<g:message code="fixedfee.category.label" default="Category" />
		
	</label>
	<div class="col-sm-9">
	
	<g:select name="category.id" id="category" class="form-control search-select" from="${category}" optionKey="id" optionValue="categoryName"
	noSelection="['-1': '-Select Category-']" onchange="${remoteFunction(action: 'getMincharge',
                  onSuccess: 'updateMincharge(data)',
                  params: '\'catval=\' + this.value')}" value="${fixedfeeInstance?.category?.id}"/>
<%--	<g:select id="category" name="category.id" from="${dametro.Category.list()}" optionKey="id" required="" value="${fixedfeeInstance?.category?.id}"--%>
<%--	 optionValue="categoryName" class="form-control search-select" onchange="${remoteFunction(--%>
<%--            action:'updateMincharge(data)',--%>
<%--            onSuccess:'thisForm', --%>
<%--            params:'\'catval=\' + this.value' )}"--%>
<%--         />--%>
	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="minCharge">
		<g:message code="fixedfee.minCharge.label" default="Minimum Charge" /> 
		
	</label>
	<div class="col-sm-9">
	${fixedfeeInstance?.minCharge}
	<g:field class="form-control" name="minCharge" id="minCharge" type="number" Min="0" value="" required="" disabled="disabled"/>
	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="ratePa">
		<g:message code="fixedfee.ratePa.label" default="Rate Imposed" />
		
	</label>
	<div class="col-sm-9">
	<g:field class="form-control" name="ratePa" id="ratePa" type="number" Min="0" value="${fixedfeeInstance?.ratePa}" required=""/>
	</div>
</div>


<%--<<g:hiddenField name="userId" value="${ }"/>--%>
<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="fixedfee.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${fixedfeeInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: fixedfeeInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="fixedfee.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${fixedfeeInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>



<%--<div class="fieldcontain ${hasErrors(bean: fixedfeeInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="fixedfee.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${fixedfeeInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="fixedfee.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${fixedfeeInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['fixedfee.id': fixedfeeInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>