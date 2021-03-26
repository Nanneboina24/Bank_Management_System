<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Action</title>
</head>
<body>
      
      <form:form id="actionForm" modelAttribute="action" action="actionProcess" method="post">
		
      <table  align="center" border="8" width="50%" cellpadding="10" >
		<tr>
			<td><a href="withdraw"><b>Withdraw</b></a></td><td>
			<td><a href="deposit"><b>Deposit</b></a></td><td>
			<td><a href="transfer"><b>Transfer</b></a></td>
			<td><a href="myaccount"><b>MyAccount</b></a></td>
			<td><a href="home.jsp"><b>SignOut</b></a></td>
		</tr>
	</table>
	</form:form>
</body>
</html>