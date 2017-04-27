package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Carte;
import metier.CarteVisaElectron;
import metier.CarteVisaPremier;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Coordonnees;

public class DAO implements Idao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("bddproxiv3-pu");

	@Override
	public Client creerClient(Client c, Coordonnees coor) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		c.setCoordonnees(coor);
		em.persist(c);

		tx.commit();
		em.close();
		return c;
	}

	@Override
	public CompteCourant creerCompteCourant(Client c, CompteCourant compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Collection<Compte> listeComptes = c.getComptes();
		listeComptes.add(compte);
		c.setComptes(listeComptes);
		compte.setClient(c);

		em.persist(c);

		tx.commit();
		em.close();
		return compte;
	}

	@Override
	public CompteEpargne creerCompteEpargne(Client c, CompteEpargne compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Collection<Compte> listeComptes = c.getComptes();
		listeComptes.add(compte);
		c.setComptes(listeComptes);
		compte.setClient(c);

		em.persist(compte);

		tx.commit();
		em.close();
		return compte;
	}

	@Override
	public void associerCarteCompte(Carte cb, CompteCourant compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		cb.setCompte(compte); // Association entre cb et compte
		// courant
		compte.setCarte(cb); // Association entre compte courant et cb
		em.merge(compte);
		tx.commit();
		em.close();
	}


	@Override
	public void associerConseillerClient(Conseiller conseiller, Client client) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		conseiller.getClients().add(client);
		client.setConseiller(conseiller);
		em.merge(client);
		tx.commit();
		em.close();
	}

	@Override
	public int modifierClient(Client client, Coordonnees coor) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		client.setCoordonnees(coor);

		em.merge(client);

		tx.commit();
		em.close();
		return client.getId();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Client> listerClients(Conseiller cons) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<Client> listeClients = new ArrayList<Client>();
		Query req = em.createNamedQuery("Client.findAll");
		req.setParameter("idcons", cons.getId());
		listeClients = req.getResultList();
		tx.commit();
		em.close();
		return listeClients;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Compte> listerComptes(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		List<Compte> co = new ArrayList<Compte>();
		Query req = em.createQuery("SELECT co FROM Compte co WHERE compte.client.id= :idclient");
		req.setParameter("idclient", c.getId());
		co = req.getResultList();

		em.close();
		return co;
	}

	@Override
	public void ajoutSolde(Compte c, double montant) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Query req = em.createNamedQuery("SELECT c FROM Compte c where numCompte = :numCompte");
		req.setParameter("numCompte", c.getNumCompte());
		c = (Compte) req.getSingleResult();
		c.setSolde(c.getSolde() + montant);

		em.merge(c);

		tx.commit();
		em.close();
	}

	@Override
	public void retraitSolde(Compte c, double montant) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query req = em.createNamedQuery("SELECT c FROM Compte c where numCompte = :numCompte");
		req.setParameter("numCompte", c.getNumCompte());
		c = (Compte) req.getSingleResult();
		c.setSolde(c.getSolde() - montant);
		em.merge(c);

		tx.commit();
		em.close();

	}

	@Override
	public void supprimerClient(Client c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Collection<Compte> listeComptes = c.getComptes();
		for (Compte compte : listeComptes) {
			em.remove(compte.getCarte());
		}

		em.remove(listeComptes);
		em.remove(c);

		tx.commit();
		em.close();

	}

	@Override
	public Client lireInfoClient(int idClient) {
		EntityManager em = emf.createEntityManager();
		Client client = em.find(Client.class, idClient);
		em.close();
		return client;
	}

	@Override
	public Conseiller authentificationConseiller(String login, String mdp) {
		Conseiller cons = new Conseiller();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query req = em.createQuery("SELECT cons FROM Conseiller cons where cons.login = :login and cons.mdp = :mdp");
		req.setParameter("login", login);
		req.setParameter("mdp", mdp);
		if (req.getSingleResult() != null) {
			cons = (Conseiller) req.getSingleResult();
			return cons;
		}
		tx.commit();
		em.close();
		cons.setId(0);

		return cons;
	}

	@Override
	public Carte creerCarteVisaPremier(CarteVisaPremier cvp) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(cvp);

		tx.commit();
		em.close();
		return cvp;
	}

	@Override
	public Carte creerCarteVisaElectron(CarteVisaElectron cve) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(cve);

		tx.commit();
		em.close();
		return cve;
	}


}
