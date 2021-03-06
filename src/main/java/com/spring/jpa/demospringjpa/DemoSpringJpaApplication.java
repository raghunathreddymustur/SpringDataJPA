package com.spring.jpa.demospringjpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.spring.jpa.demospringjpa.entites.Course;
import com.spring.jpa.demospringjpa.entites.Passport;
import com.spring.jpa.demospringjpa.entites.Review;
import com.spring.jpa.demospringjpa.entites.Student;
import com.spring.jpa.demospringjpa.repo.CourseRepository;
import com.spring.jpa.demospringjpa.repo.StudentRepo;

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

	@Autowired
	EntityManager em;

	@Autowired
	StudentRepo studentRepo;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//FindBy
		// TODO Auto-generated method stub
		// Course course=courseRepository.findById(1001L);
		// logger.info("Course details-->{}",course);

		//deleteBy
		// courseRepository.deleteById(1002L);

		//save
		// Course course=courseRepository.save(new Course("Spring raghu"));
		// logger.info("Course details-->{}",course);

		// Course course1=courseRepository.findById(1L);
		// course1.setName("updated Raghu");
		// course1=courseRepository.save(course1);
		// logger.info("Course details-->{}",course1);

		// Student student=studentRepo.findById(1L);
		// logger.info("Student------->{}", student);

		// studentRepo.save();

		// Passport pass=em.find(Passport.class, 15L);
		// logger.info("Pass---->{}",pass);
		// logger.info("Pass-Student----{}",pass.getStudent());

		// courseRepository.addReviewForCourseHardcoded();

		// List<Review> reviews=new ArrayList<>();
		// Review r1=new Review("6","Very good");
		// Review r2=new Review("5","Not Very good");
		// reviews.add(r1);
		// reviews.add(r2);

		// courseRepository.addReviewForCourseGeneric(7L, reviews);

		Student stu=new Student("Raghu");
		Course cou=new Course("Spring-jpa");
		courseRepository.insertStudentAndCourse(stu, cou);
		
	}

}
