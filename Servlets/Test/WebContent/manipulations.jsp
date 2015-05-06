<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manipulations</title>
</head>
<body>


<%

	for(int i = 0; i<5; i++) {

%>

<p>This HTML is in a scriplet loop, iteration: <%= i %></p>

<%

	}

%>

<%

String id = request.getParameter("id");

if(id == null) {
%>

<strong>ID parameter is missing</strong>

<% } else { %>

<p>ID parameter is: <%= id %></p>

<% } %>


</body>
</html>