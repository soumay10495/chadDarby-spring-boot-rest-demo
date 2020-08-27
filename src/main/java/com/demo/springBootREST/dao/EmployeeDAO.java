package com.demo.springBootREST.dao;

import com.demo.springBootREST.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getEmployees();

    public Employee getEmployee(int id);

    public void saveEmployee(Employee employee);

    public void removeEmployee(int id);
}
