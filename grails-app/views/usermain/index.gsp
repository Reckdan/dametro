<html lang="en" class="no-js">
	<!--<![endif]-->
	<!-- start: HEAD -->
	<head>
		<title>Clip-One - Responsive Admin Template</title>
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
						<li class="dropdown">
							<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" data-close-others="true" href="#">
								<i class="clip-list-5"></i>
								<span class="badge"> 12</span>
							</a>
							<ul class="dropdown-menu todo">
								<li>
									<span class="dropdown-menu-title"> You have 12 pending tasks</span>
								</li>
								<li>
									<div class="drop-down-wrapper">
										<ul>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc" style="opacity: 1; text-decoration: none;">Staff Meeting</span>
													<span class="label label-danger" style="opacity: 1;"> today</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc" style="opacity: 1; text-decoration: none;"> New frontend layout</span>
													<span class="label label-danger" style="opacity: 1;"> today</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc"> Hire developers</span>
													<span class="label label-warning"> tommorow</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc">Staff Meeting</span>
													<span class="label label-warning"> tommorow</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc"> New frontend layout</span>
													<span class="label label-success"> this week</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc"> Hire developers</span>
													<span class="label label-success"> this week</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc"> New frontend layout</span>
													<span class="label label-info"> this month</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc"> Hire developers</span>
													<span class="label label-info"> this month</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc" style="opacity: 1; text-decoration: none;">Staff Meeting</span>
													<span class="label label-danger" style="opacity: 1;"> today</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc" style="opacity: 1; text-decoration: none;"> New frontend layout</span>
													<span class="label label-danger" style="opacity: 1;"> today</span>
												</a>
											</li>
											<li>
												<a class="todo-actions" href="javascript:void(0)">
													<i class="fa fa-square-o"></i>
													<span class="desc"> Hire developers</span>
													<span class="label label-warning"> tommorow</span>
												</a>
											</li>
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
						<!-- end: TO-DO DROPDOWN-->
						<!-- start: NOTIFICATION DROPDOWN -->
						<li class="dropdown">
							<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" data-close-others="true" href="#">
								<i class="clip-notification-2"></i>
								<span class="badge"> 11</span>
							</a>
							<ul class="dropdown-menu notifications">
								<li>
									<span class="dropdown-menu-title"> You have 11 notifications</span>
								</li>
								<li>
									<div class="drop-down-wrapper">
										<ul>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-primary"><i class="fa fa-user"></i></span>
													<span class="message"> New user registration</span>
													<span class="time"> 1 min</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-success"><i class="fa fa-comment"></i></span>
													<span class="message"> New comment</span>
													<span class="time"> 7 min</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-success"><i class="fa fa-comment"></i></span>
													<span class="message"> New comment</span>
													<span class="time"> 8 min</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-success"><i class="fa fa-comment"></i></span>
													<span class="message"> New comment</span>
													<span class="time"> 16 min</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-primary"><i class="fa fa-user"></i></span>
													<span class="message"> New user registration</span>
													<span class="time"> 36 min</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-warning"><i class="fa fa-shopping-cart"></i></span>
													<span class="message"> 2 items sold</span>
													<span class="time"> 1 hour</span>
												</a>
											</li>
											<li class="warning">
												<a href="javascript:void(0)">
													<span class="label label-danger"><i class="fa fa-user"></i></span>
													<span class="message"> User deleted account</span>
													<span class="time"> 2 hour</span>
												</a>
											</li>
											<li class="warning">
												<a href="javascript:void(0)">
													<span class="label label-danger"><i class="fa fa-shopping-cart"></i></span>
													<span class="message"> Transaction was canceled</span>
													<span class="time"> 6 hour</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-success"><i class="fa fa-comment"></i></span>
													<span class="message"> New comment</span>
													<span class="time"> yesterday</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-primary"><i class="fa fa-user"></i></span>
													<span class="message"> New user registration</span>
													<span class="time"> yesterday</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-primary"><i class="fa fa-user"></i></span>
													<span class="message"> New user registration</span>
													<span class="time"> yesterday</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-success"><i class="fa fa-comment"></i></span>
													<span class="message"> New comment</span>
													<span class="time"> yesterday</span>
												</a>
											</li>
											<li>
												<a href="javascript:void(0)">
													<span class="label label-success"><i class="fa fa-comment"></i></span>
													<span class="message"> New comment</span>
													<span class="time"> yesterday</span>
												</a>
											</li>
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
						<!-- end: NOTIFICATION DROPDOWN -->
						<!-- start: MESSAGE DROPDOWN -->
						
						<!-- end: MESSAGE DROPDOWN -->
						<!-- start: USER DROPDOWN -->
						<li class="dropdown current-user">
							<a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" data-close-others="true" href="#">
								<img src="${resource(dir: 'images', file: 'avatar-1-small.jpg')}" class="circle-img" alt="">
								<span class="username">Peter Clark</span>
								<i class="clip-chevron-down"></i>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="pages_user_profile.html">
										<i class="clip-user-2"></i>
										&nbsp;My Profile
									</a>
								</li>
								<li>
									<a href="pages_calendar.html">
										<i class="clip-calendar"></i>
										&nbsp;My Calendar
									</a>
								<li>
									<a href="pages_messages.html">
										<i class="clip-bubble-4"></i>
										&nbsp;My Messages (3)
									</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="utility_lock_screen.html"><i class="clip-locked"></i>
										&nbsp;Lock Screen </a>
								</li>
								<li>
									<a href="login_example1.html">
										<i class="clip-exit"></i>
										&nbsp;Log Out
									</a>
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
							<a href="${home.link}"><i class="clip-home-3"></i>
								<span class="title"> Home </span><span class="selected"></span>
							</a>
						</li>
						<g:each in="${menus}" var="menu">
						<li>
							<a href="javascript:void(0)"><i class="clip-screen"></i>
								<span class="title">${menu.menuname} </span><i class="icon-arrow"></i>
								<span class="selected"></span>
							</a>
							<ul class="sub-menu">
								<g:each in="${submenus}" var="submenu">
								<g:if test="${menu.id==submenu.subof}">
								<li>
									<a href="${submenu.link }">
										<span class="title">${submenu.menuname } </span>
										
									</a>
								</li>
								</g:if>
								
								</g:each>
							</ul>
						</li>

					</g:each>
					</ul>
					
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
								<div id="style_selector_container" style="display:block">
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
									<a href="#">
										Home
									</a>
								</li>
								<li class="active">
									Dashboard
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
								<h1>Dashboard <small>overview &amp; stats </small></h1>
							</div>
							<!-- end: PAGE TITLE & BREADCRUMB -->
						</div>
					</div>
					<!-- end: PAGE HEADER -->
					<!-- start: PAGE CONTENT -->
					<div class="row">
						<div class="col-sm-4">
							<div class="core-box">
								<div class="heading">
									<i class="clip-user-4 circle-icon circle-green"></i>
									<h2>Manage Staff</h2>
								</div>
								<div class="content">
									Staff comprises of collectors, cashiers and supervisors
								</div>
								<a class="view-more" href="#">
									View More <i class="clip-arrow-right-2"></i>
								</a>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="core-box">
								<div class="heading">
									<i class="clip-clip circle-icon circle-teal"></i>
									<h2>Manage Bills</h2>
								</div>
								<div class="content">
									Generate bills, print bills, adjust bills and set fees
								</div>
								<a class="view-more" href="#">
									View More <i class="clip-arrow-right-2"></i>
								</a>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="core-box">
								<div class="heading">
									<i class="clip-database circle-icon circle-bricky"></i>
									<h2>Manage Data</h2>
								</div>
								<div class="content">
									Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
								</div>
								<a class="view-more" href="#">
									View More <i class="clip-arrow-right-2"></i>
								</a>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-7">
							<div class="panel panel-default">
								<div class="panel-heading">
									<i class="clip-stats"></i>
									Site Visits
									<div class="panel-tools">
										<a class="btn btn-xs btn-link panel-collapse collapses" href="#">
										</a>
										<a class="btn btn-xs btn-link panel-config" href="#panel-config" data-toggle="modal">
											<i class="fa fa-wrench"></i>
										</a>
										<a class="btn btn-xs btn-link panel-refresh" href="#">
											<i class="fa fa-refresh"></i>
										</a>
										<a class="btn btn-xs btn-link panel-close" href="#">
											<i class="fa fa-times"></i>
										</a>
									</div>
								</div>
								<div class="panel-body">
									<div class="flot-medium-container">
										<div id="placeholder-h1" class="flot-placeholder"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-5">
								<div class="panel panel-default">
								<div class="panel-heading">
									<i class="clip-checkbox"></i>
									To Do
									<div class="panel-tools">
										<a class="btn btn-xs btn-link panel-collapse collapses" href="#">
										</a>
										<a class="btn btn-xs btn-link panel-config" href="#panel-config" data-toggle="modal">
											<i class="fa fa-wrench"></i>
										</a>
										<a class="btn btn-xs btn-link panel-refresh" href="#">
											<i class="fa fa-refresh"></i>
										</a>
										<a class="btn btn-xs btn-link panel-close" href="#">
											<i class="fa fa-times"></i>
										</a>
									</div>
								</div>
								<div class="panel-body panel-scroll" style="height:300px">
									<ul class="todo">
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc" style="opacity: 1; text-decoration: none;">Staff Meeting</span>
												<span class="label label-danger" style="opacity: 1;"> today</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc" style="opacity: 1; text-decoration: none;"> New frontend layout</span>
												<span class="label label-danger" style="opacity: 1;"> today</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc"> Hire developers</span>
												<span class="label label-warning"> tommorow</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc">Staff Meeting</span>
												<span class="label label-warning"> tommorow</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc"> New frontend layout</span>
												<span class="label label-success"> this week</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc"> Hire developers</span>
												<span class="label label-success"> this week</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc"> New frontend layout</span>
												<span class="label label-info"> this month</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc"> Hire developers</span>
												<span class="label label-info"> this month</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc" style="opacity: 1; text-decoration: none;">Staff Meeting</span>
												<span class="label label-danger" style="opacity: 1;"> today</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc" style="opacity: 1; text-decoration: none;"> New frontend layout</span>
												<span class="label label-danger" style="opacity: 1;"> today</span>
											</a>
										</li>
										<li>
											<a class="todo-actions" href="javascript:void(0)">
												<i class="fa fa-square-o"></i>
												<span class="desc"> Hire developers</span>
												<span class="label label-warning"> tommorow</span>
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						
						</div>
					</div>
					<div class="row">
						<div class="col-sm-7">
							<div class="row space12">
								<ul class="mini-stats col-sm-12">
									<li class="col-sm-4">
										<div class="sparkline_bar_good">
											<span>3,5,9,8,13,11,14</span>+10%
										</div>
										<div class="values">
											<strong>18304</strong>
											Visits
										</div>
									</li>
									<li class="col-sm-4">
										<div class="sparkline_bar_neutral">
											<span>20,15,18,14,10,12,15,20</span>0%
										</div>
										<div class="values">
											<strong>3833</strong>
											Unique Visitors
										</div>
									</li>
									<li class="col-sm-4">
										<div class="sparkline_bar_bad">
											<span>4,6,10,8,12,21,11</span>+50%
										</div>
										<div class="values">
											<strong>18304</strong>
											Pageviews
										</div>
									</li>
								</ul>
							</div>
						</div>
						<div class="col-sm-5">
							<div class="row space12">
								<div class="col-sm-6">
									<div class="easy-pie-chart">
										<span class="bounce number" data-percent="44"> <span class="percent">44</span> </span>
										<div class="label-chart">
											Bounce Rate
										</div>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="easy-pie-chart">
										<span class="cpu number" data-percent="82"> <span class="percent">82</span> </span>
										<div class="label-chart">
											New Visits
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						
						
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<i class="clip-calendar"></i>
									Calendar
									<div class="panel-tools">
										<a class="btn btn-xs btn-link panel-collapse collapses" href="#">
										</a>
										<a class="btn btn-xs btn-link panel-config" href="#panel-config" data-toggle="modal">
											<i class="fa fa-wrench"></i>
										</a>
										<a class="btn btn-xs btn-link panel-refresh" href="#">
											<i class="fa fa-refresh"></i>
										</a>
										<a class="btn btn-xs btn-link panel-expand" href="#">
											<i class="fa fa-resize-full"></i>
										</a>
										<a class="btn btn-xs btn-link panel-close" href="#">
											<i class="fa fa-times"></i>
										</a>
									</div>
								</div>
								<div class="panel-body">
									<div id='calendar'></div>
								</div>
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
			
			<g:javascript library="calendar"/>
		
<%--		<g:javascript library="icheck"/>--%>

		<g:javascript src="main.js"/>
				<g:javascript src="index.js"/>
		<g:javascript src="main_icheck.js"/>
</body>
	<!-- end: BODY -->
		
		
		
</html>