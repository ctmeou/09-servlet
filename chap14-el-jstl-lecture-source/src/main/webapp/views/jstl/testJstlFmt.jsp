<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL Fmt Library Tag Test</h1>

<h2>fmt:formatNumber 태그 : 숫자에 포맷을 적용하는 태그</h2>

<c:set var="number" value="123456789" />

<!-- ','와 같은 각 숫자 단위의 구분자 표시 -->
<fmt:formatNumber value="${ number }" groupingUsed="true" /> <br>

<!-- 소점 자리 패턴에 맞춰 반올림 처리 -->
<fmt:formatNumber value="1.234567" pattern="#.###" /> <br>

<!-- 소수점 자리 패턴에 맞춰 소수 표현하지만 모자라는 자릿수는 원래 값대로 표현 -->
<fmt:formatNumber value="1.2" pattern="#.##" /> <br>

<!-- 소수점 자리 패턴에 맞춰 소수 표현하지만 모자라는 자릿수는 0으로 채워 표현 -->
<fmt:formatNumber value="1.2" pattern="#.00" /> <br>

<!-- 백분율로 퍼센트를 계산하여 출력 -->
<fmt:formatNumber value="0.12" type="percent" /> <br>

<!-- 화폐 통화 기호를 붙여서 ','와 같은 각 숫자 단위의 구분까지 하여 표현
        (currencySymbol은 기본값으로 현재 시스템 국가 통화기호로 표현하며 명시적으로도 사용 가능) -->
<fmt:formatNumber value="123456789" type="currency" /> <br>
<fmt:formatNumber value="123456789" type="currency" currencySymbol="$" /> <br/>

<hr>

<h2>fmt:formatDate 태그 : 날짜와 시간에 포맷을 적용하는 태그</h2>
<c:set var="today" value="<%= new java.util.Date() %>" />
오늘 날짜 : <fmt:formatDate value="${ today }" type="date"/> <br>
현재 시간 : <fmt:formatDate value="${ today }" type="time" /> <br>
현재 날짜와 시간 : <fmt:formatDate value="${ today }" type="both" /> <br>


<h2>날짜와 시간에 제공되는 포맷을 적용한 경우</h2>
<!-- medium이 default 값이다. -->
[default] : <fmt:formatDate value="${ today }" type="both" dateStyle='default' timeStyle="default" /> <br/>
[short] : <fmt:formatDate value="${ today }" type="both" dateStyle='short' timeStyle="short" /> <br/>
[medium] : <fmt:formatDate value="${ today }" type="both" dateStyle='medium' timeStyle="medium" /> <br/>
[long] : <fmt:formatDate value="${ today }" type="both" dateStyle='long' timeStyle="long" /> <br/>
[full] : <fmt:formatDate value="${ today }" type="both" dateStyle='full' timeStyle="full" /> <br/>

<h3>원하는 포맷으로 pattern 적용한 경우</h3>
현재 날짜 : <fmt:formatDate value="${ today }" type="date" pattern="yyyy/MM/dd (E)" /> <br/>
현재 시각 : <fmt:formatDate value="${ today }" type="time" pattern="(a) hh:mm:ss" /> <br>
</body>
</html>