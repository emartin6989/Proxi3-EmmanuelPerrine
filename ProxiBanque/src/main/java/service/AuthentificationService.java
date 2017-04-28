package service;



import dao.Dao;
import dao.Idao;
import metier.Conseiller;

public class AuthentificationService implements IAuthentificationService {

	//@Inject 
	Idao dao = new Dao();
	
	@Override
	public Conseiller authentificationConseiller(String login, String mdp) {
		return dao.authentificationConseiller(login, mdp);
	}

}
