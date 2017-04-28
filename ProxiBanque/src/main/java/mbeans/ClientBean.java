package mbeans;

import java.util.ArrayList;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import metier.Client;
import metier.Compte;
import metier.Conseiller;
import metier.Coordonnees;
import service.ConseillerService;
import service.IConseillerService;

@ManagedBean
//@ViewScoped
@SessionScoped
public class ClientBean {

	IConseillerService service = new ConseillerService();

	private Client client = new Client();
	private Collection<Client> clients = new ArrayList<Client>();
	private Coordonnees coor = new Coordonnees();
	private boolean editMode = false;
	private Conseiller cons = new Conseiller();
	private Collection<Compte> comptes = new ArrayList<Compte>();

	
	
	/**
	 * @return the comptes
	 */
	public Collection<Compte> getComptes() {
		return comptes;
	}

	/**
	 * @param comptes
	 *            the comptes to set
	 */
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
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

	public void delete() {
		/*if (cons.getClients().contains(client)) {
			*/service.supprimerClient(client);/*
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("client",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vous ne gérez pas ce client", null));
		}*/
		client = new Client();
		coor = new Coordonnees();
		//return "editerClient";
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
				if (cons.getClients().size() < 10) {
					if (client.getConseiller() == null) {
						service.creerClient(cons, client, coor);
						client = new Client();
						coor = new Coordonnees();
						return "editerClient";

					} else {
						FacesContext context = FacesContext.getCurrentInstance();
						context.addMessage("client",
								new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ce client a déjà un conseiller", null));
						client = new Client();
						coor = new Coordonnees();
					}

				} else {
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage("client",
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vous avez déjà 10 clients a gérer", null));
					client = new Client();
					coor = new Coordonnees();
				}
			} else {
				service.modifierClient(client, coor);
				editMode = false;
				client = new Client();
				coor = new Coordonnees();
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("client",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir des valeurs non nulles", null));
		}
		client = new Client();
		coor = new Coordonnees();
		return "editerClient";
	}
	
	public String listerComptes() {
		Client clientcourant=this.client;
		comptes = service.listerComptes(clientcourant);
		return "listeCompte";
	}

}
