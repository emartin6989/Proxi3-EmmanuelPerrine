package service;

import java.util.Collection;

import javax.inject.Inject;

import dao.Idao;
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

public class ConseillerService implements IConseillerService {

	@Inject
	private Idao dao;

	
	@Override
	public Conseiller authentificationConseiller(String login, String mdp) {
		System.out.println("service"+login+mdp);
		return dao.authentificationConseiller(login, mdp);
	}

	@Override
	public Collection<Client> listerClients(Conseiller cons) {
		return dao.listerClients(cons);
	}

	@Override
	public void effectuerVirement(Conseiller conseiller, Compte compteEmetteur, Compte compteRecepteur, double montant)
			throws SoldeInsuffisantException, MontantNegatifException,
			ClientGererParAutreConseillerException {
		if (!conseiller.getClients().contains(compteEmetteur)) {
			throw new ClientGererParAutreConseillerException("Ce conseiller ne gère pas ce client");
		}
		if (montant >= 0) {
			if (compteEmetteur instanceof CompteEpargne) {
				if (montant > compteEmetteur.getSolde()) {
					throw new SoldeInsuffisantException("Solde insuffisant");
				}

			}

			if (compteEmetteur instanceof CompteCourant) {
				double decouvert = ((CompteCourant) compteEmetteur).getDecouvert();
				if (montant > compteEmetteur.getSolde() + decouvert) {
					throw new SoldeInsuffisantException("Solde insuffisant");
				}
			}
		} else {
			throw new MontantNegatifException("Montant négatif");
		}

		dao.retraitSolde(compteEmetteur, montant);
		dao.ajoutSolde(compteRecepteur, montant);
	}

	@Override
	public Collection<Compte> listerComptes(Client c)  {
				Collection<Compte> listecomptes = dao.listerComptes(c);
			return listecomptes;
	}

	@Override
	public int modifierClient(Client client, Coordonnees coor) {
		return dao.modifierClient(client, coor);
		
	}

	@Override
	public int ajouterClient(Conseiller cons, Client c, Coordonnees coor) throws NombreClientsMaxAtteintException {
		if (cons.getClients().size() >= 10) {
			throw new NombreClientsMaxAtteintException("Le conseiller a déjà 10 clients");
			
		} else {
			dao.ajouterClient(cons, c, coor);
			return c.getId();
			
		}
	}

	@Override
	public void supprimerClient(Conseiller cons, Client c, int id) throws ClientInexistantException, ClientGererParAutreConseillerException{
		if (!cons.getClients().contains(c)){
			throw new ClientGererParAutreConseillerException("Ce conseiller ne gère pas ce client");
		}else{
		}
		if(c.getId()!=0){
			dao.supprimerClient(c, id);
		}else{
		throw new ClientInexistantException("Ce Client n'existe pas");
	}
	}

	@Override
	public int ajouterCompteCourant(Client c, CompteCourant compte) throws NombreCompteMaxAtteintException {
		if(c.getCompte().contains(compte)){
			throw new NombreCompteMaxAtteintException("Le client possède déjà un compte courant");
		}
			dao.ajouterCompteCourant(c, compte);
			return (int) compte.getId();
		
		
	}

	@Override
	public int ajouterCompteEpargne(Client c, CompteEpargne compte) throws NombreCompteMaxAtteintException {
		if(c.getCompte().contains(compte)){
			throw new NombreCompteMaxAtteintException("Le client possède déjà un compte courant");
		}
		dao.ajouterCompteEpargne(c, compte);
		return (int) compte.getId();
	}

}
