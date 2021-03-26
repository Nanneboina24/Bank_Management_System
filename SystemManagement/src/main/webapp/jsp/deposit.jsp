<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit</title>
</head>
<body>
       <form:form id="depositForm" modelAttribute="deposit" action="depositProcess"
		method="post">

		<table  align="center" border="10" width="30%" cellpadding="6">
		    <tr>
				<td><form:label path="idnum">AccountNumber</form:label></td>
				<td style="font-style: bold; color: black;">${deposit.getIdnum()}</td>
			</tr>
		
			<tr>
				<td><form:label path="user">UserName</form:label></td>
				<td style="font-style: bold; color: black;">${deposit.getUser()}</td>
			</tr>
			
			<tr>
				<td><form:label path="amount">Amount</form:label></td>
				<td><form:input path="amount" name="amount" id="amount" /></td>
			</tr>
			
			
		</table>
		  <table align="center">
		  <tr></tr><tr></tr>
			<tr>
				
				<td><a href="action"><b>Back</b></a></td>
			
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
				<td><form:button id="deposit" name="deposit">Deposit</form:button></td>
			</tr>
			
			</table> 
	</form:form>
</body>
</html>