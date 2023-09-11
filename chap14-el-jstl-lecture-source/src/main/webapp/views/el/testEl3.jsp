<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>parameter 값 받아서 출력하기</h1>
    <!-- parameter를 꺼내올 때는 반드시 param.에서 꺼내와야 하며 생략이 불가능하다. -->
    상품명 : ${ param.name } <br>
    가격 : ${ param.price } <br>
    제품번호 : ${ param.no } <br>
    <!-- 같은 name으로 여러 개의 parameter가 넘어온 경우 paramValues.에서 꺼내 인덱스로 참조한다. -->
    제품번호 : ${ paramValues.no["0"] }와 ${ paramValues.no[1] } <br>
    <!-- EL 내에서 연산자 사용 가능 -->
    옵션 : ${ empty param.option ? "옵션 없음" : param.option } <br>
</body>
</html>
