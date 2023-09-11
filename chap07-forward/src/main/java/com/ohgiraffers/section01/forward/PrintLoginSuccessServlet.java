package com.ohgiraffers.section01.forward;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* forward된 서블릿에서도 요청 방식이 get이면 doGet, post이면 doPost를 호출한다.
        * foward할 때 전달한 request, response의 모든 정보를 이용해 새로운 request, response를
        * 깊은 복사를 통해 만들어서 전달하므로 데이터를 그대로 유지하고 있다. */

        String userId = (String) request.getAttribute("userId");

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(userId)
                .append("님 환영합니다.</h1>")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print(responseBuilder.toString());
        out.close();

        /* forward 방식을 통해 다른 서블릿으로 위임하더라도 데이터를 공유할 수 있다.
        * forward 동작을 클라이언트가 알 필요가 없으므로 url은 변경되지 않는다.
        * 새로고침(= 재요청)을 하게 되면 동일한 요청을 반복하게 되는데 이 때 데이터베이스에 insert하는 등의
        * 행위를 하게 되면 중복 행 삽입 가능성이 있다.
        * => 그 때는 redirect 방식이 필요하다. */
    }
}
