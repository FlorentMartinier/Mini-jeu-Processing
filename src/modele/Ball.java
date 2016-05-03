package modele;

public class Ball extends Perturbateur {

	private static final long serialVersionUID = -786874141870123144L;

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
