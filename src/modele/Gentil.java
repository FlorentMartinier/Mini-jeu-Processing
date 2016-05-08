package modele;

import processing.core.PApplet;

public class Gentil extends Creature {

	/** Vie du gentil */
	private int vie;

	/**
	 * Constructeur du gentil (définission d'une abscisse, d'une ordonnée et de
	 * la vie)
	 * 
	 * @param x
	 *            abscisse
	 * @param y
	 *            ordonnée
	 * @param vie
	 *            Vie du gentil
	 */
	public Gentil(int x, int y, int vie) {
		super(x, y);
		this.vie = vie;
	}

	/**
	 * Déplacer le gentil vers le bas d'une case
	 */
	public void faireMouvementBas() {
		setY(getY() + 10);
	}

	/**
	 * Déplacer le gentil vers le haut d'une case
	 */
	public void faireMouvementHaut() {
		setY(getY() - 10);
	}

	/**
	 * Déplacer le gentil vers la droite d'une case
	 */
	public void faireMouvementdroite() {
		setX(getX() + 10);
	}

	/**
	 * Déplacer le gentil vers le haut d'une case
	 */
	public void faireMouvementgauche() {
		setX(getX() - 10);
	}

	/**
	 * Manger de la nourriture pour augmenter sa santer
	 */
	public void manger(Nourriture nourriture) {
		if (nourriture.isExistent()) {
			vie = vie + 10;
		}
		if (vie > 194) {
			vie = 194;
		}
		nourriture.setExistent(false);
	}

	/**
	 * Faire baisser la vie du gentil avec le temps
	 * 
	 * @param tempsDebut
	 * @param tempsTotal
	 * @param applet
	 * @return
	 */
	public int baisserVieAvecTemps(int tempsDebut, int tempsTotal, PApplet applet) {
		int tempsPasse = applet.millis() - tempsDebut;
		if (tempsPasse > tempsTotal) {
			if (getVie() > 0) {
				setVie(getVie() - 1);
				return applet.millis();
			}
		}
		return tempsDebut;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
}
