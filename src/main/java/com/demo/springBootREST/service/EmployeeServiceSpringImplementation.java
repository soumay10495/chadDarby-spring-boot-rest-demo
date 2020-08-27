package com.demo.springBootREST.service;


import com.demo.springBootREST.dao.EmployeeRepository;
import com.demo.springBootREST.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service making use of Spring Data JPA (Minimal coding)
@Service
public class EmployeeServiceSpringImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        return result.get();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void removeEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
