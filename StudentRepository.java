package com.example.demo.repository;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<Entity, TypeOfPrimaryKey>
// It already gives us save(), findAll(), findById(), deleteById()
// No need to write any SQL!
// JpaRepository is a specialized interface in Spring Data JPA that simplifies database interactions for Java applications. Instead of writing boilerplate SQL or implementation code, you simply create an interface that extends JpaRepository, and Spring Data JPA automatically provides ready-to-use methods to Create, Read, Update, and Delete (CRUD) data.
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}