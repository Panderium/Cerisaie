<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cerisaie</title>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${oneActivity}">
            <h3>Activité</h3>
            ${activite}
            <h3>Client</h3>
            ${client}
        </c:when>
        <c:when test="${! oneActivity}">
            ${clientByActivity}
        </c:when>
    </c:choose>
</div>
</body>
</html>