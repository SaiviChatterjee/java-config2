package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
@Qualifier("StudentDao")
public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setjdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public boolean insert(Student s) {
		int row = jdbcTemplate.update("INSERT INTO students VALUES(?, ?, ?)", s.getId(), s.getName(), s.getMarks());
		if (row > 0)
			return true;
		return false;
	}

	public boolean update(int id, String name, int marks) {
		int row = jdbcTemplate.update("UPDATE students SET name=?,marks=? WHERE id=?", name, marks, id);
		if (row > 0)
			return true;
		return false;
	}

	public boolean delete(int id) {
		int row = jdbcTemplate.update("DELETE FROM students where id=?", id);
		if (row > 0)
			return true;
		return false;
	}

	public List<Student> getAll() {
		List<Student> students = jdbcTemplate.query("SELECT * FROM students", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getInt("marks"));
				return student;
			}});
		return students;
	}
	public Student getStudent(int id) {
        String sql = "SELECT * FROM STUDENTS WHERE ID = ?";

        return (Student) jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Student(rs.getInt(1), rs.getString(2), rs.getInt(3)));
	}
	
}
