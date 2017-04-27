package service;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Coordonnees;
import service.exceptions.ClientGererParAutreConseillerException;
import service.exceptions.ClientInexistantException;
import service.exceptions.MontantNegatifException;
import service.exceptions.NombreClientsMaxAtteintException;
import service.exceptions.SoldeInsuffisantException;
import servlets.exceptions.NombreCompteMaxAtteintException;

public interface IConseillerService {

	public Conseiller authentificationConseiller(String login, String mdp);

	public Collection<Client> listerClients(Conseiller cons);

	public Collection<Compte> listerComptes(Client c);

	void effectuerVirement(Conseiller conseiller, Compte compteEmetteur, Compte compteRecepteur, double montant)
			throws SoldeInsuffisantException, MontantNegatifException,
			ClientGererParAutreConseillerException;

	public int modifierClient(Client client, Coordonnees coor);

	public int ajouterClient(Conseiller cons, Client c, Coordonnees coor)throws NombreClientsMaxAtteintException;

	public void supprimerClient(Conseiller cons, Client c, int id) throws ClientInexistantException, ClientGererParAutreConseillerException;

	public int ajouterCompteCourant(Client c, CompteCourant compte)throws NombreCompteMaxAtteintException;

	public int ajouterCompteEpargne(Client c, CompteEpargne compte)throws NombreCompteMaxAtteintException;

	
}
