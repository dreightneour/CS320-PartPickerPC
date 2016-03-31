<!DOCTYPE html>

<html>
	<head>
		<title>Logged in Homepage</title>

	</head>

	<body>
<h2 style="background-color:blue; color:red: padding:30px;"> Welcome to Part Picker PC ${username}</h2>
<FORM method="post" action="${pageContext.servletContext.contextPath}/homepage">
<div >
<button name="quickbuild" > Let's make a Quick Build!!!</button>
<button name="allparts" > Show me all the parts</button>
</div>
</FORM>
	</body>
</html>
