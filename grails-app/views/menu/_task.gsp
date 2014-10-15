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
<%--													<g:if test="${DateCategory.minus(new Date(),taskInstance.dueDate).getDays<1 }">--%>
<%--													<span class="label label-danger" style="opacity: 1;"> ${taskInstance.dueDate }</span>--%>
<%--													</g:if>--%>
<%--													<g:elseif test="${DateCategory.minus(new Date(),taskInstance.dueDate).getDays>=1 && DateCategory.minus(new Date(),taskInstance.dueDate).getDays<5 }">--%>
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