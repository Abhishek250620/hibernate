package com.persons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestOneToOne {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("per");
		EntityManager em=emf.createEntityManager();	
		EntityTransaction et=em.getTransaction();
		
		PanCard pancard = new PanCard();
		pancard.setName("Ford");
		pancard.setAddress("Gia");
		
		Person person=new Person();
		person.setLoc("Goa");
		person.setPhno(87345734575l);
		person.setPancard(pancard);
		
		person.setName("Ford");
		et.begin();
//		em.persist(person);
//		em.persist(pancard);
		System.out.println(em.find(Person.class,1));
		System.out.println("*******************************************************************");
		System.out.println(em.find(PanCard.class,1));
//		em.remove(em.find(Person.class,2));
		et.commit();
	}
}
