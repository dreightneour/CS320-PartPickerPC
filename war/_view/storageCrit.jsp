<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
	<form method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<table>
				<tr>
					<td>from:$$</td>
					<td><input type="text" name="slow" size="15" value="${slow}" /></td>
				</tr>
				<tr>
					<td>to:$$</td>
					<td><input type="text" name="shigh" size="15" value="${shigh}" /></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><select name="sbrand">
							<option value="none"> ALL </option>
							<option value="Samsung">Samsung</option>
  							<option value="Intel">Intel</option>
  							<option value="SanDisk">SanDisk</option>
						  	
						  	
						</select></td>
				</tr>
				<tr>
					<td><input id="searchStorage" type="submit" name="searchStorage" size="20" value="searchStorage"   >  </td>
				</tr>					
				
	</table>
	</form>
</div>
	</body>
</html>