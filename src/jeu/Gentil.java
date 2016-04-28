package jeu;

import processing.core.PApplet;
import processing.core.PImage;

public class Gentil extends PApplet {

	private static final long serialVersionUID = 1708516344371834562L;

	/* Coordonnées du gentil */
	private int x, y;

	/* Vie du gentil */
	private int vie;

	private int savedTime; // instauration d'un timer
	private int totalTime = 1000;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getSavedTime() {
		return savedTime;
	}

	public void setSavedTime(int savedTime) {
		this.savedTime = savedTime;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	/**
	 * Constructeur du gentil (définission d'une abscisse et d'une ordonnée)
	 * 
	 * @param x
	 *            abscisse
	 * @param y
	 *            ordonnée
	 */
	public Gentil(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Afficher le gentil sur la map
	 */
	public void afficher() {
		// Chargement de l'image représentant le gentil
		PImage img;
		img = loadImage("mrbean.gif");

		// Affichage de l'image aux coordonnées du gentil
		image(img, x, y);
		noStroke();
	}

	/**
	 * Déplacer le gentil vers le bas d'une case
	 */
	public void faireMouvementBas() {
		for (int i = 0; i < 10; i++) {
			y++;
		}
	}

	/**
	 * Déplacer le gentil vers le haut d'une case
	 */
	public void faireMouvementHaut() {
		for (int i = 0; i < 10; i++) {
			y--;
		}
	}

	/**
	 * Déplacer le gentil vers la droite d'une case
	 */
	public void faireMouvementdroite() {
		for (int i = 0; i < 10; i++) {
			x++;
		}
	}

	/**
	 * Déplacer le gentil vers le haut d'une case
	 */
	public void faireMouvementgauche() {
		for (int i = 0; i < 10; i++) {
			x--;
		}
	}

	/**
	 * Afficher la vie du gentil
	 */
	public void afficherVie() {
		fill(0);
		rect(21, 21, 196, 17);
		fill(255, 0, 0);
		rect(22, 22, vie, 15);
		fill(0);
		textSize(20);
		text("Sant\u00e9", 20, 20);
	}

	/**
	 * Faire baisser la vie du gentil avec le temps
	 */
	public void baisserVieAvecTemps() {
		int tempsPasse = millis() - savedTime;
		if (tempsPasse > totalTime) {
			if (vie > 0) {
				vie--;
				savedTime = millis();
			}
		}
	}
}
