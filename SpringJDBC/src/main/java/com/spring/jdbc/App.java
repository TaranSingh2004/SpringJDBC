package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Program started...................");

        //spring jdbc -->> JdbcTemplate
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);

        //insert
        //        Student student = new Student();
        //        student.setId(004);
        //        student.setName("Utkarsh");
        //        student.setCity("fbd");
        //        int result = studentDao.insert(student);
        //        System.out.println("number of rows inserted: "+ result);

        //Update
//        Student student = new Student();
//        student.setId(004);
//        student.setName("Utkarsh");
//        student.setCity("fbd");
//        int result = studentDao.change(student);
//        System.out.println("data changed : "+ result);


//        delete
//        int result = studentDao.delete(004);
//        System.out.println("deleted : " + result);

//        select
//        Student student=studentDao.getStudent(002);
//        System.out.println(student);

        //select all
        List<Student> students = studentDao.getAllStudent();
        for (Student s:students
             ) {
            System.out.println(s);
        }
    }
}
