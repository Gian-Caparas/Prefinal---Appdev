package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController                  // Handles web requests, returns JSON
@RequestMapping("/student/api")    // Base URL: /students
public class StudentController {

    @Autowired
    StudentService service;

    public StudentController(){} // default constructor

    // CREATE -> POST /students
    @PostMapping ("/postNewStudent")
    public StudentEntity postStudent(@RequestBody StudentEntity student) {   // @RequestBody = data from JSON
        return service.postStudent(student);
    }

    // READ ALL -> GET /students
    @GetMapping ("/getAllStudents")
    public List<StudentEntity> getAllStudents() {
        return service.getAllStudents();
    }

    // READ ONE -> GET /students/1
    @GetMapping("/getStudent/{id}")
    public StudentEntity getById(@PathVariable int id) {         // @PathVariable = id from URL
        return service.getById(id);
    }

    // UPDATE -> PUT /students/1
    @PutMapping("/putStudent/{id}")
    public StudentEntity putStudent(@PathVariable int id, @RequestBody StudentEntity newStudentDetails) {
        return service.putStudent(id, newStudentDetails);
    }

    // DELETE -> DELETE /students/1
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Student deleted";
    }
}