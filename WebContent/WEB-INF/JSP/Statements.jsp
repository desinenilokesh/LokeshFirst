<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#datepickerfromDate").datepicker({
			maxDate : 0,
			dateFormat : 'yy-dd-mm'
		});
		$("#datepickertodate").datepicker({
			maxDate : 0,
			dateFormat : 'yy-dd-mm'
		});
	});
</script>

<script type="text/javascript">
	function validatestmt() {
		var accno = document.getElementById("datepickerfromDate").value;
		var pwd = document.getElementById("datepickertodate").value;
		var accnolen = accno.length;
		var pwdlen = pwd.length;
		if (accnolen == 0 || pwdlen == 0) {
			alert("pls provide Valid Dates");
			return false;
		} else {
			return true;
		}
	}
</script>
<Style>
.statements {
	background-color: silver;
	padding-top: 200px;
	padding-bottom: 200px;;
	margin: 0 auto 0 auto;
	height: 60%;
}

.statementsdisplay {
	background-color: white;
	margin: 0 auto 0 auto;
}

.generatebutton {
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

.datestable {
	color: DarkOliveGreen;
	font-size: large;
	font-family: "Times New Roman", Serif;
	font-weight: bolder;
	background-color: #EAFDEF;
	width: 45%;
	height: 50%;
}

th {
	background-color: infobackground;
	font-size: medium;
	color: black;
	text-shadow: 2px 2px 4px #000000;
}

td {
	font-size: large;
}
</Style>




</head>
<body>
	<%@ include file="common/header.jsp"%>
	<form:form method="GET" action="genstmt"
		modelAttribute="genratestatements" commandName="genratestatements">
		<div class="statements">
			<table align="center" class="datestable"
				style="height: 288px; width: 598px;">
				<tr>
					<td colspan="2">
						<h2 align="center">STATEMENT INFORMATION</h2>
					</td>
				</tr>
				<tr>

					<td>FROM DATE:</td>
					<td><form:input path="fromdate" id="datepickerfromDate" /></td>

				</tr>

				<tr>

					<td>TODATE:</td>
					<td><form:input path="todate" id="datepickertodate" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" onclick="return validatestmt()"
						value="Generate" class="generatebutton" align="middle" /></td>

				</tr>
			
			</table>

			<br /> <br />

			<div id="print">

				<c:if test="${!empty stmt}">
					<table border="1" class="statementsdisplay">
						<tr>
							<%-- 			<th><spring:message code="employee.id"/></th> --%>
							<th>Account No</th>
							<th>Account Name</th>
							<th>Transaction Date</th>
							<th>Credit</th>

							<th>Debit</th>

							<th>amount</th>
						</tr>

						<c:forEach items="${stmt}" var="stmt">
							<tr>
								<td><c:out value="${stmt.accno}" /></td>
								<td><c:out value="${stmt.accname}" /></td>
								<td><c:out value="${stmt.txdate}" /></td>
								<td><c:out value="${stmt.credit}" /></td>
								<td><c:out value="${stmt.debit}" /></td>
								<td><c:out value="${stmt.amount}" /></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="6" align="center"><a href="emailstmt"
								onclick="validatestmt" align="center">Send Mail</a></td>
						</tr>
						<!-- 		<tr> -->
						<!-- 		<td colspan="6" align="center">  <input type="submit"  id="btnprint" value="print" onclick="print()"/> -->

						<!-- 		</td> -->
						<!-- 		</tr> -->
					</table>

				</c:if>
				<!-- 			<a href="emailstmt" onclick="validatestmt" align="center">  Mail</a> -->

			</div>
			<h5 Style="color: green; background:white" align="center">${status}</h5>
		</div>


	</form:form>
</body>
<%@ include file="common/footer.jsp"%>
</html>