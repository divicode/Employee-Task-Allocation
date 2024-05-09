package com.cts.userdetails.service;

import com.cts.userdetails.exception.EmptyDataAccessException;
import com.cts.userdetails.feign.EmployeeClient;
import com.cts.userdetails.model.*;
import com.cts.userdetails.repository.RoleDao;
import com.cts.userdetails.repository.UserDetailsDao;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.metamodel.SingularAttribute;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsDao repo;

    @Autowired
    private EmployeeClient employeeClient;
    @Autowired
    private RoleDao roleRep;
    @Autowired
    private SuccessResponse successResponse;
    @Transactional    public String registerUser(User user){
        if(user==null){
            throw new NullPointerException("Object is null");
        }

        // Insert the data into employee table
        Employee employee=new Employee();
        employee.setId(user.getId());
        employee.setFirstName(user.getFirstName());
        employee.setLastName(user.getLastName());
        employee.setEmail(user.getEmail());
        try {
            repo.save(user);
            employeeClient.registerEmployee(employee);
        }catch (Exception e){return "User is not registered...Try again..";}

        return "User is registered successfully.";

    }

    @SneakyThrows
    public SuccessResponse updateUser(User newUser){            //updating old data with new data

        User existingUser=repo.findById(newUser.getId()).orElseThrow(new EmptyDataAccessException("User data is not Found"));
        Employee existingEmployee=employeeClient.employeeDetail(newUser.getId());

        existingUser.setFirstName(newUser.getFirstName());
        existingUser.setLastName(newUser.getLastName());
        existingUser.setPassword(newUser.getPassword());
//        existingUser.setRoles(newUser.getRoles());
        existingUser.setEmail(newUser.getEmail());

        existingEmployee.setFirstName(newUser.getFirstName());
        existingEmployee.setLastName(newUser.getLastName());
        existingEmployee.setEmail(newUser.getEmail());

        employeeClient.registerEmployee(existingEmployee);
        repo.save(existingUser);
        successResponse.setMessage("Updated");
        successResponse.setTimestamp(new Date());
        return successResponse;


    }

    public SuccessResponse deleteUser(long id){
        employeeClient.deleteEmployee(id);
        repo.deleteById(id);
        successResponse.setMessage("User is deleted successfully");
        successResponse.setTimestamp(new Date());
        return successResponse;
    }

    public Login loadUserByName(long userName){
        User user=repo.getReferenceById(userName);
        return new Login(user.getId(),user.getPassword());
    }


//    public String getRole(long id) {
//        String
//        String roleName = repo.getRoleName(role_id);
//        return roleName;
//
//    }



    public User userDetail(long id) {
        User emp=repo.getReferenceById( id);
        return emp;
    }

    public Role userRoleById(long id) {
        User emp=repo.getReferenceById( id);
        List<Role> roles= emp.getRoles();
        Role[] myArray = new Role[roles.size()];
        roles.toArray(myArray);
        return myArray[0];
    }

    public SuccessResponse userPasswordById(long id) {
        User emp=repo.getReferenceById( id);
        successResponse.setMessage(emp.getPassword());
        return successResponse;
    }
}
