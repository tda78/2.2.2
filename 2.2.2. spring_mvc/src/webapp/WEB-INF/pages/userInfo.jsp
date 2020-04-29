<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>user</title>
</head>
<body>

<c:set var="user" value="${user}"/>
<h2>id:        ${user.user_id}</h2>
<h2>name:      ${user.username}</h2>
<h2>password:  ${user.password}</h2>
<h1>roles:</h1>
<c:forEach var="role" items="${user.roles}">
 <h2> ${role.rolename}</h2>
</c:forEach>

<jsp:include page="logout.jsp"/>
</body>
</html>