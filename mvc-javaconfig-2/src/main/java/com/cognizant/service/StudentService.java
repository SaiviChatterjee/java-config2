package com.cognizant.service;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentService {
	public Boolean insert(Student student);
	public List<Student> getAll();
	public Student getStudent(int id);
	public Boolean update(int id, String name, int marks);
	public Boolean delete(int id);
}
