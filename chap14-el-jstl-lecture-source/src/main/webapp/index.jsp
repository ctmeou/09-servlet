<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>EL & JSTL</title>
</head>
<body>
    <h1>JSP Action Tag</h1>
    <h3><a href="views/action/testAction.jsp">JSP Action Tag 테스트</a></h3>

    <h1>EL</h1>
    <h3><a href="test1">request.getAttribute() 테스트</a></h3>
    <h3><a href="test2">request에 저장된 객체 출력 테스트</a></h3>
    <h3><a href="views/el/testEl3.jsp?name=galaxy&price=95&no=5&no=6&option=삼성">parameter로 전달된 값 출력 테스트</a></h3>
    <h3><a href="test4">requestScope와 sessionScope</a></h3>

    <h1>JSTL</h1>
    <h3><a href="views/jstl/testJstlCore.jsp">Core Library Test</a></h3>
    <h3><a href="views/jstl/testJstlFmt.jsp">Fmt Library Test</a></h3>
    <h3><a href="views/jstl/testFunction.jsp">Function Library Test</a></h3>
</body>
</html>