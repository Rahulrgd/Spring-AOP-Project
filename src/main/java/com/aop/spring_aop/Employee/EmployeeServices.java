package com.aop.spring_aop.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository repository;

    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Object getAllEmployee() {
        return repository.findAll();
    }

    public Object getEmployeeWithID(Integer id) {
        return repository.findById(id);
    }

    public void deleteEmployeeWithId(Integer id) {
        Employee employee = (Employee) getEmployeeWithID(id);
        repository.delete(employee);
    }
    
}
