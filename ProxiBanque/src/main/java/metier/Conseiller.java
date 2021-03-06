package metier;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Classe repr�sentant les conseiller de l'agence. Elle h�rite de la classe Personne
 * @author Perrine EMIN et Guillaume OTHMANE
 *
 */
@Entity
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends Personne {

	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Agence agence;
	@OneToMany(mappedBy="conseiller")
	private Collection<Client> clients = new ArrayList<Client>();
	
	/**
	 * Getter de l'agence du conseiller
	 * @return Agence du conseiller
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * Setter de l'agence du conseiller
	 * @param agence Agence du conseiller
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/**
	 * Getter des clients du conseiller
	 * @return Clients du conseiller
	 */
	public Collection<Client> getClients() {
		return clients;
	}

	/**
	 * Setter des clients du conseiller
	 * @param clients Clients du conseiller
	 */
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp
	 *            the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "[Conseiller : "+ getPrenom()+ " "+ getNom()+"]";
	}

	
}
