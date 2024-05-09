package com.cts.employee.service;

import com.cts.employee.exception.NoRecordsException;
import com.cts.employee.model.Employee;
import com.cts.employee.repository.EmployeeDao;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao repo;
    public List<Employee> employeeDetails() throws NoRecordsException {
        List<Employee> empList=repo.findAll();
         if(empList.isEmpty()){
             throw new NoRecordsException("No Employee Records found");
         }
         return empList;
    }

    public Employee employeeDetail(long id) throws NoRecordsException {
        Employee emp=repo.getReferenceById(id);
        if(!repo.existsById(id)){
            throw new NoRecordsException("No Record is found with id "+id);
        }
        return emp;
    }
    @SneakyThrows
    @Transactional
    public boolean registerEmployee(Employee employee){
        if(employee==null){
            throw new NullPointerException("Object is null");
        }
        try{
            repo.save(employee);
        }catch (Exception e){
            throw new Exception("Invalid data");
        }
        return true;
    }

    @SneakyThrows
    public boolean deleteEmployee(long id){
        try {
            repo.deleteById(id);
        }catch (Exception e){
            throw new Exception("The Record is not presented with id : "+id);
        }
        return true;
    }


}
