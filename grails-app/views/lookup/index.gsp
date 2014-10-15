
<!DOCTYPE html>
<html>
	<head>
<g:set var="entityName" value="${message(code: 'lookup.label', default: 'Lookup')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<!-- start: META -->
		<meta charset="utf-8" />
		<meta content="" name="description" />
		<meta content="" name="author" />
		 <meta name="layout" content="main_pgs"/>
				

		<g:javascript library="jquery"/>
		<r:require module="jquery-validate"/>
<%--		<flot:resources includeJQueryLib="false"/>--%>
<%--		<r:require module="sparklines"/>--%>
		<r:require module="jquery-ui"/>
		<r:require module="font-awesome"/>
	
		<!-- end: META -->
		<!-- start: MAIN CSS -->
		
	</head>
	<!-- end: HEAD -->
	<!-- start: BODY -->
	<body>

<!-- start: HEADER -->

<!-- start: HEADER -->
		<div class="navbar navbar-inverse navbar-fixed-top">
			<!-- start: TOP NAVIGATION CONTAINER -->
			<div class="container">
				<div class="navbar-header">
					<!-- start: RESPONSIVE MENU TOGGLER -->
					<button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
						<span class="clip-list-2"></span>
					</button>
					<!-- end: RESPONSIVE MENU TOGGLER -->
					<!-- start: LOGO -->
					<a class="navbar-brand" href="index.html">
						CLIP<i class="clip-clip"></i>ONE
					</a>
					<!-- end: LOGO -->
				</div>
				<div class="navbar-tools">
					<!-- start: TOP NAVIGATION MENU -->
					<ul class="nav navbar-right">
						<!-- start: TO-DO DROPDOWN -->
						<g:if test="${tasks.size>0}">
						<li class="dropdown">
							<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" data-close-others="true" href="#">
								<i class="clip-list-5"></i>
								<span class="badge"> ${tasks.size }</span>
							</a>
							<ul class="dropdown-menu todo">
								<li>
									<span class="dropdown-menu-title"> You have ${tasks.size } pending task(s)</span>
								</li>
								<li>
									<div class="drop-down-wrapper">
										<ul>
									
										
										<g:each in="${tasks }" status="i" var="taskInstance">
										
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc" style="opacity: 1; text-decoration: none;">${taskInstance.taskDescription}</span>
													<g:danger duedate="${taskInstance.dueDate}">
													<span class="label label-danger" style="opacity: 1;"><g:formatDate date="${taskInstance.dueDate }" format="dd-MMM-yyyy"/> </span>
													</g:danger>
													<g:warning duedate="${taskInstance.dueDate}">
													<span class="label label-warning" style="opacity: 1;"><g:formatDate date="${taskInstance.dueDate }" format="dd-MMM-yyyy"/></span>
													</g:warning>
													<g:info duedate="${taskInstance.dueDate}">
													<span class="label label-info" style="opacity: 1;"> <g:formatDate date="${taskInstance.dueDate }" format="dd-MMM-yyyy"/></span>
													</g:info>
<%--														<g:datediff duedate="${taskInstance.dueDate}"/>--%>
<%--													<g:if test="${DateLookup.minus(new Date(),taskInstance.dueDate).getDays<1 }">--%>
<%--													<span class="label label-danger" style="opacity: 1;"> ${taskInstance.dueDate }</span>--%>
<%--													</g:if>--%>
<%--													<g:elseif test="${DateLookup.minus(new Date(),taskInstance.dueDate).getDays>=1 && DateLookup.minus(new Date(),taskInstance.dueDate).getDays<5 }">--%>
<%--													<span class="label label-warning" style="opacity: 1;"> ${taskInstance.dueDate }</span>--%>
<%--													</g:elseif>--%>
<%--													--%>
<%--													<g:else><span class="label label-info" style="opacity: 1;"> ${taskInstance.dueDate }</span></g:else>--%>
												</a>
											</li>
											
										</g:each>	
																																										
										</ul>
									</div>
								</li>
								<li class="view-all">
									<a href="javascript:void(0)">
										See all tasks <i class="fa fa-arrow-circle-o-right"></i>
									</a>
								</li>
							</ul>
						</li>
						</g:if>
						
						<!-- end: TO-DO DROPDOWN-->
						<!-- start: NOTIFICATION DROPDOWN -->
						<g:if test="${notifications.size>0}">
						<li class="dropdown">
							<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" data-close-others="true" href="#">
								<i class="clip-notification-2"></i>
								<span class="badge"> ${notifications.size }</span>
							</a>
							<ul class="dropdown-menu notifications">
								<li>
									<span class="dropdown-menu-title"> You have ${notifications.size } notifications</span>
								</li>
								<li>
									<div class="drop-down-wrapper">
										<ul>
										<g:each in="${notifications}" status="i" var="notificationInstance">
											<li>
												<a href="javascript:void(0)">
													<span class="label label-primary"><i class="fa fa-user"></i></span>
													<span class="message"> ${notificationInstance.itemDesc}</span>
													<span class="time"><g:timediff duedate="${notificationInstance.dueDate}"/></span>
												</a>
											</li>
										</g:each>
											
										</ul>
									</div>
								</li>
								<li class="view-all">
									<a href="javascript:void(0)">
										See all notifications <i class="fa fa-arrow-circle-o-right"></i>
									</a>
								</li>
							</ul>
						</li>
						</g:if>
						<!-- end: NOTIFICATION DROPDOWN -->
						<!-- start: MESSAGE DROPDOWN -->
						
						<!-- end: MESSAGE DROPDOWN -->
						<!-- start: USER DROPDOWN -->
						<li class="dropdown current-user">
							<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" data-close-others="true" href="#">
								<img src="${resource(dir: 'images', file: 'avatar-1-small.jpg')}" class="circle-img" alt="">
								<span class="username">${loginuser.firstname + ' ' + loginuser.lastname }</span>
								<i class="clip-chevron-down"></i>
							</a>
							<ul class="dropdown-menu">
								<li>
									
									<g:link controller="user" action="userprofile"><i class="clip-user-2"></i>
										&nbsp;My Profile</g:link>
								</li>
								<li>
									
									<g:link controller="user" action="calendar"><i class="clip-calendar"></i>
										&nbsp;My Calendar</g:link>
								</li>
								<li class="divider"></li>
								<li>
								<g:link controller="user" action="lockscreen"><i class="clip-locked"></i>
										&nbsp;Lock Screen</g:link>
								
								</li>
								<li>
								<g:link controller="user" action="lockscreen"><i class="clip-exit"></i>
										&nbsp;Log Out</g:link>
									
								</li>
							</ul>
						</li>
						<!-- end: USER DROPDOWN -->
					</ul>
					<!-- end: TOP NAVIGATION MENU -->
				</div>
			</div>
			<!-- end: TOP NAVIGATION CONTAINER -->
		</div>
	
		<!-- end: HEADER -->
		<!-- start: MAIN CONTAINER -->
		<div class="main-container">
			<div class="navbar-content">
				<!-- start: SIDEBAR -->
				<div class="main-navigation navbar-collapse collapse">
					<!-- start: MAIN MENU TOGGLER BUTTON -->
					<div class="navigation-toggler">
						<i class="clip-chevron-left"></i>
						<i class="clip-chevron-right"></i>
					</div>
					<!-- end: MAIN MENU TOGGLER BUTTON -->
					<!-- start: MAIN NAVIGATION MENU -->
					<ul class="main-navigation-menu">
						
						<li class="active open">
							<g:link controller="home" action="index"><i class="clip-home-3"></i>
										<span class="title">Home </span><span class="selected"></span> </g:link>
						</li>
						<g:each in="${menus}" var="menu">
						<li>
								
						<a href="javascript:void(0)"><i class="clip-screen"></i>
								<span class="title">${menu.menuname} </span><i class="icon-arrow"></i>
								<span class="selected"></span>
							</a>
							<ul class="sub-menu">
								<g:each in="${submenus}" var="submenu">
								<g:if test="${menu.menuname==submenu.subof}">
								<li>
								<g:link controller="${submenu.menucontroller}" action="${submenu.menuaction}">
										<span class="title">${submenu.menuname} </span></g:link>
								</li>
								</g:if>
								
								</g:each>
							</ul>
						</li>

					</g:each>
					</ul>
				</div>	
					<!-- end: MAIN NAVIGATION MENU -->
				</div>
				<!-- end: SIDEBAR -->
			</div>
			<!-- start: PAGE -->
			<div class="main-content">
				<!-- start: PANEL CONFIGURATION MODAL FORM -->
				<div class="modal fade" id="panel-config" tabindex="-1" role="dialog" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title">Panel Configuration</h4>
							</div>
							<div class="modal-body">
								Here will be a configuration form
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">
									Close
								</button>
								<button type="button" class="btn btn-primary">
									Save changes
								</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				<!-- end: SPANEL CONFIGURATION MODAL FORM -->
				<div class="container">
					<!-- start: PAGE HEADER -->
					<div class="row">
						<div class="col-sm-12">
							<!-- start: STYLE SELECTOR BOX -->
							<div id="style_selector" class="hidden-xs">
								<div id="style_selector_container">
									<div class="style-main-title">
										Style Selector
									</div>
									<div class="box-title">
										Choose Your Layout Style
									</div>
									<div class="input-box">
										<div class="input">
											<select name="layout">
												<option value="default">Wide</option><option value="boxed">Boxed</option>
											</select>
										</div>
									</div>
									<div class="box-title">
										Choose Your Header Style
									</div>
									<div class="input-box">
										<div class="input">
											<select name="header">
												<option value="fixed">Fixed</option><option value="default">Default</option>
											</select>
										</div>
									</div>
									<div class="box-title">
										Choose Your Footer Style
									</div>
									<div class="input-box">
										<div class="input">
											<select name="footer">
												<option value="default">Default</option><option value="fixed">Fixed</option>
											</select>
										</div>
									</div>
									<div class="box-title">
										Backgrounds for Boxed Version
									</div>
									<div class="images boxed-patterns">
										<a id="bg_style_1" href="#"><img alt="" src="${resource(dir: 'images', file: 'bg.png')}"></a>
										<a id="bg_style_2" href="#"><img alt="" src="${resource(dir: 'images', file: 'bg_2.png')}"></a>
										<a id="bg_style_3" href="#"><img alt="" src="${resource(dir: 'images', file: 'bg_3.png')}"></a>
										<a id="bg_style_4" href="#"><img alt="" src="${resource(dir: 'images', file: 'bg_4.png')}"></a>
										<a id="bg_style_5" href="#"><img alt="" src="${resource(dir: 'images', file: 'bg_5.png')}"></a>
									</div>
									<div class="box-title">
										5 Predefined Color Schemes
									</div>
									<div class="images icons-color">
										<a id="light" href="#"><img class="active" alt="" src="${resource(dir: 'images', file: 'lightgrey.png')}"></a>
										<a id="dark" href="#"><img alt="" src="${resource(dir: 'images', file: 'darkgrey.png')}"></a>
										<a id="black_and_white" href="#"><img alt="" src="${resource(dir: 'images', file: 'blackandwhite.png')}"></a>
										<a id="navy" href="#"><img alt="" src="${resource(dir: 'images', file: 'navy.png')}"></a>
										<a id="green" href="#"><img alt="" src="${resource(dir: 'images', file: 'green.png')}"></a>
									</div>
									<div class="box-title">
										Style it with LESS
									</div>
									<div class="images">
										<div class="form-group">
											<label>
												Basic
											</label>
											<input type="text" value="#ffffff" class="color-base">
											<div class="dropdown">
												<a class="add-on dropdown-toggle" data-toggle="dropdown"><i style="background-color: #ffffff"></i></a>
												<ul class="dropdown-menu pull-right">
													<li>
														<div class="colorpalette"></div>
													</li>
												</ul>
											</div>
										</div>
										<div class="form-group">
											<label>
												Text
											</label>
											<input type="text" value="#555555" class="color-text">
											<div class="dropdown">
												<a class="add-on dropdown-toggle" data-toggle="dropdown"><i style="background-color: #555555"></i></a>
												<ul class="dropdown-menu pull-right">
													<li>
														<div class="colorpalette"></div>
													</li>
												</ul>
											</div>
										</div>
										<div class="form-group">
											<label>
												Elements
											</label>
											<input type="text" value="#007AFF" class="color-badge">
											<div class="dropdown">
												<a class="add-on dropdown-toggle" data-toggle="dropdown"><i style="background-color: #007AFF"></i></a>
												<ul class="dropdown-menu pull-right">
													<li>
														<div class="colorpalette"></div>
													</li>
												</ul>
											</div>
										</div>
									</div>
									<div style="height:25px;line-height:25px; text-align: center">
										<a class="clear_style" href="#">
											Clear Styles
										</a>
										<a class="save_style" href="#">
											Save Styles
										</a>
									</div>
								</div>
								<div class="style-toggle close"></div>
							</div>
							<!-- end: STYLE SELECTOR BOX -->
							<!-- start: PAGE TITLE & BREADCRUMB -->
							<ol class="breadcrumb">
								<li>
									<i class="clip-home-3"></i>
									<a href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a>
								</li>
								<li class="active">
									List
								</li>
								<li class="search-box">
									<form class="sidebar-search">
										<div class="form-group">
											<input type="text" placeholder="Start Searching...">
											<button class="submit">
												<i class="clip-search-3"></i>
											</button>
										</div>
									</form>
								</li>
							</ol>
							<div class="page-header">
								<h1><g:message code="default.list.label" args="[entityName]" /></h1>
							</div>
							<!-- end: PAGE TITLE & BREADCRUMB -->
						</div>
					</div>
					<!-- end: PAGE HEADER -->
					<!-- start: PAGE CONTENT -->
					
<%--					<a class="btn btn-primary" href="#"><i class="fa fa-plus"></i>--%>
<%--											Add Item</a>--%>
					
		<div class="nav" role="navigation">
				<g:link class="btn btn-primary" action="create"><g:message code="default.new.label" args="[entityName]" />
				<i class="fa fa-plus"></i>
				</g:link>
		</div>
		<div id="list-lookup" class="content scaffold-list" role="main">
		
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-striped table-bordered table-hover table-full-width" id="sample_1">
			<thead>
					<tr>
					
						<g:sortableColumn property="label" title="${message(code: 'lookup.label.label', default: 'Description')}" />
					
						<g:sortableColumn property="active" title="${message(code: 'lookup.active.label', default: 'Active')}" />
					
						<g:sortableColumn property="type" title="${message(code: 'lookup.lookupType.label', default: 'Type')}" />
					
						<g:sortableColumn property="organizationType" title="${message(code: 'lookup.position.label', default: 'Item Position')}" />
					

						<th>Operation</th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${lookups}" status="i" var="lookupInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${lookupInstance.id}">${fieldValue(bean: lookupInstance, field: "label")}</g:link></td>
					
						<td>${fieldValue(bean: lookupInstance, field: "active")}</td>
					
						<td>${fieldValue(bean: lookupInstance.type, field: "typeDesc")}</td>
					
						<td>${fieldValue(bean: lookupInstance, field: "position")}</td>
						


									<td>
														<div class="visible-md visible-lg hidden-sm hidden-xs">

													<g:link class="btn btn-xs btn-teal tooltips" data-placement="top" data-original-title="Edit" action="edit" resource="${lookupInstance}">
															<i class="fa fa-edit"></i></g:link>
												<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_SUPERVISOR">			
													<g:link class="btn btn-xs btn-bricky tooltips" data-placement="top" data-original-title="Remove" action="delete" resource="${lookupInstance}">
															<i class="fa fa-times fa fa-white"></i></g:link>
												</sec:ifAnyGranted>
												</div>
												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="btn-group">
														<a class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown" href="#">
															<i class="fa fa-cog"></i> <span class="caret"></span>
														</a>
														<ul role="menu" class="dropdown-menu pull-right">
															<li role="presentation">
															<g:link role="menuitem" tabindex="-1" action="edit" resource="${lookupInstance}">
															<i class="fa fa-edit"></i>
															<g:message code="default.button.edit.label" default="Edit" /></g:link>
																
															</li>
															<sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_SUPERVISOR">
																<li role="presentation">
																
																	<g:link role="menuitem" tabindex="-1" action="delete" resource="${lookupInstance}">
																		<i class="fa fa-times"></i> Remove
																	</g:link>
																</li>
															</sec:ifAnyGranted>
														</ul>
													</div>
												</div></td>
					</tr>
				</g:each>
				</tbody>
			</table>
<%--			<div class="pagination">--%>
<%--				<g:paginate total="${lookupInstanceCount ?: 0}" />--%>
<%--			</div>--%>
		<!-- end: PAGE CONTENT-->
				</div>
			</div>
			
		
			<!-- end: PAGE -->
		<!-- end: MAIN CONTAINER -->
		<!-- start: FOOTER -->
		<div class="footer clearfix">
			<div class="footer-inner">
				2014 &copy; clip-one by cliptheme.
			</div>
			<div class="footer-items">
				<span class="go-top"><i class="clip-chevron-up"></i></span>
			</div>
		</div>
		<!-- end: FOOTER -->
		<div id="event-management" class="modal fade" tabindex="-1" data-width="760" style="display: none;">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title">Event Management</h4>
					</div>
					<div class="modal-body"></div>
					<div class="modal-footer">
						<button type="button" data-dismiss="modal" class="btn btn-light-grey">
							Close
						</button>
						<button type="button" class="btn btn-danger remove-event no-display">
							<i class='fa fa-trash-o'></i> Delete Event
						</button>
						<button type='submit' class='btn btn-success save-event'>
							<i class='fa fa-check'></i> Save
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end: MAIN CONTAINER -->
			<r:require module="bootstrap"/>
			<r:require module="bootstraphoverdropdown"/>
			<g:javascript library="jquerycookie" />	
<%--			<g:javascript library="calendar"/>--%>
			<g:javascript library="mousewheel"/>
			<g:javascript library="perfectscrollbar"/>
			<g:javascript library="colorpalette"/>
			<g:javascript library="select2"/>
			<g:javascript library="dataTable"/>
<%--			<g:javascript library="datatableBT"/>--%>
<%--		<g:javascript library="icheck"/>--%>
		
		<g:javascript library="mainapp"/>
<%--			<g:javascript src="myapp.js"/>	--%>
		
		<g:javascript>
		
			jQuery(document).ready(function() {
			
			//runWIndowResize();
            
            runInit();
         
            runStyleSelector();
           
            runSearchInput();
            runElementsPosition();
            runToDoAction();
            runNavigationToggler();
            runNavigationMenu();
            runGoTop();
            runModuleTools();
            runDropdownEnduring();
            runTooltips();
            runPopovers();
            runPanelScroll();
            runShowTab();
            
            runAccordionFeatures();
            runCustomCheck();
           
            runColorPalette();
            
            runSaveSetting();
            runCustomSetting();
            runClearSetting();
			
			//dataTable();
    	    //alert(test()); 
			
			 $('#sample_1').dataTable();
			
		// $('#sample_1_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
        // modify table search input
        $('#sample_1_wrapper .dataTables_length select').addClass("m-wrap small");
        // modify table per page dropdown
        $('#sample_1_wrapper .dataTables_length select').select2();
        // initialzie select2 dropdown
        
   
        $(".search-select").select2({
            placeholder: "Select a type",
            allowClear: true
        });
    
        
			});
			
			
		</g:javascript>
<%--		<g:javascript src="myapp.js"/>--%>
</body>
	<!-- end: BODY -->
		
		
		
</html>