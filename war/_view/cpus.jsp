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
  	text-align: center;
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
     padding: 10px;
     
}
.button:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>
	<head>
		<title>Logged in Homepage</title>

	</head>

	<body>

<div class = "title"><h2> Welcome to Part Picker PC ${username}</h2></div>
	<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<div  class = "inner" >
	<table>
	<caption> CPUs </caption>
	<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Series</td><td>Socket Type</td><td> Frequency</td><td>Cores</td></tr>
	<c:forEach items="${clist}" var="cpu" varStatus="counter">
    <tr>
       <td><a href="${cpu.url}" target="_blank">${cpu.model}</a></td>
	   <td>${cpu.price}</td>
	   <td>${cpu.brand}</td>
	   <td>${cpu.series}</td>
	   <td>${cpu.socketType}</td>
	   <td>${cpu.frequency}</td>
	   <td>${cpu.cores}</td>
	   <td><button class ="button" id="submitCpu" type="submit" name="submitCpu" value="${counter.index}" > ADD</button></td>
    </tr>
</c:forEach>
</table>
	</div>
	</FORM>
	</body>
</html>