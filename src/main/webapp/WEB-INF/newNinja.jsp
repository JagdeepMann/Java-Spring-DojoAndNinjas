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
		<h1>New Ninja</h1>
		<a href ="/dojos/new">New Dojo</a>
		
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		
			<p>
				<form:label path="dojo">Dojo</form:label>
				<form:select path="dojo">
					<c:forEach items ="${dojos }" var = "d">
						<form:option value = "${d }">
							<c:out value = "${d.name}" />
						</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="dojo" />
			</p>
		
			<p>
				<form:label path="firstName">First Name : </form:label>
				<form:errors path="firstName" />
				<form:input path="firstName" />
			</p>
			<p>
				<form:label path="lastName">Last Name : </form:label>
				<form:errors path="lastName" />
				<form:textarea path="lastName" />
			</p>
			<p>
				<form:label path="age">Age</form:label>
				<form:errors path="age" />
				<form:input path="age" />
			</p>

			<input class = "btn btn-primary" type="submit" value="Create" />
		</form:form>
	</div>

</body>
</html>