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
<td><a href="${cpuLink}" target="_blank">${cpuModel}</a></td>
<td>${cpuPrice}</td>
<td>${cpuBrand}</td>
<td>${cpuSeries}</td>
<td>${cpuSocket}</td>
<td>${cpuFrequency}</td>
<td>${cpuCores}</td>
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
<td><a href="${gpuLink}" target="_blank">${gpuModel}</a></td>
<td>${gpuPrice}</td>
<td>${gpuBrand}</td>
<td>${gpuSeries}</td>
<td>${gpuSlot}</td>
<td>${gpuMemory}</td>
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
<td><a href="${motherboardLink}" target="_blank">${motherboardModel}</a></td>
<td>${motherboardPrice}</td>
<td>${motherboardBrand}</td>
<td>${motherboardSocket}</td>
</table>
</div>
<div id="RamCurrent">
<table border="1">
<tr>
<th>Name</th>
<th>Price $</th>
<th>Brand</th>
<th>Series</th>
<th>Type</th>
<th>Capacity(GB)</th>
<th>Multi-Channel Type</th>
</tr>
<tr>
<td><a href="${ramLink}" target="_blank">${ramModel}</a></td>
<td>${ramPrice}</td>
<td>${ramBrand}</td>
<td>${ramSeries}</td>
<td>${ramType}</td>
<td>${ramCapacity}</td>
<td>${ramMulti}</td>
</table>
</div>
<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
<div>

<button type="submit" name="cpus" value="cpus"> Find a CPU </button>
<button type="submit" name="gpus" value="gpus"> Find a GPU </button>
<button type="submit" name="mbs" value="mbs"> Find a MOTHERBOARD </button>
<button type="submit" name="rams" value="rams"> Find a RAM </button>
</div>
</FORM>

	</body>
</html>