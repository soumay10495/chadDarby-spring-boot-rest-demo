package com.demo.springBootREST.service;

import com.demo.springBootREST.dao.EmployeeDAO;
import com.demo.springBootREST.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Service making use of Hibernate/JPA DAO implementation (using Qualifier)
@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    @Qualifier("employeeDAOJpaImplementation")
    EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void removeEmployee(int id) {
        employeeDAO.removeEmployee(id);
    }
}
