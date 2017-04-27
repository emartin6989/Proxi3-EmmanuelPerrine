/**
 * 
 */
package metier;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Classe pour la gestion des adresses et des numeros de telephone.
 * 
 * @author Perrine EMIN et Guillaume OTHMANE
 */
@Entity
public class Coordonnees {

	// Proprietes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Coordonnees_id")
	private int id;
	private String adresse;
	private String ville;
	private String cp;
	private String telephone;
	private String email;
	@OneToMany(mappedBy="coordonnees")
	private Collection<Personne> personne;


	/**
	 * Getter de l'adresse
	 * 
	 * @return Adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Setter de l'adresse
	 * 
	 * @param adresse
	 *            Adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter de la ville
	 * 
	 * @return Ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter de la ville
	 * 
	 * @param ville
	 *            Ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter du code postal
	 * 
	 * @return Code postal
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Setter du code postal
	 * 
	 * @param cp
	 *            Code postal
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * Getter du numéro de téléphone
	 * 
	 * @return Numéro de téléphone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Setter du numéro de téléphone
	 * 
	 * @param telephone
	 *            Numéro de téléphone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter de l'email
	 * 
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter de l'email
	 * 
	 * @param email
	 *            Email du client
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	// Methode toString()
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coordonees: " + adresse + ", " + cp + " " + ville + "; tel: " + telephone;
	}
}
