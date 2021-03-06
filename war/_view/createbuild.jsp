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
.inner {<!---->
    position: relative;
    top: 20%;
    left: 10px;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    
}
<!--.innerh {
    position: absolute;
    top: 18%;
    left: 500px;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    
}-->
.inner1 {
    position: relative;
    top: 28%;
    left: 10px;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    
}
.inner2 {
    position: relative;
    top: 0%;
    left: 10px;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    
}
.inner3 {
    position: relative;
    top: 44%;
    left: 10px;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    
}
.inner4 {
    position: relative;
    top: 52%;
    left: 10px;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    
}
.inner5 {
    position: absolute;
    top: 60%;
    left: 22.5%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    padding: 5px
    
}
.table {
    position: absolute;
    top: 25%;
    left: 22.5%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    padding: 10px
    
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
     text-align: center;
     top: 5%;
     left: 35%;
     padding: 5px
}
.button:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>
	<head>
		<title>Build a custom PC</title>

	</head>

	<body>

<h2 class = "title"><a href="/ppc/homepage" >Home</a> <div>Welcome to Part Picker PC ${username}!</div>
<div style = "text-align: center">This is your Current Build: ${buildName}</div>
</h2>

<div class = "innerh">

</div>
<div class = "table">
	<div class = "inner" id="cpuCurrent">
	<table border="1">
	<tr>
	<th>Name</th>
	<th>Price $</th>
	<th>Brand</th>
	<th>Series</th>
	<th>Socket Type</th>
	<th>Frequency(Ghz)</th>
	<th>Cores</th>
	</tr>
	<tr>
	<td><a href="${cpubuild.url}" target="_blank">${cpubuild.model}</a></td>
	<td>${cpubuild.price}</td>
	<td>${cpubuild.brand}</td>
	<td>${cpubuild.series}</td>
	<td>${cpubuild.socketType}</td>
	<td>${cpubuild.frequency}</td>
	<td>${cpubuild.cores}</td>
	</table>
	</div>
	<div class = "inner1" id="GpuCurrent">
	<table border="1">
	<tr>
	<th>Name</th>
	<th>Price $</th>
	<th>Brand</th>
	<th>Series</th>
	<th>Slot Type</th>
	<th>Memory Size(GB)</th>
	</tr>
	<tr>
	<td><a href="${gpubuild.url}" target="_blank">${gpubuild.model}</a></td>
	<td>${gpubuild.price}</td>
	<td>${gpubuild.brand}</td>
	<td>${gpubuild.gpuBase}</td>
	<td>${gpubuild.slotType}</td>
	<td>${gpubuild.memorySize}</td>
	</table>
	</div>
	<div class = "inner2" id="MbCurrent">
	<table border="1">
	<tr>
	<th>Name</th>
	<th>Price $</th>
	<th>Brand</th>
	<th>Socket Type</th>
	</tr>
	<tr>
	<td><a href="${mbbuild.url}" target="_blank">${mbbuild.model}</a></td>
	<td>${mbbuild.price}</td>
	<td>${mbbuild.brand}</td>
	<td>${mbbuild.socketType}</td>
	</table>
	</div>
	<div class = "inner3" id="RamCurrent">
	<table border="1">
	<tr>
	<th>Name</th>
	<th>Price $</th>
	<th>Brand</th>
	<th>Type</th>
	<th>Capacity(GB)</th>
	<th>Multi-Channel Type</th>
	</tr>
	<tr>
	       <td><a href="${rambuild.url}" target="_blank">${rambuild.model}</a></td>
		   <td>${rambuild.price}</td>
		   <td>${rambuild.brand}</td>
		   <td>${rambuild.type}</td>
		   <td>${rambuild.capacity}</td>
		   <td>${rambuild.multichannelType}</td>
	</table>
	</div>
	<div class = "inner4" id="StorageCurrent">
	<table border="1">
	<tr>
	<th>Name</th>
	<th>Price $</th>
	<th>Brand</th>
	<th>Capacity(GB)</th>
	<th>Speed</th>
	</tr>
	<tr>
	       <td><a href="${ssdbuild.url}" target="_blank">${ssdbuild.model}</a></td>
		   <td>${ssdbuild.price}</td>
		   <td>${ssdbuild.brand}</td>
		   <td>${ssdbuild.capacity}</td>
		   <td>${ssdbuild.dataSpeed}</td>
	</table>
	</div>
</div>
<div class = "inner5">
<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
<div style = "padding:5px">

<button class = "button" type="submit" name="cpus" value="cpus"> Find a CPU </button>
<button class = "button" type="submit" name="gpus" value="gpus"> Find a GPU </button>
<button class = "button" type="submit" name="mbs" value="mbs"> Find a MOTHERBOARD </button>
<button class = "button" type="submit" name="rams" value="rams"> Find a RAM </button>
<button class = "button" type="submit" name="storages" value="storages"> Find a STORAGE </button>


</div>
<div style = "padding: 5px;">
<button class = "button" type="submit" name="update" value="update"> Update the prices of current build </button>
<button class = "button" type="submit" name="saveB" value="saveB"> Save Build </button>
<button class = "button" type="submit" name ="loadB" value = "loadB"> Load Build</button>
</div>
<div>
<input type="checkbox" name="priceUpd" value="priceUpd"> Update Price of Item<br>  
${userVerify}
<td>Name Your Build:</td>
<td><input type="text" name="buildName" size="15" value="${buildName}" /> </td>  

</div>
</FORM>
</div>


	</body>
</html>