package metier;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe abstraite représentant les comptes des clients de la banque
 * @author Perrine EMIN et Guillaume OTHMANE
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
public abstract class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Compte_id")
	private long numCompte;
	private double solde;
	private Date dateOuverture;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Client client;
	@OneToOne(mappedBy="compte")
	private Carte carte;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Agence agence;

	
	/**
	 * Getter du numéro de compte
	 * @return Numéro de compte
	 */
	public long getNumCompte() {
		return numCompte;
	}

	/**
	 * Setter du numéro de compte
	 * @param numCompte Numéro de compte
	 */
	public void setNumCompte(long numCompte) {
		this.numCompte = numCompte;
	}

	/**
	 * Getter du solde du compte
	 * @return Solde du compte
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * Setter du solde du compte
	 * @param solde Solde du compte
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * Getter de la date d'ouverture du compte
	 * @return Date d'ouverture du compte
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * Setter de la date d'ouverture du compte
	 * @param dateOuverture Date d'ouverture du compte
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	/**
	 * Getter du client du compte
	 * @return Client du compte
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Setter du client du compte
	 * @param client Client du compte
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Getter de la carte du compte
	 * @return Carte du compte
	 */
	public Carte getCarte() {
		return carte;
	}

	/**
	 * Setter de la carte du compte
	 * @param carte Carte du compte
	 */
	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	@Override
	public String toString() {
		return "Compte [Numéro de compte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + ", carte=" + carte + "]";
	}

}
