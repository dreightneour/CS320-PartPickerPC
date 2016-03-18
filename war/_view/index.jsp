<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>

	</head>

	<body>
	<form class="loginwindow"  method="post" onsubmit="return myFunction();">
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
					<td><input id="submit" type="submit" name="login" size="20" value="Login" onclick="myTest()"  >  </td>
				</tr>					
				<tr>
					<td><button id="mytest" type="button" value="Test" onclick="myTest()">  </button> </td>
				</tr>
	</table>
</div>
${userVerify}
<div  >

</div>

		<button type="button" onclick="myTest()">Hide content of p</button>
</div>



		</form>
<script>

var loggedin = ${loggedin};
function myTest() {

	var elements = document.getElementsByClassName('loginwindow')
	for (var i = 0; i < elements.length; i++){
    elements[i].style.visibility = "hidden";
}
}
function myFunction() {
	
	var elements = document.getElementsByClassName('loginwindow')
	for (var i = 0; i < elements.length; i++){
    elements[i].style.visibility = "hidden";
	}
}
</script>
	</body>
</html>
