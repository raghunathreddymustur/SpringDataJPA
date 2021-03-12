package com.spring.jpa.demospringjpa.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class  Passport{
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String course;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passportId")
    private Student student;

    protected Passport()
    {

    }
    
    public Long getId()
    {
        return id;
    }
    @Override
    public String toString() {
        return "Passport [passport=" + course + ", id=" + id + "]";
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    

}
