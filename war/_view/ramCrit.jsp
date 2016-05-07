<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<!--w3schools was used to help with css techniques like button styles and div styles-->
<!--http://www.w3schools.com/css/css3_buttons.asp-->
<!--also the below link was used to find more stylish divs to be used in the css-->
<!--http://tympanus.net/codrops/2012/10/23/basic-ready-to-use-css-styles/-->
<style>
body{
background-image: linear-gradient(rgba(0,0,0,.25), rgba(0,0,0,0));
background-color: crimson;
}

.inner {
    position: absolute;
    top: 30%;
    left: 42%;
    align: center;
    box-shadow: inset 0 0 7px 4px rgba(255,255,255,.5);
    background-color:goldenrod;
}
.button:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>
	<div class="inner" >
	<form method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<table>
				<tr>
					<td>from:$$</td>
					<td><input type="text" name="rlow" size="15" value="${rlow}" /></td>
				</tr>
				<tr>
					<td>to:$$</td>
					<td><input type="text" name="rhigh" size="15" value="${rhigh}" /></td>
				</tr>
				<tr>
					<td>Type</td>
					<td><select name="rtype">
							<option value="none"> ALL </option>
						  	<option value="184-Pin DDR SDRAM">DDR</option>
						  	<option value="240-Pin DDR2 SDRAM">DDR 2</option>
						  	<option value="240-Pin DDR3 SDRAM">DDR 3</option>
						  	<option value="288-Pin DDR4 SDRAM">DDR 4</option>
						</select></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><select name="rbrand">
							<option value="none"> ALL </option>
							<option value="CORSAIR">Corsair</option>
  							<option value="G.SKILL">G.Skill</option>
  							<option value="Crucial">Crucial</option>
  							<option value="HyperX">HyperX</option>
						  	
						  	
						</select></td>
				</tr>
				<tr>
					<td><input class = "button" id="searchRam" type="submit" name="searchRam" size="20" value="searchRam"   >  </td>
				</tr>					
				
	</table>
	</form>
</div>
	</body>
</html>