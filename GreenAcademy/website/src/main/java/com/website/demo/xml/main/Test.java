package com.website.demo.xml.main;

import java.util.ArrayList;

import org.hibernate.Session;

import com.website.demo.xml.persistence.HibernateUtil;
import com.website.demo.xml.dao.Address;
import com.website.demo.xml.dao.Course;
import com.website.demo.xml.dao.HomeWork;
import com.website.demo.xml.dao.Student;

public class Test {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Address address = new Address();
		address.setStreet("Nguyen Thi Minh Khai");
		address.setDistrict("1");
		address.setCity("HCM");

		Address address2 = new Address();
		address2.setStreet("Dinh Tien Hoang");
		address2.setDistrict("1");
		address2.setCity("HCM");

		Course course = new Course();
		course.setCourseName("Java");

		Course course2 = new Course();
		course2.setCourseName("Spring");

		Course course3 = new Course();
		course3.setCourseName("Hibernate");

		Course course4 = new Course();
		course4.setCourseName("JQuery");
		
		session.save(course);
		session.save(course2);
		session.save(course3);
		session.save(course4);

		HomeWork homeWork = new HomeWork();
		homeWork.setName("Basic-Java");
		homeWork.setCourse(course);
		course.getHomeworks().add(homeWork);
		HomeWork homeWork2 = new HomeWork();
		homeWork2.setName("Advance-Java");
		homeWork2.setCourse(course);
		course.getHomeworks().add(homeWork2);

		HomeWork homeWork3 = new HomeWork();
		homeWork3.setName("SpringMVC");
		homeWork3.setCourse(course2);
		course2.getHomeworks().add(homeWork3);
		HomeWork homeWork4 = new HomeWork();
		homeWork4.setName("SpringSecurity");
		homeWork4.setCourse(course2);
		course2.getHomeworks().add(homeWork4);

		HomeWork homeWork5 = new HomeWork();
		homeWork5.setName("ORM");
		homeWork5.setCourse(course3);
		course3.getHomeworks().add(homeWork5);

		session.save(homeWork);
		session.save(homeWork2);
		session.save(homeWork3);
		session.save(homeWork4);
		session.save(homeWork5);

		Student student = new Student();
		student.setFirstName("Phuong");
		student.setLastName("Mai");
		student.setAge(29);
		student.setAddress(address);
		student.setCourses(new ArrayList<Course>());
		student.getCourses().add(course);
		student.getCourses().add(course2);
		student.getCourses().add(course3);
		student.getCourses().add(course4);

		Student student2 = new Student();
		student2.setFirstName("An");
		student2.setLastName("Tran");
		student2.setAge(29);
		student2.setAddress(address);
		student2.setCourses(new ArrayList<Course>());
		student2.getCourses().add(course2);
		student2.getCourses().add(course3);

		session.save(student);
		session.save(student2);
		session.getTransaction().commit();
		System.out.println("Done");
	}

}
