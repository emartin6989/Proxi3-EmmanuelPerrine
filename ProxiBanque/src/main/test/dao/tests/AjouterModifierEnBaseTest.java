package dao.tests;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import dao.Dao;
import dao.Idao;
import metier.Client;
import metier.CompteCourant;
import metier.Coordonnees;

public class AjouterModifierEnBaseTest {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bddproxiv3-pu");

	/*@Inject
	private Idao dao;*/
	Idao dao = new Dao();
	
	@Test
	public void testAjouterCompteCourant() {
		//on test que deux lignes sont ajoutée (une dans la table compte l'autre dans la table comptecourant)
		CompteCourant cc = new CompteCourant();
		cc.setSolde(10);
		cc.setDecouvert(500);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Client cl= em.find(Client.class, 2);
		Assert.assertEquals(cc, dao.creerCompteCourant(cl, cc));
		em.close();
	}
	
	@Test
	public void testmodifierClientExistant() {
		Coordonnees coor = new Coordonnees();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Client cl= em.find(Client.class, 2);
		coor.setAdresse("24 rue de la bienveillance");
		cl.setCoordonnees(coor);
		//on test que une ligne est modifiée
		Assert.assertEquals(2, dao.modifierClient(cl, coor));
		em.close();

	}


	@Test
	public void testmodifierClientInconnu() {
		
		Client c = new Client();
		Coordonnees coor = new Coordonnees();
		//on test que rien n'est modifié
		Assert.assertEquals(0, dao.modifierClient(c, coor));

	}
	
}
