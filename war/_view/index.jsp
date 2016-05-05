<!DOCTYPE html>
<style>
body{
background-image: linear-gradient(rgba(0,0,0,.25), rgba(0,0,0,0));
background-color: crimson;
}

.inner {
    position: absolute;
    top: 20%;
    left: 20%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    style:background-color:goldenrod;
}
.button1:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
.button2:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>
<html>
	<head>
		<title>Index view</title>

	</head>

	<body>
	<form   method="post" action="${pageContext.servletContext.contextPath}/index"  >
		<div class = "inner" align = "center"style="background-color:goldenrod; color:black; padding:70px;">

<h2 >Login</h2>
<p > Welcome, please sign in or create an account</p>



<div class="loginwindow" style="background-color:crimson; background-image: linear-gradient(rgba(255,255,255,.5), rgba(255,255,255,0));">
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
					<td><input class ="button1" id="submit" type="submit" name="login" size="20" value="Login"   >  </td>
				</tr>					
				
	</table>
</div>
${userVerify}
<button class="button2" type='button' onclick="showRegister()">Register</button>
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

<div>
</div>

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
