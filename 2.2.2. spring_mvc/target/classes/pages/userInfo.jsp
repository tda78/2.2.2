<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>user</title>
</head>
<body>

<c:set var="user" value="${user}"/>
<h2>id:        ${user.id}</h2>
<h2>name:      ${user.name}></h2>
<h2>password:  ${user.password}></h2>
<c:forEach var="role" items="${user.roles}">
 <h2> ${role.role_name}</h2>
</c:forEach>
</body>
</html>