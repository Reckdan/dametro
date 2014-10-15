



<%--<div class="fieldcontain ${hasErrors(bean: unitInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="unitName">
		<g:message code="unit.unitName.label" default="Unit Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Unit Name" class="form-control" name="unitName" maxlength="6" value="${unitInstance?.unitName}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="electoralarea">
		<g:message code="unit.electoralarea.label" default="Electoral Area" />
	</label>
	<div class="col-sm-9">
	<g:select id="electoralarea" name="electoralarea.id" from="${dametro.Electoralarea.list()}" optionKey="id" required="" value="${unitInstance?.electoralarea?.id}" optionValue="electoralAreaName" class="form-control search-select"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="constituency">
		<g:message code="unit.constituency.label" default="Constituency" />
	</label>
	<div class="col-sm-9">
	<g:select id="constituency" name="constituency.id" from="${dametro.Constituency.list()}" optionKey="id" required="" value="${unitInstance?.constituency?.id}" optionValue="constituencyName" class="form-control search-select"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="submetro">
		<g:message code="unit.submetro.label" default="Submetro" />
	</label>
	<div class="col-sm-9">
	<g:select id="submetro" name="submetro.id" from="${dametro.Submetro.list()}" optionKey="id" required="" value="${unitInstance?.submetro?.id}" optionValue="submetroName" class="form-control search-select"/>
	</div>
</div>

