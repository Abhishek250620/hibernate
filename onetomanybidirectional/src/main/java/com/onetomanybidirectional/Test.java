package com.onetomanybidirectional;

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
		
		Mobile mobile=new Mobile();
		mobile.setId(2);
		mobile.setBrand("Nokia");
		mobile.setCost("24000");
		
		
		
		Sim s1=new Sim();
		s1.setId(4);
		s1.setSimType("4G");
		s1.setTelecomName("Airtel");
		s1.setMobile(mobile);
		
		Sim s2=new Sim();
		s2.setId(3);
		s2.setSimType("5G");
		s2.setTelecomName("VI");
		s2.setMobile(mobile);

		List<Sim> sims=new ArrayList();
		sims.add(s1);
		sims.add(s2);
		
		mobile.setSims(sims);
		
		et.begin();
//		em.merge(s1);
		em.merge(s2);
//		em.merge(mobile);
		et.commit();
		
	}
}
