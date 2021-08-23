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

    <form:form action="books?${_csrf.parameterName}=${_csrf.token}" modelAttribute="book" enctype="multipart/form-data" method="post" >
        <form:input path="tittle" placeholder="name"/><br>
        <form:input path="publishingName" placeholder="publishing"/><br>
        <form:input path="page" placeholder="page count"/><br>
        <input type="file" name="bookImage" required><br>
<%--        <form:input path="quantity" placeholder="name"/>--%>
        <form:input path="genre.genre" placeholder="genre"/><br>
        <input type="text" name="authorName" placeholder="author name"><br>
        <input type="submit" value="OK">
    </form:form>
<br>



</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>