<%--
  Created by IntelliJ IDEA.
  User: kabul
  Date: 07.03.2018
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="book" items="${requestScope.books}">
<ul>
<li>Author: <c:out value="${book.author}"/></li>
</ul>

</c:forEach>

</body>
</html>
