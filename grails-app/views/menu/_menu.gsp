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
			