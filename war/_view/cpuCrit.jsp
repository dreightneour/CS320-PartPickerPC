<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<div class="CpuWindow" style="background-color:blue; color:red: padding:30px;">
	<form method="post" action="${pageContext.servletContext.contextPath}/createbuild">
	<table>
				<tr>
					<td><font color = "white">from:$$</font></td>
					<td><input type="text" name="clow" size="15" value="${clow}" /></td>
				</tr>
				<tr>
					<td><font color = "white">to:$$</font></td>
					<td><input type="text" name="chigh" size="15" value="${chigh}" /></td>
				</tr>
				<tr>
					<td><font color = "white">Socket Type</font></td>
					<td><select name="cseries">
							<option value="none"> ALL </option>
  							<option value="Core i3">i3</option>
						  	<option value="Core i5">i5</option>
						  	<option value="Core i7">i7</option>
						  	<option value="Pentium">Pentium</option>
						  	<option value="FX-Series">FX Series</option>
						  	<option value="A-Series APU">A Series</option>
						</select></td>
				</tr>
				<tr>
					<td><font color = "white">Socket Type</font></td>
					<td><select name="csocketType">
							<option value="none"> ALL </option>
  							<option value="LGA 1150">LGA 1150</option>
						  	<option value="LGA 1151">LGA 1151</option>
						  	<option value="LGA 1155">LGA 1155</option>
						  	<option value="LGA 2011-v3">LGA 2011-v3</option>
						  	<option value="Socket AM1">AM1</option>
						  	<option value="Socket AM2">AM2</option>
						  	<option value="Socket AM3">AM3</option>
						  	<option value="Socket AM3+">AM3+</option>
						  	<option value="Socket FM2">FM2</option>
						  	<option value="Socket FM2+">FM2+</option>
						</select></td>
				</tr>
				<tr>
					<td><font color = "white">Socket Type</font></td>
					<td><select name="ccores">
							<option value="none"> ALL </option>
							<option value="Dual-Core">Dual Core</option>
  							<option value="Quad-Core">Quad Core</option>
						  	<option value="6-Core">6 Core</option>
						  	<option value="8-Core">8 Core</option>
						  	
						  	
						</select></td>
				</tr>
				<tr>
					<td><font color = "white">Brand</font></td>
					<td><select name="cbrand">
							<option value="none"> ALL </option>
							<option value="Intel">Intel</option>
  							<option value="AMD">AMD</option>
						  	
						  	
						</select></td>
				</tr>
				<tr>
					<td><input id="searchCpu" type="submit" name="searchCpu" size="20" value="searchCpu"   >  </td>
				</tr>					
				
	</table>
	</form>
</div>
	</body>
</html>