package com.onetomany;

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
		
//		Item item1=new Item();
//		item1.setName("Phonoe");
//		item1.setCost(6000);
//		item1.setColour("Black");
//		
//		Item item2=new Item();
//		item2.setName("laptop");
//		item2.setCost(300000);
//		item2.setColour("White");
		
		List<Item> item=new ArrayList<Item>();
		
//		item.add(item1);
//		item.add(item2);
		
		AmazonOrder amazonOrder=new AmazonOrder();
		amazonOrder.setAddress("Vijaynagara");
		amazonOrder.setPhNo(787654321);
		amazonOrder.setStatus("order waiting");
		
		
		et.begin();
//		em.persist(amazonOrder);
//		em.persist(item1);
//		em.persist(item2);
//		System.out.println(em.find(AmazonOrder.class, 2));
//		em.remove(em.find(AmazonOrder.class, 1));
		
//		----------------used to add existing data to new column---------------
//		item.add(em.find(Item.class, 1));
//		item.add(em.find(Item.class, 2));
//		amazonOrder.setItem(item);
//		em.persist(amazonOrder);
		
		
//		-------------------used to delete the row-------------------------
//		AmazonOrder ao=em.find(AmazonOrder.class, 2);
//		List<Item> Items=ao.getItem();
//		for(Item item1: Items) {
//			em.remove(item1);
//		}
//		em.remove(ao);
		
//		------------------------update-------------------------------------
		AmazonOrder ao=em.find(AmazonOrder.class, 3);
		ao.setAddress("Delhi");
		
		et.commit();
	}
}
