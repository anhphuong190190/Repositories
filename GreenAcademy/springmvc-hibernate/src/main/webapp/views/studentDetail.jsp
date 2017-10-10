<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../resources/bootstrap.min.css">
<script src="../../resources/jquery.1.10.2.min.js"></script>
<script src="../../resources/bootstrap.min.js"></script>
<title><spring:message code="student.detail.label" /></title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center"><spring:message code="student.detail.label" /></div>
		<div class="panel-body">
		
			<spring:message code="student.detail.fName.plhd"  var="fName_plhd" />
			<spring:message code="student.detail.lName.plhd" var="lName_plhd" />
			<spring:message code="student.detail.age.plhd" var="age_plhd" />
			<spring:message code="student.detail.street.plhd" var="street_plhd" />
			<spring:message code="student.detail.district.plhd" var="district_plhd" />
			<spring:message code="student.detail.city.plhd" var="city_plhd" />
			
			<form:form class="form-horizontal" action="./save" method="post" modelAttribute="student">
				<div class="form-group">
					<label class="control-label col-sm-4" for="fName"><spring:message code="student.detail.fName" /></label>
					<div class="col-sm-6">
						<form:input path="firstName" type="text" class="form-control" id="fName" name="fName" placeholder="${fName_plhd}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="lName"><spring:message code="student.detail.lName" /></label>
					<div class="col-sm-6">
						<form:input path="lastName" type="text" class="form-control" id="lName" name="lName" placeholder="${lName_plhd}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="age"><spring:message code="student.detail.age" /></label>
					<div class="col-sm-6">
						<form:input path="age" type="text" class="form-control" id="age" name="age" placeholder="${age_plhd}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="street"><spring:message code="student.detail.street" /></label>
					<div class="col-sm-6">
						<form:input path="address.street" type="text" class="form-control" id="street" name="street" placeholder="${street_plhd}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="district"><spring:message code="student.detail.district" /></label>
					<div class="col-sm-6">
						<form:input path="address.district" type="text" class="form-control" id="district" name="district" placeholder="${district_plhd}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="city"><spring:message code="student.detail.city" /></label>
					<div class="col-sm-6">
						<form:input path="address.city" type="text" class="form-control" id="city" name="city" placeholder="${city_plhd}" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-6">
						<button type="submit" class="btn btn-primary"><spring:message code="student.detail.btn.save" /></button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>