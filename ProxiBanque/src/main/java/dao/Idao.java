package dao;

import java.sql.SQLException;
import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Coordonnees;

public interface Idao {

	/**
	 * Méthode permettant de retrouver un conseiller par son login et son mot de
	 * passe
	 * 
	 * @return Le conseiller s'il existe
	 * @throws ClassNotFoundException
	 */
	public Conseiller authentificationConseiller(String login, String mdp);

	/**
	 * Méthode permettant à un conseiller de lister ses clients
	 * 
	 * @return La liste des informations client pour les clients du conseiller
	 *         authentifié
	 * @throws ClassNotFoundException
	 */
	public Collection<Client> listerClients(Conseiller cons);

	/**
	 * Méthode permettant à un conseiller d'afficher la liste des comptes de ses
	 * clients
	 * 
	 * @return La liste des comptes des clients du conseiller authentifié
	 */
	public Collection<Compte> listerComptes(Client cl);

	/**
	 * Méthode permettant d'augmenter le solde d'un compte
	 * 
	 * @param c
	 *            Compte dont le solde est modifié suite à un virement
	 * @param montant
	 *            Montant du virement à effectuer
	 * @throws SQLException
	 */
	public void ajoutSolde(Compte c, double montant);

	/**
	 * Méthode permettant de diminuer le solde d'un compte
	 * 
	 * @param c
	 *            Compte dont le solde est modifié suite à un virement
	 * @param montant
	 *            Montant du virement à effectuer
	 * @throws SQLException
	 */
	public void retraitSolde(Compte c, double montant);

	/**
	 * Méthode permettant de modifier les informations d'un client
	 * 
	 * @param c
	 *            Client à modifier
	 * @param coor
	 *            Nouvelles coordonnées du client
	 * @return l'Id du client modifié
	 */
	public int modifierClient(Client c, Coordonnees coor);

	/**
	 * Méthode permettant d'ajouter un client
	 * 
	 * @param cons
	 *            Conseiller rajoutant un client à sa liste de clients
	 * @param c
	 *            Client à rajouter
	 * @param coor
	 *            Coordonnées du client à préciser
	 * @return l'Id du client rajouté
	 */
	public int ajouterClient(Conseiller cons, Client c, Coordonnees coor);

	/**
	 * Méthode permettant de supprimer un client
	 * 
	 * @param client
	 *            Client à supprimer
	 * @param id
	 *            Id du client à supprimer
	 * @throws ClientInexistantException
	 *             Exception si le client choisi n'existe pas
	 */
	public void supprimerClient(Client client, int id) ;

	/**
	 * Méthode permettant d'ajouter un compte courant
	 * 
	 * @param c
	 *            Client pour lequel on veut rajouter un compte courant
	 * @param compte
	 *            Compte que l'on veut rajouter
	 * @return l'Id du compte créé
	 */
	public int ajouterCompteCourant(Client c, CompteCourant compte);

	/**
	 * Méthode permettant d'ajouter un compte épargne
	 * 
	 * @param c
	 *            Client pour lequel on veut rajouter un compte épargne
	 * @param compte
	 *            Compte que l'on veut rajouter
	 * @return l'Id du compte créé
	 */
	public int ajouterCompteEpargne(Client c, CompteEpargne compte);

}
