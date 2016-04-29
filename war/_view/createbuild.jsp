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
<div class="GpuWindow" style="background-color:blue; color:red: padding:30px;">
	<table>
				<tr>
					<td>from:$$</td>
					<td><input type="text" name="low" size="15" value="${glow}" /></td>
				</tr>
				<tr>
					<td>to:$$</td>
					<td><input type="text" name="high" size="15" value="${ghigh}" /></td>
				</tr>
				<tr>
					<td><input id="submit" type="submit" name="SearchGpu" size="20" value="SearchGpu"   >  </td>
				</tr>					
				
	</table>
</div>
<button name="ram" > Choose from Rams</button>
<div class="RamWindow" style="background-color:blue; color:red: padding:30px;">
	<table>
				<tr>
					<td>from:$$</td>
					<td><input type="text" name="low" size="15" value="${rlow}" /></td>
				</tr>
				<tr>
					<td>to:$$</td>
					<td><input type="text" name="high" size="15" value="${rhigh}" /></td>
				</tr>
				<tr>
					<td><select name="ramBrand">
					<option value="Any">Any</option>
  					<option value="G.SKILL">G.SKILL</option>
  					<option value="Corsair">Corsair</option>
  					<option value="HyperX">HyperX</option>
 					<option value="Crucial">Crucial</option>
 					<option value="Mushkin Enhanced">Mushkin Enhanced</option>
						</select></td>
				</tr>
				<tr>
					<td><input id="submit" type="submit" name="SearchRam" size="20" value="SearchRam"   >  </td>
				</tr>					
				
	</table>
</div>
</div>
</FORM>

<div id="cpu">
<button type="button" onclick="hideCpu()">Hide CPUs</button>
<table>
<caption> CPUs </caption>
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Series</td><td>Socket Type</td><td> Frequency</td><td>Cores</td></tr>
<c:forEach items="${cpus}" var="cpu">
    <tr>
       <td><a href="${cpu.url}" target="_blank">${cpu.name}</a></td>
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
<tr><td>Name</td><td>Price($)</td><td>Brand</td><td>Series</td><td>Type</td><td>Capacity(GB)</td><td>Multi-Channel Type</td></tr>
<c:forEach items="${rams}" var="ram">
    <tr>
       <td><a href="${ram.url}" target="_blank">${ram.model}</a></td>
	   <td>${ram.price}</td>
	   <td>${ram.brand}</td>
	   <td>${ram.series}</td>
	   <td>${ram.type}</td>
	   <td>${ram.capacity}</td>
	   <td>${ram.multichannelType}</td>
    </tr>
</c:forEach>
</table>
</div>
	</body>
</html>