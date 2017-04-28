package metier;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Classe représentant les clients de la banque, héritant de la classe Personne
 * 
 * @author Perrine EMIN et Guillaume OTHMANE
 *
 */
@Entity
@DiscriminatorValue("CLIENT")
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c where c.conseiller.id = :idcons")
public class Client extends Personne {

	private boolean entreprise;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Conseiller conseiller;
	@OneToMany(mappedBy = "client")
	private Collection<Compte> comptes;
	@OneToMany(mappedBy = "client")
	private Collection<Placement> placements;

	
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
	 * @return the entreprise
	 */
	public boolean isEntreprise() {
		return entreprise;
	}

	/**
	 * @param entreprise
	 *            the entreprise to set
	 */
	public void setEntreprise(boolean entreprise) {
		this.entreprise = entreprise;
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
	 * @return the placements
	 */
	public Collection<Placement> getPlacements() {
		return placements;
	}

	/**
	 * @param placements
	 *            the placements to set
	 */
	public void setPlacements(Collection<Placement> placements) {
		this.placements = placements;
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


	@Override
	public String toString() {
		if (isEntreprise()) {
			return "Client [entreprise=" + entreprise + ", conseiller=" + conseiller + ", comptes=" + comptes
					+ ", getNom()=" + getNom() + "]";
		}
		return "Client [entreprise=" + entreprise + ", conseiller=" + conseiller + ", comptes=" + comptes
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + "]";
	}

}
