<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>전달된 request 객체에 저장된 정보 출력하기</h1>

    name : ${ requestScope.name } <br>
    age : ${ requestScope.age } <br>
    phone : ${ requestScope.phone } <br>

    name : ${ name } <br>
    age : ${ age } <br>
    phone : ${ phone } <br>

    0 : ${ requestScope.items[0] } <br>
    1 : ${ requestScope.items[1] } <br>
    2 : ${ requestScope.items[2] } <br>

    0 : ${ items[0] } <br>
    1 : ${ items[1] } <br>
    2 : ${ items[2] } <br>
</body>
</html>
