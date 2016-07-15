package controller;

import modele.Ball;
import modele.EtatPartie;
import modele.Gentil;
import modele.Mechant;
import modele.Nourriture;
import processing.core.PApplet;
import vue.Vue;

public class Jeu extends PApplet {

	private static final long serialVersionUID = 2772472098256683184L;
	private PApplet applet;

	private Gentil gentil;
	private Mechant mechant;
	private Ball ball;
	private Nourriture nourriture;

	private EtatPartie etatPartie;

	private Vue vue;

	/** Timer */
	private int tempsDebut;
	private int tempsTotal;

	/**
	 * Initialisation de l'application. Instruction s'éxécutant une seule fois
	 * au démarrage.
	 */
	@Override
	public void setup() {
		applet = this;
		vue = new Vue();
		etatPartie = EtatPartie.EN_JEU;

		// Définition de la taille de la fenêtre
		applet.size(800, 800);

		// Définition des acteurs
		gentil = new Gentil(100, 100, 195);
		gentil.initialiserImageElement(applet);

		mechant = new Mechant(100, 100, 10, 10, false);
		mechant.initialiserImageElement(applet);

		ball = new Ball(100, 100, 10, 10, false);
		ball.initialiserImageElement(applet);

		nourriture = new Nourriture(100, 100, false);
		nourriture.initialiserImageElement(applet);

		// Temps depuis le début de l'application
		tempsDebut = applet.millis();
		tempsTotal = 1000;
	}

	/**
	 * Boucle de jeu (équivaut à un while true)
	 */
	@Override
	public void draw() {

		// Si le gentil est caturé, le signaler
		if (etatPartie == EtatPartie.GENTIL_CAPTURE) {
			vue.afficherCapturer(applet);
		}

		// Si le gentil est mort, fin du jeu
		else if (etatPartie == EtatPartie.GENTIL_MORT) {
			vue.afficherGameOver(applet);
		}

		// Sinon le jeu continue
		else {

			// Afficher le décors de jeu et le gentil
			vue.afficherDecors(applet);
			gentil.afficher(applet);

			// Gérer les interactions du méchant
			if (mechant.isExistent()) {
				mechant.afficherEtBouger(applet);
				if (mechant.toucherElement(gentil)) {
					mechant.attaquer(gentil);

					// Si après l'attaque, le gentil n'a plus de vie, il est
					// mort
					if (gentil.getVie() < 1) {
						etatPartie = EtatPartie.GENTIL_MORT;
					}
				}
			}

			// Gérer les interactions avec la ball
			if (ball.isExistent()) {
				ball.afficherEtBouger(applet);

				// Si le gentil est touché par la ball, il est capturé
				if (ball.toucherElement(gentil)) {
					ball.setExistent(false);
					mechant.setExistent(false);
					etatPartie = EtatPartie.GENTIL_CAPTURE;
				}
			}

			// Gérer les interactions avec la nourriture
			if (nourriture.isExistent()) {
				nourriture.afficher(applet);

				// Si le gentil touche la nourriture, il la mange
				if (gentil.toucherElement(nourriture)) {
					gentil.manger(nourriture);
				}
			}

			// Gérer les interactions avec le clavier
			if (applet.keyPressed) {
				gererEvenementClavier();
			}

			// Gérer les interactions avec la souris
			if (applet.mousePressed) {
				gererEvenementSouris();
			}

			// Afficher la vie du gentil et les informations pour l'utilisateur
			vue.afficherVie(gentil, applet);
			vue.afficherInformations(applet);

			// Faire baisser la vie du gentil avec le temps
			tempsDebut = gentil.baisserVieAvecTemps(tempsDebut, tempsTotal, applet);
		}
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

		// Mouvements du gentil
		else if (key == CODED) {
			if (keyCode == DOWN) {
				gentil.faireMouvementBas();
			}
			if (keyCode == RIGHT) {
				gentil.faireMouvementdroite();
			}
			if (keyCode == LEFT) {
				gentil.faireMouvementgauche();
			}
			if (keyCode == UP) {
				gentil.faireMouvementHaut();
			}
		}
	}

	/**
	 * Gérer les évenements au clic de la souris
	 */
	public void gererEvenementSouris() {

		// Afficher la nourriture
		nourriture.setExistent(true);
		nourriture.setX(applet.mouseX - 50);
		nourriture.setY(applet.mouseY - 50);
	}

	/**
	 * Jouer le jeu
	 */
	public static void main(String[] args) {
		PApplet.main(new String[] { Jeu.class.getName() });
	}
}
