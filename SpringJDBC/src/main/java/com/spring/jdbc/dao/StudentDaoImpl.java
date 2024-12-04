package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(Student student) {
        //inserting
        String query = "insert into student(id, name, city) values(?,?,?)";
        int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());

        return r;
    }

    public int change(Student student) {
        //updating
        String query = " update student set name=?, city=? where id =?";
        int r= this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return r;
    }

    public int delete(int studentId) {
        String query = "delete from student where id=?";
        int r= this.jdbcTemplate.update(query, studentId);
        return r;
    }

    public Student getStudent(int studentId) {
        String query = "select * from student where id =?";
        RowMapper<Student> rowmapper = new RowmapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowmapper, studentId);
        return student;
    }

    public List<Student> getAllStudent() {
        String query = "select * from student";
        List<Student> students=this.jdbcTemplate.query(query, new RowmapperImpl());
        return students;
    }
}
