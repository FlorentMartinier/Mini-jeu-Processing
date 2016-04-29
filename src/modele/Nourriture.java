package modele;

import processing.core.PApplet;
import processing.core.PImage;

// TODO extends Element afficher
public class Nourriture extends PApplet {

	private static final long serialVersionUID = -5401351733796883435L;

	/* Coordonnées */
	private int x, y;

	/* Existence de la nourriture */
	private boolean isExistent;

	public Nourriture(int x, int y, boolean isExistent) {
		this.x = x;
		this.y = y;
		this.isExistent = isExistent;
	}

	/**
	 * Afficher la nourriture
	 */
	public void afficher() {
		PImage imageNourriture;
		imageNourriture = loadImage("273.png");

		// Afficher la nourriture après un clic
		if (mousePressed) {
			isExistent = true;

			// Réinitialiser les coordonnées après chaque clic
			x = (int) random(800);
			y = (int) random(800);
		}
		if (isExistent) {
			fill(100, 100, 0);
			image(imageNourriture, x - 50, y - 50);
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
}
