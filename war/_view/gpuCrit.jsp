<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
	<form method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<table>
				<tr>
					<td>from:$$</td>
					<td><input type="text" name="glow" size="15" value="${glow}" /></td>
				</tr>
				<tr>
					<td>to:$$</td>
					<td><input type="text" name="ghigh" size="15" value="${ghigh}" /></td>
				</tr>
				<tr>
					<td>Memory Size (GB)</td>
					<td><select name="gmemorysize">
							<option value="none"> ALL </option>
  							<option value="1GB">1</option>
						  	<option value="2GB">2</option>
						  	<option value="4GB">4</option>
						  	<option value="6GB">6</option>
						  	<option value="8GB">8</option>
						  	<option value="12GB">12</option>
						</select></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><select name="gbrand">
							<option value="none"> ALL </option>
							<option value="GIGABYTE">GIGABYTE</option>
  							<option value="SAPPHIRE">SAPPHIRE</option>
  							<option value="PowerColor">PowerColor</option>
  							<option value="XFX">XFX</option>
  							<option value="MSI">MSI</option>
						  	
						  	
						</select></td>
				</tr>
				<tr>
					<td><input id="searchGpu" type="submit" name="searchGpu" size="20" value="searchGpu"   >  </td>
				</tr>					
				
	</table>
	</form>
</div>
	</body>
</html>