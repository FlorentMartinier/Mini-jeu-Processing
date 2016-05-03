package controller;

public class Main {
	
	/**
	 * Jouer le jeu
	 * @param args
	 */
	public static void main (String [] args){
		// Créer le jeu
		Jeu jeu = new Jeu();
		
		// Initialiser le jeu
		jeu.initialiser();
		
		// Lancer la boucle de jeu
		jeu.jouerBoucle();
	}
}
