package metier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * La classe Credit permet de définir un crédit
 * 
 * @author Perrine EMIN et Guillaume OTHMANE
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CREDIT")
public abstract class Credit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Credit_id")
	private int id;

	/**
	 * Le taux du crédit en %.
	 */
	private float taux;

	/**
	 * La durée du crédit en mois.
	 */
	private int duree;

	/**
	 * Le montant du credit.
	 */
	private double montant;

	/**
	 * Constructeur de la classe Credit avec arguments
	 * 
	 * @param taux
	 *            le taux du crédit
	 * @param duree
	 *            la durée du crédit
	 * @param montant
	 *            le montant du crédit
	 */
	public Credit(float taux, int duree, double montant) {
		super();
		this.taux = taux;
		this.duree = duree;
		this.montant = montant;
	}

	/**
	 * Getter de l'attribut taux
	 * 
	 * @return le taux du crédit
	 */
	public float getTaux() {
		return taux;
	}

	/**
	 * Setter de l'attribut taux
	 * 
	 * @param taux
	 *            le taux du crédit
	 */
	public void setTaux(float taux) {
		this.taux = taux;
	}

	/**
	 * Getter de l'attribut duree
	 * 
	 * @return la durée du crédit
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * Setter de l'attribut duree
	 * 
	 * @param duree
	 *            la durée du crédit
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * Getter de l'attribut montant
	 * 
	 * @return le montant du crédit
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Setter de l'attribut montant
	 * 
	 * @param montant
	 *            le montant du crédit
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	

	public Credit() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Credit [taux=" + taux + ", duree=" + duree + ", montant=" + montant + "]";
	}

}
