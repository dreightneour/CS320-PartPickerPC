
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
    left: 15%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    style:background-color:goldenrod;
}
head{
   background-color: goldenrod
   padding: 5px
   color: black
   left: 20%
}
.title{
     box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
     background-color:goldenrod;
     position: absolute;
     text-align: center;
     top: 2%;
     left: 45%;
     padding: 10px
}
</style>
	<head>
		<title>All Parts</title>
		

	</head>

	<body>
<div class = "title" >
<h1><a href="/ppc/homepage">Home</a></h1>
<h2 class = "head" style = "background-color: goldenrod" align="center" > List of Parts </h2></div>
</div>
<div class = "inner" style ="background-color:goldenrod">
<FORM method="post" action="${pageContext.servletContext.contextPath}/allparts">
<div id="cpu">
<button type="button" onclick="hideCpu()">Hide CPUs</button>
<table>
<caption> CPUs </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Series</td><td>Socket Type</td><td> Frequency</td><td>Cores</td></tr>
<c:forEach items="${cpus}" var="cpu">
    <tr style = "overflow:scroll">
       <td><a href="${cpu.url}" target="_blank">${cpu.model}</a></td>
	   <td>${cpu.price}</td>
	   <td>${cpu.brand}</td>
	   <td>${cpu.series}</td>
	   <td>${cpu.socketType}</td>
	   <td>${cpu.frequency}</td>
	   <td>${cpu.cores}</td>
    </tr>
</c:forEach>
</table>
</div>
<div  id = "mb">
<button type="button" onclick="hideMb()">Hide Motherboards</button>
<table>
<caption> Motherboards </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Socket Type</td></tr>
<c:forEach items="${motherboards}" var="mb">
    <tr>
       <td><a href="${mb.url}" target="_blank">${mb.model}</a></td>
	   <td>${mb.price}</td>
	   <td>${mb.brand}</td>
	   <td>${mb.socketType}</td>
    </tr>
</c:forEach>
</table>
</div>
<div id="gpu">
<button type="button" onclick="hideGpu()">Hide GPUs</button>
<table>
<caption> GPUs </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Series</td><td>Slot Type</td><td>Memory Size(GB)</td></tr>
<c:forEach items="${gpus}" var="gpu">
    <tr>
       <td><a href="${gpu.url}" target="_blank">${gpu.model}</a></td>
	   <td>${gpu.price}</td>
	   <td>${gpu.brand}</td>
	   <td>${gpu.gpuBase}</td>
	   <td>${gpu.slotType}</td>
	   <td>${gpu.memorySize}</td>
    </tr>
</c:forEach>
</table>
</div>
<div id = "ram">
<button type="button" onclick="hideRam()">Hide Rams</button>
<table>
<caption> RAMs </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Type</td><td>Capacity(GB)</td></tr>
<c:forEach items="${rams}" var="ram">
    <tr>
       <td><a href="${ram.url}" target="_blank">${ram.model}</a></td>
	   <td>${ram.price}</td>
	   <td>${ram.brand}</td>
	   <td>${ram.type}</td>
	   <td>${ram.capacity}</td>
    </tr>
</c:forEach>
</table>
</div>
<div id = "ssd">
<button type="button" onclick="hideStorage()">Hide Storage</button>
<table>
<caption> Storages </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Capacity(GB)</td><td>Speed</td></tr>
<c:forEach items="${storages}" var="ssd">
    <tr>
       <td><a href="${ssd.url}" target="_blank">${ssd.model}</a></td>
	   <td>${ssd.price}</td>
	   <td>${ssd.brand}</td>
	   <td>${ssd.capacity}</td>
	   <td>${ssd.dataSpeed}</td>
    </tr>
</c:forEach>
</table>
</div>

<div>

<button type = "submit" name="UpdatePrices" value = "UpdatePrices"> Update all prices</button>

</div>
</div>
</FORM>

<script>
function hideCpu() {
    document.getElementById("cpu").style.display = "none";
}
function hideGpu() {
	document.getElementById("gpu").style.display = "none";
}
function hideMb() {
	document.getElementById("mb").style.display = "none";
}
function hideRam() {
	document.getElementById("ram").style.display = "none";
}
</script>
	</body>
</html>