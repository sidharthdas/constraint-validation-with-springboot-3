package com.constraintvalidation.controller;

import com.constraintvalidation.model.Data;
import com.constraintvalidation.model.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/student/")
public class StudentController {

    List<Student> studentList = new ArrayList<>();

    @GetMapping("check-server")
    public String testServer() {
        return "Server is up . . . ";
    }

    @PostMapping("add")
    public ResponseEntity<Void> addStudent(@Valid @RequestBody Student student) {
        studentList.add(student);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping("all-students")
    public ResponseEntity<List<Student>> addStudent() {
        return new ResponseEntity<>(studentList, HttpStatusCode.valueOf(200));
    }

    @GetMapping("check-problem")
    public ProblemDetail testProblem() {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(200), "");
        problemDetail.setProperty("sid1", "test1");
        problemDetail.setProperty("sid2", "test2");
        return problemDetail;
    }

    @GetMapping("get-data")
    public Data getData() {
        Data data = new Data();
        data.setName("sid");
        data.setAdd("add");
        data.setProperty("t1", "t2");

        return data;
    }
}
