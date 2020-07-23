<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Troy.</title>
	</head>
	<img src="2000px-Oracle_logo.svg.png" height="34"/>
	<hr>
	<h1> <center> Oracle ACS Session by Tanmoy. </h1>
	<hr>
	
	<%	if(request.getAttribute("Message")!=null)
			{ out.print(request.getAttribute("Message")); } %>
	<h3> <center> Google.com included in the page.</h2>
	<hr>
	<body>
		<c:import url="http://www.google.com" />
	
	</body>
</html>