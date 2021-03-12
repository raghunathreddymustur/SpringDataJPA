package com.spring.jpa.demospringjpa.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String course;
    
     @OneToOne(fetch = FetchType.LAZY)
    private Passport passportId;

    protected Student()
    {

    }
    
    public Long getId()
    {
        return id;
    }
    @Override
    public String toString() {
        return "Student [course=" + course + ", id=" + id +", Passport_Id "+passportId+"]";
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student(String course,Passport passportId) {
        this.course = course;
        this.passportId=passportId;
    }

    public Passport getPassportId() {
        return passportId;
    }

    public void setPassportId(Passport passportId) {
        this.passportId = passportId;
    }
    

}
