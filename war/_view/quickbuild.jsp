<!DOCTYPE html>

<html>
	<head>
		<title>Quick</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> <font color = "yellow">Pick a type of Quick Build to make ${username}!</font></h2>
<FORM method="post" action="${pageContext.servletContext.contextPath}/quickbuild">
<div style="background-color:green: color:orange: padding: 20px:"> 
<button name="cheap"  >Let's go cheap and save money!</button>
</div>
<div style="background-color:black: color:gold: padding: 20px:"> 
<button name="expensive"  >I'm rich I don't care</button>
</div>
<div style="background-color:black: color:gold: padding: 20px:"> 
<button name="anotherbuild"  >Show me what works!</button>
</div>
</FORM>

<div style="background-color:purple: color:red: padding:40px:">
Your Quick Build is...
</div>
<div style="background-color:purple: color:red: padding:40px:">
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
<div style="background-color:purple: color:red: padding:40px:">
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
<div style="background-color:purple: color:red: padding:40px:">
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
<div style="background-color:purple: color:red: padding:40px:">
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
<div style="background-color:purple: color:red: padding:40px:">
<h2> TOTAL PRICE = $$$ ${total} $$$</h2>
</div>
	</body>
</html>