<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
	<form action="${pageContext.servletContext.contextPath}/index" method="post">
		<div style="background-color:black; color:white; padding:20px;">

<h2>Login</h2>
<p>Welcome, please sign in</p>

</div>

<div style="background-color:blue; color:red: padding:30px;">
	<table>
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" name="username" size="15" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="text" name="password" size="15" value="${password}" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="login" size="20" value="Login"> </td>
				</tr>					
				<tr>
					<td><input type="submit" name="test" size="20" value="Test"> </td>
				</tr>
	</table>
</div>
${userVerify}
<div  >

</div>
		</form>
	</body>
</html>
