<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<Style>
.balance {
	background-color: silver;
	padding-top: 200px;
	padding-bottom: 200px;;
	margin: 0 auto 0 auto;
}

.balancebutton {
	height: 35px;
	background-color: AntiqueWhite;
	text-shadow: activeborder;
	color: #0080C0;
	font-style: italic;
	font-size: large;
	font-family: "Trebuchet MS", Sans-Serif;
	font-weight: bold;
	width: 261px
}

.balancetable {
	height: 300px;
	color: DarkOliveGreen;
	font-size: large;
	font-family: "Times New Roman", Serif;
	font-weight: bolder;
	background-color: #EAFDEF;
	width: 85%;
}

th {
	color: rgb(144, 144, 144);
	font-size: x-large;
}

td {
	font-size: large;
}

h2 {
	color: #E5E7BD;
	text-shadow: 2px 2px 4px #000000;
}
</Style>

</head>
<body>
	<%@ include file="common/header.jsp"%>
	<form:form method="GET" action="statements" modelAttribute="ubean"
		commandName="ubean">
		<div class="balance">
			<table class="balancetable" align="center" border="1">
				<tr>
					<th colspan="4" style="font-size: x-large;"><h2
							align="center";>Account Details</h2></th>
				</tr>
				<tr>
					<th>Account No</th>
					<th>Account Holder Name</th>
					<th>Branch</th>
					<th>Balance</th>
				</tr>

				<tr>
					<td align="center">${user.accno }</td>
					<td align="center">${user.accname}</td>
					<td align="center">${user.branch}</td>
					<td align="center">RS. ${user.bal}</td>

				</tr>
				<tr>
					<td colspan="4" align="center"><input type="submit"
						value="Generate Statements" class="balancebutton" /></td>
				</tr>
			</table>
		</div>
	</form:form>
<h1>lokesh</h1>
	<%@ include file="common/footer.jsp"%>
</body>
</html>