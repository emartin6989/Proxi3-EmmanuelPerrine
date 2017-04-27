package service;

import java.util.Collection;

import javax.inject.Inject;

import dao.DAO;
import dao.Idao;
import metier.Carte;
import metier.CarteVisaElectron;
import metier.CarteVisaPremier;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import metier.Coordonnees;

public class ConseillerService implements IConseillerService {

	/*@Inject 
	private Idao dao;*/
	Idao dao = new DAO();

	@Override
	public Client creerClient(Conseiller cons, Client c, Coordonnees coor) {
		Client client = dao.creerClient(c, coor);
		dao.associerConseillerClient(cons, client);
		return client;
	}

	@Override
	public CompteCourant creerCompteCourant(Client c, CompteCourant compte) {
		return dao.creerCompteCourant(c, compte);
	}

	@Override
	public CompteEpargne creerCompteEpargne(Client c, CompteEpargne compte) {
		return dao.creerCompteEpargne(c, compte);
	}
	
	@Override
	public Carte creerCarteVisaPremier(CompteCourant compte, CarteVisaPremier cvp) {
		Carte carte = dao.creerCarteVisaPremier(cvp);
		dao.associerCarteCompte(carte, compte);
		return carte;
	}

	@Override
	public Carte creerCarteVisaElectron(CompteCourant compte, CarteVisaElectron cve) {
		Carte carte = dao.creerCarteVisaElectron(cve);
		dao.associerCarteCompte(carte, compte);
		return carte;
	}


	@Override
	public int modifierClient(Client client, Coordonnees coor) {
		return dao.modifierClient(client, coor);
	}

	@Override
	public Collection<Client> listerClients(Conseiller cons) {
		return dao.listerClients(cons);
	}

	@Override
	public Collection<Compte> listerComptes(Client c) {
		return dao.listerComptes(c);
	}

	@Override
	public void effectuerVirement(Compte compteEmetteur, Compte compteRecepteur, double montant) {
		dao.retraitSolde(compteEmetteur, montant);
		dao.ajoutSolde(compteRecepteur, montant);
		
	}

	@Override
	public void supprimerClient(Client c) {
		dao.supprimerClient(c);
		
	}

	@Override
	public Client lireInfoClient(int idClient) {
		return dao.lireInfoClient(idClient);
	}

	


}
