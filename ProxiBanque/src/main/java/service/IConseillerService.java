package service;

import java.util.Collection;

import metier.Carte;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Coordonnees;

public interface IConseillerService {
	
	public Client creerClient(Client c, Coordonnees coor);
	public CompteCourant creerCompteCourant(Client c, CompteCourant compte);
	public CompteEpargne creerCompteEpargne(Client c, CompteEpargne compte);
	public Carte  creerCarteVisaPremier();
	public Carte  creerCarteVisaElectron();
	
	public void associerCarteCompte(Carte carte, CompteCourant compte);
	public void associerCompteClient(Client client, Compte compte);
	public void associerConseillerClient(Conseiller conseiller, Client client);
	

	public int modifierClient(Client client, Coordonnees coor);
	

	public Collection<Client> listerClients(Conseiller cons);
	public Collection<Compte> listerComptes(Client c);
	

	public void effectuerVirement(Compte compteEmetteur, Compte compteRecepteur, double montant);


	public void supprimerClient(Client c, int id) ;

	
	public String lireInfoClient(Client client);
	
	
	

	
}
