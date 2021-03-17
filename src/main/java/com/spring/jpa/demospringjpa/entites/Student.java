package com.spring.jpa.demospringjpa.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
    joinColumns = @JoinColumn(name="STUDENT_ID"),
    inverseJoinColumns = @JoinColumn(name="COURSE_ID")
    )
    private List<Course> courses=new ArrayList<>();

    
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

    public Student(String course) {
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

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
    
    public void removeCourse(Course course) {
        this.courses.remove(course);
    }
    

}
