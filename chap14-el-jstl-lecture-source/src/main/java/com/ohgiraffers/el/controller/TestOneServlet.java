package com.ohgiraffers.el.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test1")
public class TestOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("name", "홍길동");
        request.setAttribute("age", "19");
        request.setAttribute("phone", "010-1234-5678");

        List<String> items = new ArrayList<>();
        items.add(new String("apple"));
        items.add(new String("banana"));
        items.add(new String("melon"));

        request.setAttribute("items", items);

        RequestDispatcher rd = request.getRequestDispatcher("views/el/testEl1.jsp");
        rd.forward(request, response);
    }
}
