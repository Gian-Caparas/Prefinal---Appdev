package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

import javax.naming.NameNotFoundException;

@Service                     // Business logic layer
public class StudentService {

    @Autowired               // Spring gives us the repository automatically
    StudentRepository repo;
    
    public StudentService(){} // default constructor

    // CREATE - add a new student
    public StudentEntity postStudent(StudentEntity student) {
        return repo.save(student);
    }

    // READ - get all students
    public List<StudentEntity> getAllStudents() {
        return repo.findAll();
    }

    // READ - get one student by id
    public StudentEntity getById(int id) {
        return repo.findById(id).orElse(null);   // null if not found
    }

    // UPDATE - change an existing student
    public StudentEntity putStudent(int id, StudentEntity newStudentDetails) {
        StudentEntity student = new StudentEntity();
        try{
            student = repo.findById(id).get();
            student.setName(newStudentDetails.getName);
            student.setCourse(newStudentDetails.getCourse);
        }catch (NoSuchElementException ex){
            throw new  NameNotFoundException("Student: " + id + "does now exist!");
        }finally{
            return repo.save(student); // at table student in database
        }
    }

    // DELETE - remove a student
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}