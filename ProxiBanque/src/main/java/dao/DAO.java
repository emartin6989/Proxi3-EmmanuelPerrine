package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Coordonnees;


public class DAO implements Idao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bddproxiv3-pu");

	

	@Override
	public int ajouterClient() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Client client = new Client();
		client.setNom("Bouda");
		client.setPrenom("Clark");
		

		em.persist(client);

		tx.commit();
		em.close();
		return client.getId();
	}

	

}
