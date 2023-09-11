<!-- 1. 페이지 지시자 태그 : 페이지에 대한 설정을 하는 지시자 태그이다.
현 페이지의 스크립틀릿 태그를 이용하여 작성하는 문법은 java라는 것을 나타내며,
response header에 응답을 위한 설정으로 content-type이라는 헤더에 MIME 타입과 인코딩 방식을 지정했다. -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- 2. jsp 주석 태그 -->
    <%-- HTML 주석은 클라이언트에 노출되지만 JSP 주석은 클라이언트에게 노출되지 않는다. --%>

    <!-- 3. 선언 태그 : 서블릿으로 변환 시 선언 태그 내에 작성한 내용을 필드로 선언한다. -->
    <%!
        private String name;
        private int age;
    %>

    <!-- 4. 스크립틀릿 태그-->
    <%
        // 간단한 자바 코드를 작성할 수 있는 부분이다.
        name = "홍길동";
        age = 20;

        System.out.println("name : " + name);
        System.out.println("age : " + age);


        /* 간단한 로직도 작성 가능하다. */
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }
    %>

    <!-- 5. expression 태그 : PrintWriter를 이용하여 브라우저에 값을 내보내 보여지게 한다. -->
    name : <%= name %> <br>
    age : <%= age %>
</body>
</html>
