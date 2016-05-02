<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
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
					<td><input id="searchRam" type="submit" name="searchRam" size="20" value="searchRam"   >  </td>
				</tr>					
				
	</table>
	</form>
</div>
	</body>
</html>