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
    <title>Books</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h2>All Books</h2>
<br>

<table>

    <tr>
        <th>Title</th>
        <th>Publishing</th>
        <th>Page Count</th>
        <th>Image</th>
        <th>Quantity</th>
        <th>Genre</th>
        <th>User</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.tittle}</td>
            <td>${book.publishingName}</td>
            <td>${book.page}</td>
            <td>${book.image}</td>
            <td>${book.quantity}</td>
            <td>${book.genre.genre}</td>
            <td>${book.user.username}</td>
            <td>
                <a href="/books/${book.id}"><button type="button">view</button></a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="${contextPath}/addBook"><button type="button">Add</button></a>
</body>
</html>
