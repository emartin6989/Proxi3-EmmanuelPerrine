package mbeans;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import metier.Client;
import metier.Conseiller;
import metier.Coordonnees;
import metier.Personne;
import service.IConseillerService;

@ManagedBean
public class ClientBean {

	@Inject
	private IConseillerService service;

	private Client client = new Client();
	private Collection<Client> clients = new ArrayList<Client>();
	private Coordonnees coor = new Coordonnees();
	private boolean editMode = false;
	private Conseiller cons = new Conseiller();
	private Personne personne;

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
	 * @return the clients
	 */
	public Collection<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients
	 *            the clients to set
	 */
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the coor
	 */
	public Coordonnees getCoor() {
		return coor;
	}

	/**
	 * @param coor
	 *            the coor to set
	 */
	public void setCoor(Coordonnees coor) {
		this.coor = coor;
	}

	/**
	 * @return the cons
	 */
	public Conseiller getCons() {
		return cons;
	}

	/**
	 * @param cons
	 *            the cons to set
	 */
	public void setCons(Conseiller cons) {
		this.cons = cons;
	}

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

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
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
	 * @return the conseillerService
	 */
	public IConseillerService getConseillerService() {
		return service;
	}

	/**
	 * @param conseillerService
	 *            the conseillerService to set
	 */
	public void setConseillerService(IConseillerService conseillerService) {
		service = conseillerService;
	}

	
	
	public String delete() {
		service.supprimerClient(client);
		client = new Client();
		return "index";
	}

	public void maj() {
		editMode = true;
	}

	public String add() {
		if (!(client.getNom().equalsIgnoreCase("") && client.getPrenom().equalsIgnoreCase("")
				&& coor.getAdresse().equalsIgnoreCase("") && coor.getCp().equalsIgnoreCase("")
				&& coor.getEmail().equalsIgnoreCase("") && coor.getTelephone().equalsIgnoreCase("")
				&& coor.getVille().equalsIgnoreCase(""))) {
			if (editMode == false) {
				service.creerClient(cons, client, coor);
			} else {
				service.modifierClient(client, coor);
				editMode = false;
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("client",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir les valeurs non nulles", null));
		}
		client = new Client();
		return "index";
	}

}
