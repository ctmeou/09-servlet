package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/* Service로 updateEmp 메소드 호출하여 결과 반환 받고
 * 수정 완료 시 Employee 목록을 조회하는 화면으로 처리 */

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String empId = request.getParameter("empId");
        String empName = request.getParameter("empName");

        EmployeeDTO emp = new EmployeeDTO();
        emp.setEmpId(empId);
        emp.setEmpName(empName);

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.updateEmp(emp);

        if(result > 0) {
            response.sendRedirect(request.getContextPath() + "/employee/list");
        } else {
            request.setAttribute("message", "직원 정보 수정에 실패하였습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }

    }

}