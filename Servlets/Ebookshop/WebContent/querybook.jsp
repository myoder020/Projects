<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Yet Another e-Bookshop</title>
</head>
<body>
	
	<h2>Yet Another e-Bookshop</h2>
	<form action="/Ebookshop/query">
	<p>Choose your author:</p>
	<input type="checkbox" name="author" value="Tan Ah Teck"/> Ah Teck
	<input type="checkbox" name="author" value="Mohammad Ali"/> Ali
	<input type="checkbox" name="author" value="Kumar"/> Kumar	
	<input type="submit" value="Search">
	</form>

</body>
</html>