<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">


<%--    // реализовать одну форму book а для автора потребуется посмоьреть авторов и написать его имя--%>

    <form:form action="authors" modelAttribute="author" method="post">
        <form:input path="name" placeholder="name"/><br>
        <form:input path="surname" placeholder="surname"/><br>
        <form:input path="age" placeholder="age"/><br>
        <form:input path="image" placeholder="image path"/><br>
        <input type="submit" value="OK">
    </form:form>
<br>


</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>