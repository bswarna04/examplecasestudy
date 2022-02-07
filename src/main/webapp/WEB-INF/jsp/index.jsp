<html>
<body style="background: lightgray ">
<h1>Registration form </h1>
<form method="get" action="/indexSubmit">
<%--    <label>First Name </label>--%>
    First Name <input type="text" name="firstname"><br><br>
    <label>Last Name </label>
    <input type="text" name="lastname"><br><br>
    <label>Email </label>
    <input type="text" name="email"><br><br>
    <label>Password</label>
    <input type="text" name="password"><br><br>
    <label>Confirm Password </label>
    <input type="text" name="confirmpassword"><br><br>
    <label>Date of Birth</label>
    <input type="date" name="dob"><br><br>
    <label>Gender
        <input type="radio" name="select">
        <label>Male</label>
        <input type="radio" name="select">
        <label>Female</label>
    </label><br><br>
    <input type="submit" name="formsubmit" value="Register">

</form>
</body>
</html>