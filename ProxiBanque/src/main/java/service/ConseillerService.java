package service;

import java.util.Collection;

import javax.inject.Inject;

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

	@Inject
	private Idao dao;

	@Override
	public Client creerClient(Client c, Coordonnees coor) {
		return dao.creerClient(c, coor);
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
	public void associerCarteCompte(Carte carte, CompteCourant compte) {
		dao.associerCarteCompte(carte, compte);
		
	}

	@Override
	public void associerCompteClient(Client client, Compte compte) {
		dao.associerCompteClient(client, compte);
		
	}

	@Override
	public void associerConseillerClient(Conseiller conseiller, Client client) {
		dao.associerConseillerClient(conseiller, client);
		
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

	@Override
	public Carte creerCarteVisaPremier(CarteVisaPremier cvp) {
		return dao.creerCarteVisaPremier(cvp);
	}

	@Override
	public Carte creerCarteVisaElectron(CarteVisaElectron cve) {
		return dao.creerCarteVisaElectron(cve);
	}


}
