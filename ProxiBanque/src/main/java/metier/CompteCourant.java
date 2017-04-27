package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe repr�sentant un type sp�cifique de compte, les comptes courants
 * @author Perrine EMIN et Guillaume OTHMANE
 *
 */
@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	private double decouvert = 1000;

	/**
	 * Getter du d�couvert du compte courant
	 * @return D�couvert du compte courant
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * Setter du d�couvert du compte courant
	 * @param decouvert D�couvert du compte courant
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}


	@Override
	public String toString() {
		return "CompteCourant [getId()=" + getId() + ", getSolde()=" + getSolde() + "]";
	}

	

	

}
