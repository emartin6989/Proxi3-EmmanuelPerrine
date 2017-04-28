package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Classe représentant le gérant d'une agence. Hérite de la classe Personne
 * 
 * @author Jérome IZARD et Perrine EMIN
 *
 */
@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Personne {


	@OneToOne
	@JoinColumn(name="AGENCE_ID")
	private Agence agence;

	/**
	 * Getter de l'attribut agence
	 * 
	 * @return agence du gérant
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * Setter de l'attribut agence
	 * 
	 * @param agence
	 *            agence du gérant
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public void auditerAgence() {

	}

	@Override
	public String toString() {
		return "Gerant [getNom()=" + getNom() + "]";
	}

}
