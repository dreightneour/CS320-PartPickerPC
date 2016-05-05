<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Load Build</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> <font color = "white"> List of Parts</font> </h2>
<FORM method="post" action="${pageContext.servletContext.contextPath}/loadb">
<div id="cpu">
<table>
<caption> Builds </caption>
<tr><td>Build #</td><td>Name</td><tr>
<c:forEach items="${builds}" var="build">
    <tr>
	   <td>${build.id}</td>
	   <td></td>
	   <td>${build.name}</td>
    </tr>
</c:forEach>
</table>
</div>

</FORM>
