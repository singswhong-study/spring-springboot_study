package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CourseCommmandLineRunner implements CommandLineRunner {

    private CourseJdbcRepository courseJdbcRepository;

    private CourseJpaRepository courseJpaRepository;

    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    public CourseCommmandLineRunner(CourseJdbcRepository courseJdbcRepository,
                                    CourseJpaRepository courseJpaRepository,
                                    CourseSpringDataJpaRepository courseSpringDataJpaRepository){
        this.courseJdbcRepository = courseJdbcRepository;
        this.courseJpaRepository = courseJpaRepository;
        this.courseSpringDataJpaRepository = courseSpringDataJpaRepository;
    }

    //어플리케이션 시작시에 실행 될 SQL이 있을때 사용
    @Override
    public void run(String... args) throws Exception {
        System.out.println("======== START QUERY EXECUTE ========");
        //JDBC template 사용
//        courseJdbcRepository.insert(new Course(1, "Learn AWS", "in28minutes"));
//        System.out.println(courseJdbcRepository.findById(1));


        //JPA 사용
//        courseJpaRepository.deleteById(1);
//        courseJpaRepository.insert(new Course(1, "Learn JPA", "in28minutes"));
//        System.out.println(courseJpaRepository.findById(1));

        //spring data jpa 사용
//        courseSpringDataJpaRepository.deleteById(1L);
//        courseSpringDataJpaRepository.save(new Course(1, "Learn SPRING DATA JPA", "in28minutes"));
//        System.out.println(courseSpringDataJpaRepository.findById(1L));
        System.out.println(courseSpringDataJpaRepository.findAll());
        System.out.println(courseSpringDataJpaRepository.count());
        System.out.println(courseSpringDataJpaRepository.findByAuthor("in28minutes"));

    }
}
