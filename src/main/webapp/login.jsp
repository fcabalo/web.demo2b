<%@ page language="java" isELIgnored="false"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
	<h2>Login</h2><hr/>
	<a href="${pageContext.servletContext.contextPath}/account-holders">View Accounts</a>
	<div>
	   <form action="${pageContext.servletContext.contextPath}/login" method="post">
		   <label>Username</label>
		   <input type="text" name="username">
		   <br/>
		   <label>Password</label>
	       <input type="password" name="password">
	       <br/>
	       <input type="submit" value="Login">
       </form>
	</div>
</body>
</html>
