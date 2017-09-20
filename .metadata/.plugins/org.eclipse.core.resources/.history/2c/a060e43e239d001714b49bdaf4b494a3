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
<div align="center">>
       
            <form action="editUser1" method="post">
        
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    
                        Edit user
                    
                </h2>
            </caption>
                      
            <tr>
                <th>Phone number: </th>
                <td>
                    <input type="text" name="phone_no" size="20"                          
                       pattern="[0-9]{10}" title="Ten digit phone number"
                   required placeholder="9856231478" autofocus value="<c:out value='${user.phoneNo}' />" />
                </td>
            </tr>
            <th>First Name: </th>
                <td>
                    <input type="text" name="first_name" size="20"
                             required value="<c:out value='${user.firstName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="last_name" size="45"
                             required value="<c:out value='${user.lastName}' />"
                    />
                </td>
            </tr>
           <tr>
                <th>Address: </th>
                <td>
                    <input type="text" name="address" size="150"
                             required value="<c:out value='${user.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email_id" size="45"
                             required placeholder="aswin.r@wipro.com" value="<c:out value='${user.email}' />"
                    />
                </td>
            </tr>
            
            
            
            
            
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
response.setHeader("Refresh", timeout + "; URL = userLogin.jsp");
%> 
</body>
</html>