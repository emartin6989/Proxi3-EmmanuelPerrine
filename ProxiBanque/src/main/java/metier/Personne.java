package metier;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * Classe abstraite représentant les personnes
 * 
 * @author Perrine EMIN et Guillaume OTHMANE
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERSONNE")
public abstract class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	protected String nom;
	protected String prenom;
	@ManyToOne(cascade = CascadeType.PERSIST)
	protected Coordonnees coordonnees;
	protected String login = null;
	protected String mdp = null;

	/**
	 * Getter de l'attribut id
	 * 
	 * @return the id Id de la personne
	 */
	public int getId() {
		return id;
	}

	/**
	 * Seter de l'attribut id
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Geter de l'attribut nom
	 * 
	 * @return the nom nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Seter de l'attribut nom
	 * 
	 * @param nom
	 *            the nom to set nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de l'attribut prenom
	 * 
	 * @return the prenom prenom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter de l'attribut prenom
	 * 
	 * @param prenom
	 *            the prenom to set prenom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de l'attribut coordonnees
	 * 
	 * @return the coordonnees coordonnées de la personne
	 */
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	/**
	 * @param coordonnees
	 *            the coordonnees to set
	 */
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
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

	/**
	 * Constructeur de Personne sans argument
	 */
	public Personne() {
		super();
	}

}
