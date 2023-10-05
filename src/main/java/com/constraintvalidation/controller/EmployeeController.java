package com.constraintvalidation.controller;

import com.constraintvalidation.model.Employee;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/employee/")
public class EmployeeController {

    List<Employee> employeeList = new ArrayList<>();

    @GetMapping("check-server")
    public String testServer() {
        return "Server is up . . . ";
    }

    @PostMapping("add")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        Set<ConstraintViolation<Employee>> v = Validation
                .buildDefaultValidatorFactory().getValidator().validate(employee);

        v.forEach(violation -> System.out.println(violation.getMessage()));
        employeeList.add(employee);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping("all-employees")
    public ResponseEntity<List<Employee>> addEmployee() {
        return new ResponseEntity<>(employeeList, HttpStatusCode.valueOf(200));
    }

}
