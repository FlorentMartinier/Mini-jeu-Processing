/*package controller;

import modele.Ball;
import modele.Gentil;
import modele.Mechant;
import modele.Nourriture;
import outils.Outils;
import processing.core.*;

public class Mini_Jeu extends PApplet {
	private static final long serialVersionUID = -2331210285961685039L;
	Gentil gentil = new Gentil(100, 100, 195); // notre h\u00e9ros !
	Nourriture[] nourriture = new Nourriture[10]; // la nourriture
	Mechant mechant = new Mechant(PApplet.parseInt(random(800)), PApplet.parseInt(random(800)), 10, 10, false); // le
																												// m\u00e9chant
																												// !
	Ball ball = new Ball(PApplet.parseInt(random(800)), PApplet.parseInt(random(800)), 10, 10, false); // un
																												// \u00e9l\u00e9ment
																												// perturbateur
	int savedTime; // instauration d'un timer
	int totalTime = 1000;
	float[] distance = new float[10];
	float distance_poke = 26;

	public void setup() {
		for (int i = 0; i < 10; i++) {
			nourriture[i] = new Nourriture((int) random(800), (int) random(800), false);
		}
		size(800, 800);
		savedTime = millis();
	}

	public void draw() {
		for (int i = 0; i < 10; i++) {
			// distance héros / nourriture :
			Outils.calculerDistanceNourriture(gentil, nourriture[i]);
		}
		// distance héros / méchant :
		float distance_mechant = Outils.calculerDistanceMechant(gentil, mechant);
		if (distance_poke > 25 && ball.isExistent()) {
			// distance héros / masterball :
			distance_poke = sqrt((ball.getX() - gentil.getX() - 5) * (ball.getX() - gentil.getX() - 5)
					+ (ball.getY() - gentil.getY() - 10) * (ball.getY() - gentil.getY() - 10));
		}
		if (distance_poke > 25) {
			// les 3 prochaines lignes peuvent \u00eatre remplac\u00e9es par un
			// background pour plus de rapidit\u00e9.
			// PImage img_foret;
			// img_foret = loadImage ("foret.png");
			// image (img_foret, 0, 0);
			background(0, 200, 0);
			// les instructions pour l'utilisateur :
			fill(255);
			text("'z' = ennemie", 680, 20);
			text("clic = nourriture", 659, 40);
			text("'p' = surprise !", 670, 60);
			gentil.afficher();
			for (int i = 0; i < 10; i++) {
				nourriture[i].afficher();
			}
			gentil.afficherVie();
			gentil.baisserVieAvecTemps();
		}
		for (int i = 0; i < 10; i++) {
			if (distance[i] < 25) {
				gentil.manger(nourriture[i]);
			}
		}
		ball.afficher();
		mechant.afficher();
		mechant.bouger();
		mechant.rebondir();
		gentil.mourrir();
		if (distance_mechant < 25) {
			mechant.attaquer(gentil);
		}
		ball.afficher();
		ball.bouger();
		if (ball.toucherMurHauteur()){
			ball.rebondirHauteur();			
		}
		if (ball.toucherMurLargeur()){
			ball.rebondirLargeur();			
		}
		if (distance_poke < 25) {
			ball.capturer();
		}
	}

	public void keyPressed() {
		if (key == CODED) {
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

	static public void main(String args[]) {
		PApplet.main(new String[] { "--bgcolor=#F0F0F0", "call_of_gland" });
	}
}
*/