<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Storages Picker</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> Welcome to Part Picker PC ${username}</h2>
	<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
	<table>
	<caption> Storages </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Capacity(GB)</td><td>Speed</td></tr>
	<c:forEach items="${slist}" var="storage" varStatus="counter">>
    <tr>
	    <td><a href="${storage.url}" target="_blank">${storage.model}</a></td>
	   <td>${storage.price}</td>
	   <td>${storage.brand}</td>
	   <td>${storage.capacity}</td>
	   <td>${storage.dataSpeed}</td>
	   <td><button id="submitStorage" type="submit" name="submitStorage" value="${counter.index}" > ADD</button></td>
    </tr>
</c:forEach>
</table>
	</div>
	</FORM>
	</body>
</html>