package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("per");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Course c1=new Course();
		c1.setCourseName("Sql");
		c1.setTrainerName("Manoj");
		c1.setCost(32000);
		
		Course c2=new Course();
		c2.setCourseName("Java");
		c2.setTrainerName("Uday");
		c2.setCost(32000);
		
		Course c3=new Course();
		c3.setCourseName("Hibernet");
		c3.setTrainerName("Hemanth");
		c3.setCost(32000);
		
		List<Course> list1=new ArrayList();
		list1.add(c1);
		list1.add(c2);
		
		List<Course> list2=new ArrayList();
		list2.add(c2);
		list2.add(c3);
		
		Student std1=new Student();
		std1.setName("Sagar");
		std1.setPhno(9876543423l);
		std1.setCourses(list1);
		
		Student std2=new Student();
		std2.setName("Dinga");
		std2.setPhno(70903543423l);
		std2.setCourses(list2);

		et.begin();
		em.persist(std2);
		em.persist(std1);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		et.commit();
	}
}
