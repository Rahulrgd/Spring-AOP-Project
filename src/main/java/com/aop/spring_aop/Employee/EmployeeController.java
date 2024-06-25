package com.aop.spring_aop.Employee;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class EmployeeController {

    // Create Employee
    @PostMapping("/create-employee")
    public String createEmployee(@RequestBody Employee employee) {
        return EmployeeServices.createEmployee(employee);
    }
    
    // Get All Employee
    @GetMapping("/all-employee")
    public void getAllEmployee() {
        return EmployeeServices.getAllEmployee();
    }
    
    // Get Employee with ID
    @GetMapping("/employee-with-id")
    public void getEmployeeWithID(@RequestParam Integer id) {
        return EmployeeServices.getEmployeeWithID(id);
    }
    
    // Delete Employee with ID
    @DeleteMapping("/delete-employee-with-id")
    public void deleteEmployeeWithId(@RequestParam Integer id){
        return EmployeeServices.deleteEmployeeWithId(id);
    }
}
