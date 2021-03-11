package com.spring.jpa.demospringjpa.repo;
import static org.junit.Assert.assertEquals;

import com.spring.jpa.demospringjpa.entites.Course;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;
    @Test
	void contextLoads() {
        Course course=courseRepository.findById(1003L);
        assertEquals("learn very slowly",course.getName());
    }
    @Test
    void findById()
    {
        Course course=courseRepository.findById(1003L);
        assertEquals("learn very slowly",course.getName());
    }
}
