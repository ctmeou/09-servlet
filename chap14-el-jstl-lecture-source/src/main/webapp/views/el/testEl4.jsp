<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>requestScope와 sessionScope</h1>

    <h3>requestScope 값 출력하기</h3>
    이름 : ${ requestScope.member.name } <br>
    나이 : ${ requestScope.member.age } <br>
    연락처 : ${ requestScope.member.phone } <br>
    이메일 : ${ requestScope.member.email } <br>

    <h3>sessionScope 값 출력하기</h3>
    이름 : ${ sessionScope.member.name } <br>
    나이 : ${ sessionScope.member.age } <br>
    연락처 : ${ sessionScope.member.phone } <br>
    이메일 : ${ sessionScope.member.email } <br>

    <h3>우선 순위 테스트</h3>
    <!-- 대상 scope를 생략했을 경우 좁은 범위부터 값을 탐색한다.
    requestScope가 sessionScope보다 범위가 좁기 때문에 requestScope가 우선적으로 탐색된다.
    만약 member라는 값이 requesionScope 안에 없었을 경우에는 sessionScope의 값이 출력된다. -->
    이름 : ${ member.name } <br>
    나이 : ${ member.age } <br>
    연락처 : ${ member.phone } <br>
    이메일 : ${ member.email } <br>
</body>
</html>
