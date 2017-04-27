package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe représentant un type particulier de carte bancaire, la Visa Electron
 * @author Perrine EMIN et Guillaume OTHMANE
 *
 */
@Entity
@DiscriminatorValue("ELECTRON")
public class CarteVisaElectron extends Carte {

	
	@Override
	public String toString() {
		return "VisaElectron";
	}

}
