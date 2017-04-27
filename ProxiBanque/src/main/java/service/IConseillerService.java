package service;

import java.util.Collection;

import metier.Carte;
import metier.CarteVisaElectron;
import metier.CarteVisaPremier;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Coordonnees;

public interface IConseillerService {
	
	public Client creerClient(Conseiller cons, Client c, Coordonnees coor);
	public CompteCourant creerCompteCourant(Client c, CompteCourant compte);
	public CompteEpargne creerCompteEpargne(Client c, CompteEpargne compte);
	public Carte creerCarteVisaPremier(CompteCourant compte, CarteVisaPremier cvp);
	public Carte creerCarteVisaElectron(CompteCourant compte, CarteVisaElectron cve);

	public int modifierClient(Client client, Coordonnees coor);
	public int modifierCompte(Compte c);
	

	public Collection<Client> listerClients(Conseiller cons);
	public Collection<Compte> listerComptes(Client c);
	

	public void effectuerVirement(Compte compteEmetteur, Compte compteRecepteur, double montant);


	public void supprimerClient(Client c) ;

	
	public Client lireInfoClient(int idClient);
	
	public void supprimerCompte(Compte c);
	

	
}
