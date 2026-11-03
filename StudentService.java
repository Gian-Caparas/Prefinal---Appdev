package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service                     // Business logic layer
public class StudentService {

    @Autowired               // Spring gives us the repository automatically
    private StudentRepository repo;

    // CREATE - add a new student
    public Student create(Student student) {
        return repo.save(student);
    }

    // READ - get all students
    public List<Student> getAll() {
        return repo.findAll();
    }

    // READ - get one student by id
    public Student getById(Long id) {
        return repo.findById(id).orElse(null);   // null if not found
    }

    // UPDATE - change an existing student
    public Student update(Long id, Student newData) {
        Student existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(newData.getName());
            existing.setCourse(newData.getCourse());
            return repo.save(existing);          // save() updates because id exists
        }
        return null;
    }

    // DELETE - remove a student
    public void delete(Long id) {
        repo.deleteById(id);
    }
}