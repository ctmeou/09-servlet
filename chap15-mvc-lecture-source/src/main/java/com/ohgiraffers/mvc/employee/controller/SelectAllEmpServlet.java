package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeService employeeService = new EmployeeService();
        List<EmployeeDTO> empList = employeeService.selectAllEmp();

        String path = "";
        if (empList != null && !empList.isEmpty()) {
            path = "/WEB-INF/views/employee/employeeList.jsp";
            request.setAttribute("empList", empList);
        } else {
            path = "WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "직원 전체 목록이 조회되지 않았습니다.");
        }

        request.getRequestDispatcher(path).forward(request, response);

    }
}
