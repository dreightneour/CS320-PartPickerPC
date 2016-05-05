<!DOCTYPE html>

<html>
<style>
body{
background-image: linear-gradient(rgba(0,0,0,.25), rgba(0,0,0,0));
background-color: crimson;
}
.title{
     box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
     background-color:goldenrod;
     position: absolute;
     top: 7%;
     left: 14%;
     padding: 10px
}
.innerbuttons {
    position: absolute;
    top: 25%;
    left: 40%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    padding: 5px
}
.innerbuttons1 {
    position: absolute;
    top: 26%;
    left: 10%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    padding: 5px
}
.innerbuttons2 {
    position: absolute;
    top: 28%;
    left: 1%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
    padding: 5px
}
.inner1 {
    position: absolute;
    top: 20%;
    left: 20%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    style:background-color:goldenrod;
}
.inner2 {
    position: absolute;
    top: 35%;
    left: 1%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
}
.inner3 {
    position: absolute;
    top: 20%;
    left: 20%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    style:background-color:goldenrod;
}
.inner4 {
    position: absolute;
    top: 20%;
    left: 20%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    style:background-color:goldenrod;
}
</style>
	<head>
		<title>Quick</title>

	</head>

	<body>
<div class = "title">
<h2> Pick a type of Quick Build to make ${username}!</h2></div>
<FORM method="post" action="${pageContext.servletContext.contextPath}/quickbuild">
<div class = "innerbuttons">
<div style="background-color:green: color:orange: padding: 20px:"> 
<button name="cheap">Let's go cheap and save money!</button>
</div>
<div style="background-color:black: color:gold: padding: 20px:"> 
<button name="expensive"  >I'm rich I don't care</button>
</div>
<div style="background-color:black: color:gold: padding: 20px:"> 
<button name="anotherbuild"  >Show me what works!</button>
</div>
</div>
</FORM>
<div class = inner2>
<div style="background-color:purple: color:red: padding:40px:">
Your Quick Build is...
</div>
<div style="background-color:purple: color:red: padding:40px:">
<table border="1">
<tr>
<th>Name</th>
<th>Price $</th>
<th>Brand</th>
<th>Series</th>
<th>Socket Type</th>
<th>Frequency(Ghz)</th>
<th>Cores</th>
</tr>
<tr>
<td><a href="${cpuLink}" target="_blank">${cpuModel}</a></td>
<td>${cpuPrice}</td>
<td>${cpuBrand}</td>
<td>${cpuSeries}</td>
<td>${cpuSocket}</td>
<td>${cpuFrequency}</td>
<td>${cpuCores}</td>
</table>
</div>
<div class = "inne"style="background-color:purple: color:red: padding:40px:">
<table border="1">
<tr>
<th>Name</th>
<th>Price $</th>
<th>Brand</th>
<th>Socket Type</th>
</tr>
<tr>
<td><a href="${motherboardLink}" target="_blank">${motherboardModel}</a></td>
<td>${motherboardPrice}</td>
<td>${motherboardBrand}</td>
<td>${motherboardSocket}</td>
</table>
</div>
<div style="background-color:purple: color:red: padding:40px:">
<table border="1">
<tr>
<th>Name</th>
<th>Price $</th>
<th>Brand</th>
<th>Series</th>
<th>Slot Type</th>
<th>Memory Size(GB)</th>
</tr>
<tr>
<td><a href="${gpuLink}" target="_blank">${gpuModel}</a></td>
<td>${gpuPrice}</td>
<td>${gpuBrand}</td>
<td>${gpuSeries}</td>
<td>${gpuSlot}</td>
<td>${gpuMemory}</td>
</table>
</div>
<div style="background-color:purple: color:red: padding:40px:">
<table border="1">
<tr>
<th>Name</th>
<th>Price $</th>
<th>Brand</th>
<th>Series</th>
<th>Type</th>
<th>Capacity(GB)</th>
<th>Multi-Channel Type</th>
</tr>
<tr>
<td><a href="${ramLink}" target="_blank">${ramModel}</a></td>
<td>${ramPrice}</td>
<td>${ramBrand}</td>
<td>${ramSeries}</td>
<td>${ramType}</td>
<td>${ramCapacity}</td>
<td>${ramMulti}</td>
</table>
</div>
</div>
<div style="background-color:purple: color:red: padding:40px:">
<h2> TOTAL PRICE = $$$ ${total} $$$</h2>
</div>
	</body>
</html>