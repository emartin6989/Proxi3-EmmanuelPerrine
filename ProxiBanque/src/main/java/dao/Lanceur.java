package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Client;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bddproxiv3-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Client c = new Client();
		c.setNom("nomTest");
		c.setPrenom("prenomTest");
		em.persist(c);

		tx.commit();
		em.close();
	
	}

} 
