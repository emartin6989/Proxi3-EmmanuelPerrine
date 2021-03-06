package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * La classe creditConsommation permet de d�finir un cr�dit � la consommation.
 * 
 * @author Perrine EMIN et Guillaume OTHMANE
 * 
 */
@Entity
@DiscriminatorValue("CONSOMMATION")
public class CreditConsommation extends Credit {

	/**
	 * Constructeur de la classe CreditConsommation avec arguments
	 * 
	 * @param taux
	 *            taux du cr�dit
	 * @param duree
	 *            dur�e du cr�dit
	 * @param montant
	 *            montant du cr�dit
	 */
	public CreditConsommation(float taux, int duree, double montant) {
		super(taux, duree, montant);
	}

	public CreditConsommation() {
		super();
	}
	
}
