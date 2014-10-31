<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<Style>
.forgotpassword {
	background-color: silver;
	padding-top: 200px;
	padding-bottom: 200px;;
	margin: 0 auto 0 auto;
}

.submitbutton {
	height: 35px;
	width: 173px;
	background-color: AntiqueWhite;
}

.passwordtable {
	color: DarkOliveGreen;
	font-size: large;
	font-family: "Times New Roman", Serif;
	font-weight: bolder;
	background-color: #EAFDEF;
}
</Style>
<script type="text/javascript">
function validate()
{
	var accno=document.getElementById("txtaccno").value;
	var name=document.getElementById("txtname").value;
	var accnolen=accno.length;
	var name=name.length;
	if(accnolen==0 || pwdlen== 0)
		{
		alert("pls provide valid credential details");
		return false;
		}
	else
		{
		return true;
		}
	}
</script>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<form:form method="POST" onsubmit="return validate()"
		action="forgotpwd" modelAttribute="forgot" commandName="forgot">
		<div class="forgotpassword">
			<table align="center" class="passwordtable"
				style="height: 256px; width: 629px;" border="1">
				<tr>
					<td>Acc No:</td>
					<td style="width: 280px;"><form:input path="accno"
							id="txtaccno" /></td>
				</tr>
				<tr>
					<td>Acc Name:</td>
					<td><form:input path="accname" id="txtname" /></td>
				</tr>

				<tr>

					<td colspan="2" align="center"><input type="submit"
						value="Submit" class="submitbutton" /></td>
				</tr>

			</table>
			<h3 align="center">
				<a href="backlogin"> Back </a>
			</h3>
			<h3 align="center" style="color: green;">${status}</h3>
			<h3 align="center" style="color: red;">${message}</h3>

		</div>
	</form:form>
	<%@ include file="common/footer.jsp"%>
	<h1>Forgot password</h1>
</body>
</html>