package mbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import metier.Client;
import metier.Coordonnees;
import service.IConseillerService;

@Named
public class ClientBean {
	
	@Inject
	private IConseillerService service;
	
	private Client client = new Client();
	private Coordonnees coor = new Coordonnees();
	private boolean editMode = false;
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
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
	 * @param editMode the editMode to set
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
	 * @param conseillerService the conseillerService to set
	 */
	public void setConseillerService(IConseillerService conseillerService) {
		service = conseillerService;
	}
	
	public void delete() {
		service.supprimerClient(client);
		client = new Client();
	}

	public void maj() {
		editMode = true;
	}
	
	public String add() {
		if (!(client.getNom().equalsIgnoreCase("") && client.getPrenom().equalsIgnoreCase("") && coor.getAdresse().equalsIgnoreCase("")&& coor.getCp().equalsIgnoreCase("")&& coor.getEmail().equalsIgnoreCase("")&& coor.getTelephone().equalsIgnoreCase("")&& coor.getVille().equalsIgnoreCase(""))) {
			if (editMode == false) {
				service.creerClient(client, coor);
			} else {
				service.modifierClient(client, coor);
				editMode = false;
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("client", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Veuillez saisir les valeurs non nulles", null));
		}
		client = new Client();
		return "index";
	}

}
