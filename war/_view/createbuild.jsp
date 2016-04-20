<!DOCTYPE html>

<html>
	<head>
		<title>Build a custom PC</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> Welcome to Part Picker PC ${username}</h2>
<FORM method="post" action="${pageContext.servletContext.contextPath}/createbuild">
<div >
<button name="cpu" > Choose from Cpus</button>
<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
	<table>
				<tr>
					<td>from:</td>
					<td><input type="text" name="low" size="15" value="${clow}" /></td>
				</tr>
				<tr>
					<td>to:</td>
					<td><input type="text" name="high" size="15" value="${chigh}" /></td>
				</tr>
				<tr>
					<td><input id="submit" type="submit" name="SearchCpu" size="20" value="SearchCpu"   >  </td>
				</tr>					
				
	</table>
</div>
<button name="mb" > Choose from Motherboards</button>
<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
	<table>
				<tr>
					<td>from:</td>
					<td><input type="text" name="low" size="15" value="${mlow}" /></td>
				</tr>
				<tr>
					<td>to:</td>
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