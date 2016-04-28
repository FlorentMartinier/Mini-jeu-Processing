package jeu;

import processing.core.*;
import processing.xml.*;

import java.applet.*;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.FocusEvent;
import java.awt.Image;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
import java.util.zip.*;
import java.util.regex.*;

public class Mini_Jeu extends PApplet {
	private static final long serialVersionUID = -2331210285961685039L;
	Gentil florent = new Gentil(100, 100); // notre h\u00e9ros !
	Nourriture[] Gland = new Nourriture[10]; // la nourriture
	Mechant Nicolas = new Mechant(PApplet.parseInt(random(800)), PApplet.parseInt(random(800)), 10, 10, false); // le
																												// m\u00e9chant
																												// !
	Ball Masterball = new Ball(PApplet.parseInt(random(800)), PApplet.parseInt(random(800)), 10, 10, false); // un
																												// \u00e9l\u00e9ment
																												// perturbateur
	int energie = 195;
	int savedTime; // instauration d'un timer
	int totalTime = 1000;
	float[] distance = new float[10];
	float distance_poke = 26;

	public void setup() {
		for (int i = 0; i < 10; i++) {
			Gland[i] = new Nourriture((int) random(800), (int) random(800), false);
		}
		size(800, 800);
		savedTime = millis();
	}

	public void draw() {
		for (int i = 0; i < 10; i++) {
			// distance h\u00e9ros / nourriture :
			distance[i] = sqrt((Gland[i].getX() - florent.getX() - 5) * (Gland[i].getX() - florent.getX() - 5)
					+ (Gland[i].getY() - florent.getY() - 10) * (Gland[i].getY() - florent.getY() - 10));
		}
		// distance h\u00e9ros / m\u00e9chant :
		float distance_mechant = sqrt((Nicolas.getX() - florent.getX()) * (Nicolas.getX() - florent.getX())
				+ (Nicolas.getY() - florent.getY()) * (Nicolas.getY() - florent.getY()));
		if (distance_poke > 25 && Masterball.isExistent()) {
			// distance h\u00e9ros / masterball :
			distance_poke = sqrt((Masterball.getX() - florent.getX() - 5) * (Masterball.getX() - florent.getX() - 5)
					+ (Masterball.getY() - florent.getY() - 10) * (Masterball.getY() - florent.getY() - 10));
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
			florent.afficher();
			for (int i = 0; i < 10; i++) {
				Gland[i].afficher();
			}
			florent.afficherVie();
			florent.baisserVieAvecTemps();
		}
		for (int i = 0; i < 10; i++) {
			if (distance[i] < 25) {
				Gland[i].manger();
			}
		}
		Masterball.afficher();
		Nicolas.afficher();
		Nicolas.bouger();
		Nicolas.rebondir();
		Nicolas.mourrir();
		if (distance_mechant < 25) {
			Nicolas.attaquer();
		}
		Masterball.afficher();
		Masterball.bouger();
		Masterball.rebondir();
		if (distance_poke < 25) {
			Masterball.capturer();
		}
	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == DOWN) {
				florent.faireMouvementBas();
			}
			if (keyCode == RIGHT) {
				florent.faireMouvementdroite();
			}
			if (keyCode == LEFT) {
				florent.faireMouvementgauche();
			}
			if (keyCode == UP) {
				florent.faireMouvementHaut();
			}
		}
	}

	static public void main(String args[]) {
		PApplet.main(new String[] { "--bgcolor=#F0F0F0", "call_of_gland" });
	}
}
