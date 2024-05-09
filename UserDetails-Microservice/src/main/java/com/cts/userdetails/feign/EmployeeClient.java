package com.cts.userdetails.feign;

import com.cts.userdetails.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Employee-Microservice", url = "localhost:8200/emp")
public interface EmployeeClient {
    @PostMapping(value = "/RegisterEmployee")
    public boolean registerEmployee(@RequestBody Employee employee);

    @DeleteMapping(value = "/deleteEmployee/{id}")
    public boolean deleteEmployee(@PathVariable long id);

    @GetMapping(value = "/EmployeeDetail/{id}") // Rest end point
    public Employee employeeDetail(@PathVariable long id);

    }
