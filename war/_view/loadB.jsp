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
    top: 29%;
    left: 43.5%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    padding: 10px
}
.title{
     box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
     background-color:goldenrod;
     position: absolute;
     top: 10%;
     left: 45%;
     padding: 13px
}
</style>
	<head>
		<title>Load Build</title>

	</head>

	<body>
<div class = "title">
<h2>  List of Parts </h2></div>
	<div class = "inner" id="cpu">
		<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
		
		<table>
		<caption> Builds </caption>
		<c:forEach items="${blist}" var="build" varStatus = "counter">
		    <tr>
			   <td>${build.name}
			   
			   <button type="submit" name="selectB" value="${counter.index}"> Choose Build </button>
			   <button type="submit" name="deleteB" value="deleteB"> Delete Build </button>
			   </td>
		    </tr>
		</c:forEach>
		</table>
		
		
		</FORM>
	</div>