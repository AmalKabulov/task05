<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/" method="post">
    <button type="submit" name="STAX">
        <input type="hidden" value="STAX" name="STAX">
    </button>
    <button type="submit" title="SAX">
        <input type="hidden" value="SAX" name="SAX">
    </button>
    <button type="submit" name="DOM">
        <input type="hidden" value="DOM" name="DOM">
    </button>

</form>
<c:forEach var="book" items="${requestScope.books}">
    <ul>
        <li>Author: <c:out value="${book.author}"/></li>
    </ul>

</c:forEach>
<%--<form action="/" method="post">--%>
<%--<input type="text" value="">--%>
<%--</form>--%>
</body>
</html>
