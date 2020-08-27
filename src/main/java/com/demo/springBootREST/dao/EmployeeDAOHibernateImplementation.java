package com.demo.springBootREST.dao;

import com.demo.springBootREST.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

// EntityManager using native Hibernate API (Vendor specific)
@Repository
public class EmployeeDAOHibernateImplementation implements EmployeeDAO {
    EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {
        Session session = entityManager.unwrap(Session.class);

        //Using Hibernate Native API
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void removeEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = getEmployee(id);
        session.delete(employee);
    }
}
