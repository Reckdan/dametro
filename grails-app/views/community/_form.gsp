



<%--<div class="fieldcontain ${hasErrors(bean: communityInstance, field: 'code', 'error')} ">--%>
<div class="form-group">
	<label class="col-sm-2 control-label" for="communityName">
		<g:message code="community.communityName.label" default="Community Name" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Community" class="form-control" name="communityName" maxlength="50" value="${communityInstance?.communityName}"/>
	</div>
</div>

<div class="form-group">
	<label  class="col-sm-2 control-label" for="submetro">
		<g:message code="community.submetro.label" default="Sub Metro" />
	</label>
	<div class="col-sm-9">
	<g:select id="submetro" name="submetro.id" from="${dametro.submetro.list()}" optionKey="id" required="" value="${communityInstance?.submetro?.id}" optionValue="submetroName" class="form-control search-select"/>
	</div>
</div>

