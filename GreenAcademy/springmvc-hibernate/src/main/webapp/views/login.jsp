<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../resources/bootstrap.min.css">
<script src="../resources/bootstrap.min.js"></script>
<script src="../resources/jquery.1.10.2.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="login.label" /></title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading h3 text-center"><spring:message code="login.label" /></div>
		<div class="panel-body">
			<form class="form-horizontal" action="login" method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="userName"><spring:message code="login.userName" /></label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="userName" name="userName" placeholder="<spring:message code="login.userName.plhd" />">
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2" for="pwd"><spring:message code="login.password" /></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="pwd" name="password" placeholder="<spring:message code="login.password.plhd" />">
					</div>
				</div>
				<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary"><spring:message code="login.btn" /></button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>