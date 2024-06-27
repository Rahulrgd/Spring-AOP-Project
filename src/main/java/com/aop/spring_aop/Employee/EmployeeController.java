package com.aop.spring_aop.Employee;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;



@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices services;

    // Create Employee
    @PostMapping("/create-employee")
    public Employee createEmployee(@RequestBody Employee employee) throws Exception {
        return services.createEmployee(employee);
    }
    
    // Get All Employee
    @GetMapping("/all-employee")
    public Object getAllEmployee() {
        return services.getAllEmployee();
    }
    
    // Get Employee with ID
    @GetMapping("/employee-with-id")
    public Object getEmployeeWithID(@RequestParam Integer id) {
        return services.getEmployeeWithID(id);
    }
    
    // Delete Employee with ID
    @DeleteMapping("/delete-employee-with-id")
    public ResponseEntity<Object> deleteEmployeeWithId(@RequestParam Integer id){
        services.deleteEmployeeWithId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
