package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private JdbcTemplate springJdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate springJdbcTemplate){
        this.springJdbcTemplate = springJdbcTemplate;
    }

    private static String INSERT_QUERY =
            """ 
                insert into course (id, name, author) values (?, ?, ?)
            """;

    private static String SELET_QUERY =
            """
                select * from course where id = ?
            """;


    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public Course findById(long id){
        return springJdbcTemplate.queryForObject(SELET_QUERY, new BeanPropertyRowMapper<>(Course.class),id);
    }
}
