<%-- 
    Document   : update.jsp
    Created on : Mar 12, 2023, 1:26:10 PM
    Author     : phong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
    <center>
        <h1>Update category</h1>
        <c:set var="c" value="${requestScope.service}" />
        <form action="update" method="POST">
            Enter Service ID: <input type="text" name="serviceID" readonly value="${c.serviceID}"><br/>
            Enter Service Name: <input type="text" name="serviceName" value="${c.serviceName}"><br/>
            Enter Service Address: <input type="text" name="serviceAddress" value="${c.serviceAddress}"><br/>
            Enter Service Phone:<input type="text" name="servicePhone" readonly value="${c.servicePhone}"><br/>
            Enter Service Quantity: <input type="text" name="serviceQuantity" value="${c.serviceQuantity}"><br/>
            Enter Service Price: <input type="int" name="servicePrice" value="${c.servicePrice}"><br/>
            <input type="submit" value="Save">
        </form>
    </center>
</body>
</html>
