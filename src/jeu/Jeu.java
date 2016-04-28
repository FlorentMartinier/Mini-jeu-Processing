package jeu;

import processing.core.PApplet;

public class Jeu extends PApplet{

	private static final long serialVersionUID = 2772472098256683184L;
	
	Gentil gentil;
	Mechant mechant;
	Ball ball;
	Nourriture nourriture;

	/** Timer */
	int tempsDebut;
	int tempsTotal;
	
	/*
	 * Initialisation de l'application. Instruction s'éxécutant une seule fois au démarrage.
	 * @see processing.core.PApplet#setup()
	 */
	public void setup() {
		
		// Définition de la taille de la fenêtre
		size(800, 800);
		
		// Définition des acteurs
		gentil = new Gentil(100, 100, 195);
		tempsDebut = millis();
		tempsTotal = 1000;
	}
	
	/* 
	 * Instructions s'exécutant régulièrement (équivaut à un while(true))
	 * @see processing.core.PApplet#draw()
	 */
	public void draw() {
		// TODO définir l'intelligence de jeu
	}
}
