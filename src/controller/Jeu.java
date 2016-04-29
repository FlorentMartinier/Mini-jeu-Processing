package controller;

import modele.Ball;
import modele.Creature;
import modele.Gentil;
import modele.Mechant;
import modele.Nourriture;
import processing.core.PApplet;
import vue.Vue;

public class Jeu extends PApplet {

	private static final long serialVersionUID = 2772472098256683184L;

	Gentil gentil;
	Mechant mechant;
	Ball ball;
	Nourriture nourriture;

	Vue vue;

	/** Timer */
	int tempsDebut;
	int tempsTotal;

	/*
	 * Initialisation de l'application. Instruction s'éxécutant une seule fois
	 * au démarrage.
	 * 
	 * @see processing.core.PApplet#setup()
	 */
	public void setup() {

		// Définition de la taille de la fenêtre
		vue.definirFenetre(800, 800);

		// Définition des acteurs
		gentil = new Gentil(100, 100, 195);
		tempsDebut = millis();
		tempsTotal = 1000;
	}

	/*
	 * Instructions s'exécutant régulièrement (équivaut à un while(true))
	 * 
	 * @see processing.core.PApplet#draw()
	 */
	public void draw() {
		// TODO définir l'intelligence de jeu
		if (keyPressed) {
			gererEvenementClavier();
		}

		if (ball.isExistent()) {
			vue.capturer();
			ball.setExistent(false);
		}
		
		if (mechant.isExistent()){
			mechant.attaquer(gentil);
		}

		vue.afficherVie(gentil);
	}

	/**
	 * Faire rebondir le méchant sur les murs en changeant sa trajectoire
	 */
	public void rebondir() {
		// width et height sont la largeur et la longueur de la fenêtre affichée
		// (calculée par PApplet)
		if (mechant.getX() > width - 10 || mechant.getX() < 10) {
			mechant.setVitesseX(-mechant.getVitesseX());
		}
		if (mechant.getY() > height - 10 || mechant.getY() < 10) {
			mechant.setVitesseY(-mechant.getVitesseY());
		}
	}

	/**
	 * Faire baisser la vie du gentil avec le temps
	 */
	public void baisserVieAvecTemps() {
		int tempsPasse = millis() - tempsDebut;
		if (tempsPasse > tempsTotal) {
			if (gentil.getVie() > 0) {
				gentil.setVie(gentil.getVie() - 1);
				tempsDebut = millis();
			}
		}
	}

	/**
	 * @return Vrai si les coordonnées de la balle sont sur un mur en hauteur
	 */
	public boolean toucherMurHauteur(Creature creature) {
		if (creature.getX() > width - 10 || creature.getX() < 10) {
			return true;
		}
		return false;
	}

	/**
	 * @return Vrai si les coordonnées de la balle sont sur un mur en largeur
	 */
	public boolean toucherMurLargeur(Creature creature) {
		if (creature.getY() > height - 10 || creature.getY() < 10) {
			return true;
		}
		return false;
	}

	/**
	 * Gérer tous les évènements clavier
	 */
	public void gererEvenementClavier() {
		if (key == 'z') {
			mechant.setExistent(true);
		} else if (key == 'p') {
			ball.setExistent(true);
		}
	}
}
