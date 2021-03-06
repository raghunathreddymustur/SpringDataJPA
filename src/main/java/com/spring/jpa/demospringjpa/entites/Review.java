package com.spring.jpa.demospringjpa.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String rating;
    
    private String review;

    @ManyToOne
    private Course course;

    public Review(){}

    public Review(String rating, String review) {
        this.rating = rating;
        this.review = review;
    }
    public Long getId()
    {
        return id;
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", rating=" + rating + ", review=" + review + "]";
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
}
