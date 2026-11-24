<!DOCTYPE html>
<html>
<head>
    <title>Young Person</title>
</head>
<body>
<h1>Person Information - Born in 1990 or Later</h1>
<jsp:useBean id="person" type="com.syrine.mvcapplication.model.Person" scope="request"/>
<p>First Name: <jsp:getProperty name="person" property="firstName"/> </p>
<p>Last Name: <jsp:getProperty name="person" property="lastName"/> </p>
<p>Birth Day: <jsp:getProperty name="person" property="birthDay"/> </p>
<p>Sex: <jsp:getProperty name="person" property="sex"/> </p>
</body>
</html>
