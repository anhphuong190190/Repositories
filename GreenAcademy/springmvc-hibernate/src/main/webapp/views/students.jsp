<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/bootstrap.min.css">
<script src="resources/jquery.1.10.2.min.js"></script>
<title><spring:message code="home.label" /></title>
</head>
<body>
	<table class="table table-striped">
		<c:if test="${!empty students}">
			<thead>
				<tr>
					<th><spring:message code="home.table.id" /></th>
					<th><spring:message code="home.table.name" /></th>
					<th><spring:message code="home.table.age" /></th>
					<th><spring:message code="home.table.address" /></th>
					<th><spring:message code="home.table.action" /></th>
				</tr>
			<thead>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.id}</td>
						<td>${student.firstName + student.lastName}</td>
						<td>${student.age}</td>
						<td>${student.address}</td>
						<td>
							<button class="btn btn-info" onclick="location.href='${viewUrl}'">View</button>
							<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
							<button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
						</td>
					</tr>
				</c:forEach>
		</c:if>
		<c:otherwise>
			<tr>
				<th colspan="2"><spring:message code="home.table.empty" /></th>
			</tr>
		</c:otherwise>
	</table>
</body>
</html>