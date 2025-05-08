package com.crud.service;

import com.crud.model.Employee;
import com.crud.model.EmployeeDTO;
import com.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// 5
// Service Implementation Layer consist of business logic. It also consists of logic
// of conversion of Entity (Employee) to Java Record (EmployeeDTO) and vice-versa to keep
// Controller class clean and focus only on handling HTTP requests.

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    /*@Autowired
    private EmployeeRepository employeeRepository;*/

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployee()
    {
        return employeeRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id)
    {
        return employeeRepository.findById(id).map(this::convertToDTO);

    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO)
    {
        Employee employee = convertToEmployee(employeeDTO);
        Employee savedEmployee =  employeeRepository.save(employee);
        return convertToDTO(savedEmployee);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setFirstName(employeeDTO.firstName());
        employee.setLastName(employeeDTO.lastName());
        employee.setEmail(employeeDTO.email());
        Employee updateEmployee = employeeRepository.save(employee);
        return convertToDTO(updateEmployee);
    }

    public void deleteById(Long id)
    {
        employeeRepository.deleteById(id);
    }

    /*public void deleteMultipleByIds(Long id)
    {
        employeeRepository.deleteById(id);
    }*/



    private EmployeeDTO convertToDTO(Employee employee)
    {
        return new EmployeeDTO(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail());
    }

    private Employee convertToEmployee(EmployeeDTO employeeDTO)
    {
        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.firstName());
        employee.setLastName(employeeDTO.lastName());
        employee.setEmail(employeeDTO.email());
        return employee;
    }


}
