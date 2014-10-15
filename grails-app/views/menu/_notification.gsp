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