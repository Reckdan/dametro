<!DOCTYPE html>
<html>
<head>
<g:set var="entityName"
	value="${message(code: 'building.label', default: 'Property')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
<!-- start: META -->
<meta charset="utf-8" />
<meta content="" name="description" />
<meta content="" name="author" />
<meta name="layout" content="main_pgs" />


<g:javascript library="jquery" />
<r:require module="jquery-validate" />
<%--		<flot:resources includeJQueryLib="false"/>--%>
<%--		<r:require module="sparklines"/>--%>
<r:require module="jquery-ui" />
<r:require module="font-awesome" />

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
				<button data-target=".navbar-collapse" data-toggle="collapse"
					class="navbar-toggle" type="button">
					<span class="clip-list-2"></span>
				</button>
				<!-- end: RESPONSIVE MENU TOGGLER -->
				<!-- start: LOGO -->
				<a class="navbar-brand" href="index.html"> CLIP<i
					class="clip-clip"></i>ONE
				</a>
				<!-- end: LOGO -->
			</div>
			<div class="navbar-tools">
				<!-- start: TOP NAVIGATION MENU -->
				<ul class="nav navbar-right">
					<!-- start: TO-DO DROPDOWN -->
					<g:if test="${tasks.size&gt;0}">
						<li class="dropdown"><a data-toggle="dropdown"
							data-hover="dropdown" class="dropdown-toggle"
							data-close-others="true" href="#"> <i class="clip-list-5"></i>
								<span class="badge"> ${tasks.size }</span>
						</a>
							<ul class="dropdown-menu todo">
								<li><span class="dropdown-menu-title"> You have ${tasks.size }
										pending task(s)
								</span></li>
								<li>
									<div class="drop-down-wrapper">
										<ul>


											<g:each in="${tasks }" status="i" var="taskInstance">

												<li><a class="todo-actions" href="javascript:void(0)">
														<i class="fa fa-square-o"></i> <span class="desc"
														style="opacity: 1; text-decoration: none;">
															${taskInstance.taskDescription}
													</span> <g:danger duedate="${taskInstance.dueDate}">
															<span class="label label-danger" style="opacity: 1;"><g:formatDate
																	date="${taskInstance.dueDate }" format="dd-MMM-yyyy" />
															</span>
														</g:danger> <g:warning duedate="${taskInstance.dueDate}">
															<span class="label label-warning" style="opacity: 1;"><g:formatDate
																	date="${taskInstance.dueDate }" format="dd-MMM-yyyy" /></span>
														</g:warning> <g:info duedate="${taskInstance.dueDate}">
															<span class="label label-info" style="opacity: 1;">
																<g:formatDate date="${taskInstance.dueDate }"
																	format="dd-MMM-yyyy" />
															</span>
														</g:info> <%--														<g:datediff duedate="${taskInstance.dueDate}"/>--%>
														<%--													<g:if test="${DateBuilding.minus(new Date(),taskInstance.dueDate).getDays<1 }">--%>
														<%--													<span class="label label-danger" style="opacity: 1;"> ${taskInstance.dueDate }</span>--%>
														<%--													</g:if>--%> <%--													<g:elseif test="${DateBuilding.minus(new Date(),taskInstance.dueDate).getDays>=1 && DateBuilding.minus(new Date(),taskInstance.dueDate).getDays<5 }">--%>
														<%--													<span class="label label-warning" style="opacity: 1;"> ${taskInstance.dueDate }</span>--%>
														<%--													</g:elseif>--%> <%--													--%> <%--													<g:else><span class="label label-info" style="opacity: 1;"> ${taskInstance.dueDate }</span></g:else>--%>
												</a></li>

											</g:each>

										</ul>
									</div>
								</li>
								<li class="view-all"><a href="javascript:void(0)"> See
										all tasks <i class="fa fa-arrow-circle-o-right"></i>
								</a></li>
							</ul></li>
					</g:if>

					<!-- end: TO-DO DROPDOWN-->
					<!-- start: NOTIFICATION DROPDOWN -->

					<g:if test="${notifications.size&gt;0}">
						<li class="dropdown"><a data-toggle="dropdown"
							data-hover="dropdown" class="dropdown-toggle"
							data-close-others="true" href="#"> <i
								class="clip-notification-2"></i> <span class="badge"> ${notifications.size }</span>
						</a>
							<ul class="dropdown-menu notifications">
								<li><span class="dropdown-menu-title"> You have ${notifications.size }
										notifications
								</span></li>
								<li>
									<div class="drop-down-wrapper">
										<ul>
											<g:each in="${notifications}" status="i"
												var="notificationInstance">
												<li><a href="javascript:void(0)"> <span
														class="label label-primary"><i class="fa fa-user"></i></span>
														<span class="message"> ${notificationInstance.itemDesc}</span>
														<span class="time"><g:timediff
																duedate="${notificationInstance.dueDate}" /></span>
												</a></li>
											</g:each>

										</ul>
									</div>
								</li>
								<li class="view-all"><a href="javascript:void(0)"> See
										all notifications <i class="fa fa-arrow-circle-o-right"></i>
								</a></li>
							</ul></li>
					</g:if>


					<!-- end: NOTIFICATION DROPDOWN -->
					<!-- start: MESSAGE DROPDOWN -->

					<!-- end: MESSAGE DROPDOWN -->
					<!-- start: USER DROPDOWN -->


					<li class="dropdown current-user"><a data-toggle="dropdown"
						data-hover="dropdown" class="dropdown-toggle"
						data-close-others="true" href="#"> <img
							src="${resource(dir: 'images', file: 'avatar-1-small.jpg')}"
							class="circle-img" alt=""> <span class="username">
								${loginuser.firstname + ' ' + loginuser.lastname }
						</span> <i class="clip-chevron-down"></i>
					</a>
						<ul class="dropdown-menu">
							<li><g:link controller="user" action="userprofile">
									<i class="clip-user-2"></i>
										&nbsp;My Profile</g:link></li>
							<li><g:link controller="user" action="calendar">
									<i class="clip-calendar"></i>
										&nbsp;My Calendar</g:link></li>
							<li class="divider"></li>
							<li><g:link controller="user" action="lockscreen">
									<i class="clip-locked"></i>
										&nbsp;Lock Screen</g:link></li>
							<li><g:link controller="user" action="lockscreen">
									<i class="clip-exit"></i>
										&nbsp;Log Out</g:link></li>
						</ul></li>


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
					<i class="clip-chevron-left"></i> <i class="clip-chevron-right"></i>
				</div>
				<!-- end: MAIN MENU TOGGLER BUTTON -->
				<!-- start: MAIN NAVIGATION MENU -->
				<ul class="main-navigation-menu">

					<li class="active open"><g:link controller="home"
							action="index">
							<i class="clip-home-3"></i>
							<span class="title">Home </span>
							<span class="selected"></span>
						</g:link></li>
					<g:each in="${menus}" var="menu">
						<li><a href="javascript:void(0)"><i class="clip-screen"></i>
								<span class="title">
									${menu.menuname}
							</span><i class="icon-arrow"></i> <span class="selected"></span> </a>
							<ul class="sub-menu">
								<g:each in="${submenus}" var="submenu">
									<g:if test="${menu.menuname==submenu.subof}">
										<li><g:link controller="${submenu.menucontroller}"
												action="${submenu.menuaction}">
												<span class="title">
													${submenu.menuname}
												</span>
											</g:link></li>
									</g:if>

								</g:each>
							</ul></li>

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
		<div class="modal fade" id="panel-config" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Panel Configuration</h4>
					</div>
					<div class="modal-body">Here will be a configuration form</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
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
							<div class="style-main-title">Style Selector</div>
							<div class="box-title">Choose Your Layout Style</div>
							<div class="input-box">
								<div class="input">
									<select name="layout">
										<option value="default">Wide</option>
										<option value="boxed">Boxed</option>
									</select>
								</div>
							</div>
							<div class="box-title">Choose Your Header Style</div>
							<div class="input-box">
								<div class="input">
									<select name="header">
										<option value="fixed">Fixed</option>
										<option value="default">Default</option>
									</select>
								</div>
							</div>
							<div class="box-title">Choose Your Footer Style</div>
							<div class="input-box">
								<div class="input">
									<select name="footer">
										<option value="default">Default</option>
										<option value="fixed">Fixed</option>
									</select>
								</div>
							</div>
							<div class="box-title">Backgrounds for Boxed Version</div>
							<div class="images boxed-patterns">
								<a id="bg_style_1" href="#"><img alt=""
									src="${resource(dir: 'images', file: 'bg.png')}"></a> <a
									id="bg_style_2" href="#"><img alt=""
									src="${resource(dir: 'images', file: 'bg_2.png')}"></a> <a
									id="bg_style_3" href="#"><img alt=""
									src="${resource(dir: 'images', file: 'bg_3.png')}"></a> <a
									id="bg_style_4" href="#"><img alt=""
									src="${resource(dir: 'images', file: 'bg_4.png')}"></a> <a
									id="bg_style_5" href="#"><img alt=""
									src="${resource(dir: 'images', file: 'bg_5.png')}"></a>
							</div>
							<div class="box-title">5 Predefined Color Schemes</div>
							<div class="images icons-color">
								<a id="light" href="#"><img class="active" alt=""
									src="${resource(dir: 'images', file: 'lightgrey.png')}"></a>
								<a id="dark" href="#"><img alt=""
									src="${resource(dir: 'images', file: 'darkgrey.png')}"></a> <a
									id="black_and_white" href="#"><img alt=""
									src="${resource(dir: 'images', file: 'blackandwhite.png')}"></a>
								<a id="navy" href="#"><img alt=""
									src="${resource(dir: 'images', file: 'navy.png')}"></a> <a
									id="green" href="#"><img alt=""
									src="${resource(dir: 'images', file: 'green.png')}"></a>
							</div>
							<div class="box-title">Style it with LESS</div>
							<div class="images">
								<div class="form-group">
									<label> Basic </label> <input type="text" value="#ffffff"
										class="color-base">
									<div class="dropdown">
										<a class="add-on dropdown-toggle" data-toggle="dropdown"><i
											style="background-color: #ffffff"></i></a>
										<ul class="dropdown-menu pull-right">
											<li>
												<div class="colorpalette"></div>
											</li>
										</ul>
									</div>
								</div>
								<div class="form-group">
									<label> Text </label> <input type="text" value="#555555"
										class="color-text">
									<div class="dropdown">
										<a class="add-on dropdown-toggle" data-toggle="dropdown"><i
											style="background-color: #555555"></i></a>
										<ul class="dropdown-menu pull-right">
											<li>
												<div class="colorpalette"></div>
											</li>
										</ul>
									</div>
								</div>
								<div class="form-group">
									<label> Elements </label> <input type="text" value="#007AFF"
										class="color-badge">
									<div class="dropdown">
										<a class="add-on dropdown-toggle" data-toggle="dropdown"><i
											style="background-color: #007AFF"></i></a>
										<ul class="dropdown-menu pull-right">
											<li>
												<div class="colorpalette"></div>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div style="height: 25px; line-height: 25px; text-align: center">
								<a class="clear_style" href="#"> Clear Styles </a> <a
									class="save_style" href="#"> Save Styles </a>
							</div>
						</div>
						<div class="style-toggle close"></div>
					</div>
					<!-- end: STYLE SELECTOR BOX -->
					<!-- start: PAGE TITLE & BREADCRUMB -->
					<ol class="breadcrumb">
						<li><i class="clip-home-3"></i> <a
							href="${createLink(uri: '/')}"><g:message
									code="default.home.label" /></a></li>
						<li><g:link action="index">
								<g:message code="default.list.label" args="[entityName]" />
							</g:link></li>
						<li class="active">Show</li>
						<li class="search-box">
							<form class="sidebar-search" action="">
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
						<h1>
							<g:message code="default.show.label" args="[entityName]" />
						</h1>
					</div>
					<!-- end: PAGE TITLE & BREADCRUMB -->
				</div>
			</div>
			<!-- end: PAGE HEADER -->
			<!-- start: PAGE CONTENT -->

			<%--					<a class="btn btn-primary" href="#"><i class="fa fa-plus"></i>--%>
			<%--											Add Item</a>--%>
			<div class="col-md-12">
				<!-- start: DYNAMIC TABLE PANEL -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-external-link-square"></i> Property Building
						<div class="panel-tools">

							<a class="btn btn-xs btn-link panel-config" href="#panel-config"
								data-toggle="modal"> <i class="fa fa-wrench"></i>
							</a> <a class="btn btn-xs btn-link panel-refresh" href="#"> <i
								class="fa fa-refresh"></i>
							</a> <a class="btn btn-xs btn-link panel-expand" href="#"> <i
								class="fa fa-resize-full"></i>
							</a>

						</div>
					</div>
					<div class="panel-body">

						<div id="show-building" class="content scaffold-show" role="main">

							<g:if test="${flash.message}">
								<div class="alert alert-danger">
									${flash.message}
								</div>
							</g:if>
							<form role="form" id="form" action="">
								<div class="col-md-6">

									<g:if test="${buildingInstance?.accountNo}">
										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.accountNo.label" default="accountNo" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="accountNo"/>'
												id="form-field-21" class="form-control" disabled="disabled">


										</div>


									</g:if>

									<g:if test="${buildingInstance?.type}">

										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.type.label" default="Property Type" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="type.typeName"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>

									</g:if>


									<g:if test="${buildingInstance?.category}">

										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.lastName.label" default="Last Name" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance.category}" field="categoryName"/>'
												id="form-field-21" class="form-control" disabled="disabled">


										</div>

									</g:if>
									<g:if test="${buildingInstance?.houseaddress}">
										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.homeAddress.label" default="Home Address" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="homeAddress"/>'
												id="form-field-21" class="form-control" disabled="disabled">


										</div>

									</g:if>
									<g:if test="${buildingInstance?.metro}">

										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.metro.label" default="Metro" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="metro.metro"/>'
												id="form-field-21" class="form-control" disabled="disabled">


										</div>

									</g:if>
									<g:if test="${buildingInstance?.submetro}">

										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.submetro.label" default="Sub Metro" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="submetro.submetroName"/>'
												id="form-field-21" class="form-control" disabled="disabled">


										</div>

									</g:if>

									<g:if test="${buildingInstance?.constituency}">
										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.constituency.label" default="Constituency" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="constituency.constituencyName"/>'
												id="form-field-21" class="form-control" disabled="disabled">


										</div>

									</g:if>

									<g:if test="${buildingInstance?.electoralarea}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.electoralarea.label" default="Electoral Area" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="electoralarea.electoralareaName"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>


									<g:if test="${buildingInstance?.community}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.community.label" default="communityName" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="communityName"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>


									<g:if test="${buildingInstance?.unit}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.unit.label"
													default="Unit Committee Area" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="unit.unitName"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>

									<g:if test="${buildingInstance?.street}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.street.label" default="Street" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="street"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>


									<g:if test="${buildingInstance?.division}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.division.label"
													default="Division" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="division"/>'
												id="form-field-21" class="form-control" disabled="disabled">
										</div>


									</g:if>
									<g:if test="${buildingInstance?.serialNo}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.serialNo.label"
													default="Serial Number" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="serialNo"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>

									<g:if test="${buildingInstance?.propertyUse}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.propertyUse.label" default="Property Use" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="propertyUse"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>
									<g:if test="${buildingInstance?.modeOfRefuseCollection}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.modeOfRefuseCollection.label" default="Mode of Refuse Collection" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="modeOfRefuseCollection"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>
									<g:if test="${buildingInstance?.buildingPermit}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.buildingPermit.label" default="Permit Number" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="buildingPermit"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>
									<g:if test="${buildingInstance?.permitDate}">
										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.permitDate.label" default="Permit Date" />
											</label> <input type="text" placeholder="text"
												value='<g:formatDate date="${buildingInstance?.permitDate}" />'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>
									
									<g:if test="${buildingInstance?.assessmentNo}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.assessmentNo.label" default="Assessment Number" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="assessmentNo"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>
									<g:if test="${buildingInstance?.assessmentDate}">
										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.assessmentDate.label" default="Assessment Date" />
											</label> <input type="text" placeholder="text"
												value='<g:formatDate date="${buildingInstance?.assessmentDate}" />'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>
									
									<g:if test="${buildingInstance?.contact}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.contact.label" default="Contact Person" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="contact.fullName"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>

									<g:if test="${buildingInstance?.datecreated}">
										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.datecreated.label" default="Datecreated" />
											</label> <input type="text" placeholder="text"
												value='<g:formatDate date="${buildingInstance?.datecreated}" />'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>

									<g:if test="${buildingInstance?.createdByUser}">
										<div class="form-group">
											<label class="control-label" for="form-field-20"> <g:message
													code="building.createdByUser.label" default="Created By" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="createdByUser.fullName"/>'
												id="form-field-21" class="form-control" disabled="disabled">

										</div>


									</g:if>
									<g:if test="${buildingInstance?.rateableValue}">
										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.rateableValue.label" default="Rateable Value" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance}" field="rateableValue"/>'
												id="form-field-21" class="form-control" disabled="disabled">


										</div>

									</g:if>
									<g:if test="${buildingInstance?.status}">
										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.status.label" default="Status" />
											</label> <input type="text" placeholder="text"
												value='<g:fieldValue bean="${buildingInstance.status}" field="label"/>'
												id="form-field-21" class="form-control" disabled="disabled">


										</div>

									</g:if>



								</div>
								<div class="col-md-6">
									<g:if test="${buildingInstance?.buildingPicture}">
										<div class="form-group">

											<label class="control-label" for="form-field-20"> <g:message
													code="building.buildingPicture.label"
													default="Building's Picture" />
											</label>
											<div class="fileupload fileupload-new"
												data-provides="fileupload">
												<div class="fileupload-new thumbnail"
													style="width: 200px; height: 150px;">
													<img
														src="${resource(dir: 'images/photos', file: buildingInstance?.buildingPicture)}"
														alt="" />
												</div>
												<div class="fileupload-preview fileupload-exists thumbnail"
													style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>

											</div>


										</div>

									</g:if>
									
								</div>

							</form>
							<div class="col-md-12">
								<g:form url="[resource:buildingInstance, action:'delete']"
									method="DELETE">
									<fieldset class="buttons">
										<g:link class="btn btn-primary" action="edit"
											resource="${buildingInstance}">
											<g:message code="default.button.edit.label" default="Edit" />
										</g:link>
										<g:actionSubmit class="btn btn-danger" action="delete"
											value="${message(code: 'default.button.delete.label', default: 'Delete')}"
											onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
									</fieldset>
								</g:form>
							</div>


						</div>



					</div>
				</div>
				<!-- end: DYNAMIC TABLE PANEL -->
			</div>





			<!-- UPLOAD PANEL -->
			<div class="col-md-12">
				<!-- start: DYNAMIC TABLE PANEL -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-external-link-square"></i> Upload Images
						<div class="panel-tools">

							<a class="btn btn-xs btn-link panel-config" href="#panel-config"
								data-toggle="modal"> <i class="fa fa-wrench"></i>
							</a> <a class="btn btn-xs btn-link panel-refresh" href="#"> <i
								class="fa fa-refresh"></i>
							</a> <a class="btn btn-xs btn-link panel-expand" href="#"> <i
								class="fa fa-resize-full"></i>
							</a>

						</div>
					</div>
					<div class="panel-body">


						<g:form url="[resource:buildingInstance, action:'upload']"
							method="PUT" class="form-horizontal"
							enctype="multipart/form-data">
							<g:hiddenField name="version"
								value="${buildingInstance?.version}" />
							<div class="col-sm-6">
								<div class="fileupload fileupload-new"
									data-provides="fileupload">
									<div class="fileupload-new thumbnail"
										style="width: 200px; height: 150px;">
										<img
											src="http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image"
											alt="" />
									</div>
									<div class="fileupload-preview fileupload-exists thumbnail"
										style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
									<div>
										<span class="btn btn-light-grey btn-file"><span
											class="fileupload-new"><i class="fa fa-picture-o"></i>
												Select Building Image</span><span class="fileupload-exists"><i
												class="fa fa-picture-o"></i> Change Building Image</span> <input
											type="file" name="buildingPicture"> </span> <a href="#"
											class="btn fileupload-exists btn-light-grey"
											data-dismiss="fileupload"> <i class="fa fa-times"></i>
											Remove
										</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="fileupload fileupload-new"
									data-provides="fileupload">
									<div class="fileupload-new thumbnail"
										style="width: 200px; height: 150px;">
										<img
											src="http://www.placehold.it/200x150/EFEFEF/AAAAAA?text=no+image"
											alt="" />
									</div>
									<div class="fileupload-preview fileupload-exists thumbnail"
										style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
									<div>
										<span class="btn btn-light-grey btn-file"><span
											class="fileupload-new"><i class="fa fa-picture-o"></i>
												Select Guarantor Image</span><span class="fileupload-exists"><i
												class="fa fa-picture-o"></i> Change Gurantor Image</span> <input
											type="file" name="guarantorPicture"> </span> <a href="#"
											class="btn fileupload-exists btn-light-grey"
											data-dismiss="fileupload"> <i class="fa fa-times"></i>
											Remove
										</a>
									</div>
								</div>
							</div>
							<p>
								<g:submitButton name="upload" class="btn btn-primary"
									value="${message(code: 'default.button.upload.label', default: 'Upload')}" />
							</p>
						</g:form>

					</div>

				</div>


			</div>

			<!-- end: PAGE CONTENT-->
		</div>
	</div>


	<!-- end: PAGE -->
	<!-- end: MAIN CONTAINER -->
	<!-- start: FOOTER -->
	<div class="footer clearfix">
		<div class="footer-inner">2014 &copy; clip-one by cliptheme.</div>
		<div class="footer-items">
			<span class="go-top"><i class="clip-chevron-up"></i></span>
		</div>
	</div>
	<!-- end: FOOTER -->
	<div id="event-management" class="modal fade" tabindex="-1"
		data-width="760" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Event Management</h4>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal"
						class="btn btn-light-grey">Close</button>
					<button type="button"
						class="btn btn-danger remove-event no-display">
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
	<r:require module="bootstrap" />
	<r:require module="bootstraphoverdropdown" />
	<g:javascript library="jquerycookie" />
	<%--			<g:javascript library="calendar"/>--%>
	<g:javascript library="mousewheel" />
	<g:javascript library="perfectscrollbar" />
	<g:javascript library="colorpalette" />
	<g:javascript library="select2" />
	<g:javascript library="dataTable" />
	<g:javascript library="bootstrapfileupload" />
	<%--			<g:javascript library="datatableBT"/>--%>
	<%--		<g:javascript library="icheck"/>--%>

	<g:javascript library="mainapp" />
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