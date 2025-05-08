package com.crud.service;

import com.crud.model.Employee;
import com.crud.model.EmployeeDTO;

import java.util.List;
import java.util.Optional;

// 4
// Service Layer consist of business logic

public interface EmployeeService
{
    List<EmployeeDTO> getAllEmployee();
    Optional<EmployeeDTO> getEmployeeById(Long id);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(Long id,EmployeeDTO employeeDTO);
    void deleteById(Long id);
   // void deleteMultipleByIds(Long id);

}
