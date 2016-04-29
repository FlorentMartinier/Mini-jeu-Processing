package modele;

/**
 * Classe représentant les éléments perturbateurs du jeu (Le méchant et la ball)
 * @author florent
 */
public class Perturbateur extends Creature{

	/* Indices de déplacement */
	private int vitesseX, vitesseY;

	/* Vrai si le perturbateur est présent sur la map */
	private boolean isExistent;
	

	public Perturbateur(int x, int y, int vitesseX, int vitesseY, boolean isExistent) {
		super(x, y);
		this.vitesseX = vitesseX;
		this.vitesseY = vitesseY;
		this.isExistent = isExistent;
	}
	
	/**
	 * Faire rebondir sur les murs en hauteur
	 */
	public void rebondirHauteur() {
		setVitesseX(-getVitesseX());
	}

	/**
	 * Faire rebondir sur les murs en largeur
	 */
	public void rebondirLargeur() {
		setVitesseY(-getVitesseY());
	}
	
	/**
	 * Mouvement du perturbateur
	 */
	public void bouger() {
		if (isExistent()) {
			setX(getX() + getVitesseX());
			setY(getY() + getVitesseY());
		}
	}

	public int getVitesseX() {
		return vitesseX;
	}

	public void setVitesseX(int vitesseX) {
		this.vitesseX = vitesseX;
	}

	public int getVitesseY() {
		return vitesseY;
	}

	public void setVitesseY(int vitesseY) {
		this.vitesseY = vitesseY;
	}

	public boolean isExistent() {
		return isExistent;
	}

	public void setExistent(boolean isExistent) {
		this.isExistent = isExistent;
	}
}
