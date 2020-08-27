package com.demo.springBootREST.dao;

import com.demo.springBootREST.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

//// EntityManager using native JPA API (Vendor independent)
@Repository
public class EmployeeDAOJpaImplementation implements EmployeeDAO {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee employee1 = entityManager.merge(employee);
        employee.setId(employee1.getId());
    }

    @Override
    public void removeEmployee(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
