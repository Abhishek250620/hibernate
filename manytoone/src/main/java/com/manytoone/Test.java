package com.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("per");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		AmazonOrder ao=new AmazonOrder();
		ao.setAddress("Ramnagara");
		ao.setPhno(8747933204l);
		
		Item item1=new Item();
		item1.setName("Bag");
		item1.setCost(400);
		item1.setA0(ao);
		
		Item item2=new Item();
		item2.setName("Moblie");
		item2.setCost(20000);
		item2.setA0(ao);
		
		et.begin();
		em.persist(ao);
		em.persist(item1);
		em.persist(item2);
		et.commit();
		
	}

}
