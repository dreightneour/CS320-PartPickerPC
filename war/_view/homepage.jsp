<!DOCTYPE html>

<html>
<style>
body{
background-image: linear-gradient(rgba(0,0,0,.25), rgba(0,0,0,0));
background-color: crimson;
}
.inner {
    position: absolute;
    top: 40%;
    left: 33.5%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    style:background-color:goldenrod;
}
.title{
     box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
     background-color:goldenrod;
     position: absolute;
     top: 10%;
     left: 37%;
     padding: 10px
}
.button:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>
	<head>
		<title>Logged in Homepage</title>

	</head>

	<body>
<div class = "title" style = "align: center">
<h2> Welcome to Part Picker PC ${username}</h2>
</div>
<FORM method="post" action="${pageContext.servletContext.contextPath}/homepage">
<div class = "inner" style = "background-color: goldenrod; padding: 30px">
<button  class = "button" name="quickbuild" > Let's make a Quick Build!!!</button>
<button class = "button" name="allparts" > Show me all the parts</button>
<button class = "button" name="createbuild" > Let's make a Custom Build</button>

</div>

</FORM>
	</body>
</html>