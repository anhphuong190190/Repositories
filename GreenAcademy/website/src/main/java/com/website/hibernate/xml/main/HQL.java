package com.website.hibernate.xml.main;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.website.hibernate.xml.model.Student;
import com.website.hibernate.xml.persistence.HibernateUtil;

public class HQL {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

//		Query query = session.createQuery("from Address as A where A.city = 'HCM'");
//		query.setFirstResult(20);
//		query.setMaxResults(10);
//		List list = query.list();
//		System.out.println(Arrays.toString(list.toArray()));
//
//		query = session.createQuery("select S from Student as S where S.firstName = :fName");
//		query.setParameter("fName", "Phuong");
//		Student student = (Student) query.uniqueResult();
//		System.out.println(student);
//
//		query = session.createQuery("update Student set firstName = :fName, lastName = :lName where id = :id");
//		query.setParameter("fName", "Phuong1");
//		query.setParameter("lName", "Mai1");
//		query.setParameter("id", 1);
//		int result = query.executeUpdate();
//
//		// get all the records
//		Criteria criteria = session.createCriteria(Student.class);
//		List students = criteria.list();
//
//		// pagination with limit and offset
//		criteria = session.createCriteria(Student.class);
//		criteria.setFirstResult(0);
//		criteria.setMaxResults(10);
//		students = criteria.list();
//
//		// set order ASC
//		criteria.addOrder(Order.asc("age"));
//
//		// set order DES
//		
//
//		// set restrictions
//		criteria.add(Restrictions.between("age", 10, 20));
//		criteria.add(Restrictions.like("firstName", ""));
//
//		criteria.add(Restrictions.eq("age", 20));
//		criteria.add(Restrictions.ne("age", 20));
//
//		criteria.add(Restrictions.lt("age", 20));
//		criteria.add(Restrictions.le("age", 20));
//
//		criteria.add(Restrictions.gt("age", 20));
//		criteria.add(Restrictions.ge("age", 20));
		
		
		SQLQuery query = session.createSQLQuery("SELECT * FROM STUDENT as s, ADDRESS as a where s.STUDENT_ID = a.ID");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
//		query.addEntity(Student.class);
		List students = query.list();
		System.out.println(Arrays.toString(students.toArray()));

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
