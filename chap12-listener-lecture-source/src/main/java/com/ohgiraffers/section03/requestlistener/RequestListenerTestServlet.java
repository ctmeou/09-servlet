package com.ohgiraffers.section03.requestlistener;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* request에 attribute를 추가할 때 attributeAdded() 메소드가 동작한다. */
        request.setAttribute("username", "honggildong");
        request.setAttribute("age", 20);
        request.setAttribute("gender", "M");

        /* request에 attribute를 동일한 key로 덮어 쓰는 경우 (value 수정) attributeReplaced() 메소드가 동작한다. */
        request.setAttribute("username", "hong");

        /* request에 attribute를 제거할 때 attributeRemoved()가 동작한다. */
        request.removeAttribute("gender");

    }

}