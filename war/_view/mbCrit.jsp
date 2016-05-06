<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
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
					<td><input type="text" name="mlow" size="15" value="${mlow}" /></td>
				</tr>
				<tr>
					<td>to:$$</td>
					<td><input type="text" name="mhigh" size="15" value="${mhigh}" /></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><select name="mbrand">
							<option value="none"> ALL </option>
							<option value="ASRock">ASRock</option>
  							<option value="ASUS">ASUS</option>
  							<option value="GIGABYTE">GIGABYTE</option>
						  	
						  	
						</select></td>
				</tr>
				<tr>
					<td><input class = "button" id="searchMb" type="submit" name="searchMb" size="20" value="searchMb"   >  </td>
				</tr>					
				
	</table>
	</form>
</div>
	</body>
</html>