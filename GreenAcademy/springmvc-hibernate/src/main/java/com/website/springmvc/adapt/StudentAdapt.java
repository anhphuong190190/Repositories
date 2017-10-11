package com.website.springmvc.adapt;

import java.util.ArrayList;
import java.util.List;

import com.website.springmvc.entities.Student;
import com.website.springmvc.model.StudentModel;

public class StudentAdapt {
	public static List<Student> build(List<StudentModel> models) {
		List<Student> students = new ArrayList<Student>();
		for (StudentModel model : models) {
			students.add(build(model));
		}
		return students;
	}

	public static Student build(StudentModel model) {
		Student student = new Student();
		return student;
	}

	public static List<StudentModel> adapt(List<Student> students) {
		List<StudentModel> result = new ArrayList<StudentModel>();
		for (Student student : students) {
			result.add(adapt(student));
		}
		return result;
	}

	public static StudentModel adapt(Student student) {
		StudentModel model = new StudentModel();
		return model;
	}
}
