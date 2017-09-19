<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Car Database</title>
</head>
<body>
    <center>
        <h1>Car Rental Suite</h1>
        
    </center>
    <c:out value='${message}' />
<div align="center">>
       
            <form action="changePassword" method="post">
        
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    
                        Change password
                    
                </h2>
            </caption>
             <tr>
            <th>Old password:</th>
            <td>
            <input type="password" name="old_password" size="45"
                             required autofocus
                    />
               </td>
               </tr>
               
            <tr>
            <th>New password:</th>
            <td>
            <input type="password" name="password" size="45"
                             required id="password"
                    />
               </td>
               </tr>
               
           <tr>
           <th>Confirm password:</th>
           <td>
           <input name="password_confirm" required type="password" id="password_confirm" oninput="check(this)" size="45" />
           <script language='javascript' type='text/javascript'>
       function check(input) {
        if (input.value != document.getElementById('password').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            // input is valid -- reset the error message
            input.setCustomValidity('');
        }
    }
</script>
            
        <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div> 
    <br>
  <%
int timeout = session.getMaxInactiveInterval();
response.setHeader("Refresh", timeout + "; URL = loginRedirect.jsp");
%> 
</body>
</html>