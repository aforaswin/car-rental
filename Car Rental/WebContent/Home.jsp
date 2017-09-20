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
        <h2>
            <a href="editUser">Manage Account Details</a>
            &nbsp;&nbsp;&nbsp;
            <a href="change">Change password</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Cars</h2></caption>
            <tr>
                <th>Registration</th>
                <th>Company</th>
                <th>Car</th>
                <th>Type</th>
                <th>Number of Seats</th>
                <th>Rent per day(Rs)</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="car" items="${listCar}">
                <c:if test="${car.status=='Available'}">
                <tr>
                    <td><c:out value="${car.regNo}" /></td>
                    <td><c:out value="${car.companyName}" /></td>
                    <td><c:out value="${car.carName}" /></td>
                    <td><c:out value="${car.type}" /></td>
                    <td><c:out value="${car.noOfSeats}" /></td>
                    <td><c:out value="${car.rent}" /></td>
                    <td>
                        <form action="checkout" method="post">
                        Number of days: <input type="number" name="days" min="1" max="30"/><br/><br/>
                        <input type="hidden" name="id" value="<c:out value='${car.regNo}' />">
                        <input type="submit" value="Checkout"/>
                            </form>               
                    </td>
                </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>  
    <br>
    <h4> <a href="userLogout">Logout</a>  </h4> 
       <%
int timeout = session.getMaxInactiveInterval();
response.setHeader("Refresh", timeout + "; URL = userLogin.jsp");
%>
</body>
</html>