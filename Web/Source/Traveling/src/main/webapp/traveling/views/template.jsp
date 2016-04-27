<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link href="../css/style.css" rel="stylesheet">

<title>${param.title}</title>
</head>
<body>
	<!-- Header of Page -->
	<jsp:include page="header.jsp">
		<jsp:param name="content" value="${param.page}" />
	</jsp:include>
	<!-- End Header of Page -->

	<!-- Content of Page -->
	<jsp:include page="${param.content}${param.page}" />
	<!-- End Content of Page -->

	<!-- Footer of Page -->
	<jsp:include page="footer.jsp" />
	<!-- End Footer of Page -->
	
	<script type="text/javascript">
		$('.carousel').carousel({
			interval : 3500, // in milliseconds
			pause : 'none' // set to 'true' to pause slider on mouse hover
		})
	</script>
	<script type="text/javascript">
		$("a.submenu").click(function() {
			$(".menuBar").slideToggle("normal", function() {
				// Animation complete.
			});
		});
		$("ul li.dropdown a").click(function() {
			$("ul li.dropdown ul").slideToggle("normal", function() {
				// Animation complete.
			});
			$('ul li.dropdown').toggleClass('current');
		});
	</script>
</body>
</html>