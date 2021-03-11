package com.spring.jpa.demospringjpa.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.spring.jpa.demospringjpa.DemoSpringJpaApplication;
import com.spring.jpa.demospringjpa.entites.Course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoSpringJpaApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Test
	public void findById_basic() {
		Course course = repository.findById(3L);
		assertEquals("Spring raghu", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(4L);
		assertNull(repository.findById(4L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {

		// get a course
		Course course = repository.findById(5L);
		assertEquals("Spring raghu", course.getName());

		// update details
		course.setName("JPA in 50 Steps - Updated");

		repository.save(course);

		// check the value
		Course course1 = repository.findById(5L);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}

}