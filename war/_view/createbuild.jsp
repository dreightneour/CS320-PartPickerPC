<!DOCTYPE html>

<html>
	<head>
		<title>Build a custom PC</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> Welcome to Part Picker PC ${username}</h2>
<div>
Current Build
</div>
<button>Cpu: ${cpuModel}</button>
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
<button>Gpu: ${gpuModel}</button>
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
<button>Motherboard: ${motherboardModel}</button>
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
<button>Ram: ${ramModel}</button>
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
<button name="cpu" > Choose from Cpus</button>
<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
	<table>
				<tr>
					<td>from:$$</td>
					<td><input type="text" name="low" size="15" value="${clow}" /></td>
				</tr>
				<tr>
					<td>to:$$</td>
					<td><input type="text" name="high" size="15" value="${chigh}" /></td>
				</tr>
				<tr>
					<td><input id="submit" type="submit" name="SearchCpu" size="20" value="SearchCpu"   >  </td>
				</tr>					
				
	</table>
</div>
<button name="mb" > Choose from Motherboards</button>
<div class="MbWindow" style="background-color:blue; color:red: padding:30px;">
	<table>
				<tr>
					<td>from:$$</td>
					<td><input type="text" name="low" size="15" value="${mlow}" /></td>
				</tr>
				<tr>
					<td>to:$$</td>
					<td><input type="text" name="high" size="15" value="${mhigh}" /></td>
				</tr>
				<tr>
					<td><input id="submit" type="submit" name="SearchMb" size="20" value="SearchMb"   >  </td>
				</tr>					
				
	</table>
</div>
<button name="gpu" > Choose from Gpus</button>
<button name="ram" > Choose from Rams</button>
</div>
</FORM>
	</body>
</html>