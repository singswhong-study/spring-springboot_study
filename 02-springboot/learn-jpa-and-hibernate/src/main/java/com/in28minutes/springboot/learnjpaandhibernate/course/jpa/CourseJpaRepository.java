package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insert(Course course){
        entityManager.persist(course);
        //upsert용도로 쓴다면 merger()
    }

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    @Transactional
    public void deleteById(long id){
        Course c = entityManager.find(Course.class, id);
        entityManager.remove(c);
    }

}
