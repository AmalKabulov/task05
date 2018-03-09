<%--
  Created by IntelliJ IDEA.
  User: kabul
  Date: 07.03.2018
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
          rel="stylesheet"
          id="bootstrap-css">


</head>
<body>

<div class="container">
    <c:forEach var="book" items="${requestScope.books}">
        <div class="span3">
            <div class="well">
                <h2 class="text-info">${book.title}</h2>
                <p><span class="label label-info">${book.author}</span></p>
                <ul>
                    <li>${book.genre}</li>
                    <li>${book.date}</li>
                </ul>
                <p>${book.description}</p>
                <hr>
                <h3>${book.price}$</h3>
                <hr>
                <p><a class="btn btn-large" href="#"><i class="icon-ok"></i>Buy</a></p>
            </div>
        </div>
    </c:forEach>
</div>

<nav aria-label="Page navigation" id="div1">
    <ul class="pager">
        <c:if test="${requestScope.page != 1}">
            <li>
                <a href="/?page=${page - 1}&command=${requestScope.command}&parser=${requestScope.parser}"
                   aria-label="Previous">
                    <span aria-hidden="true">«</span>
                </a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${requestScope.pageCount}" var="index">
            <c:choose>
                <c:when test="${requestScope.page eq index}">
                    <li>${index}</li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="/?page=${index}&command=${requestScope.command}&parser=${requestScope.parser}"> ${index} </a>
                    </li>
                </c:otherwise>
            </c:choose>

        </c:forEach>

        <c:if test="${requestScope.page lt requestScope.pageCount}">
            <li>
                <a href="/?page=${page + 1}&command=${requestScope.command}&parser=${requestScope.parser}"
                   aria-label="Next">
                    <span aria-hidden="true">»</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>

<form action="/" method="get">
    <button class="btn btn-default" type="submit" value="main" name="command">HOME</button>
</form>
</body>
</html>
