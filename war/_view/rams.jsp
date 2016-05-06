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
    top: 20%;
    left: 27%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    width: 800px;
	height: 800px;
	overflow: scroll;
}
.head{
   background-color: goldenrod
   padding: 5px
   color: black
   left: 20%
}
.title{
     box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
     background-color:goldenrod;
     position: absolute;
     top: 5%;
     left: 35%;
     padding: 10px
}
.button:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>
	<head>
		<title>Gpus Picker</title>

	</head>

	<body>
<h2 class = "title"> Welcome to Part Picker PC ${username}</h2>
	<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<div class = "inner">
	<table>
	<caption> RAMs </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Type</td><td>Capacity(GB)</td><td>Multi-Channel Type</td></tr>
	<c:forEach items="${rlist}" var="ram" varStatus="counter">
    <tr>
	    <td><a href="${ram.url}" target="_blank">${ram.model}</a></td>
	   <td>${ram.price}</td>
	   <td>${ram.brand}</td>
	   <td>${ram.type}</td>
	   <td>${ram.capacity}</td>
	   <td>${ram.multichannelType}</td>
	   <td><button class = "button" id="submitRam" type="submit" name="submitRam" value="${counter.index}" > ADD</button></td>
    </tr>
</c:forEach>
</table>
	</div>
	</FORM>
	</body>
</html>