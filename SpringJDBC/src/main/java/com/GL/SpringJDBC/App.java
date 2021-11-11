package com.GL.SpringJDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.GL.SpringJDBC.dao.StudentDao;
import com.GL.SpringJDBC.entities.Student;


 
public class App 
{
	public static void main( String[] args )throws Exception
	{
		System.out.println( "First Spring jdbc program" );
		
		// spring jdbc => jdbcTemplate
		ApplicationContext ac=new AnnotationConfigApplicationContext(JDBCConfig.class);
		StudentDao sd=ac.getBean("studentdao",StudentDao.class);
		
		//
		//insert
		/*
		Student student=new Student();
		student.setId(50);
		student.setName("Vidit");
		student.setCity("Agra");
		
		int result=sd.insert(student);
		*/
		
		//update
		/*
		Student student=new Student();
		student.setId(45);
		student.setName("Abhishek Kumar");
		student.setCity("Balia");
		int result=sd.update(student);
		System.out.println("Data updated "+result);
		*/
		
		//delete
		/*
		int result=sd.delete(50);
		System.out.println("Data deleted "+result);
		*/
		
		//Select a single data
		/*
		Student student=sd.getStudent(45);
		System.out.println(student);
		*/
		
		//selecting muptiple records
		
		List<Student> student=sd.getAllStudent();	
		for(Student s:student) {
			System.out.println(s);
		}
	}
}
