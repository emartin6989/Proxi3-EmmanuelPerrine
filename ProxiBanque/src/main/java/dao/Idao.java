package dao;

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

public interface Idao {
	
	public Conseiller authentificationConseiller(String login, String mdp);

	public Client creerClient(Client c, Coordonnees coor);

	public CompteCourant creerCompteCourant(Client c, CompteCourant compte);

	public CompteEpargne creerCompteEpargne(Client c, CompteEpargne compte);

	public void associerCarteCompte(Carte carte, CompteCourant compte);

	public int modifierClient(Client client, Coordonnees coor);

	public Collection<Client> listerClients(Conseiller cons);

	public Collection<Compte> listerComptes(Client c);

	public void supprimerClient(Client c);

	public Client lireInfoClient(int id);

	public Carte creerCarteVisaPremier(CarteVisaPremier cvp);

	public Carte creerCarteVisaElectron(CarteVisaElectron cve);

	public void ajoutSolde(Compte c, double montant);

	public void retraitSolde(Compte c, double montant);

	public void associerConseillerClient(Conseiller conseiller, Client client);
	
	public int modifierCompte(Compte c);
	
	public void supprimerCompte(Compte c);

}
