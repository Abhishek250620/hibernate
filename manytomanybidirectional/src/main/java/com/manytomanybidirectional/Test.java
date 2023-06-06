package com.manytomanybidirectional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;  
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("per");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();

		Student std1=new Student();
		std1.setName("Smith");
		std1.setAge(22);

		Student std2=new Student();
		std2.setName("Ford");
		std2.setAge(20);

		Student std3=new Student();
		std3.setName("Allean");
		std3.setAge(23);


		Course c1=new Course();
		c1.setCourseName("Java");
		c1.setCost(23000);

		Course c2=new Course();
		c2.setCourseName("sql");
		c2.setCost(40000);

		Course c3=new Course();
		c3.setCourseName("web");
		c3.setCost(30000);

		List<Course> lc1=new ArrayList();
		lc1.add(c1);
		lc1.add(c3);
		lc1.add(c2);

		List<Course> lc2=new ArrayList();
		lc2.add(c1);
		lc2.add(c2);

		List<Course> lc3=new ArrayList();
		lc3.add(c3);
		lc3.add(c2);

		std1.setCourses(lc3);
		std2.setCourses(lc2);
		std3.setCourses(lc1);

		List<Student> ls1=new ArrayList();
		ls1.add(std3);
		ls1.add(std1);

		List<Student> ls2=new ArrayList();
		ls2.add(std2);
		ls2.add(std3);

		List<Student> ls3=new ArrayList();
		ls3.add(std1);
		ls3.add(std2);
		
		c1.setStudents(ls3);
		c2.setStudents(ls2);
		c3.setStudents(ls1);

		et.begin();
//		em.persist(std1);
//		em.persist(std2);
//		em.persist(std3);
//		em.persist(c1);
//		em.persist(c2);
//		em.persist(c3);
		Query q=em.createQuery("select s from Student s");
		List<Student> s=q.getResultList();
		
		for(Student student:s) {
			System.out.println(student);
		}

		et.commit();

	}
}
