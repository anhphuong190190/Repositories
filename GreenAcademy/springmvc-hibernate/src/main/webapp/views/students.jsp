<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../resources/bootstrap.min.css">
<script src="../../resources/jquery.1.10.2.min.js"></script>
<script src="../../resources/bootstrap.min.js"></script>
<title><spring:message code="student.label" /></title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center">
			<spring:message code="student.header" />
		</div>
		<div class="panel-body">
			<table class="table table-striped">
					<thead>
						<tr>
							<th><spring:message code="student.table.id" /></th>
							<th><spring:message code="student.table.name" /></th>
							<th><spring:message code="student.table.age" /></th>
							<th><spring:message code="student.table.address" /></th>
							<th><spring:message code="student.table.action" /></th>
						</tr>
					<thead>
				<c:choose>
	  				<c:when test="${!empty students}">
						<c:forEach items="${students}" var="student">
							<tr>
								<td>${student.id}</td>
								<td>${student.firstName} ${student.lastName}</td>
								<td>${student.age}</td>
								<td>${student.address.street}, ${student.address.district}, ${student.address.city}</td>
								<td>
									<button class="btn btn-info" onclick="location.href=''"><spring:message code="student.btn.view" /></button>
									<button class="btn btn-primary" onclick="location.href=''"><spring:message code="student.btn.edit" /></button>
									<button class="btn btn-danger" onclick="location.href=''"><spring:message code="student.btn.delete" /></button>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<th colspan="5" class="text-center"><spring:message code="student.table.empty" /></th>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<th colspan="5">
						<button onclick="location.href='add'" class="btn btn-primary"><spring:message code="student.btn.add" /></button>
					</th>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>