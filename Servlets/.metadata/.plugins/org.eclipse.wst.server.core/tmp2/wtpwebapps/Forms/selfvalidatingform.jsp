<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>

<style>
form {
	border: 1px solid #000;
	padding: 10px 0;
	border-radius: 10px;
}

form input {
	margin-left: 10px;
}
</style>
</head>
<body>

	<jsp:useBean id="user1" class="beans.User" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="user1" />

	<%
		String action = request.getParameter("action");
		if (action != null && action.equals("formsubmit")) {
			if (user1.validate()) {
				request.getRequestDispatcher("/Controller").forward(
						request, response);
			}
		}
	%>


	<h2><jsp:getProperty property="message" name="user1" /></h2>

	<form action="/Forms/selfvalidatingform.jsp" method="post">

		<input type="hidden" name="action" value="formsubmit" /> <input
			type="text" name="email" placeholder="email"
			value="<jsp:getProperty name="user1" property="email"/>" />
		<p />
		<input type="text" name="password" placeholder="password"
			value="<jsp:getProperty name="user1" property="password"/>" /> <input
			type="submit" value="Submit" />

	</form>


</body>
</html>