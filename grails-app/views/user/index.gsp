<html lang="en" class="no-js">
	<!--<![endif]-->
	<!-- start: HEAD -->
	<head>
		<title>Clip-One - Responsive Admin Template</title>
		<!-- start: META -->
		<meta charset="utf-8" />
		<meta content="" name="description" />
		<meta content="" name="author" />
		 <meta name="layout" content="main_login"/>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">

		<g:javascript library="jquery"/>
		<r:require module="jquery-validate"/>
		<r:require module="jquery-ui"/>
		<r:require module="font-awesome"/>
		
		<!-- end: META -->
		<!-- start: MAIN CSS -->
		
	</head>
	<!-- end: HEAD -->
	<!-- start: BODY -->
	<body class="login example1">

		<div class="main-login col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
			<div class="logo">CLIP<i class="clip-clip"></i>ONE
			</div>
				<!-- start: LOGIN BOX -->
			<div class="box-login" id="box-login">
				<h3>Sign in to your account</h3>
				<p>
					Please enter your name and password to log in.
				</p>
<%--				<g:if test="${flash.message}">--%>
<%--            		<div class="message" role="status">${flash.message}</div>--%>
<%--            	 </g:if>--%>
<%--				<form class="form-login" action="user/login" method="post">--%>
				<div class="message">
					${flash.message}
				</div>
				<g:formRemote name="loginForm" url="[controller:'user', action:'login']" class="form-login" update="danger">
				 
					<div class="errorHandler alert alert-danger no-display">
						<i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
					</div>
					<fieldset>
						<div class="form-group">
							<span class="input-icon">
<%--								<input type="text" class="form-control" name="username" placeholder="Username">--%>
								<g:textField name="username" class="form-control" placeholder="Username"/>
								<i class="fa fa-user"></i> </span>
							<!-- To mark the incorrectly filled input, you must add the class "error" to the input -->
							<!-- example: <input type="text" class="login error" name="login" value="Username" /> -->
						</div>
						<div class="form-group form-actions">
							<span class="input-icon">
								<g:field name="password" type="password" class="form-control password" placeholder="Password" />
<%--								<input type="password" class="form-control password" name="password" placeholder="Password">--%>
								<i class="fa fa-lock"></i>
								<a class="forgot" href="#">
									I forgot my password
								</a> </span>
						</div>
						<div class="form-actions">
							<label for="remember" class="checkbox-inline">
								<input type="checkbox" class="grey" id="remember" name="remember">
								Keep me signed in
							</label>
							<button type="submit" class="btn btn-bricky pull-right" id="loginBtn">
								Login <i class="fa fa-arrow-circle-right"></i>
							</button>
<%--						<i class="fa fa-arrow-circle-right"></i>--%>
<%--						<g:submitButton name="Login" class="btn btn-bricky pull-right"  />--%>
						
						</div>
						<div class="new-account">
							Don't have an account yet?
							<a href="#" class="register">
								Create an account
							</a>
						</div>
					</fieldset>
					</g:formRemote>
<%--				</form>--%>

			
			</div>
			<!-- end: LOGIN BOX -->
			<!-- start: FORGOT BOX -->
			<div class="box-forgot">
				<h3>Forget Password?</h3>
				<p>
					Enter your e-mail address below to reset your password.
				</p>
				<form class="form-forgot">
					<div class="errorHandler alert alert-danger no-display">
						<i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
					</div>
					<fieldset>
						<div class="form-group">
							<span class="input-icon">
								<input type="email" class="form-control" name="email" placeholder="Email">
								<i class="fa fa-envelope"></i> </span>
						</div>
						<div class="form-actions">
							<a class="btn btn-light-grey go-back">
								<i class="fa fa-circle-arrow-left"></i> Back
							</a>
							<button type="submit" class="btn btn-bricky pull-right">
								Submit <i class="fa fa-arrow-circle-right"></i>
							</button>
						</div>
					</fieldset>
				</form>
			</div>
			<!-- end: FORGOT BOX -->
			<!-- start: REGISTER BOX -->
			<div class="box-register">
				<h3>Sign Up</h3>
				<p>
					Enter your personal details below:
				</p>
				<form class="form-register">
					<div class="errorHandler alert alert-danger no-display">
						<i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
					</div>
					<fieldset>
						<div class="form-group">
							<input type="text" class="form-control" name="full_name" placeholder="Full Name">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="address" placeholder="Address">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="city" placeholder="City">
						</div>
						<div class="form-group">
							<div>
								<label class="radio-inline">
									<input type="radio" class="grey" value="F" name="gender">
									Female
								</label>
								<label class="radio-inline">
									<input type="radio" class="grey" value="M" name="gender">
									Male
								</label>
							</div>
						</div>
						<p>
							Enter your account details below:
						</p>
						<div class="form-group">
							<span class="input-icon">
								<input type="email" class="form-control" name="email" placeholder="Email">
								<i class="fa fa-envelope"></i> </span>
						</div>
						<div class="form-group">
							<span class="input-icon">
								<input type="password" class="form-control" id="password" name="password" placeholder="Password">
								<i class="fa fa-lock"></i> </span>
						</div>
						<div class="form-group">
							<span class="input-icon">
								<input type="password" class="form-control" name="password_again" placeholder="Password Again">
								<i class="fa fa-lock"></i> </span>
						</div>
						<div class="form-group">
							<div>
								<label for="agree" class="checkbox-inline">
									<input type="checkbox" class="grey agree" id="agree" name="agree">
									I agree to the Terms of Service and Privacy Policy
								</label>
							</div>
						</div>
						<div class="form-actions">
							<a class="btn btn-light-grey go-back">
								<i class="fa fa-circle-arrow-left"></i> Back
							</a>
							<button type="submit" class="btn btn-bricky pull-right">
								Submit <i class="fa fa-arrow-circle-right"></i>
							</button>
						</div>
					</fieldset>
				</form>
			</div>
			<!-- end: REGISTER BOX -->
		
			<!-- start: COPYRIGHT -->
			<div class="copyright">
				2014 &copy; clip-one by cliptheme.
			</div>
			<!-- end: COPYRIGHT -->
		</div>
	 	<r:require module="bootstrap"/>	
		<g:javascript library="icheck"/>
		<g:javascript src="main_icheck.js"/>
		<g:javascript src="logintest.js"/>
		<g:javascript src="main.js"/>
		
		
</body>
	<!-- end: BODY -->

</html>