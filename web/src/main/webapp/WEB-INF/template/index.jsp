<html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="/resources/css/buuton.css">
<body>

<%--<form action="/" method="get">--%>
    <div class='menu closed'>
        <input type="hidden" value="1" name="page">
        <input type="hidden" value="parse" name="command">
        <div class='messages button'>
            <button type="submit" value="STAX" name="parser">STAX</button>
        </div>
        <div class='music button'>
            <button type="submit" value="SAX" name="parser">SAX</button>
        </div>
        <div class='home button'>
            <button type="submit" value="DOM" name="parser">DOM</button>
        </div>
        <%--<div class='places button'></div>--%>
        <%--<div class='bookmark button'></div>--%>
        <div class='main button'>Menu</div>
    </div>
<%--</form>--%>


<form action="/" method="get">
    <input type="hidden" value="1" name="page">
    <input type="hidden" value="parse" name="command">
    <button type="submit" value="STAX" name="parser">STAX</button>
    <hr>
    <button type="submit" value="SAX" name="parser">SAX</button>
    <hr>
    <button type="submit" value="DOM" name="parser">DOM</button>
</form>


<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="/resources/js/button.js"></script>
</body>

</html>
