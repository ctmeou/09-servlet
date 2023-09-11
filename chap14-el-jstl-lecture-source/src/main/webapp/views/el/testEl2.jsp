<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>전달된 request 객체에 저장된 Member 객체 필드값 출력하기</h1>

    이름 : ${ requestScope.member.name } <br>
    나이 : ${ requestScope.member.age } <br>
    전화번호 : ${ requestScope.member.phone } <br>
    이메일 : ${ requestScope.member.email } <br>

    이름 : ${ member.name } <br>
    나이 : ${ member.age } <br>
    전화번호 : ${ member.phone } <br>
    이메일 : ${ member.email } <br>

</body>
</html>
