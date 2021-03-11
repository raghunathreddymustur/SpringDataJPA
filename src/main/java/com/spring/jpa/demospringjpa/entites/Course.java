package com.spring.jpa.demospringjpa.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    protected Course()
    {

    }
    
    public Long getId()
    {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + "]";
    }

    
}