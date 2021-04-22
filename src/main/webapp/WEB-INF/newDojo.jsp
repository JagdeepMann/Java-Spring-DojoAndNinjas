<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h1>New Dojo</h1>
		<a href ="/ninjas/new">New Ninja</a>
		<form:form action="/dojos/new" method="post" modelAttribute="dojo">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input type="text" path="name" />
			</p>
			<input class="btn btn-primary" type="submit" value="Create" />

		</form:form>
	</div>

</body>
</html>