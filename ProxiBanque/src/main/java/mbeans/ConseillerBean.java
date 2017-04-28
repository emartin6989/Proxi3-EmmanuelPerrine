package mbeans;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;
import service.AuthentificationService;
import service.ConseillerService;
import service.IAuthentificationService;
import service.IConseillerService;

@ManagedBean
public class ConseillerBean {

	// @Inject
	private IAuthentificationService service = new AuthentificationService();
	// @Inject
	private IConseillerService cs = new ConseillerService();

	// IAuthentificationService service = new AuthentificationService();
	// IConseillerService cs = new ConseillerService();

	private Conseiller conseiller = new Conseiller();
	private CompteCourant cCourant = new CompteCourant();
	private CompteEpargne cEpargne = new CompteEpargne();
	private Collection<Client> clients;
	/**
	 * @return the cs
	 */
	public IConseillerService getCs() {
		return cs;
	}

	/**
	 * @param cs
	 *            the cs to set
	 */
	public void setCs(IConseillerService cs) {
		this.cs = cs;
	}

	/**
	 * @return the cCourant
	 */
	public CompteCourant getcCourant() {
		return cCourant;
	}

	/**
	 * @param cCourant
	 *            the cCourant to set
	 */
	public void setcCourant(CompteCourant cCourant) {
		this.cCourant = cCourant;
	}

	/**
	 * @return the cEpargne
	 */
	public CompteEpargne getcEpargne() {
		return cEpargne;
	}

	/**
	 * @param cEpargne
	 *            the cEpargne to set
	 */
	public void setcEpargne(CompteEpargne cEpargne) {
		this.cEpargne = cEpargne;
	}

	/**
	 * @return the service
	 */
	public IAuthentificationService getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(IAuthentificationService service) {
		this.service = service;
	}

	/**
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller
	 *            the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public String authentification() {
		if (!(conseiller.getLogin().equalsIgnoreCase("") && conseiller.getLogin().equalsIgnoreCase(""))) {
			String login = conseiller.getLogin();
			String mdp = conseiller.getMdp();
			conseiller = service.authentificationConseiller(login, mdp);
			if (conseiller.getId() != 0) {
				return "editerClient";
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("conseiller", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Identifiants et/ou mot de passe inexistants", null));
				return "index";
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("conseiller",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir des valeurs non nulles", null));
			return "index";
		}

	}

	public String virement(Compte compteEmetteur, Compte compteRecepteur, double montant) {
		if ((compteEmetteur instanceof CompteCourant && cCourant.getSolde() <= (0 - cCourant.getDecouvert()))
				|| (compteEmetteur instanceof CompteEpargne && cEpargne.getSolde() <= 0)) {

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("compte", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Solde insuffisant", null));
		} else {
			cs.effectuerVirement(compteEmetteur, compteRecepteur, montant);
		}
		return "virementCompteACompte";
	}
	
	public Collection<Client> listerClients() {
		clients = cs.listerClients(conseiller);
		return clients;
	}
}
