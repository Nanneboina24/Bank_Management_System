<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
</head>
<body>
       <form:form id="accountForm" modelAttribute="myaccount" action="myaccountProcess"
		method="post">

		<table  align="center" border="10" width="30%" cellpadding="6" >
		    <tr>
				<td><form:label path="idnum">AccountNumber</form:label></td>
				<td style="font-style: bold; color: black;">${myaccount.getIdnum()}</td>
			</tr>
		
			<tr>
				<td><form:label path="username">UserName</form:label></td>
				<td style="font-style: bold; color: black;">${myaccount.getUsername()}</td>
			</tr>
			
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td style="font-style: bold; color: black;">${myaccount.getPassword()}</td>
			</tr>
			
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td style="font-style: bold; color: black;">${myaccount.getFirstname()}</td>
			</tr>
			
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td style="font-style: bold; color: black;">${myaccount.getLastname()}</td>
			</tr>
			
			<tr>
				<td><form:label path="phone">Phone</form:label></td>
				<td style="font-style: bold; color: black;">${myaccount.getPhone()}</td>
			</tr>
			
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td style="font-style: bold; color: black;">${myaccount.getEmail()}</td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td style="font-style: bold; color: black;">${myaccount.getAddress()}</td>
			</tr>
			<tr>
				<td><form:label path="amount">Amount</form:label></td>
				<td style="font-style: bold; color: black;">${myaccount.getAmount()}</td>
			</tr>
			
			
			
		</table>
		<table align="center">
		<tr></tr><tr></tr><tr></tr>
			<tr>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td></td><td></td><td></td><td></td><td></td><td></td>
				<td><a href="action"><b>Back</b></a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>