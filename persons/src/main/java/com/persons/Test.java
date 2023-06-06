package com.persons;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {

	public static void main(String[] args) {
//		Person p1=new Person();
//		p1.setName("Smith");
//		p1.setLoc("Delhi");
//		p1.setPhno(9816543321l);

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("per");
		EntityManager em=emf.createEntityManager();	
		EntityTransaction et=em.getTransaction();


		et.begin();
//		em.persist(p1);
//		Person p=em.find(Person.class,5);
		Query q=em.createQuery("select pe from Person pe where pe.id=?1"); // :anyName  (setParameter("anyName", value)
		q.setParameter(1, 3);
		List<Person> person=q.getResultList();
		for(Person p:person) {
			System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getLoc()+"\t"+p.getPhno());
		}
		et.commit();
	}
}
