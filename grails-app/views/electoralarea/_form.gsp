



<%--<div class="fieldcontain ${hasErrors(bean: electoralareaInstance, field: 'code', 'error')} ">--%>




<div class="form-group">
	<label  class="col-sm-2 control-label" for="electoralAreaName">
		<g:message code="electoralarea.electoralAreaName.label" default="Electoral Area Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField  placeholder="Electoral Area Name" class="form-control"  name="electoralAreaName" maxlength="50" value="${electoralareaInstance?.electoralAreaName}"/>
	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="constituency">
		<g:message code="electoralarea.constituency.label" default="Constituency" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="constituency" name="constituency.id" from="${dametro.Constituency.list()}" optionKey="id" required="" value="${electoralareaInstance?.constituency?.id}" optionValue="constituencyName" class="form-control search-select"/>
	</div>
</div>

<div class="form-group">
	<label class="col-sm-2 control-label" for="constituency">
		<g:message code="electoralarea.submetro.label" default="Submetro" />
		
	</label>
	<div class="col-sm-9">
	<g:select id="submetro" name="submetro.id" from="${dametro.Submetro.list()}" optionKey="id" required="" value="${electoralareaInstance?.submetro?.id}" optionValue="submetroName" class="form-control search-select"/>
	</div>
</div>
