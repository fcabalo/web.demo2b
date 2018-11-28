<%@page import="com.demo.model.AccountHolder"%>
<%@page import="java.util.List"%>
<%@ page language="java" isELIgnored="false"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
	<h2>Account Holders</h2><hr/>
	<table>
	   <tr>
	       <td>Id</td>
	       <td>Registration ID</td>
	       <td>Balance</td>
	   </tr>
	   <%
	    List<AccountHolder> accountHolders = (List<AccountHolder>) request.getAttribute("accountHolders");
	    for(AccountHolder accountHolder: accountHolders) {
	   %>
	        <tr>
	           <td><%= accountHolder.getId() %></td>
	           <td><%= accountHolder.getRegistrationId() %></td>
	           <td><%= accountHolder.getBalance() %></td>
	       </tr>
	   <%
	    }
	   %>
	</table>
</body>
</html>
