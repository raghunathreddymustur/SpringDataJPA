package com.spring.jpa.demospringjpa.repo;

import java.util.List;

import javax.persistence.EntityManager;

import com.spring.jpa.demospringjpa.entites.Course;
import com.spring.jpa.demospringjpa.entites.Review;

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
    public void addReviewForCourseHardcoded()
    {
        Course course=findById(8L);
        logger.info("course get Review-->{}",course.getReviews());

       Review r1=new Review("6","Very good");
        Review r2=new Review("5","Not Very good");

       course.addReview(r1);
       r1.setCourse(course);

        course.addReview(r2);
        r2.setCourse(course);

       em.persist(r1);
        em.persist(r2);
        logger.info("course get Review-->{}",course.getReviews());
        
    }

    public void addReviewForCourseGeneric(Long cId,List<Review> reviews)
    {
        Course course=findById(cId);
        for(Review r:reviews)
        {
            course.addReview(r);
            r.setCourse(course);
            em.persist(r);
        }
    }
}
