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