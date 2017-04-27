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
	public int ajouterClient();

	

}
