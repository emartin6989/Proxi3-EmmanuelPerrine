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
	 * M�thode permettant de retrouver un conseiller par son login et son mot de
	 * passe
	 * 
	 * @return Le conseiller s'il existe
	 * @throws ClassNotFoundException
	 */
	public Conseiller authentificationConseiller(String login, String mdp);

	/**
	 * M�thode permettant � un conseiller de lister ses clients
	 * 
	 * @return La liste des informations client pour les clients du conseiller
	 *         authentifi�
	 * @throws ClassNotFoundException
	 */
	public Collection<Client> listerClients(Conseiller cons);

	/**
	 * M�thode permettant � un conseiller d'afficher la liste des comptes de ses
	 * clients
	 * 
	 * @return La liste des comptes des clients du conseiller authentifi�
	 */
	public Collection<Compte> listerComptes(Client cl);

	/**
	 * M�thode permettant d'augmenter le solde d'un compte
	 * 
	 * @param c
	 *            Compte dont le solde est modifi� suite � un virement
	 * @param montant
	 *            Montant du virement � effectuer
	 * @throws SQLException
	 */
	public void ajoutSolde(Compte c, double montant);

	/**
	 * M�thode permettant de diminuer le solde d'un compte
	 * 
	 * @param c
	 *            Compte dont le solde est modifi� suite � un virement
	 * @param montant
	 *            Montant du virement � effectuer
	 * @throws SQLException
	 */
	public void retraitSolde(Compte c, double montant);

	/**
	 * M�thode permettant de modifier les informations d'un client
	 * 
	 * @param c
	 *            Client � modifier
	 * @param coor
	 *            Nouvelles coordonn�es du client
	 * @return l'Id du client modifi�
	 */
	public int modifierClient(Client c, Coordonnees coor);

	/**
	 * M�thode permettant d'ajouter un client
	 * 
	 * @param cons
	 *            Conseiller rajoutant un client � sa liste de clients
	 * @param c
	 *            Client � rajouter
	 * @param coor
	 *            Coordonn�es du client � pr�ciser
	 * @return l'Id du client rajout�
	 */
	public int ajouterClient(Conseiller cons, Client c, Coordonnees coor);

	/**
	 * M�thode permettant de supprimer un client
	 * 
	 * @param client
	 *            Client � supprimer
	 * @param id
	 *            Id du client � supprimer
	 * @throws ClientInexistantException
	 *             Exception si le client choisi n'existe pas
	 */
	public void supprimerClient(Client client, int id) ;

	/**
	 * M�thode permettant d'ajouter un compte courant
	 * 
	 * @param c
	 *            Client pour lequel on veut rajouter un compte courant
	 * @param compte
	 *            Compte que l'on veut rajouter
	 * @return l'Id du compte cr��
	 */
	public int ajouterCompteCourant(Client c, CompteCourant compte);

	/**
	 * M�thode permettant d'ajouter un compte �pargne
	 * 
	 * @param c
	 *            Client pour lequel on veut rajouter un compte �pargne
	 * @param compte
	 *            Compte que l'on veut rajouter
	 * @return l'Id du compte cr��
	 */
	public int ajouterCompteEpargne(Client c, CompteEpargne compte);

}
