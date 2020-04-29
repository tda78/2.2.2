<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 25.04.2020
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="listResults" class="java.util.ArrayList" scope="request"/>

<%@ page import="java.util.List" %>
<%@ page import="web.model.User" %>
<%@ page import="web.service.UserServiceImpl" %>
<%@ page import="java.util.Collection" %>
<%@ page import="javax.management.relation.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users</title>
</head>
<body>
<h1 align="center">USERS</h1>
<table border="1" width="500" align="center">
    <caption>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>roles</th>
    </caption>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.user_id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>

              <c:forEach items="${user.roles}" var="role">
                <p>${role.rolename}</p>
              </c:forEach>
            </td>

            <td>
                <form method="post" action="/admin/delete">
                    <input type="hidden" name="userID" value=${user.user_id}>
                    <input type="submit" value="delete">
                </form>
                <form method="get" action="/admin/update">
                    <input type="hidden" name="userID" value=${user.user_id}>
                    <input type="submit" value="update">
                </form>

            </td>
        </tr>
    </c:forEach>
</table>
<form method="get" action="/admin/new_user"  >
    <input align="center" type="submit" width="500" value="new user">
</form>
</body>
</html>
