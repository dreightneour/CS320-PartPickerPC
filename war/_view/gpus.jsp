<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<!--w3schools was used to help with css techniques like button styles and div styles-->
<!--http://www.w3schools.com/css/css3_buttons.asp-->
<!--also the below link was used to find more stylish divs to be used in the css-->
<!--http://tympanus.net/codrops/2012/10/23/basic-ready-to-use-css-styles/-->
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
     left: 37%;
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
	<div class="inner">
	<table>
	<caption> GPUs </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Series</td><td>Slot Type</td><td>Memory Size(GB)</td></tr>
	<c:forEach items="${glist}" var="gpu" varStatus="counter">
    <tr>
       <td><a href="${gpu.url}" target="_blank">${gpu.model}</a></td>
		<td>${gpu.price}</td>
	   <td>${gpu.brand}</td>
	   <td>${gpu.gpuBase}</td>
	   <td>${gpu.slotType}</td>
	   <td>${gpu.memorySize}</td>
	   <td><button class ="button" id="submitGpu" type="submit" name="submitGpu" value="${counter.index}" > ADD</button></td>
    </tr>
</c:forEach>
</table>
	</div>
	</FORM>
	</body>
</html>