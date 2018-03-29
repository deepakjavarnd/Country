<%@ page errorPage="error.jsp" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.javarnd.domain.Country"%>

<h3 align="center">
	<font color="Red">Customer Detials</font>
</h3>
<%
	List<Country> data = (ArrayList<Country>) request.getAttribute("country");
%>
<table border="1">
	<tr>
		<td>Country</td>
		<td>City</td>
		<td>Language</td>
		<td>Sports</td>
	</tr>

	<c:forEach items="${data}" var="data">
		<tr>
			<td>${data.countryId}</td>
			<td>${data.city}</td>
			<td>${data.language}</td>
			<td>${data.sports}</td>
	</c:forEach>
	</tr>
</table>
</html>