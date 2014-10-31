<%@page import="com.spring.project.banking.form.UserForm"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

	<style>
		body { margin: 0 auto 0 auto; font-family: verdana;  }
		h1 {text-align: center; margin: 0; padding: 15px;color: white;}
		
		
		.footer { clear: both;  overflow:hidden; border-top: 1px #ccc solid;style="vertical-align:bottom"}
		.footer .text {float: right; margin-right: 20px;}
		
		</style>
</head>
<body>
<div style="background-color: olive;"><h1>Online Banking</h1></div>
<h4 align="left">
	<%
		
		String loggedin = (String)session.getAttribute("loggedin");

		if((loggedin != null) && (loggedin.equals("yes")))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
			String date = sdf.format(new Date());

			out.println(date);
	%></h4>
	<h4 align="right">
	<%		
	UserForm  Profile = (UserForm)session.getAttribute("UserProfile");
	
			out.println("Welcome "+Profile.getAccname().toUpperCase()+"\t");
			
			out.println( "<a align = 'right' href='logout'>Logout</a>");
	
			
		}%>
		</h4>


</body>