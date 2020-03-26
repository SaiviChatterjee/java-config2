package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	public Boolean insert(Student student) {
		try {
			return studentDao.insert(student);
		} catch (Exception e) {
			return false;
		}
	}

	public List<Student> getAll() {
		return studentDao.getAll();
	}

	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}

	public Boolean update(int id, String name, int marks) {
		try {
			return studentDao.update(id, name, marks);
		}catch(Exception e) {
			return false;
		}
	}

	public Boolean delete(int id) {
		try {
			return studentDao.delete(id);
		}catch(Exception e){
			return false;
		}
	}
}
