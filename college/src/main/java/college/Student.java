package college;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	int age;
	
	public static void main(String[] args) {
		Student s=new Student();
//		s.id=2;
		s.name="Smith";
		s.age=20;
		
//		EntityManagerFactory --  responsible for establishing connection
//		EntityManager -- performing CRUD operation
//		EntityTransaction -- responsible for commit rolleback 
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("abhi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();

		et.begin();
		em.persist(s);
		et.commit();
	}

}
