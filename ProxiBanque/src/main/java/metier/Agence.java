package metier;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Classe repr�sentant une agence
 * @author Perrine EMIN et Guillaume OTHMANE
 *
 */
@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Agence_id")
	private int id;
	private String nomAgence;
	private String dateCreation;
	@OneToOne(mappedBy="agence")
	private Gerant gerant;
	@OneToMany(mappedBy="agence")
	private Collection<Conseiller> conseillers;
	@OneToMany(mappedBy="agence")
	private Collection<Compte> comptes;
	
	/**
	 * Getter de l'identifiant de l'agence
	 * @return Identifiant de l'agence
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter de l'identifiant de l'agence
	 * @param id Identifiant de l'agence
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter du num�ro de l'agence
	 * @return Num�ro de l'agence
	 */
	public String getNomAgence() {
		return nomAgence;
	}

	/**
	 * Setter du num�ro de l'agence
	 * @param numAgence Num�ro de l'agence
	 */
	public void setNomAgence(String numAgence) {
		this.nomAgence = nomAgence;
	}

	/**
	 * Getter de la date de cr�ation de l'agence
	 * @return Date de cr�ation de l'agence
	 */
	public String getDateCreation() {
		return dateCreation;
	}

	/**
	 * Setter de la date de cr�ation de l'agence
	 * @param dateCreation Date de cr�ation de l'agence
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Getter du g�rant de l'agence
	 * @return G�rant de l'agence
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * Setter du g�rant de l'agence
	 * @param gerant G�rant de l'agence
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	/**
	 * Getter des conseillers de l'agence
	 * @return Conseillers de l'agence
	 */
	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}

	/**
	 * Setter des conseillers de l'agence
	 * @param conseillers Conseillers de l'agence
	 */
	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	/**
	 * Getter des comptes de l'agence
	 * @return Comptes de l'agence
	 */
	public Collection<Compte> getComptes() {
		return comptes;
	}

	/**
	 * Setter des comptes de l'agence
	 * @param comptes Comptes de l'agence
	 */
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}



	@Override
	public String toString() {
		return "Agence [id=" + id + ", numAgence=" + nomAgence + ", dateCreation=" + dateCreation + ", gerant=" + gerant
				+ ", conseillers=" + conseillers + "]";
	}

	
}
