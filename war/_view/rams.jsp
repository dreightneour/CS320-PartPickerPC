<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Gpus Picker</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> Welcome to Part Picker PC ${username}</h2>
	<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
	<table>
	<caption> RAMs </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Type</td><td>Capacity(GB)</td><td>Multi-Channel Type</td></tr>
	<c:forEach items="${rlist}" var="ram" varStatus="counter">>
    <tr>
	    <td><a href="${ram.url}" target="_blank">${ram.model}</a></td>
	   <td>${ram.price}</td>
	   <td>${ram.brand}</td>
	   <td>${ram.type}</td>
	   <td>${ram.capacity}</td>
	   <td>${ram.multichannelType}</td>
	   <td><button id="submitRam" type="submit" name="submitRam" value="${counter.index}" > ADD</button></td>
    </tr>
</c:forEach>
</table>
	</div>
	</FORM>
	</body>
</html>