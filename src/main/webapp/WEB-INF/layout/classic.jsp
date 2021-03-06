<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html >
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><tiles:getAsString name="title" /></title>
</head>
<body bgcolor="#E6E6FA">

	<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
		prefix="tilesx"%>

	<tilesx:useAttribute name="current" />


	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<spring:url value="/index.html" />">Java
						Shop</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="${current == 'index' ? 'active' : ''} "><a
							href='<spring:url value="/" />'>Home</a></li>

						<security:authorize access="hasRole('ROLE_ADMIN')">
							<li class="${current == 'users' ? 'active' : ''} "><a
								href='<spring:url value="/users.html" />'>Users</a></li>
						</security:authorize>

						<security:authorize access="hasRole('ROLE_USER')">
							<li class="${current == 'items' ? 'active' : ''} "><a
								href='<spring:url value="/items.html" />'>Items</a></li>
						</security:authorize>

						<security:authorize access="! isAuthenticated()">
							<li class="${current == 'login' ? 'active' : ''} "><a
								href='<spring:url value="/login.html" />'>Login</a></li>
						</security:authorize>

						<security:authorize access=" isAuthenticated()">
							<li><a href="<spring:url value="/logout" />">Logout</a></li>
						</security:authorize>

					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>

		<tiles:insertAttribute name="body" />

		<br> <br>
		<div align="center">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>