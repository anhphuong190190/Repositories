package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.springmvc.dao.Dao;
import com.website.springmvc.entities.Student;

@Service
public class StudentService {
	@Autowired
	Dao<Student> studentDao;

	public List<Student> get() {
		return studentDao.get();
	}

	public Student get(Long id) {
		return studentDao.get(id);
	}

	public Student add(Student student) {
		return studentDao.add(student);
	}

	public Boolean update(Student student) {
		return studentDao.update(student);
	}

	public Boolean delete(Student student) {
		return studentDao.delete(student);
	}
}
