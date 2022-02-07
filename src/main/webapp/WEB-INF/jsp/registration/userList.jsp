<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />

<html>
 <form method="get" action="/registration-url-path/userList">
     <input type="text" name="search" value="${searchInput}">
     <button type="submit">Search </button><br>
    FirstName <input type="text" name="firstName"><br>
<%--    // <button type="submit">FirstName</button><br>--%>
    LastName: <input type="text" name="lastName">
    <button type="submit">Search </button>

 </form>

 <table border="1" class="center">
    <tr>
        <td><b>Id</b></td>
        <td><b>Username</b></td>
        <td><b>Email</b></td>
        <td><b>Password</b></td>
        <td><b>FirstName</b></td>
        <td><b>LastName</b></td>
        <td><b>Edit</b></td>
        <td><b>Delete</b></td>

    </tr>
    <c:forEach items="${userListKey}" var="user">
        <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
         <td>${user.email}</td>
         <td>${user.password}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
         <td><a href="/registration-url-path/register?id=${user.id}">Edit</a></td>
            <td><a href="/registration-url-path/deleteUser?id=${user.id}">Delete</a></td>

        </tr>
    </c:forEach>

 </table>
</html>

<jsp:include page="../include/footer.jsp" />