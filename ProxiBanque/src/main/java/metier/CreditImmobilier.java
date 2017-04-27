/**
 * 
 */
package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * La classe CreditImmobilier permet de d�finir un cr�dit immobilier.
 * 
 * @author Perrine EMIN et Guillaume OTHMANE
 * 
 */
@Entity
@DiscriminatorValue("IMMOBILIER")
public class CreditImmobilier extends Credit {

	/**
	 * Constructeur de la classe CreditImmobilier avec arguments
	 * 
	 * @param taux
	 *            taux du cr�dit
	 * @param duree
	 *            dur�e du cr�dit
	 * @param montant
	 *            montant du cr�dit
	 */
	public CreditImmobilier(float taux, int duree, double montant) {
		super(taux, duree, montant);
	}

	public CreditImmobilier() {
		super();
	}
	
}
