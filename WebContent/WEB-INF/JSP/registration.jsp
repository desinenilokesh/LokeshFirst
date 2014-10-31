<html>
<head>
<script type="text/javascript">
function formvalidation()
{
	var umail=document.getElementById("textemailid");
	var pwd=document.getElementById("password");
	var confirmpassword="";
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(uemail.value.match(mailformat))  
	{  
	return true;  
	}  
	else  
	{  
	alert("You have entered an invalid email address!");  
	uemail.focus();  
	return false;  
	}  
	
	}
</script>
<Style>
.registration {
	background-color: silver;
	padding-top: 200px;
	padding-bottom: 200px;;
	margin: 0 auto 0 auto;
}

.registrationbutton {
	height: 35px;
	width: 173px;
	background-color: olive;
}

.logintable {
	color: DarkOliveGreen;
	font-size: large;
	font-family: "Times New Roman", Serif;
	font-weight: bolder;
	background-color: #EAFDEF;
}
</Style>
<Script>
function ValidateEmail(uemail)  
{ 
	alert('hi');
	var umail=document.getElementById("textemailid");
	alert(umail.valueOf());
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(uemail.value.match(mailformat))  
{  
return true;  
}  
else  
{  
alert("You have entered an invalid email address!");  
uemail.focus();  
return false;  
}  
} 
</Script>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<form:form method="POST" action="registration"
		modelAttribute="registration" commandName="registration">
		<div class="registration">
			<table align="center" class="registrationtable">
				<tr>
					<td colspan="2">
						<h2>Registration Form</h2>
					</td>
				</tr>
				<tr>
					<td>Account No:</td>
					<td><form:input path="accno" type="text" /></td>
				</tr>
				<tr>
					<td>Account Name</td>
					<td><form:input path="accname" type="text" /></td>
				</tr>
				<tr>
					<td>Branch</td>
					<td><form:input path="branch" type="text" /></td>
				</tr>

				<tr>
					<td>Address</td>
					<td><form:input path="address" type="textarea" /></td>
				</tr>
				<tr>
					<td>contact no</td>
					<td><form:input path="contactno" type="text" /></td>
				</tr>
				<tr>
					<td>Email id</td>
					<td><form:input path="mailid" type="text" id="textemailid" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="password" type="password" /></td>
				</tr>
				<tr>
					<td>confirmpassword</td>
					<td><form:input path="password" type="password"
							onmouseout="return formvalidation()" /></td>
				</tr>

				<tr>

					<td align="center" colspan="2"><input type="submit"
						class="registrationbutton" value="Submit" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<h3>${status}</h3>
					</td>
				</tr>
			</table>
	</form:form>

	</form>

	<%@ include file="common/footer.jsp"%>
</body>
</html>
