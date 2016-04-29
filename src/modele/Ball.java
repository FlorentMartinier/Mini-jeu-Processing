package modele;

public class Ball extends Perturbateur {

	/**
	 * Constructeur
	 * 
	 * @param x
	 *            Absysse
	 * @param y
	 *            Ordonnées
	 * @param vitesseX
	 *            Vitesse en abcysse
	 * @param vitesseY
	 *            Vitesse en ordonnées
	 * @param isExistent
	 *            Existence
	 */
	public Ball(int x, int y, int vitesseX, int vitesseY, boolean isExistent) {
		super(x, y, vitesseX, vitesseY, isExistent);
	}
}
