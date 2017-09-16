package com.website.hibernate.annotation.main;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.website.hibernate.xml.persistence.HibernateUtil;

public class HQL {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query query = session.createQuery("from student where student_name = :name");
		query.setParameter("name", "Phuong");
		List list = query.list();
		Arrays.toString(list.toArray());

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
