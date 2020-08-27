package com.demo.springBootREST.dao;

import com.demo.springBootREST.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data JPA implementation (Minimal coding)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
