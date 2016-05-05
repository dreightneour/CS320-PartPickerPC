<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Build a custom PC</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> Welcome to Part Picker PC ${username}</h2>
<div>
Current Build
</div>
<div id="cpuCurrent">
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
<td><a href="${cpubuild.url}" target="_blank">${cpubuild.name}</a></td>
<td>${cpubuild.price}</td>
<td>${cpubuild.brand}</td>
<td>${cpubuild.series}</td>
<td>${cpubuild.socketType}</td>
<td>${cpubuild.frequency}</td>
<td>${cpubuild.cores}</td>
</table>
</div>
<div id="GpuCurrent">
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
<div id="MbCurrent">
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
<div id="RamCurrent">
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
<div id="StorageCurrent">
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
<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
<div>

<button type="submit" name="cpus" value="cpus"> Find a CPU </button>
<button type="submit" name="gpus" value="gpus"> Find a GPU </button>
<button type="submit" name="mbs" value="mbs"> Find a MOTHERBOARD </button>
<button type="submit" name="rams" value="rams"> Find a RAM </button>
<button type="submit" name="storages" value="storages"> Find a STORAGE </button>


</div>
<div>
<button type="submit" name="update" value="update"> Update the prices of current build </button>
<button type="submit" name="newB" value="newB"> Start New Build </button>
<button type="submit" name="saveB" value="saveB"> Save Build </button>
<button type="submit" name ="loadB" value = "loadB"> Load Build</button>
</div>
<div>
<input type="checkbox" name="priceUpd" value="priceUpd"> Update Price of Item<br>  
<td>Name Your Build:</td>
<td><input type="text" name="buildName" size="15" value="${buildName}" /></td>  
</div>
</FORM>

	</body>
</html>