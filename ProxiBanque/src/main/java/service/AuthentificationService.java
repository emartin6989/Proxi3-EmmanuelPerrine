package service;

import javax.inject.Inject;

import dao.Idao;
import metier.Conseiller;

public class AuthentificationService implements IAuthentificationService {

	@Inject 
	private Idao dao;
	
	@Override
	public Conseiller authentificationConseiller(String login, String mdp) {
		return dao.authentificationConseiller(login, mdp);
	}

}
