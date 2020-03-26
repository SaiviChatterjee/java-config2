package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentDao {
	public boolean insert(Student s);
	public boolean update(int id,String name,int marks);
	public boolean delete(int id);
	public List<Student> getAll();
	public Student getStudent(int id);
}
