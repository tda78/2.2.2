<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 21.04.2020
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<h1>
  <c:out value= "${caption}" />
</h1>
<table border="1">


    <tr>
        <th>Model</th>
        <th>color</th>
        <th>licence plate number</th>
    </tr>
<c:forEach var="car" items="${cars}">
  <tr>
    <td>${car.model}</td>
    <td>${car.color}</td>
    <td>${car.licensePlate}</td>
  </tr>
</c:forEach>
</table>
</body>


</html>
