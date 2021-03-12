package com.spring.jpa.demospringjpa.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class  Passport{
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String course;

    protected Passport()
    {

    }
    
    public Long getId()
    {
        return id;
    }
    @Override
    public String toString() {
        return "Student [course=" + course + ", id=" + id + "]";
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Passport(String course) {
        this.course = course;
    }
    

}
