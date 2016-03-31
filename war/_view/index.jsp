<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>

	</head>

	<body>
	<form   method="post" action="${pageContext.servletContext.contextPath}/index"  >
		<div style="background-color:black; color:white; padding:20px;">

<h2 ">Login</h2>
<p > Welcome, please sign in or create an account</p>



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
<button class="loginwindow" type='button' onclick="showRegister()">Register</button>
<div id="registerFields" style="display: none;" > 


	<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" size="15" value="${name}" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" size="15" value="${email}" /></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="registerusername" size="15" value="${regusername}" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="registerpassword" size="15" value="${regpassword}" /></td>
				</tr>
				<tr>
					<td><input id="submit" type="submit" name="registerlogin" size="20" value="Create Account!"   >  </td>
				</tr>				
				
	</table>
</div>
</div>
</form>



	</body>
	<script>
	function showRegister() {
		document.getElementById("registerFields").style.display = "block";
		
		var loginwindow = document.getElementsByClassName('loginwindow'), i;

		for (var i = 0; i < loginwindow.length; i ++) {
		    loginwindow[i].style.display = 'none';
		}
		
		
	}
	
	
	</script>
</html>
