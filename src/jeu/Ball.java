package jeu;

import processing.core.PApplet;
import processing.core.PImage;

class Ball extends PApplet {
	private static final long serialVersionUID = 3894489779619834739L;

	/* Abscysse et Ordonnées */
	private int x, y;

	/* Vitesse de déplacement */
	private int vitesseX, vitesseY;

	/* Existence de la balle */
	private boolean isExistent;

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
		this.x = x;
		this.y = y;
		this.vitesseX = vitesseX;
		this.vitesseY = vitesseY;
		this.isExistent = isExistent;
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

	/**
	 * Afficher la balle
	 */
	public void afficher() {
		PImage imageBall;
		imageBall = loadImage("masterball.png");

		// Affichage de la balle en appyant sur "p"
		if (keyPressed) {
			if (key == 'p') {
				isExistent = true;
			}
		}
		if (isExistent) {
			image(imageBall, x, y);
			text("masterball go !", 350, 350);
		}
	}

	/**
	 * Mouvement de la balle
	 */
	public void bouger() {
		if (isExistent) {
			x = x + vitesseX;
			y = y + vitesseY;
		}
	}

	/**
	 * Faire rebondir la balle sur les murs en changeant de trajectoire
	 */
	public void rebondir() {
		if (x > width - 10 || x < 10) {
			vitesseX = -vitesseX;
		}
		if (y > height - 10 || y < 10) {
			vitesseY = -vitesseY;
		}
	}

	/**
	 * Si la master ball touche notre héro, il se fait capturer ! N'oublions pas
	 * que la master ball est unique et capture à tous les coups !
	 */
	public void capturer() {
		if (isExistent) {
			background(0);
			textSize(50);
			fill(255, 0, 0);
			text("vous \u00eates captur\u00e9 !", 170, 400);
			isExistent = false;
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
