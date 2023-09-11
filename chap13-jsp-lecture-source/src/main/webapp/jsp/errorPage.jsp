<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // isErrorPage="true" 설정 시 exception 내장 객체 사용 가능
        String exceptionType = exception.getClass().getName();
        String exceptionMessage = exception.getMessage();
    %>

    <h1><%= exceptionType %></h1>
    <h3><%= exceptionMessage %></h3>
</body>
</html>
