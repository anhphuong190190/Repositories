package com.website.demo.xml.main;

import org.hibernate.Session;

import com.website.demo.annotation.persistence.HibernateUtil;
import com.website.demo.xml.dao.Address;
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

		Student student = new Student();
		student.setFirstName("Phuong");
		student.setLastName("Mai");
		student.setAge(29);
		student.setAddress(address);

		session.save(student);
		session.getTransaction().commit();
	}

}
