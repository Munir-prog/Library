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
<div style="display: flex; justify-content: center; background-color: #1b6d85">
    <h2>All Authors</h2>
    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
    <h2><a href="${contextPath}/addAuthor"><button type="button">Add new author</button></a></h2>
</div>
<br>

<%--<table>--%>

<%--    <tr>--%>
<%--        <th>Name</th>--%>
<%--        <th>Surname</th>--%>
<%--        <th>Age</th>--%>
<%--        <th>Image</th>--%>
<%--        <th>User</th>--%>
<%--        <th>Operations</th>--%>
<%--    </tr>--%>

<%--    <c:forEach var="author" items="${authors}">--%>
<%--        <tr>--%>
<%--            <td>${author.name}</td>--%>
<%--            <td>${author.surname}</td>--%>
<%--            <td>${author.age}</td>--%>
<%--            <td>${author.image}</td>--%>
<%--            <td>${author.user.username}</td>--%>
<%--            <td>--%>
<%--                <a href="/authors/${author.id}"><button type="button">view</button></a>--%>
<%--                <a href="/authors/${author.id}/edit"><button type="button">edit</button></a>--%>
<%--                <a href="/authors/${author.id}/delete"><button type="button">delete</button></a>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>

<div style="display: flex;  flex-direction: column; align-items: center; width: 100%">
    <c:forEach var="author" items="${authors}">
        <div style="height: 300px; width: 650px; border: 3px solid #1b6d85; border-radius: 30px; margin-bottom: 40px;
        display: flex; flex-direction: column; align-items: center; justify-content: center">
            <div style="width: 50%; display: flex; flex-direction: column; align-items: center;">
                <h4><span>Author name: ${author.name}</span></h4><br>
                <h4><span>Author surname: ${author.surname}</span></h4><br>
            </div>
            <div style="width: 50%; display: flex; flex-direction: row; justify-content: space-around;">
                <a href="/authors/${author.id}"><button type="button" style="width: 75px; height: 30px">view</button></a>
                <a href="/authors/${author.id}/edit"><button type="button" style="width: 75px; height: 30px">edit</button></a>
                <a href="/authors/${author.id}/delete"><button type="button" style="width: 75px; height: 30px">delete</button></a>
            </div>
        </div>

    </c:forEach>
</div>


</body>
</html>
