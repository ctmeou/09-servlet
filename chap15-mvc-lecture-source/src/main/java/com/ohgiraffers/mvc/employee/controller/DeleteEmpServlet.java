package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
/* Service로 deleteEmp 메소드 호출하여 결과 반환 받고
 * 삭제 완료 시 Employee 목록을 조회하는 화면으로 처리 */

@WebServlet("/employee/delete")
public class DeleteEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String empId = request.getParameter("empId");

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.deleteEmp(empId);

        if(result > 0) {
            response.sendRedirect(request.getContextPath() + "/employee/list");
        } else {
            request.setAttribute("message", "직원 정보 삭제에 실패하였습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }

    }

}