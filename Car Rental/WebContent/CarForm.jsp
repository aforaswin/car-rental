<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Car Database</title>
</head>
<body>
    <center>
        <h1>Car Management Suite</h1>
        <h2>
            <a href="new">Add New Car</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List of all Cars</a>
             
        </h2>
    </center>
    <div align="center">>
        <c:if test="${car != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${car == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${car != null}">
                        Edit car
                    </c:if>
                    <c:if test="${car == null}">
                        Add New car
                    </c:if>
                </h2>
            </caption>
                <c:if test="${car != null}">
                    <input type="hidden" name="id" value="<c:out value='${car.id}' />" />
                </c:if>           
            <tr>
                <th>Registration number: </th>
                <td>
                    <input type="text" name="reg_no" size="6"
                            value="<c:out value='${car.regNo}' />" 
                       required placeholder="Kl 01 AT 8400" autofocus />
                </td>
            </tr>
            <tr>
                <th>Company Name: </th>
                <td>
                    <input type="text" name="company_name" size="30"
                            value="<c:out value='${car.companyName}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Car Name: </th>
                <td>
                    <input type="text" name="car_name" size="45"
                            value="<c:out value='${car.carName}' />" required
                    />
                </td>
            </tr>
           <tr>
                <th>Type: </th>
                <td>
                    <input type="text" name="type" size="6"
                            value="<c:out value='${car.type}' />" required
                    />
                </td>
            </tr>
            <tr>
                <th>Number of seats: </th>
                <td>
                    <input type="text" name="no_of_seats" size="1"
                            value="<c:out value='${car.noOfSeats}' />" required placeholder="5"
                    />
                </td>
            </tr>
             <tr>
                <th>Rent per hour(Rs): </th>
                <td>
                    <input type="text" name="rent" size="10"
                            value="<c:out value='${car.rent}' />"
                   required  />
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
   
</body>
</html>