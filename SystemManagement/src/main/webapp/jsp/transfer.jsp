<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer</title>
</head>
<body>
       <form:form id="transferForm" modelAttribute="transfer" action="transferProcess"
		method="post">
		
        <table  align="center" border="10" width="30%" cellpadding="6" >
		   <tr>
				<td><form:label path="idnum">AccountNumber</form:label></td>
				<td style="font-style: bold; color: black;">${transfer.getIdnum()}</td>
			</tr>
		
			<tr>
				<td><form:label path="user">UserName</form:label></td>
				<td style="font-style: bold; color: black;">${transfer.getUser()}</td>
			</tr>
			<tr>
				<td><form:label path="toid">ToAccNumber</form:label></td>
				<td><form:input path="toid" name="toid" id="toid" /></td>
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
				<td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
				<td><form:button id="transfer" name="transfer">Transfer</form:button></td>
			
				
			</tr>
		</table>
	</form:form>
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>
</html>