package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe représentant un type particulier de carte bancaire, la Visa premier
 * @author Perrine EMIN et Guillaume OTHMANE
 * 
 *
 */
@Entity
@DiscriminatorValue("PREMIER")
public class CarteVisaPremier extends Carte {
	

	@Override
	public String toString() {
		return "VisaPremier";
	}

}
