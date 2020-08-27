package com.demo.springBootREST.rest;

import com.demo.springBootREST.entity.Employee;
import com.demo.springBootREST.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//REST controller using either of two service implementations (using Qualifier)
@RestController
@RequestMapping("/api")
public class EmployeeRESTController {
    @Autowired
    @Qualifier("employeeServiceSpringImplementation")
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null)
            throw new RuntimeException("Employee with ID : " + id + " not found");
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String removeEmployee(@PathVariable int id) {
        if (getEmployee(id) == null)
            throw new RuntimeException("Employee with ID : " + id + " not found");
        employeeService.removeEmployee(id);
        return "Removed employee with ID : " + id;
    }
}
