<%--<html>--%>
<%--<head>--%>
<%--    <title>indexsubmitpage</title>--%>
<%--</head>--%>
<%--<body>--%>

<jsp:include page="../include/header.jsp" />

<h1>This is success page.Login successful</h1>

User <b>${usernameSessionKey }</b> is logged in ( from session )
<br>
Logged in user = <b>${loggedInUser }</b> ( from response model )
<br>
<a href="/logout">Logout</a>

<jsp:include page="../include/footer.jsp" />

<%--</body>--%>
<%--</html>--%>