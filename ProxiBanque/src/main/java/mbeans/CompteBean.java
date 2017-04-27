package mbeans;

import javax.inject.Inject;

import metier.Carte;
import metier.CarteVisaElectron;
import metier.CarteVisaPremier;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import service.IConseillerService;

public class CompteBean {
	
	@Inject
	private IConseillerService service;
	
	private Compte cCourant = new CompteCourant();
	private Compte cEpargne = new CompteEpargne();
	private Carte cVisaPremier = new CarteVisaPremier();
	private Carte cVisaElectron = new CarteVisaElectron();
	/**
	 * @return the service
	 */
	public IConseillerService getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(IConseillerService service) {
		this.service = service;
	}
	/**
	 * @return the cCourant
	 */
	public Compte getcCourant() {
		return cCourant;
	}
	/**
	 * @param cCourant the cCourant to set
	 */
	public void setcCourant(Compte cCourant) {
		this.cCourant = cCourant;
	}
	/**
	 * @return the cEpargne
	 */
	public Compte getcEpargne() {
		return cEpargne;
	}
	/**
	 * @param cEpargne the cEpargne to set
	 */
	public void setcEpargne(Compte cEpargne) {
		this.cEpargne = cEpargne;
	}
	/**
	 * @return the cVisaPremier
	 */
	public Carte getcVisaPremier() {
		return cVisaPremier;
	}
	/**
	 * @param cVisaPremier the cVisaPremier to set
	 */
	public void setcVisaPremier(Carte cVisaPremier) {
		this.cVisaPremier = cVisaPremier;
	}
	/**
	 * @return the cVisaElectron
	 */
	public Carte getcVisaElectron() {
		return cVisaElectron;
	}
	/**
	 * @param cVisaElectron the cVisaElectron to set
	 */
	public void setcVisaElectron(Carte cVisaElectron) {
		this.cVisaElectron = cVisaElectron;
	}
	
	

}
