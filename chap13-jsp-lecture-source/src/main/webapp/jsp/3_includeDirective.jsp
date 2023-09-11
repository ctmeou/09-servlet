<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>include directive</h1>

    <!-- include 지시자 태그는 해당 jsp에 작성된 내용을 그대로 포함시켜 현재 jsp 파일을 동작시킨다.
    동일한 변수명을 사용하면 컴파일 에러가 발생한다.-->
    <div><%@ include file="today.jsp"%></div>

    <%
        // String output = "";
    %>
</body>
</html>
