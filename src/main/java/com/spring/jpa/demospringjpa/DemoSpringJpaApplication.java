package com.spring.jpa.demospringjpa;

import com.spring.jpa.demospringjpa.entites.Course;
import com.spring.jpa.demospringjpa.repo.CourseRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringJpaApplication implements CommandLineRunner{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Course course=courseRepository.findById(1001L);
		logger.info("Course details-->{}",course);

		courseRepository.deleteById(1002L);
	}

}
