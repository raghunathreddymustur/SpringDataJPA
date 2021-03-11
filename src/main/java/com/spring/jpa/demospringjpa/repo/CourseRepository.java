package com.spring.jpa.demospringjpa.repo;

import javax.persistence.EntityManager;

import com.spring.jpa.demospringjpa.entites.Course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;
    private Logger logger=LoggerFactory.getLogger(this.getClass());
    public Course findById(Long id)
    {
        return em.find(Course.class, id);
    }
    public void deleteById(Long id)
    {
        Course course=findById(id);
        em.remove(course);
    }
    public Course save(Course course)
    {
        if(course.getId()==null)
        {
            //logger.info("-----------------------------------------------NEW{}",course.getId());
            em.persist(course);
            //logger.info("-----------------------------------------------NEW>{}",course.getId());

        }
        else
        {
            //logger.info("-----------------------------------------------NEW{}",course.getId());
            em.merge(course);
            //logger.info("-----------------------------------------------NEW{}",course.getId());
        }
        return course;
    }
}
