
<%@ include file="common/header.jsp"%><html>
<head>
<script type="text/javascript">
function validateform()
{
	var accno=document.getElementById("txtaccno").value;
	
	var pwd=document.getElementById("txtpwd").value;
	var accnolen=accno.length;
	var pwdlen=pwd.length;
	if(accnolen==0 && pwdlen== 0)
		{
		alert("Please give credential details");
	
		return false;
		}
	else if(accnolen==0|| accnolen<10)
		{
		alert('accno should be greater ten letters');

		return false;
		}
	else if(pwdlen==0||pwdlen<4)
		{
		alert('password minimum three characters required');
	
		return false;
		}
	else if(accnolen>0 && accnolen==10 && pwdlen>4 )
		{
		return true;
		}
	
	}
</script>
<Style>
.login {
	background-color: silver;
	padding-top: 200px;
	padding-bottom: 200px;
	/* margin:0 auto 0 auto; */
}

.loginbutton {
	height: 35px;
	width: 173px;
	background-color: AntiqueWhite;
}

.logintable {
	font-size: large;
	font-family: "Times New Roman", Serif;
	font-weight: bolder;
	background-color: #EAFDEF;
	
}

.loginerror {
	color: red;
	margin: 0 auto 0 auto;
	font-size: 15px;
}

h1 {
	color: white;
	text-shadow: 2px 2px 4px #000000;
}

.topmenu {
	float: right;
}
</Style>
</head>
<body>

	<form:form method="POST" onsubmit="return validateform()"
		action="validateLogin" modelAttribute="user" commandName="user">

		<div class="login">
			<h1 color="black">Login</h1>

			<table align="center" class="logintable"
				style="height: 230px; width: 547px; background-color: #F0E1FF">

				<tr>
					<td> <h2>&nbsp; &nbsp; Account Number: </h2></td>
					<td style="width: 252px;"> &nbsp; <p align="center"> <form:input path="accno" type="text" id="txtaccno" /></p></td>
				</tr>
				<tr>
					<td><h2> &nbsp; &nbsp; Password: </h2></td>
					<td style="width: 252px;"> &nbsp; &nbsp; <p align="center"> <form:input path="pwd" type="password" id="txtpwd" /></p></td>
				</tr>

				<tr>
				<td>	&nbsp; &nbsp;<a href="fgtpwd">  <i>Forgot Password ???</i></a></td>
					<td style="width: 249px; ">	&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="Login"
						onclick="validateLogin" style='width: 109px; color: #000000; font-style: italic; font-size: medium; background-color: #FFFFFF; font-family: "Comic Sans MS", Sans-Serif'/></td>
				</tr>
			</table>
			<h3 align="center" style="color: red; background: white;">${error}</h3>
		</div>

		<h3 align="center" >${message}</h3>
	</form:form>
	<div class="loginerror" align="center"></div>

</body>
</html>
<%@ include file="common/footer.jsp"%>
