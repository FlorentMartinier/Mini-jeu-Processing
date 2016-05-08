package modele;

public class Mechant extends Perturbateur {

	/**
	 * Constructeur
	 * 
	 * @param x
	 *            Abscisse
	 * @param y
	 *            Ordonnée
	 * @param vitesseX
	 *            Vitesse en abscisse
	 * @param vitesseY
	 *            Vitesse en ordonnée
	 * @param isExistent
	 *            Existence du méchant
	 */
	public Mechant(int x, int y, int vitesseX, int vitesseY, boolean isExistent) {
		super(x, y, vitesseX, vitesseY, isExistent);
	}

	/**
	 * Attaquer le gentil et faire disparaitre le méchant
	 */
	public void attaquer(Gentil gentil) {
		if (gentil.getVie() > 50) {
			gentil.setVie(gentil.getVie() - 50);
		} else {
			gentil.setVie(0);
		}
		setExistent(false);
	}
}