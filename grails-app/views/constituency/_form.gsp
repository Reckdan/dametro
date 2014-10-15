



<%--<div class="fieldcontain ${hasErrors(bean: constituencyInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="constituencyName">
		<g:message code="constituency.constituencyName.label" default="Constituency Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Constituency" class="form-control" name="constituencyName" maxlength="50" value="${constituencyInstance?.constituencyName}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="submetro">
		<g:message code="constituency.submetro.label" default="Sub Metro" />
	</label>
	<div class="col-sm-9">
	<g:select id="submetro" name="submetro.id" from="${dametro.submetro.list()}" optionKey="id" required="" value="${constituencyInstance?.submetro?.id}" optionValue="submetroName" class="form-control search-select"/>
	</div>
</div>

