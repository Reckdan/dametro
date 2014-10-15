



<%--<div class="fieldcontain ${hasErrors(bean: metroInstance, field: 'code', 'error')} ">--%>






<div class="form-group ">
	<label class="col-sm-2 control-label"  for="region">
		<g:message code="fileupload.title.label" default="Title" />
		
	</label>
	<div class="col-sm-9">
	<g:textField placeholder="Title" class="form-control" name="title" value="${fieldValue(bean: fileuploadInstance, field: 'title')}"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="organizationType">
		<g:message code="fileupload.filecategory.label" default="File Category" />
		
	</label>
	<div class="col-sm-9">
		<g:select id="filecategory" name="filecategory" from="${['logos','signatures','site plans','building fence & block plans','drawings','land title registration']}"  required="" value="${fileuploadInstance?.filecategory}"  class="form-control search-select"/>
	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="logo">
		<g:message code="metro.logo.label" default="Metro Logo" />
		
	</label>
	<div class="col-sm-9">
	<div class="fileupload fileupload-new" data-provides="fileupload">
													<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image" alt=""/>
													</div>
													<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
													<div>
														<span class="btn btn-light-grey btn-file"><span class="fileupload-new"><i class="fa fa-picture-o"></i> Select image</span><span class="fileupload-exists"><i class="fa fa-picture-o"></i> Change</span>
															<input type="file" name="myFile">
														</span>
														<a href="#" class="btn fileupload-exists btn-light-grey" data-dismiss="fileupload">
															<i class="fa fa-times"></i> Remove
														</a>
													</div>
												</div>

	</div>
</div>

<div class="form-group ">
	<label class="col-sm-2 control-label" for="logo">
		<g:message code="metro.logo.label" default="Metro Logo" />
		
	</label>
	<div class="col-sm-9">
	<div class="fileupload fileupload-new" data-provides="fileupload">
													<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image" alt=""/>
													</div>
													<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
													<div>
														<span class="btn btn-light-grey btn-file"><span class="fileupload-new"><i class="fa fa-picture-o"></i> Select image</span><span class="fileupload-exists"><i class="fa fa-picture-o"></i> Change</span>
															<input type="file" name="logo">
														</span>
														<a href="#" class="btn fileupload-exists btn-light-grey" data-dismiss="fileupload">
															<i class="fa fa-times"></i> Remove
														</a>
													</div>
												</div>

	</div>
</div>
<%--<<g:hiddenField name="userId" value="${ }"/>--%>
<%--<div class="form-group">
	<label for="datecreated">
		<g:message code="metro.datecreated.label" default="Datecreated" />
		
	</label>
	<g:datePicker name="datecreated" precision="day"  value="${metroInstance?.datecreated}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: metroInstance, field: 'dateupdated', 'error')} ">
	<label for="dateupdated">
		<g:message code="metro.dateupdated.label" default="Dateupdated" />
		
	</label>
	<g:datePicker name="dateupdated" precision="day"  value="${metroInstance?.dateupdated}" default="none" noSelection="['': '']" />

</div>

--%>
<%--<div class="fieldcontain ${hasErrors(bean: metroInstance, field: 'updatedByUser', 'error')} required">
	<label for="updatedByUser">
		<g:message code="metro.updatedByUser.label" default="Updated By User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="updatedByUser" name="updatedByUser.id" from="${dametro.Muser.list()}" optionKey="id" required="" value="${metroInstance?.updatedByUser?.id}" class="many-to-one"/>

</div>
--%>
<%--<div class="form-group} ">
	<label  class="col-sm-2 control-label" for="fixedfees">
		<g:message code="metro.fixedfees.label" default="Fixedfees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${metroInstance?.fixedfees?}" var="f">
    <li><g:link controller="fixedfee" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="fixedfee" action="create" params="['metro.id': metroInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'fixedfee.label', default: 'Fixedfee')])}</g:link>
</li>
</ul>


</div>--%>