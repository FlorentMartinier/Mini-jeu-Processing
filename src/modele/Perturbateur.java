package modele;

import processing.core.PApplet;

/**
 * Classe représentant les éléments perturbateurs du jeu (Le méchant et la ball)
 * 
 * @author florent
 */
public class Perturbateur extends Creature {

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
	 * Faire avancer le perturbateur sur la map
	 */
	public void avancer() {
		setX(getX() + getVitesseX());
		setY(getY() + getVitesseY());
	}

	/**
	 * Détermine si le perturbateur touche un mur sur la hauteur
	 * 
	 * @return Vrai si les coordonnées de la balle sont sur un mur en hauteur
	 */
	public boolean toucherMurHauteur(PApplet applet) {
		if (getX() > applet.width - 10 || getX() < 10) {
			return true;
		}
		return false;
	}

	/**
	 * Détermine si le perturbateur touche un mur sur la largeur
	 * 
	 * @return Vrai si les coordonnées de la balle sont sur un mur en largeur
	 */
	public boolean toucherMurLargeur(PApplet applet) {
		if (getY() > applet.height - 10 || getY() < 10) {
			return true;
		}
		return false;
	}

	/**
	 * Gère tous les mouvements que peut faire un perturbateur. C'est à dire le
	 * faire avancer sur la map et le faire rebondir sur les mur si besoin.
	 */
	public void gererMouvements(PApplet applet) {
		avancer();
		if (toucherMurHauteur(applet)) {
			rebondirHauteur();
		}
		if (toucherMurLargeur(applet)) {
			rebondirLargeur();
		}
	}

	/**
	 * Afficher le perturbateur et le faire bouger
	 * 
	 * @param applet
	 *            Application courante
	 */
	public void afficherEtBouger(PApplet applet) {
		afficher(applet);
		gererMouvements(applet);
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
