<html>
<head>
<style>
.admintable
{
background-color: black;
}
</style>
</head>
<%@ include file="common/header.jsp" %>
		<form:form method="POST" modelAttribute="user" commandName="user">
		<table align="center">
<!-- 			    <tr> -->
<%-- 			        <td><form:label path="accno">Account No</form:label></td> --%>
<%-- 			        <td><form:input path="accno" value="${user.id}" /></td> --%>
<!-- 			    </tr> -->
			    <tr>
			        <td><form:label path="accname">Account Name:</form:label></td>
			        <td><form:input path="accname" value="${user.accname}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="branch">Branch</form:label></td>
			        <td><form:input path="branch" value="${user.branch}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="emailid">Mail</form:label></td>
			        <td><form:input path="emailid" value="${user.emailid}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="address"> Address:</form:label></td>
                    <td><form:input path="address" value="${user.address}"/></td>
			    </tr>
			    
			    <tr>
			        <td><form:label path="contactno"> contactno:</form:label></td>
                    <td><form:input path="contactno" value="${user.contactno}"/></td>
			    </tr>
			    
			    <tr>
			    <a href="checkuser" align="center"> Check</a>
<!-- 			      <td align="center" colspan="2" ><input type="submit" value="Submit"/></td> -->
		      </tr>
			</table> 
  <c:if test="${!empty userdata}">
		<h2 align="center">List Customers</h2>
	<table align="center" border="1">
		<tr>
			<th>accno</th>
			<th>aname</th>
			<th>branch</th>
			<th>address</th>
			<th>contactno</th>
			
			<th>maildi</th>
			<th>status</th>
			<th>id</th>
		
		</tr>

		<c:forEach items="${userdata}" var="user">
			<tr>
			<h1>1</h1>
				<td><a href="edit?id=${user.id}"><c:out value="${user.accno}"/></td>
				<td><c:out value="${user.accname}"/></a></td>
				<td><c:out value="${user.branch}"/></td>
				<td><c:out value="${user.address}"/></td>
				<td><c:out value="${user.contactno}"/></td>
				
				<td><c:out value="${user.emailid}"/></td>
				<td><c:out value="${user.status}"/></td>
				<td><c:out value="${user.id}"/></td>
				
				
<%-- 								<td><a href="edit?id=${user.id}">Edit</a></td> --%>
				
								
				
			</tr>
		</c:forEach>
	</table>
</c:if>
</form:form>
<%@ include file="common/footer.jsp" %>
</html>