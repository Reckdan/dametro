<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
    
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
<%--		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">--%>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main_clip.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main-responsive.css')}" type="text/css">
<%--		--%>
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'print.css')}" type="text/css" media="print">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css/skins/flat', file: '_all.css')}">
		<link rel="stylesheet" href="${resource(dir: 'css/skins/futurico', file: 'futurico.css')}">	
		<link rel="stylesheet" href="${resource(dir: 'css/skins/line', file: '_all.css')}">
		<link rel="stylesheet" href="${resource(dir: 'css/skins/minimal', file: '_all.css')}">
		<link rel="stylesheet" href="${resource(dir: 'css/skins/polaris', file: 'polaris.css')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'theme_light.css')}" type="text/css" id="skin_color">
		<g:layoutHead/>
<%--		<g:javascript library="application"/>		--%>

		<r:layoutResources />
	</head>
	<body>
<%--		<div id="grailsLogo" role="banner"><a href="http://grails.org"><img src="${resource(dir: 'images', file: 'grails_logo.png')}" alt="Grails"/></a></div>--%>
		<g:layoutBody/>
<%--		<div class="footer" role="contentinfo"></div>--%>
<%--		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>--%>
		<r:layoutResources />
		
	
	</body>
</html>
