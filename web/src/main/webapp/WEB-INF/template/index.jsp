<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>

<div class="buttons" align="center">
    <form action="/" method="get">
        <input type="hidden" value="1" name="page">
        <input type="hidden" value="parse" name="command">
        <c:forEach var="parser" items="${applicationScope.parsers}">
            <button class="btn btn-default" type="submit" value="${parser}" name="parser">${parser}</button>
        </c:forEach>
        <%--<button class="btn btn-default" type="submit" value="STAX" name="parser">STAX</button>--%>
        <%--<button class="btn btn-default" type="submit" value="SAX" name="parser">SAX</button>--%>
        <%--<button class="btn btn-default" type="submit" value="DOM" name="parser">DOM</button>--%>
    </form>
</div>


<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>

</html>
