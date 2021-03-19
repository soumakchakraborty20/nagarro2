package com.nagarro.hrmanager.controller;

import java.util.List;
import java.util.Optional;
 

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.hrmanager.entity.Employee;
import com.nagarro.hrmanager.service.EmployeeService;


 
@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
 
    // For Fetching All Employee
    @GetMapping("/employeeList")
    public ResponseEntity<List<Employee>> getAllEmployee(){
    	List<Employee> employee = this.employeeService.allEmployee();
        return ResponseEntity.of(Optional.of(employee));
    }
 
    // For Save an employee
    @PostMapping("/saveEmployee")
    public void  saveEmployee(@RequestBody Employee empdata ) {
        System.out.println("saved");
        this.employeeService.saveEmployee(empdata);
    }
 
    // For Delete an particular Employee data
    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable("empId") int empId) {
        this.employeeService.deleteEmployeeById(empId);
        System.out.println("deleted");
    }
 
    // For Updating The particular Employee
    @PutMapping("/showFormForUpdate/{id}")
    public Employee updateEmployee(@RequestBody Employee empData , @PathVariable("empId") int empId){
        this.employeeService.updateEmployee(empData,empId);
        System.out.println("Updated");
        return empData;
        
    }
 
}