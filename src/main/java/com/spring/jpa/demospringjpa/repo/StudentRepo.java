package com.spring.jpa.demospringjpa.repo;


import javax.persistence.EntityManager;

import com.spring.jpa.demospringjpa.entites.Passport;
import com.spring.jpa.demospringjpa.entites.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepo {
    @Autowired
    EntityManager em;

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    public Student findById(Long id)
    {
        Student student=em.find(Student.class, id);
        return student;
    }
    public void deleteById(Long id)
    {
        Student student=findById(id);
        em.remove(student);
    }

 
    public Student save()
    {
        Passport passport=new Passport("1abc6465");
        em.persist(passport);
		Student stu=new Student("MVC",passport);
        em.persist(stu);
        
		logger.info("Student------->{}", stu);
        logger.info("Student pass---->{}",stu.getPassportId());
        // if(student.getId()==null)
        // {
        //     em.persist(student);
        // }
        // else
        // {
        //     em.merge(student);
        // }
        return stu;
    }
}
