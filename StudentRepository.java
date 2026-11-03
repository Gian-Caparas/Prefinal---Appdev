package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity, TypeOfPrimaryKey>
// It already gives us save(), findAll(), findById(), deleteById()
// No need to write any SQL!
// JpaRepository is a specialized interface in Spring Data JPA that simplifies database interactions for Java applications. Instead of writing boilerplate SQL or implementation code, you simply create an interface that extends JpaRepository, and Spring Data JPA automatically provides ready-to-use methods to Create, Read, Update, and Delete (CRUD) data.
public interface StudentRepository extends JpaRepository<Student, Long> {
}