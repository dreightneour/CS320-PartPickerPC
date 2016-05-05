<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
body{
background-image: linear-gradient(rgba(0,0,0,.25), rgba(0,0,0,0));
background-color: crimson;
}
.inner {
    position: absolute;
    top: 50%;
    left: 30%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    padding: 10px
}
.title{
     box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
     background-color:goldenrod;
     position: absolute;
     top: 20%;
     left: 35%;
     padding: 13px
}
</style>
	<head>
		<title>Load Build</title>

	</head>

	<body>
<div class = "title">
<h2>  List of Parts </h2></div>
<FORM method="post" action="${pageContext.servletContext.contextPath}/loadb">
<div class = "inner" id="cpu">
<table>
<caption> Builds </caption>
<tr><td>Build #</td><td>Name</td><tr>
<c:forEach items="${blist}" var="build" varStatus = "counter">
    <tr>
	   <td>${build.name}</td>
    </tr>
</c:forEach>
</table>
</div>

</FORM>
