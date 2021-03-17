package com.spring.jpa.demospringjpa.entites;

import com.spring.jpa.demospringjpa.entites.Review;



import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews=new ArrayList<>();


    @ManyToMany(mappedBy = "courses")
    private List<Student> students=new ArrayList<>();

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

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review) ;
    }
    public void removeReview(Review review) {
        this.reviews.remove(review) ;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
    public void removeStudent(Student student) {
        this.students.remove(student);
    }

}
