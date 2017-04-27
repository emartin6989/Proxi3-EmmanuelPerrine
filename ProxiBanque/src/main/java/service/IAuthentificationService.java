package service;

import metier.Conseiller;

public interface IAuthentificationService {

	public Conseiller authentificationConseiller(String login, String mdp);
	
}
