package com.ohgiraffers.mvc.employee.model.dao;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeMapper {
    EmployeeDTO selectOneEmpById(String empId);

    List<EmployeeDTO> selectAllEmp();

    int insertEmp(EmployeeDTO emp);

    int updateEmp(EmployeeDTO emp);

    int deleteEmp(String empId);
}
