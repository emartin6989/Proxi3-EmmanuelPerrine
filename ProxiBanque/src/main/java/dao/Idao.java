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
	public int ajouterClient();

	

}
