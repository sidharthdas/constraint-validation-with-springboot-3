package com.constraintvalidation.controller;

import com.constraintvalidation.model.School;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("school/")
public class SchoolController {

    List<School> schoolList = new ArrayList<>();

    @GetMapping("check-server")
    public String checkServer() {
        return "Server is up . . .";
    }

    @GetMapping("all-school")
    public List<School> getAllSchool() {
        return schoolList;
    }

    @PostMapping("add-school")
    public List<School> addSchool(@RequestBody @Valid School school) {
        schoolList.add(school);
        return schoolList;
    }

}
