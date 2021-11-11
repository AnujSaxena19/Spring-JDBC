package com.GL.SpringJDBC.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.GL.SpringJDBC.entities.Student;

@Component("studentdao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//insert operation
	public int insert(Student student) {
		String query="insert into student(id,name,city)values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	//update operation
	public int update(Student student) {
		String query="update student set name=?, city=? where id=?";
		int res=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return res;
	}
	
	//delete operation
	public int delete(int studentId) {
		String query="delete from student where id=?";
		int res=this.jdbcTemplate.update(query,studentId);
		
		return res;
	}
	
	//selecting single data
	public Student getStudent(int studentId) {
		String query="Select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return student;
	}
	
	//selecting multiple records
	public List<Student> getAllStudent() {
		String query="Select * from student";
		List<Student> student=this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	




}
