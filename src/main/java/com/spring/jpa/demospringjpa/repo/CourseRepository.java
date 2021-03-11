package com.spring.jpa.demospringjpa.repo;

import javax.persistence.EntityManager;

import com.spring.jpa.demospringjpa.entites.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;

    public Course findById(Long id)
    {
        return em.find(Course.class, id);
    }
    public void deleteById(Long id)
    {
        Course course=findById(id);
        em.remove(course);
    }
}
