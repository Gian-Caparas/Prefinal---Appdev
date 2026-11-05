package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity                       // This class becomes a database table
public class StudentEntity {

    @Id                                                   // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Auto-increment
    private Long id;

    private String name;      // becomes a column
    private String course;    // becomes a column

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}