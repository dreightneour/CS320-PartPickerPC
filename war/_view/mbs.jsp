<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Logged in Homepage</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> Welcome to Part Picker PC ${username}</h2>
	<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
<table>
<caption> Motherboards </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Socket Type</td></tr>
<c:forEach items="${mlist}" var="mb" varStatus="counter">
    <tr>
       <td><a href="${mb.url}" target="_blank">${mb.model}</a></td>
	   <td>${mb.price}</td>
	   <td>${mb.brand}</td>
	   <td>${mb.socketType}</td>
	   <td><button id="submitMb" type="submit" name="submitMb" value="${counter.index}" > ADD</button></td>
    </tr>
</c:forEach>
</table>
	</div>
	</FORM>
	</body>
</html>