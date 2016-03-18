<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>

	</head>

	<body>
	<form class="loginwindow"  method="post" action="${pageContext.servletContext.contextPath}/index"  >
		<div style="background-color:black; color:white; padding:20px;">

<h2 class="loginwindow">Login</h2>
<p class="loginwindow"> Welcome, please sign in></p>



<div class="loginwindow" style="background-color:blue; color:red: padding:30px;">
	<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" size="15" value="${username}" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" size="15" value="${password}" /></td>
				</tr>
				<tr>
					<td><input id="submit" type="submit" name="login" size="20" value="Login"   >  </td>
				</tr>					
				
	</table>
</div>
${userVerify}
<div  >

</div>

</div>



		</form>

	</body>
</html>
