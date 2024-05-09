package com.cts.employee.controller;

import com.cts.employee.exception.NoRecordsException;
import com.cts.employee.model.Employee;
import com.cts.employee.service.EmployeeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @SneakyThrows
    @GetMapping(value = "/EmployeeDetails")  //Rest End point
    public List<Employee> employeeDetails(){
            return employeeService.employeeDetails();
    }

    @SneakyThrows
    @GetMapping(value = "/EmployeeDetail/{id}") // Rest end point
    public Employee employeeDetail(@PathVariable int id) {
            return employeeService.employeeDetail(id);
    }

    @PostMapping(value = "/RegisterEmployee")  //client end point
    public boolean registerEmployee(@RequestBody Employee employee){
        return employeeService.registerEmployee(employee);
    }

    @DeleteMapping(value = "/deleteEmployee/{id}")  //client end point
    public boolean deleteEmployee(@PathVariable long id){
        return employeeService.deleteEmployee(id);
    }

}
