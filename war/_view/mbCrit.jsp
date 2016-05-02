<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
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
					<td><input id="searchMb" type="submit" name="searchMb" size="20" value="searchMb"   >  </td>
				</tr>					
				
	</table>
	</form>
</div>
	</body>
</html>