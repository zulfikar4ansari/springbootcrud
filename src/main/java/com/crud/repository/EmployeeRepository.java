package com.crud.repository;

import com.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// 2
// JpaRepository: Provides all the necessary CRUD operations like save(), findAll(), findById(), and deleteById()
// and paging, sorting without needing to write them yourself.

// @Repository: Marks this interface as a Spring repository.

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long >
{
    List<Employee> id(Long id);
}
