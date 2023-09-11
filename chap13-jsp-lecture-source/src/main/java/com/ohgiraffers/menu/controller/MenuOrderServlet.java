package com.ohgiraffers.menu.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 1. 요청에 대한 처리(값 추출, 검증 등) */
        request.setCharacterEncoding("UTF-8");

        String menuName = request.getParameter("menuName");
        int amount = Integer.parseInt(request.getParameter("amount"));

        /* 2. 비즈니스 로직 처리(대부분 DB에 CRUD 연산을 이용해 이루어짐) */
        int orderPrice = 0;

        switch (menuName) {
            case "햄버거" : orderPrice = 6000 * amount; break;
            case "짜장면" : orderPrice = 7000 * amount; break;
            case "짬뽕" : orderPrice = 8000 * amount; break;
            case "순대국" : orderPrice = 5000 * amount; break;
        }

        /* 3. 응답 페이지 생성 후 응답
        * 직접 문자열로 페이지를 생성한 뒤 스트림으로 내보낼 수도 있지만,
        * 페이지 작성이 용이하고 응답을 보여주는 view의 역할을 구분하여 만든 JSP를 활용한다. */

        request.setAttribute("menuName", menuName);
        request.setAttribute("amount", amount);
        request.setAttribute("orderPrice", orderPrice);

        /* 응답 페이지의 역할을 할 JSP로 위임하는 코드 */
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(request, response);
    }
}
