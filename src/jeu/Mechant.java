package jeu;

import processing.core.PApplet;
import processing.core.PImage;

class Mechant extends PApplet {

	private static final long serialVersionUID = 1879318317013237995L;

	/* abscisse et ordonnées */
	private int x, y;

	/* Indices de déplacement */
	private int vitesseX, vitesseY;

	/* Vrai si le méchant est présent sur la map */
	private boolean isExistent;

	/* Vie du méchant */
	private int energie;

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
		this.x = x;
		this.y = y;
		this.vitesseX = vitesseX;
		this.vitesseY = vitesseY;
		this.isExistent = isExistent;
	}

	/**
	 * Afficher le méchant sur la map
	 */
	public void afficher() {
		PImage imageMechant;
		imageMechant = loadImage("nosferapti.png");

		// Le méchant est affiché à l'appuis de la touche "z"
		if (keyPressed) {
			if (key == 'z') {
				isExistent = true;
			}
		}
		if (isExistent) {
			image(imageMechant, x, y);
		}
	}

	/**
	 * Permet de déplacer le méchant
	 */
	public void bouger() {
		x = x + vitesseX;
		y = y + vitesseY;
	}

	/**
	 * Faire rebondir le méchant sur les murs en changeant sa trajectoire
	 */
	public void rebondir() {
		// width et height sont la largeur et la longueur de la fenêtre affichée
		// (calculée par PApplet)
		if (x > width - 10 || x < 10) {
			vitesseX = -vitesseX;
		}
		if (y > height - 10 || y < 10) {
			vitesseY = -vitesseY;
		}
	}

	/**
	 * Attaquer le gentil
	 */
	public void attaquer() {
		if (isExistent) {
			energie = energie - 50;
			isExistent = false;

			// Réinitialiser les coordonnées du méchant pour sa prochaine
			// apparition
			x = PApplet.parseInt(random(800));
			y = PApplet.parseInt(random(800));
		}
	}

	/**
	 * Faire mourrir le héro
	 */
	public void mourrir() {
		if (energie <= 0) {
			background(0);
			textSize(100);
			fill(255, 0, 0);
			text("Game Over", 150, 400);
			isExistent = false;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isExistent() {
		return isExistent;
	}

	public void setExistent(boolean isExistent) {
		this.isExistent = isExistent;
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

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}
}