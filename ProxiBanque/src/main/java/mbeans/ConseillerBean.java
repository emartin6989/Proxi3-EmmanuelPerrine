package mbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import metier.Conseiller;
import service.AuthentificationService;
import service.IAuthentificationService;

public class ConseillerBean {

	/*@Inject
	private IAuthentificationService service;
	*/
	IAuthentificationService service = new AuthentificationService();

	private Conseiller conseiller = new Conseiller();
	
	
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

	public String authentification() {
		if (!(conseiller.getLogin().equalsIgnoreCase("") && conseiller.getLogin().equalsIgnoreCase(""))) {
			String login = conseiller.getLogin();
			String mdp = conseiller.getMdp();
			conseiller = service.authentificationConseiller(login, mdp);
			if (conseiller.getId() != 0) {
				return "menu";
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("conseiller", new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Identifiants et/ou mot de passe inexistants", null));
				return "authentification";
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("conseiller",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir les valeurs non nulles", null));
			return "authentification";
		}

	}
}
