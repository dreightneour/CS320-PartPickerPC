<!DOCTYPE html>

<html>
	<head>
		<title>Logged in Homepage</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> <font color = "yellow">Welcome to Part Picker PC ${username}</font></h2>
<FORM method="post" action="${pageContext.servletContext.contextPath}/homepage">
<div >
<button name="quickbuild" > Let's make a Quick Build!!!</button>
<button name="allparts" > Show me all the parts</button>
<button name="createbuild" > Let's make a Custom Build</button>
</div>
</FORM>
	</body>
</html>
