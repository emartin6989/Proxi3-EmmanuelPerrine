package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe repr�sentant un type sp�cifique de compte, les comptes �pargne
 * @author Perrine EMIN et Guillaume OTHMANE
 *
 */
@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	private double tauxRemuneration = 0.03;

	/**
	 * Getter du taux de r�mun�ration du compte �pargne
	 * @return Taux de r�mun�ration du compte �pargne
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * Setter du taux de r�mun�ration du compte �pargne
	 * @param tauxRemuneration Taux de r�mun�ration du compte �pargne
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	@Override
	public String toString() {
		return "CompteEpargne [getNumCompte()=" + getNumCompte() + ", getSolde()=" + getSolde() + "]";
	}

	
	
}
