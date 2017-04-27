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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteCourant creerCompteCourant(Client c, CompteCourant compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteEpargne creerCompteEpargne(Client c, CompteEpargne compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void associerCarteCompte(Carte carte, CompteCourant compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void associerCompteClient(Client client, Compte compte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void associerConseillerClient(Conseiller conseiller, Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int modifierClient(Client client, Coordonnees coor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<Client> listerClients(Conseiller cons) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Compte> listerComptes(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void effectuerVirement(Compte compteEmetteur, Compte compteRecepteur, double montant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerClient(Client c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String lireInfoClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carte creerCarteVisaPremier() {
		Carte visaPremier = new CarteVisaPremier();
		return visaPremier;
	}

	@Override
	public Carte creerCarteVisaElectron() {
		Carte visaElectron = new CarteVisaElectron();
		return visaElectron;
	}


}
