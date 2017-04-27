package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe représentant un type spécifique de compte, les comptes épargne
 * @author Perrine EMIN et Guillaume OTHMANE
 *
 */
@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	private double tauxRemuneration = 0.03;

	/**
	 * Getter du taux de rémunération du compte épargne
	 * @return Taux de rémunération du compte épargne
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * Setter du taux de rémunération du compte épargne
	 * @param tauxRemuneration Taux de rémunération du compte épargne
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}

	@Override
	public String toString() {
		return "CompteEpargne [getId()=" + getId() + ", getSolde()=" + getSolde() + "]";
	}

	
	
}
