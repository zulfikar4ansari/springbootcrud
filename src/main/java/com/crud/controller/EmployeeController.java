package com.crud.controller;

import com.crud.model.Employee;
import com.crud.model.EmployeeDTO;
import com.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//6
// Controller class is to expose the REST APIs:
// The controller does not handle business logic; instead, it delegates
// everything to the service, making the code cleaner and more maintainable.

@RestController
public class EmployeeController
{
    /*@Autowired
    EmployeeService employeeService;*/

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees()
    {
        return employeeService.getAllEmployee();
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id)
    {
       Optional<EmployeeDTO> employee= employeeService.getEmployeeById(id);
       return employee.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/saveEmployee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        return employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO)
    {
        try
        {
         EmployeeDTO updateEmployee =   employeeService.updateEmployee(id, employeeDTO);
         return ResponseEntity.ok().body(updateEmployee);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(employeeDTO);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id)
    {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
