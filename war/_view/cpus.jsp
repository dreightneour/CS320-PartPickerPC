<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Logged in Homepage</title>

	</head>

	<body>
<font1 style =color:white>
<h2 style="background-color:blue; color:red: padding:30px;"> <font1>Welcome to Part Picker PC ${username}</font1></h2>
	<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
	<table>
	<caption> CPUs </caption>
	<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Series</td><td>Socket Type</td><td> Frequency</td><td>Cores</td></tr>
	<c:forEach items="${clist}" var="cpu" varStatus="counter">>
    <tr>
       <td><a href="${cpu.url}" target="_blank">${cpu.name}</a></td>
	   <td>${cpu.price}</td>
	   <td>${cpu.brand}</td>
	   <td>${cpu.series}</td>
	   <td>${cpu.socketType}</td>
	   <td>${cpu.frequency}</td>
	   <td>${cpu.cores}</td>
	   <td><button id="submitCpu" type="submit" name="submitCpu" value="${counter.index}" > ADD</button></td>
    </tr>
</c:forEach>
</table>
	</div>
	</FORM>
	</body>
</html>
