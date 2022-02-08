<%--<html>--%>
<%--<head>--%>

<%--</head>--%>
<%--<body>--%>

<jsp:include page="../include/header.jsp" />
<form action="/login/loginSecurityPost" method="POST">

  <h1 style="color:red">${errorMessage}</h1>

  username: <input type="text" name="username"><br><br>
  Password: <input type="password" name="password"><br><br>
  <button type="submit" >Login</button>
</form>

<jsp:include page="../include/footer.jsp" />
<%--</body>--%>
<%--</html>--%>