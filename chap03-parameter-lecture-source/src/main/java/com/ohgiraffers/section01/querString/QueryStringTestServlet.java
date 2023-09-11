package com.ohgiraffers.section01.querString;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    /* 톰캣 서블릿 컨테이너가 요청 url로 매핑된 Servlet 클래스의 인스턴스를 생성하여, service 메소드를 호출하고,
    * HttpServlet을 상속 받아 오버라이딩한 현재 클래스의 doGet 메소드가 동적 바인딩에 의해 호출된다. */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* HttpServletRequest 객체로부터 요청 시 전달한 값을 getParameter 메소드로 추출해올 수 있다.
        * 이 때 인자로 input 태그에 지정한 name 속성 값을 문자열 형태로 전달한다.
        * 모든 input 태그의 값을 HashMap으로 관리하고 있으므로 원하는 값을 찾기 위해서는 key 역할을 하는 문자열이 필요하기 때문이다. */
        String name = request.getParameter("name");
        System.out.println("이름: " + name);

        /* getParameter는 return 타입인 문자열이다. 즉, 숫자를 전달해도 문자열 형태로 전달이 되므로
        * 숫자 형식의 값이 필요하다면 검증 후 parsing을 한다. */
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("나이 : " + age);

        /* java.sql.Date 타입으로 저장하고 싶은 경우에도 전달된 parameter를 Date type으로 변환해야 한다. */
        java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
        System.out.println("생일 : " + birthday);

        /* 라디오버튼으로 전달된 값은 여러 값 중 선택한 하나의 값만 전달되믜로 parameter로 전달된 값을 꺼내기만 하면 된다. */
        String gender = request.getParameter("gender");
        System.out.println("성별 : " + gender);

        /* 셀레트박스를 이용한 방식도 라디오버튼 방식과 유사하다. */
        String national = request.getParameter("national");
        System.out.println("국적 : " + national);

        /* checkbox는 다중으로 입력을 받을 수 있으므로 선택된 값이 문자열 배열로 전달된다.
         * getParameterValues 메소드를 이용하여 문자열 배열 형태로 값을 반환 받는다. */
        String[] hobbies = request.getParameterValues("hobbies");

        System.out.print("취미 : ");
        for (String hobby : hobbies) {
            System.out.print(hobby + " ");
        }
    }
}
