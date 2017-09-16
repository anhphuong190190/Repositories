package com.website.hibernate.annotation.main;

import java.util.ArrayList;

import org.hibernate.Session;

import com.website.hibernate.annotation.entities.Address;
import com.website.hibernate.annotation.entities.Course;
import com.website.hibernate.annotation.entities.HomeWork;
import com.website.hibernate.annotation.entities.Student;
import com.website.hibernate.annotation.persistence.HibernateUtil;

public class Test {

	public static Address buildAddres(String street, String district, String city) {
		Address address = new Address();
		address.setStreet(street);
		address.setDistrict(district);
		address.setCity(city);
		return address;
	}

	public static Course buildCourse(String name) {
		Course course = new Course();
		course.setCourseName(name);
		return course;
	}

	public static HomeWork buildHomeWork(String name, Course course) {
		HomeWork homeWork = new HomeWork();
		homeWork.setName(name);
		homeWork.setCourse(course);
		return homeWork;
	}

	public static Student buildStudent(String fname, String lname, Integer age, Address address, Course... courses) {
		Student student = new Student();
		student.setFirstName(fname);
		student.setLastName(lname);
		student.setAge(age);
		student.setAddress(address);
		student.setCourses(new ArrayList<Course>());
		for (Course course : courses) {
			student.getCourses().add(course);
		}
		return student;
	}

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Address address = buildAddres("Nguyen Thi Minh Khai", "1", "HCM");
		Address address2 = buildAddres("Dinh Tien Hoang", "1", "HCM");

		Course course = buildCourse("Java");
		session.save(course);
		Course course2 = buildCourse("Spring");
		session.save(course2);
		Course course3 = buildCourse("Hibernate");
		session.save(course3);
		Course course4 = buildCourse("JQuery");
		session.save(course4);

		HomeWork homeWork = buildHomeWork("Basic-Java", course);
		course.getHomeworks().add(homeWork);
		session.save(homeWork);

		HomeWork homeWork2 = buildHomeWork("Advance-Java", course);
		course.getHomeworks().add(homeWork2);
		session.save(homeWork2);

		HomeWork homeWork3 = buildHomeWork("SpringMVC", course2);
		course2.getHomeworks().add(homeWork3);
		session.save(homeWork3);

		HomeWork homeWork4 = buildHomeWork("SpringSecurity", course2);
		course2.getHomeworks().add(homeWork4);
		session.save(homeWork4);

		HomeWork homeWork5 = buildHomeWork("ORM", course3);
		course3.getHomeworks().add(homeWork5);
		session.save(homeWork5);

		Student student = buildStudent("Phuong", "Mai", 29, address, course, course2, course3, course4);
		Student student2 = buildStudent("An", "Tran", 29, address2, course2, course3);

		session.save(student);
		session.save(student2);
		session.getTransaction().commit();
		System.out.println("Done");
	}
}
