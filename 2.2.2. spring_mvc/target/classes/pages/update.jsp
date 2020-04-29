<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 25.04.2020
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<h2>${bdMethod}</h2>
<c:set var="user" value="${user}"/>
<form action="/admin/update" method="post">
    <p><label>name<input type="text" name="name" value=${user.username}></label>
    <p><input type="hidden" title="name" name="userID" value=${user.user_id}>
    <p><label>password<input type="text" title="password" name="password" value=${user.password}></label>
        <c:forEach var="role" items="${roles}">
    <p><label><input type="checkbox" name="${role.rolename}"
                     value="${role.rolename}"
            <c:forEach var="userRole" items="${user.roles}">
                <c:if test="${userRole.rolename == role.rolename}">
                    checked
                </c:if>
            </c:forEach>
    />${role.rolename} </label>
        </c:forEach>
    <p><input type="submit" value="submit">
</form>
</body>
</html>
