package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController                  // Handles web requests, returns JSON
@RequestMapping("/students")     // Base URL: /students
public class StudentController {

    @Autowired
    private StudentService service;

    // CREATE -> POST /students
    @PostMapping
    public Student create(@RequestBody Student student) {   // @RequestBody = data from JSON
        return service.create(student);
    }

    // READ ALL -> GET /students
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    // READ ONE -> GET /students/1
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {         // @PathVariable = id from URL
        return service.getById(id);
    }

    // UPDATE -> PUT /students/1
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return service.update(id, student);
    }

    // DELETE -> DELETE /students/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Student deleted";
    }
}