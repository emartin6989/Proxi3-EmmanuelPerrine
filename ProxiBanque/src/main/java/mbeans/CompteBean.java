package mbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import metier.Carte;
import metier.CarteVisaElectron;
import metier.CarteVisaPremier;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import service.IConseillerService;

@Named
public class CompteBean {

	@Inject
	private IConseillerService service;

	private CompteCourant cCourant = new CompteCourant();
	private CompteEpargne cEpargne = new CompteEpargne();
	private CarteVisaPremier cVisaPremier = new CarteVisaPremier();
	private CarteVisaElectron cVisaElectron = new CarteVisaElectron();
	private Client client = new Client();
	boolean editMode = false;

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the editMode
	 */
	public boolean isEditMode() {
		return editMode;
	}

	/**
	 * @param editMode
	 *            the editMode to set
	 */
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	/**
	 * @return the service
	 */
	public IConseillerService getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(IConseillerService service) {
		this.service = service;
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
	 * @return the cVisaPremier
	 */
	public CarteVisaPremier getcVisaPremier() {
		return cVisaPremier;
	}

	/**
	 * @param cVisaPremier
	 *            the cVisaPremier to set
	 */
	public void setcVisaPremier(CarteVisaPremier cVisaPremier) {
		this.cVisaPremier = cVisaPremier;
	}

	/**
	 * @return the cVisaElectron
	 */
	public CarteVisaElectron getcVisaElectron() {
		return cVisaElectron;
	}

	/**
	 * @param cVisaElectron
	 *            the cVisaElectron to set
	 */
	public void setcVisaElectron(CarteVisaElectron cVisaElectron) {
		this.cVisaElectron = cVisaElectron;
	}

	public String delete() {
		service.supprimerCompte(cCourant);
		service.supprimerCompte(cEpargne);
		return "listeCompte";
	}

	public void maj() {
		editMode = true;
	}

	public String add() {
		if (!(cCourant.getDecouvert() != 0 && cCourant.getNumCompte() != 0)) {
			if (editMode == false) {
				service.creerCompteCourant(client, cCourant);
			}
		} else {
			if (!(cEpargne.getTauxRemuneration() != 0 && cEpargne.getNumCompte() != 0)) {
				if (editMode == false) {
					service.creerCompteEpargne(client, cEpargne);
				}else{
					
					service.modifierCompte(cCourant);
					service.modifierCompte(cEpargne);
				}
			} else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("compte",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir des valeurs non nulles", null));
			}
		}
		return "listeCompte";
	}

}
