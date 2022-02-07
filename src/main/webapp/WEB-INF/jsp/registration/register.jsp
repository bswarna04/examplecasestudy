<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />
<html>
<form method="GET" action="/registration-url-path/registerSubmit">

    <input type="hidden" name="id" value="${formBeanKey.id}">

    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" value="${formBeanKey.username}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${formBeanKey.email}"></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" value="${formBeanKey.firstName}"></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" value="${formBeanKey.lastName}"></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age" value="${formBeanKey.age}"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="${formBeanKey.password}"></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="passowrd" name="confirmPassword" value="${formBeanKey.confirmPassword}"></td>
        </tr>
        <tr>
            <td><button type="submit">Submit</button></tr></td>
        </tr>

    </table>
    <hr>

</form>
<div style="color:red">
    <c:forEach items="${formBeanKey.errorMessages}" var="message">
        <span style="color:red">${message}</span><br>
    </c:forEach>


</div>

</html>


<jsp:include page="../include/footer.jsp" />
