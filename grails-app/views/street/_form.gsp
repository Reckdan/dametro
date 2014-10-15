



<%--<div class="fieldcontain ${hasErrors(bean: streetInstance, field: 'code', 'error')} ">--%>




<div class="form-group">
	<label  class="col-sm-2 control-label" for="streetName">
		<g:message code="street.streetName.label" default="Electoral Area Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Electoral Area Name" class="form-control"  name="streetName" maxlength="50" value="${streetInstance?.streetName}"/>
	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="constituency">
		<g:message code="street.constituency.label" default="Constituency" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="constituency" name="constituency.id" from="${dametro.Constituency.list()}" optionKey="id" required="" value="${streetInstance?.constituency?.id}" optionValue="constituencyName" class="form-control search-select"/>
	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="constituency">
		<g:message code="street.submetro.label" default="Submetro" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="submetro" name="submetro.id" from="${dametro.Submetro.list()}" optionKey="id" required="" value="${streetInstance?.submetro?.id}" optionValue="submetroName" class="form-control search-select"/>
	</div>
</div>
