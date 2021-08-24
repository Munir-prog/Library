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
    <title>Author - "${author.name}"</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h2 style="text-align: center">Author - "${author.name} ${author.surname}"</h2>
<br>

<div style="display: flex; flex-direction: row; justify-content: space-around">
    <div>
        <img style="width: 250px; height: 400px" src="/resources/images/${author.image}" alt="Image not found! = /resources/images/${author.image}"><br>
    </div>
    <div>
        Age: ${author.age}<br>
    </div>
</div>
</body>
</html>
