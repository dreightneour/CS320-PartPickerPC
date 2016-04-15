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
<button name="mb" > Choose from Motherboards</button>
<button name="gpu" > Choose from Gpus</button>
<button name="ram" > Choose from Rams</button>
</div>
</FORM>
	</body>
</html>