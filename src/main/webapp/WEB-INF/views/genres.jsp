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
<div style="display: flex; justify-content: center; background-color: #1b6d85">
    <h2>All Genres</h2>
    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
    <h2><a href="${contextPath}/addGenre">
        <button type="button">Add new Genre</button>
    </a></h2>
    &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
    <h2><a href="${contextPath}/welcome">
        <button type="button">Welcome page</button>
    </a></h2>
</div>
<br>


<div style="display: flex;  flex-direction: column; align-items: center; width: 100%">
    <c:forEach var="book" items="${pages}">
        <div style="height: 300px; width: 650px; border: 3px solid #1b6d85; border-radius: 30px; margin-bottom: 40px;
        display: flex; flex-direction: column; align-items: center; justify-content: center">
            <div style="width: 50%; display: flex; flex-direction: column; align-items: center;">
                <h4><span>Genre name: ${book.genre}</span></h4><br>
            </div>
            <div style="width: 50%; display: flex; flex-direction: row; justify-content: space-around;">
                <a href="/genres/${book.id}">
                    <button type="button" style="width: 75px; height: 30px">view</button>
                </a>
                <a href="/genres/${book.id}/edit">
                    <button type="button" style="width: 75px; height: 30px">edit</button>
                </a>
                <a href="/genres/${book.id}/delete">
                    <button type="button" style="width: 75px; height: 30px">delete</button>
                </a>
            </div>
        </div>

    </c:forEach>
</div>
<nav aria-label="...">
    <ul class="pagination">
        <li class="page-item disabled">
            <a class="page-link" href="#">Pages</a>
        </li>
        <c:forEach varStatus="p" begin="1" end="${totalPages}">
            <c:choose>
                <c:when test="${(p.index - 1) == number}">
                    <li class="page-item active">
                        <a class="page-link" href="#">${p.index}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="${pageContext.request.contextPath}/genres?page=${p.index - 1}">${p.index}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ul>
</nav>
</body>
</html>