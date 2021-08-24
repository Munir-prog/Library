<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%--
  Created by IntelliJ IDEA.
  User: munir
  Date: 22/08/2021
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h2>All Authors</h2>
<br>

<table>

    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Age</th>
        <th>Image</th>
        <th>User</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.name}</td>
            <td>${author.surname}</td>
            <td>${author.age}</td>
            <td>${author.image}</td>
            <td>${author.user.username}</td>
            <td>
                <a href="/authors/${author.id}"><button type="button">view</button></a>
            </td>
        </tr>
    </c:forEach>
</table>

<button type="button"><a href="${contextPath}/addAuthor">Add</a></button>
</body>
</html>
