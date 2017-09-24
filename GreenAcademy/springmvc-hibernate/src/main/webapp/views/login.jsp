<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../resources/bootstrap.min.css">
<script src="../resources/bootstrap.min.js"></script>
<script src="../resources/jquery.1.10.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="login.label" /></title>
</head>
<body>
	<form action="login" method="post" style="display: center">
		<table class="table table-striped">
			<tr>
				<th colspan="2"><spring:message code="login.label" /></th>
			</tr>
			<tr>
				<td><spring:message code="login.userName" /></td>
				<td><input type="text" name="userName" size="20" /></input></td>
			</tr>
			<tr>
				<td><spring:message code="login.password" /></td>
				<td><input type="password" name="password" size="20" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>