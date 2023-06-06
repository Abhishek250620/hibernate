package com.emp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Employe e=new Employe();
//		System.out.println("Enter id:");
//		e.setId(sc.nextInt());
//		System.out.println("Enter name:");
//		e.setName(sc.next());
//		System.out.println("Enter salary:");
//		e.setSalary(sc.nextDouble());
//		System.out.println("Enter Location:");
//		e.setLocation(sc.next());
//		System.out.println("Enter Phone number:");
//		e.setPhno(sc.nextLong());

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("emp");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
//		em.persist(e);
//		em.merge(e);
		Employe e1=em.find(Employe.class, 4);  // used to find the particular row using primary key
		System.out.print(e1.getId()+"\t");
		System.out.print(e1.getName()+"\t");
		System.out.print(e1.getSalary()+"\t");
		System.out.print(e1.getLocation()+"\t");
		System.out.print(e1.getPhno());
//		Employe e1=em.find(Employe.class, 3);
//		em.remove(e1);
		et.commit();
	}

}
