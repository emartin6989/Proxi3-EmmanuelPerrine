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
	public Conseiller authentificationConseiller(String login, String mdp) {
		System.out.println("dao1" + login + mdp);
		Conseiller cons = new Conseiller();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query req = em.createQuery("SELECT cons FROM Conseiller cons where cons.login = :login and cons.mdp = :mdp");
		req.setParameter("login", login);
		req.setParameter("mdp", mdp);
		if (req.getSingleResult() != null) {
			cons = (Conseiller) req.getSingleResult();
			System.out.println("dao2" + cons.getId());
			return cons;
		}
		tx.commit();
		em.close();
		cons.setId(0);

		return cons;
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

	@Override
	// TODO à modifier
	public int modifierClient(Client c, Coordonnees coor) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		c.setCoordonnees(coor);

		em.merge(c);

		tx.commit();
		em.close();
		return c.getId();

	}

	@Override
	public Collection<Compte> listerComptes(Client cl) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Collection<Compte> co = cl.getCompte();
		tx.commit();
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
	public int ajouterClient(Conseiller cons, Client c, Coordonnees coor) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		c.setCoordonnees(coor);
		

		em.persist(c);
		List<Client> listClients = (List<Client>) cons.getClients();
		listClients.add(c);
		cons.setClients(listClients);
		c.setConseiller(cons);

		tx.commit();
		em.close();
		return c.getId();
	}

	@Override
	public void supprimerClient(Client client, int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Collection<Compte> listeComptes = client.getCompte();
		for (Compte compte : listeComptes) {
			em.remove(compte.getCarte());
		}

		em.remove(listeComptes);
		em.remove(client);

		tx.commit();
		em.close();

	}

	@Override
	public int ajouterCompteCourant(Client c, CompteCourant compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Collection<Compte> listeComptes = c.getCompte();
		listeComptes.add(compte);
		c.setCompte(listeComptes);
		compte.setClient(c);

		em.persist(c);

		tx.commit();
		em.close();
		return (int) compte.getId();
	}

	@Override
	public int ajouterCompteEpargne(Client c, CompteEpargne compte) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Collection<Compte> listeComptes = c.getCompte();
		listeComptes.add(compte);
		c.setCompte(listeComptes);
		compte.setClient(c);

		em.persist(compte);

		tx.commit();
		em.close();
		return (int) compte.getId();
	}

}
