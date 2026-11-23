<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Scriptlet</title>
</head>
<body>
    <h1>Server Information</h1>
    <%
        java.util.Date date = new java.util.Date();
        String serverIP = request.getRemoteHost();
    %>
    <p>Current time: <%= date %></p>
    <p>Server IP address: <%= serverIP %></p>
</body>
</html>