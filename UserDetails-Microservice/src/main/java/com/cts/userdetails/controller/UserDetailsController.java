package com.cts.userdetails.controller;

import com.cts.userdetails.model.Login;
import com.cts.userdetails.model.Role;
import com.cts.userdetails.model.SuccessResponse;
import com.cts.userdetails.model.User;
import com.cts.userdetails.service.UserDetailsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@CrossOrigin("*")
public class UserDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    @SneakyThrows
    @PostMapping(value = "/RegisterUser")
    public String registerUser(@Valid @RequestBody User user){
            return userDetailsService.registerUser(user);
    }

    @SneakyThrows
    @PostMapping(value = "/UpdateUser")
    public SuccessResponse updateUser(@RequestBody User user){
            return userDetailsService.updateUser(user);
    }

    @SneakyThrows
    @DeleteMapping(value = "/deleteUser/{id}")
    public SuccessResponse deleteUser(@PathVariable long id){
            return userDetailsService.deleteUser(id);
    }

    @GetMapping(value = "/loadUserByName/{userName}")
    public Login loadUserByName(@PathVariable long userName){
        return userDetailsService.loadUserByName(userName);
    }
//    @GetMapping(value="/getRoleById/{id}")
//            public String getRoleById(@PathVariable long id){
//        return userDetailsService.getRole(id);
//    }

    @GetMapping(value = "/getRoleById/{id}") // Rest end point
    public Role userRole(@PathVariable long id) {
        return userDetailsService.userRoleById(id);
    }
    @GetMapping(value = "/getPasswordById/{id}") // Rest end point
    public SuccessResponse userPassword(@PathVariable long id) {
        return userDetailsService.userPasswordById(id);
    }




    // Exception Handler for model attributes (user) constraints
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,code=HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({MethodArgumentNotValidException.class,DataIntegrityViolationException.class})
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
