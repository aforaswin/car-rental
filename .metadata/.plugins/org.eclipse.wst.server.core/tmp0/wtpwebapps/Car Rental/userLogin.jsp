<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login page</h2>
<br>

<form action="uslogin" method="post">
User Name:<input type="text" name="user" required autofocus="autofocus"><br/> <br/>
Password :<input type="password" name="pass" required><br><br>
<p style="text-align:center;"><input type="submit" value="Login"></p>
</form>
Don't have an account? <a href="newUser">Sign up.</a>
</body>
</html>