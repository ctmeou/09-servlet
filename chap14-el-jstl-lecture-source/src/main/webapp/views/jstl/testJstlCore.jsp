<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSTL Core Library Tag Test</h1>

    <h2>c:set : 변수 선언</h2>
    <!-- scope 생략 시 기본은 pageScope이다. -->
    <c:set var="num1" value="100" scope="session"/>
    <c:set var="num2" value="200" scope="session"/>

    <!-- c:set으로 선언한 변수는 스트립팅 요소에서 쓰는 것이 불가능하다. -->
<%--    <% int sum = num1 + num2; %>  --%>
    <!-- El을 이용해서 사용한다. -->
    <c:set var="sum" value="${ num1 + num2 }"/>
    ${ num1 } + ${ num2 } = ${ sum } <br>

    <% int num3 = 10, num4 =20; %>
    <!-- 아래 코드는 에러는 발생하지 않지만 값은 가져오지 못 한다. -->
    ${ num3 } + ${ num4 } = ${ num3 + num4 } <br>
    <!-- 스크립팅 요소를 value 속성으로 지정한 c:set 태그가 필요하다. -->
    <c:set var="sum2" value="<%= num3 + num4 %>"/>
    num3 + num4 = ${ sum2 } <br>

    <c:set var="colors">
        red, yellow, green, orange, blue, magenta
    </c:set>

    <!-- 자바스크립트와 섞어서 EL 사용하기 -->
    <script>
        window.onload = function () {
            let colors = '${ colors }'.split(', ');
            console.log(colors);
        }
    </script>

    <hr>

    <h2>c:remove : 변수 삭제</h2>
    num1 : ${ num1 }, num2 : ${ num2 } <br>

    <c:remove var="num1" scope="session"/>
    <!-- scope 미지정 시 모든 scope의 동일한 이름의 변수를 제거한다. -->
    <c:remove var="num2"/>

    num1 : ${ num1 }, num2 : ${ num2 } <br>

    <hr>

    <h2>c:out : 값 출력</h2>
    <c:out value="core 라이브러리의 <out> 태그는 값을 화면에 출력하는 태그이다."/> <br>
    <!-- escapeXml을 false로 지정하면 <, > 등을 태그로 인식하고, true로 지정하거나 지정하지 않으면 일반 문자로 인식한다. -->
    <c:out value="<h2>데이터출력</h2>" escapeXml="false"/> <br>
    <c:out value="<h2>데이터출력</h2>" escapeXml="true"/> <br>
    <c:out value="<h2>데이터출력</h2>"/> <br>
    <!-- EL로 가져오는 값이 없을 경우 대체 값을 default 속성에 설정할 수 있다. -->
    <c:out value="${ param.name }" default="아무개님"/> <br>

    <hr>

    <h2>c:if : 조건문</h2>
    <c:set var="value1" value="9" scope="page"/>
    <c:set var="value2" value="3" scope="page"/>
    value1의 값은 ${ value1 }이고, value2의 값은 ${ value2 }이다.

    <c:if test="${ value1 > value2 }">
        <h3>value1이 큽니다.</h3>
    </c:if>
    <c:if test="${ value1 < value2 }">
        <h3>value2가 큽니다.</h3>
    </c:if>

    <hr>

    <h2>c:choose, c:when, c:otherwise : 조건문</h2>
    <c:set var="no" value="${ param.no }"/>

    param.no의 값은 ${ param.no }입니다. <br>
    <c:choose>
        <c:when test="${ no == 1 }"><h2>처음 뵙겠습니다.</h2></c:when>
        <c:when test="${ no eq 2 }"><h2>안녕하세요.</h2></c:when>
        <c:otherwise><h3>환영합니다.</h3></c:otherwise>
    </c:choose>

    <hr>

    <h2>c:forEach : 반복문</h2>
    <c:forEach begin="1" end="10">
        반복 실행 <br>
    </c:forEach>
    <c:forEach var="odd" begin="1" end="9" step="2">
        ${ odd }
    </c:forEach>
    <br>
    <!-- varStatus를 통해 상태를 관리할 수 있다. index : 제로 기반 인덱스, count : 1 기반 인덱스 등 -->
    <c:forEach var="color" items="${ colors }" varStatus="st">
        (${ st.index }) ${ st.count } : 색상 ${ color } <br>
    </c:forEach>

    <hr>

    <h2>c:forTokens : 문자열을 토큰으로 분리 처리할 때 사용</h2>
    <ul>
        <c:forTokens items="yellow blue pink red green" delims=" " var="color">
            <li>${ color }</li>                 <!--delims : 구분자, 공백으로 구분-->
        </c:forTokens>
    </ul>
    <ul>
        <c:forTokens items="yellow-blue*pink/red green" delims="/*- " var="color">
            <li>${ color }</li>
        </c:forTokens>
    </ul>

    <hr>

    <h2>c:url : 링크 설정 정보 별도 지정</h2>
    <c:url var="fmtlink" value="testJstlCoreResult.jsp">
        <c:param name="num1" value="11"/>
        <c:param name="num2" value="22"/>
    </c:url>
    <a href="${ fmtlink }">결과 화면 연결</a>
</body>
</html>
